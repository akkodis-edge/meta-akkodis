DESCRIPTION = "NVRAM base program"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRCREV ?= "1c7c8378c296904edd7dfe10b7fba47f2c438289"
SRC_URI = "${DR_SOURCE_MIRROR}/nvram.git;protocol=ssh;branch=${BRANCH}"
BRANCH ?= "master"

PV = "1.1+git${SRCPV}"
S = "${WORKDIR}/git"

CXXFLAGS += "-std=c++11"

RDEPENDS_${PN} += "libstdc++"

do_compile () {
	oe_runmake all CXXFLAGS="$CXXFLAGS -DTARGET_CARGOTEC"
}

do_install () {
    install -d ${D}${sbindir}
    oe_runmake install INSTALL_PATH=${D}${sbindir}
}

FILES_${PN} = "${sbindir}/nvram"

PACKAGE_ARCH = "${MACHINE_ARCH}"
