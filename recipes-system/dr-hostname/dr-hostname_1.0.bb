DESCRIPTION = "Utility to set hostname from nvram"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit  pythonnative python3-dir
SRC_URI = 	" \
    file://dr_hostname.py \
    file://dr-hostname.service \
"

inherit systemd


S = "${WORKDIR}"
SYSTEMNAME ?= "datarespons"
RDEPENDS_${PN} = "python3-core nvram python3-dbus"
RDEPENDS_${PN} += "${@bb.utils.contains('DISTRO_FEATURES','zeroconf','avahi-utils','',d)}"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/dr_hostname.py ${D}${bindir}/dr-hostname
    install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/dr-hostname.service ${D}${systemd_unitdir}/system/dr-hostname.service
    install -d ${D}${sysconfdir}/default/
    echo "SYSTEMNAME=${SYSTEMNAME}" > ${D}${sysconfdir}/default/systemname
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${bindir}/* ${sysconfdir}/default/systemname"


SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "dr-hostname.service"
