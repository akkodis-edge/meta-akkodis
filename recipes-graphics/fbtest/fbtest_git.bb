SUMMARY = "fbtest"
DESCRIPTION = "A simple program to draw a rectangle of fixed color to the Linux frame buffer display."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6 "

SRC_URI = "git://github.com/jumpnow/fbtest.git \
           file://0001-Makefile-cross-compilation-fixes.patch \
           "

SRCREV = "6480fff3ce567bab808639ad1506b1d57330f236"

S = "${WORKDIR}/git"

#EXTRA_OEMAKE += "-f Makefile-cross"

do_install() {
    install -d ${D}${base_sbindir}
    install -m 744 ${B}/fbtest ${D}${base_sbindir}/fbtest
}