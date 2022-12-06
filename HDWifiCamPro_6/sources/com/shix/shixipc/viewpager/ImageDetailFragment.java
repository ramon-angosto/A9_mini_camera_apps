package com.shix.shixipc.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.hichip.widget.photoview.PhotoViewAttacher;
import com.shix.qhipc.R;

public class ImageDetailFragment extends Fragment {
    private PhotoViewAttacher mAttacher;
    private String mImageUrl;
    private ImageView mImageView;

    public static ImageDetailFragment newInstance(String str) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mImageUrl = getArguments() != null ? getArguments().getString("url") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_image_detail, viewGroup, false);
        this.mImageView = (ImageView) inflate.findViewById(R.id.image);
        Glide.with(getContext()).load(this.mImageUrl).into(this.mImageView);
        this.mAttacher = new PhotoViewAttacher(this.mImageView);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.mAttacher != null) {
            this.mAttacher = null;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }
}
