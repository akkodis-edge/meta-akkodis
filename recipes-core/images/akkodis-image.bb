DESCRIPTION = "Akkodis Edge base Image"
LICENSE = "MIT"

FEATURE_PACKAGES_akkodis-apps = "\
	packagegroup-akkodis-base \
"

IMAGE_FEATURES = "akkodis-apps ssh-server-openssh empty-root-password package-management"
ROOTFS_PKGMANAGE:remove = "apt"

inherit core-image dr-image-info
