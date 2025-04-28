DESCRIPTION = "Akkodis Edge developer Image"
LICENSE = "MIT"

require akkodis-image.bb

FEATURE_PACKAGES:akkodis-dev = "\
	packagegroup-akkodis-developer \
"

IMAGE_FEATURES += "akkodis-dev"
