LICENSE = "MIT"

IMAGE_INSTALL += "efi-shell efi-utils systemd-boot-signed akkodis-efi-blob"
IMAGE_CONTAINER_NO_DUMMY = "1"
IMAGE_FSTYPES = "container"
IMAGE_LINGUAS = ""
IMAGE_PREPROCESS_COMMAND:remove = " prelink_setup; prelink_image; mklibs_optimize_image;"

inherit core-image systemd_boot_loader dr-image-info

SYSTEMD_BOOT_DEFAULT_ENTRY = "${MACHINE}*"

ROOTFS_POSTPROCESS_COMMAND:append = " \
	add_efi_blob_entry; \
"

remove_etc() {
	mv ${IMAGE_ROOTFS}/etc/image_info ${IMAGE_ROOTFS}/
	rm -r ${IMAGE_ROOTFS}/etc
}

add_efi_blob_entry() {
	echo "title ${MACHINE}" > ${IMAGE_ROOTFS}/loader/entries/${MACHINE}.conf
	echo "efi /boot/akkodis-efi-blob-${MACHINE}.efi" >> ${IMAGE_ROOTFS}/loader/entries/${MACHINE}.conf
}

remove_var() {
	rm -r ${IMAGE_ROOTFS}/var
}