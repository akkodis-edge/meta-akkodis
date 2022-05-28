SUMMARY = "IBM TPM 2.0 TSS"
DESCRIPTION = "TSS2"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e023f61454ac828b4aa1bc4293f7d5f"
SECTION = "security"

DEPENDS = "openssl gcc-runtime"

SRCREV = "3599e629b3b084138df541ef3d15761366d61d09"

SRC_URI = " \
    git://git.code.sf.net/p/ibmtpm20tss/tss;protocol=https;branch=master; \
    file://Makefile \
"

PV = "${SRCREV}"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "libssl bash"

PACKAGES =+ "${PN}-tests"
RDEPENDS:${PN}-tests += "libssl bash"

EXTRA_OEMAKE += "CC='${CC}'"

do_compile() {
	cp ${WORKDIR}/Makefile utils/
    oe_runmake -C utils -f makefile
}

do_install() {
    install -d ${D}${libdir}
    install -m 0644 utils/libtss.so.0.1 ${D}${libdir}
    ln -s libtss.so.0.1 ${D}${libdir}/libtss.so.0
    ln -s libtss.so.0 ${D}${libdir}/libtss.so
    
    install -d ${D}${bindir}
    
    find ./utils -maxdepth 1 -executable -type f -exec install -m 0755 {} ${D}${bindir} \;
    rm -f ${D}${bindir}/*libtss*
    
    for f in ${D}${bindir}/* ; do
        mv $f ${D}${bindir}/tss`basename $f`
    done

    install -d ${D}${includedir}
    cp -r utils/tss2 ${D}${includedir}/
    
    install -d ${D}${datadir}/${PN}/regtests
    install -m 0755 utils/reg.sh ${D}${datadir}/${PN}
    sed -i 's/PREFIX=\.\//PREFIX=tss/g' ${D}${datadir}/${PN}/reg.sh
    cp  utils/regtests/*.sh ${D}${datadir}/${PN}/regtests
}



FILES:${PN} += "${libdir}/* ${bindir}/*"
FILES:${PN}-tests += "${datadir}/*"
INSANE_SKIP:${PN}-dev = "ldflags"
INSANE_SKIP:${PN} = "ldflags" 

