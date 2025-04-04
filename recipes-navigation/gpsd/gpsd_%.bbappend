# gpsd RRECOMEMNDS udev rules which autobind
# FTDI usb dongles as gps providers.
# We do not want this behaviour as it conflicts
# with testing equipment.
RRECOMMENDS:${PN}:remove = "gpsd-udev"
