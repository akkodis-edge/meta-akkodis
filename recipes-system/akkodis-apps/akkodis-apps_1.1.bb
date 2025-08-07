DESCRIPTION = "Targets for resolving runlevel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://akkodis-apps.target.in"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit systemd

TARGET = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'graphical.target', 'multi-user.target', d)}"

do_compile() {
	sed -e 's:@target@:${TARGET}:g' ${S}/akkodis-apps.target.in > ${S}/akkodis-apps.target
}

do_install () {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/akkodis-apps.target ${D}${systemd_system_unitdir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

SYSTEMD_PACKAGES = "${PN}"

FILES:${PN} = "${systemd_system_unitdir}/*"
