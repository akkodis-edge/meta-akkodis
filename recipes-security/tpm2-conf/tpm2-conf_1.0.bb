LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SECTION = "security"

SRC_URI = " \
	file://tpm_clear.sh \
"

RDEPENDS_${PN} = "ibmtpm20tss"


do_install () {
	install -d ${D}${sysconfdir}/default/
	echo "TPM_INTERFACE_TYPE=dev" > ${D}${sysconfdir}/default/tpm2_conf
	echo "TPM_DEVICE=/dev/tpm0" >> ${D}${sysconfdir}/default/tpm2_conf
	echo "TPM2TOOLS_TCTI_NAME=device" >> ${D}${sysconfdir}/default/tpm2_conf
	echo "TPM2TOOLS_DEVICE_FILE=/dev/tpm0" >> ${D}${sysconfdir}/default/tpm2_conf
	echo "PATH_PKS11_TPM2=/service/sdaf/pkcs11" >> ${D}${sysconfdir}/default/tpm2_conf
	
	install -d ${D}${sysconfdir}/profile.d/
	echo "export TPM_INTERFACE_TYPE=dev" > ${D}${sysconfdir}/profile.d/tpm2_conf.sh
	echo "export TPM_DEVICE=/dev/tpm0" >> ${D}${sysconfdir}/profile.d/tpm2_conf.sh
	echo "export TPM2TOOLS_TCTI_NAME=device" >> ${D}${sysconfdir}/profile.d/tpm2_conf.sh
	echo "export TPM2TOOLS_DEVICE_FILE=/dev/tpm0" >> ${D}${sysconfdir}/profile.d/tpm2_conf.sh
	echo "export PATH_PKS11_TPM2=/service/sdaf/pkcs11" >> ${D}${sysconfdir}/profile.d/tpm2_conf.sh
	
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/tpm_clear.sh ${D}${sbindir}
}

FILES_${PN} += "${sbindir}/* ${sysconfdir}/default/tpm2_conf"
PACKAGE_ARCH = "${MACHINE_ARCH}"
