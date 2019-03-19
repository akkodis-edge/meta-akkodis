# Copyright (C) 2014 Data Respons AS

DESCRIPTION = "Target packages for Cargotec SDK"
LICENSE = "MIT"

inherit packagegroup



RDEPENDS_${PN} += " \
    protobuf-dev \
    util-linux-dev \
    alsa-lib-dev \
    kernel-dev \
    sysfsutils-dev \
    libpciaccess-dev \
    util-macros-dev \
    parted-dev \
    boost-dev \
    avahi-dev \
    bluez5-dev \
    libusb1-dev \
    connman-dev \
    ofono-dev \
    p11-kit-dev \
    libp11-dev \
    libiio-dev \
    curl-dev \
    libdbus-c++-dev \
    ibmtpm20tss-dev \
    gpsd-dev \
    ell-dev \
    libqmi-dev \
"
