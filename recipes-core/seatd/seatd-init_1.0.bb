DESCRIPTION = "seatd launcher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://seatd-init.service.in"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit systemd

RDEPENDS:${PN} = "seatd"

do_install () {
	sed 's:@BINDIR@:${bindir}:g' ${S}/seatd-init.service.in > ${S}/seatd-init.service
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/seatd-init.service ${D}${systemd_system_unitdir}/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "seatd-init.service"
