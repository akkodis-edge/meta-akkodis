FILESEXTRAPATHS_append := "${THISDIR}/${PN}"

inherit systemd

SRC_URI += "file://xterm.service.in"

do_install_append() {
	sed -e 's:@bindir@:${bindir}:g' -e 's:@sbindir@:${sbindir}:g' < ${WORKDIR}/xterm.service.in > ${WORKDIR}/xterm.service
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/xterm.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE_${PN} = "xterm.service"
SYSTEMD_AUTO_ENABLE = "enable"
