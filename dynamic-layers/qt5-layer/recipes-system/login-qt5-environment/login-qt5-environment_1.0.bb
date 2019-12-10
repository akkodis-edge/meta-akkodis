DESCRIPTION = "Login shell qt5 environment"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
	install -d ${D}${sysconfdir}/profile.d/
	echo "export QT_QPA_PLATFORM=wayland" >> ${D}${sysconfdir}/profile.d/11-login-qt5-environment.sh
}