DESCRIPTION = "Data Respons qt5 Image"

require recipes-bsp/images/datarespons-image.bb

FEATURE_PACKAGES:datarespons-qt5-apps = "\
	packagegroup-datarespons-qt5 \
"

IMAGE_FEATURES += "datarespons-qt5-apps"