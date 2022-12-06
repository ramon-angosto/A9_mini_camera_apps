package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    public final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j);
        }
    }

    public final void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i2 = 0; i2 < trackSelectionArr2.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                i = -1;
            } else {
                i = this.streamPeriodIndices.get(sampleStreamArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (trackSelectionArr2[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr2[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i3 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.periods.length) {
            for (int i5 = 0; i5 < trackSelectionArr2.length; i5++) {
                TrackSelection trackSelection = null;
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    trackSelection = trackSelectionArr2[i5];
                }
                trackSelectionArr3[i5] = trackSelection;
            }
            ArrayList arrayList2 = arrayList;
            TrackSelection[] trackSelectionArr4 = trackSelectionArr3;
            int i6 = i4;
            long selectTracks = this.periods[i4].selectTracks(trackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < trackSelectionArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    Assertions.checkState(sampleStreamArr4[i7] != null);
                    sampleStreamArr3[i7] = sampleStreamArr4[i7];
                    this.streamPeriodIndices.put(sampleStreamArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (sampleStreamArr4[i7] != null) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.periods[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            trackSelectionArr3 = trackSelectionArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, sampleStreamArr3.length);
        this.enabledPeriods = new MediaPeriod[arrayList3.size()];
        arrayList3.toArray(this.enabledPeriods);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j2;
    }

    public final void discardBuffer(long j, boolean z) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public final void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i = 0; i < size; i++) {
            this.childrenPendingPreparation.get(i).continueLoading(j);
        }
        return false;
    }

    public final long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public final long readDiscontinuity() {
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i >= mediaPeriodArr.length) {
                if (readDiscontinuity != C.TIME_UNSET) {
                    MediaPeriod[] mediaPeriodArr2 = this.enabledPeriods;
                    int length = mediaPeriodArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        MediaPeriod mediaPeriod = mediaPeriodArr2[i2];
                        if (mediaPeriod == this.periods[0] || mediaPeriod.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return readDiscontinuity;
            } else if (mediaPeriodArr[i].readDiscontinuity() == C.TIME_UNSET) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity.");
            }
        }
    }

    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public final long seekToUs(long j) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) == seekToUs) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j, seekParameters);
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i];
            MediaPeriod[] mediaPeriodArr = this.periods;
            int length = mediaPeriodArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                TrackGroupArray trackGroups3 = mediaPeriodArr[i2].getTrackGroups();
                int i4 = trackGroups3.length;
                int i5 = i3;
                int i6 = 0;
                while (i6 < i4) {
                    trackGroupArr[i5] = trackGroups3.get(i6);
                    i6++;
                    i5++;
                }
                i2++;
                i3 = i5;
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}
