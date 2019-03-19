DESCRIPTION = "Emergency handling"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://dr-emergency.service \
	file://status-led.sh \
"

inherit systemd

do_install () {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/dr-emergency.service ${D}${systemd_system_unitdir}
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/status-led.sh ${D}${bindir}/status-led
}

SYSTEMD_PACKAGES = "${PN}"
FILES_${PN} = "${systemd_system_unitdir}/* ${bindir}/*"
PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_SERVICE_${PN} = "dr-emergency.service"
