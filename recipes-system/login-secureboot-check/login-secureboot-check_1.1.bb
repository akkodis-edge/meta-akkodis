DESCRIPTION = "Notify secureboot state on login"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
	file://30-secureboot-check.sh \
"

RDEPENDS:${PN} = "efitools"

do_install() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/30-secureboot-check.sh ${D}${sysconfdir}/profile.d/
}
