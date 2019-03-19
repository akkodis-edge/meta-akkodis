#!/usr/bin/env python3

import string, os


fuse_path = '/sys/fsl_otp'
#fuse_path = '/home/root'

  
# Program start

lockmask = 0x00100000

with open(os.path.join(fuse_path, 'HW_OCOTP_CFG5'), 'r') as f:
  cfg5 = f.read()


if (int(cfg5, base=16) & lockmask):
  print ("JTAG disabled already")
else:
  print("Disabling JTAG and set the BT_DIR_DIS")    
  fuselock = "0x00100008\n"
  with open(os.path.join(fuse_path, 'HW_OCOTP_CFG5'), 'w') as f:
    f.write(fuselock)
    
exit (0)
