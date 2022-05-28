SUMMARY = "qt5 packages for Data Respons"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-datarespons-qt5 \
"

RDEPENDS:packagegroup-datarespons-qt5 = "\
	login-qt5-environment \
	qtwayland \
	qt5-opengles2-test \
"
