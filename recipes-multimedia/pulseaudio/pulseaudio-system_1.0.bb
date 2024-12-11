DESCRIPTION = "pulseaudio system wide service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://pulseaudio-system.service.in file://pulseaudio-bluez5.pa"

inherit systemd useradd

# Add root to audio group for permissions to access pulseaudio server
USERADD_PACKAGES = "${PN}"
GROUPMEMS_PARAM:${PN} = "-a root -g audio"

RDEPENDS:${PN} = "pulseaudio-server ${@bb.utils.contains('DISTRO_FEATURES','bluetooth','pulseaudio-module-bluez5-device pulseaudio-module-bluez5-discover','',d)}"

do_install () {
	sed 's:@BINDIR@:${bindir}:g' ${WORKDIR}/pulseaudio-system.service.in > ${WORKDIR}/pulseaudio-system.service
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/pulseaudio-system.service ${D}${systemd_system_unitdir}/
	if ${@bb.utils.contains('DISTRO_FEATURES','bluetooth','true','false',d)}; then
		install -d ${D}${sysconfdir}/pulse/system.pa.d/
		install -m 0644 ${WORKDIR}/pulseaudio-bluez5.pa ${D}${sysconfdir}/pulse/system.pa.d/
	fi
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "pulseaudio-system.service"
