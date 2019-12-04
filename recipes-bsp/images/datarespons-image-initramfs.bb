DESCRIPTION = "Data Respons Image initramfs"

require datarespons-image.bb

IMAGE_FSTYPES = "cpio.gz"

ROOTFS_POSTPROCESS_COMMAND_append = " remove_kernel_image;"

remove_kernel_image() {
	rm ${IMAGE_ROOTFS}/boot/bzImage*
}
