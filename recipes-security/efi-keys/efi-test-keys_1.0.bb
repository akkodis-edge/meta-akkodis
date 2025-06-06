DESCRIPTION = "Sample EFI secure boot keys"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "efitools-native"

inherit deploy

SRC_URI += "\
	file://PK.crt file://PK.key \
	file://KEK.crt file://KEK.key \
	file://db.crt file://db.key \
"

S = "${WORKDIR}"

do_compile() {
	cert-to-efi-sig-list ${S}/PK.crt ${S}/PK.esl
	cert-to-efi-sig-list ${S}/KEK.crt ${S}/KEK.esl
	cert-to-efi-sig-list ${S}/db.crt ${S}/db.esl
	sign-efi-sig-list -c ${S}/PK.crt -k ${S}/PK.key PK PK.esl PK.auth
	sign-efi-sig-list -c ${S}/PK.crt -k ${S}/PK.key KEK KEK.esl KEK.auth
	sign-efi-sig-list -c ${S}/KEK.crt -k ${S}/KEK.key db db.esl db.auth
}

do_install() {
	install -d ${D}/EFI/keys
	install -m 0644 ${S}/PK.auth ${D}/EFI/keys
	install -m 0644 ${S}/KEK.auth ${D}/EFI/keys
	install -m 0644 ${S}/db.auth ${D}/EFI/keys
}

do_deploy() {
	install -d ${DEPLOYDIR}/EFI/keys
	install -m 0644 ${S}/PK.auth ${DEPLOYDIR}/EFI/keys
	install -m 0644 ${S}/KEK.auth ${DEPLOYDIR}/EFI/keys
	install -m 0644 ${S}/db.auth ${DEPLOYDIR}/EFI/keys
}
addtask deploy after do_install

# Keys generated by:
# openssl req -new -x509 -newkey rsa:2048 -subj "/CN=${COMMON_NAME}/" -keyout ${KEY_NAME}.key -out ${KEY_NAME}.crt -nodes -sha256

# Install keys by:
# efi-updatevar -f PK.auth PK
# efi-updatevar -f KEK.auth KEK
# efi-updatevar -f db.auth db

FILES:${PN} += "/EFI/keys/"
