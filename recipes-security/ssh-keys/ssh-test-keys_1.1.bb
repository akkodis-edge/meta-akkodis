DESCRIPTION = "SSH test key. Private key stored in public repository. Not for production use."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://droot.pub"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
    install -d -m 700 ${D}${ROOT_HOME}/.ssh
    install -m 0600 ${S}/droot.pub ${D}${ROOT_HOME}/.ssh/authorized_keys
}

FILES:${PN} = "${ROOT_HOME}/.ssh/authorized_keys"
