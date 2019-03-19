
PACKAGECONFIG[p2p] = ",,"
PACKAGECONFIG[introspection] = ",,"

do_configure_append () {
if echo "${PACKAGECONFIG}" | grep -qw "p2p"; then
	echo "CONFIG_P2P=y" >>  wpa_supplicant/.config
fi
if echo "${PACKAGECONFIG}" | grep -qw "introspection"; then
	echo "CONFIG_CTRL_IFACE_DBUS_INTRO=y" >>  wpa_supplicant/.config
fi
}
