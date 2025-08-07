LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://rp_filter.conf"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install () {
	install -d ${D}${sysconfdir}/sysctl.d/
	install -m 0644 ${S}/rp_filter.conf ${D}${sysconfdir}/sysctl.d/
}

FILES:${PN} += "${sysconfdir}/sysctl.d/*"
