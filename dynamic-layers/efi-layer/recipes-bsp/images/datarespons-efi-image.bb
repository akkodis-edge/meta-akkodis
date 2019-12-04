LICENSE = "MIT"

IMAGE_INSTALL += "install-keys efi-shell capsule-loader systemd-boot datarespons-efi-blob"
IMAGE_CONTAINER_NO_DUMMY = "1"
IMAGE_FSTYPES = "container"
IMAGE_LINGUAS = ""
IMAGE_PREPROCESS_COMMAND_remove = " prelink_setup; prelink_image; mklibs_optimize_image;"

inherit core-image systemd_boot_loader dr-image-info

SYSTEMD_BOOT_DEFAULT_ENTRY = "datarespons-efi-blob-${MACHINE}"

ROOTFS_POSTPROCESS_COMMAND_append += " \
	remove_etc; \
"

remove_etc() {
	mv ${IMAGE_ROOTFS}/etc/image_info ${IMAGE_ROOTFS}/
	rm -r ${IMAGE_ROOTFS}/etc
}

remove_var() {
	rm -r ${IMAGE_ROOTFS}/var
}