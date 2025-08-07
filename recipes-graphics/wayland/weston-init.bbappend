FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://weston-init.service.in"

REQUIRED_DISTRO_FEATURES += "pam systemd wayland"

RDEPENDS:${PN} += "weston-check"

do_install:prepend() {
    # Disable screen locking
    sed -i 's/.*#locking=.*/locking=false/g' ${S}/weston.ini
    
    # Disable screen fade to black
    sed -i '/^[core].*/a idle-time=0' ${S}/weston.ini
}

do_install:append() {
    sed -e 's:@bindir@:${bindir}:g' -e 's:@sbindir@:${sbindir}:g' < ${S}/weston-init.service.in > ${S}/weston-init.service
    install -m 0644 ${S}/weston-init.service ${D}${systemd_system_unitdir}/
}

SYSTEMD_SERVICE:${PN} += "weston-init.service"