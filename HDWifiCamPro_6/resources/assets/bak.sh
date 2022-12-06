#/bin/sh
# upgradeAllFlag  该值为1时，allshell_UpgradeFlag
#			     boardConfig_UpgradeFlag
#			     app_UpgradeFlag
#			     sensor_UpgradeFlag
#			    四个参数的值默认都为1， upgradeAllFlag为0时设置才有效
#
# allshell_UpgradeFlag		升级所有的shell脚本
# boardConfig_UpgradeFlag	升级功能
# app_UpgradeFlag		升级APP
# sensor_UpgradeFlag		升级sensor配置
# VERSION			版本号，与之前的版本不同时升级，相同不升级
md5str="0de67ef4ff4600086b099878e16df9e5"
VERSION="4.2.0.45"

upgradeAllFlag=1			#0-1
allshell_UpgradeFlag=1  		#0-1
app_UpgradeFlag=1			#0-1
sensor_UpgradeFlag=1			#0-1
boardConfig_UpgradeFlag=1		#0-1

# boardConfig_UpgradeFlag为1时
pwr_SwitchType=1			# 0:dip 1:button 2：snap 3:record
ir_CutAuto=0				# 0:manu 1:auto
img_RotMir=0				# 0-3
snap_PhotoButton=0			# 0:unuse 1:use
wifi_PwrButton=0			# 0:unuse 1:use
sd_DouleSize=0				# 0:normal 1:double
pwr_detect=1				# 0:unuse 1:use
light_type=0                # 0:irlight 1:daylight
screen_show=2               # 0:unuse 1:use
reset_button=0				# 0:reset 1:reset_snap 2:reset_record
slamp_button=0
server_restrict=0           #0:NO restrictions 1:restrictions
