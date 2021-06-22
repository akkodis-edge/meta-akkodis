DESCRIPTION = "Login environment"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
	install -d ${D}${sysconfdir}/profile.d/
	echo "export PAGER=less" >> ${D}${sysconfdir}/profile.d/10-login-environment.sh
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'echo "export WAYLAND_DISPLAY=/run/wayland-0" >> ${D}${sysconfdir}/profile.d/10-login-environment.sh', '',d)}
}