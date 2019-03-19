SUMMARY = "Meta package for building an installable Qt5 toolchain and SDK for the Cargotec"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit populate_sdk

TOOLCHAIN_TARGET_TASK += "packagegroup-ct"
TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-ct-host"
