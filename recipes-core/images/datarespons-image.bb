DESCRIPTION = "Data Respons base Image"
LICENSE = "MIT"

FEATURE_PACKAGES_datarespons-apps = "\
	packagegroup-datarespons-base \
"

IMAGE_FEATURES = "datarespons-apps ssh-server-openssh empty-root-password package-management"
ROOTFS_PKGMANAGE:remove = "apt"
IMAGE_INSTALL:append = " ssh-test-keys"

inherit core-image dr-image-info
