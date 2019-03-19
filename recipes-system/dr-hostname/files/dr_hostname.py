#!/usr/bin/env python3

# Program start

import subprocess, sys, string, os
from subprocess import CalledProcessError

serial_key = "DR_PRODUCT_SERIAL"
try:
  istr = subprocess.check_output(["/usr/sbin/nvram", "get", serial_key]).decode().rstrip()
except CalledProcessError as e:
  print ("Unable to get serial key from nvram")
  exit(1)

if ( len(istr) < 4 ):
  print (sys.argv[0], ": Malformed id", ident)
  exit(1)
  

if (len(sys.argv) > 1):
  prefix = sys.argv[1]
else:
  prefix = "dr"
  

hname = prefix + "-" + istr
try:
  oldname = subprocess.check_output(["hostname"]).decode().rstrip()
  if (oldname == hname):
    print ("Hostname is already", hname)
    exit (0)
except CalledProcessError as e:
  exit(1)
print (str.format("Setting hostname to: {0}", hname))

try:
  subprocess.check_call(["/usr/bin/hostnamectl", "set-hostname", hname.encode()])
  if (os.path.isfile("/usr/bin/avahi-set-host-name")):
      subprocess.check_call(["/usr/bin/avahi-set-host-name", hname.encode()])
except CalledProcessError as e:
  print (str.format("Error setting hostname to {0} ERR {1}", hname, e.returncode))
  exit(1)

exit(0)
