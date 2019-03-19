# Copyright (C) 2014 Data Respons AS

DESCRIPTION = "Extra host SDK packs"
LICENSE = "MIT"

inherit nativesdk packagegroup


RDEPENDS_${PN} += " \
    nativesdk-protobuf \
"

