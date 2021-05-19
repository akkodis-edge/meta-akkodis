FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://do-not-verify-libiio-installed-in-python-setup.patch \
"
