LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://disable-suspend.pa"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install () {
	install -d ${D}${sysconfdir}/pulse/default.pa.d
	install -m 0644 ${S}/disable-suspend.pa ${D}${sysconfdir}/pulse/default.pa.d/
}

FILES:${PN} += "${sysconfdir}/pulse/default.pa.d/"
