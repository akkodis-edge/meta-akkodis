# efi image

LICENSE = "MIT"

IMAGE_INSTALL += "efi-test-keys efi-shell efi-utils systemd-boot"
IMAGE_CONTAINER_NO_DUMMY = "1"
IMAGE_FSTYPES = "container"
IMAGE_LINGUAS = ""
IMAGE_PREPROCESS_COMMAND:remove = " prelink_setup; prelink_image; mklibs_optimize_image;"

inherit core-image systemd_boot_loader

SYSTEMD_BOOT_DEFAULT_ENTRY = "efi-shell"

ROOTFS_POSTPROCESS_COMMAND:append = " \
	remove_etc; \
"

remove_etc() {
	rm -r ${IMAGE_ROOTFS}/etc
}

remove_var() {
	rm -r ${IMAGE_ROOTFS}/var
}