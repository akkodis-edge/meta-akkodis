DESCRIPTION = "Data Respons developer Image"
LICENSE = "MIT"

require datarespons-image.bb

FEATURE_PACKAGES:datarespons-dev = "\
	packagegroup-datarespons-developer \
"

IMAGE_FEATURES += "datarespons-dev"
