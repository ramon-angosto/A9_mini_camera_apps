# A9_mini_camera_apps

This git repository contains two decompressed Apps that work with A9 minicamera. This folders contain the java code that allows the control of this camera. The main difference I have found between them is an small piece of code that identifies the ssid of the camera. This small diference make one app work with one camera and not the other. 

## Apps (allowed camera ssid start codes):
- HDWIFICAMPro ["DGK", "DGO", "DGOA", "DGOB", "DGB", "EEE", "IKB", "ABC", "YSJ", "XIAODOU"]
- YGCamera ["IKB","VMS", "VMV", "EEE", "IKB", "YSJ", "XIAODOU"]
- Little stars ["THPC","ACCQ","THDK","AZQ","ALK","BCCQ"]

## What I've found:
- Codes allowed by each app, can be found in this following this path structure ./<APPNAME>/sources/com/shix/shixipc/system/ContentCommon.java and more codes can be found here ./<APPNAME>//sources/com/shix/shixipc/utils/CommonUtil.java

- HDWIFICAMPro and YGCamera are almost identical in the way the code is written
  
- ./<APPNAME>/sources/com/shix/shixipc/activity/APConnectActivity -> getWifiSSID, checks against the found codes
  
- ./<APPNAME>/sources/object/p2pipcam/nativecaller/NativeCaller.java -> Contains declaration of functions used to call the livestream
  

This codes might be helpful for other people with more knowledge in java, and maybe help with the [A9 mini camera home assistant challenge](https://community.home-assistant.io/t/popular-a9-mini-wi-fi-camera-the-ha-challenge/230108), and finally get to integrate it as an addon
