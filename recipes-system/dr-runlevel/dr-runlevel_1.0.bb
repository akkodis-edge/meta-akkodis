DESCRIPTION = "Targets for resolving runlevel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://datarespons-apps.target \
"

inherit systemd

do_install () {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/datarespons-apps.target ${D}${systemd_system_unitdir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

SYSTEMD_PACKAGES = "${PN}"

FILES_${PN} = "${systemd_system_unitdir}/*"
