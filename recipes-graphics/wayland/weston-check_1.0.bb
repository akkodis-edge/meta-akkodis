DESCRIPTION = "Check if weston active"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "wayland"

SRC_URI = "file://weston-check.c"

S = "${WORKDIR}"

LDFLAGS += "-lwayland-client"

do_compile() {
	${CC} weston-check.c ${LDFLAGS} ${CFLAGS} -o weston-check
}

do_install() {
	 install -d ${D}${bindir}
	 install -m 0755 ${S}/weston-check ${D}${bindir}
}