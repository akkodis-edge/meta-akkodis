DESCRIPTION = "pulseaudio system wide service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://pulseaudio-system.service.in"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit systemd useradd

# Add root to audio group for permissions to access pulseaudio server
USERADD_PACKAGES = "${PN}"
GROUPMEMS_PARAM:${PN} = "-a root -g audio"

PULSE_MODULES = "\
	pulseaudio-module-loopback \
"
BLUETOOTH_MODULES = "\
	pulseaudio-module-bluez5-device \
	pulseaudio-module-bluez5-discover \
	pulseaudio-module-bluetooth-policy \
	pulseaudio-module-bluetooth-discover\
"
RDEPENDS:${PN} = "pulseaudio-server ${PULSE_MODULES} ${@bb.utils.contains('DISTRO_FEATURES','bluetooth','${BLUETOOTH_MODULES}','',d)}"

do_install () {
	sed -e 's:@BINDIR@:${bindir}:g' -e 's:@SYSCONFDIR@:${sysconfdir}:g' ${S}/pulseaudio-system.service.in > ${S}/pulseaudio-system.service
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/pulseaudio-system.service ${D}${systemd_system_unitdir}/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "pulseaudio-system.service"
