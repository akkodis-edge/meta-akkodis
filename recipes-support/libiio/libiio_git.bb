SUMMARY = "Library for interfacing with IIO devices"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/libiio"
SECTION = "libs"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

SRCREV = "5bdc24262c76ccdd3ea2ebd45c9859dde281ea46"
PV = "0.17+git${SRCPV}"

SRC_URI = "git://github.com/analogdevicesinc/libiio.git"

S = "${WORKDIR}/git"

DEPENDS = "flex-native bison-native libaio"

inherit cmake pythonnative python3-dir systemd

PACKAGECONFIG ??= "\
	${@bb.utils.contains('DISTRO_FEATURES','systemd','systemd','',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'zeroconf', 'avahi', '', d)} \
"

PACKAGECONFIG[avahi] = "-DWITH_NETWORK_BACKEND=ON,-DWITH_NETWORK_BACKEND=OFF,avahi libxml2,avahi-daemon libxml2"
PACKAGECONFIG[usb] = "-DWITH_USB_BACKEND=ON,-DWITH_USB_BACKEND=OFF,libusb1 libxml2,libusb1 libxml2"
PACKAGECONFIG[systemd] = "-DWITH_SYSTEMD=ON,-DWITH_SYSTEMD=OFF,,"

PACKAGES =+ "${PN}-iiod ${PN}-tests ${PN}-python"

RDEPENDS_${PN}-python = "${PN} python3-ctypes python3-stringold"

do_install_append () {
	install -d ${D}/${PYTHON_SITEPACKAGES_DIR}/libiio
    install -m 755 ${S}/bindings/python/*.py ${D}/${PYTHON_SITEPACKAGES_DIR}/libiio
}

FILES_${PN}-iiod = "${sbindir}/iiod"
FILES_${PN}-tests = "${bindir}"
FILES_${PN}-python = "${PYTHON_SITEPACKAGES_DIR}/*"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "iiod.service"
SYSTEMD_AUTO_ENABLE = "disable"
