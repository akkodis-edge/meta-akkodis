DESCRIPTION = "Delay start of weston until DRI device available"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI = " \
	file://weston-delay.target \
	file://20-dri.rules \
"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install () {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/weston-delay.target ${D}${systemd_system_unitdir}
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${S}/20-dri.rules ${D}${sysconfdir}/udev/rules.d
}

SYSTEMD_SERVICE:${PN} += "weston-delay.target"
SYSTEMD_PACKAGES = "${PN}"
