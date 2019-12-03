FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd wayland x11', 'file://weston.config file://weston-init.service.in', '', d)}"

HAS_SYSTEMD = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"
HAS_XWAYLAND = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland x11', 'true', 'false', d)}"

REQUIRED_DISTRO_FEATURES += "pam"

RDEPENDS_${PN} += "weston-check"

do_install_append() {
    if ${HAS_SYSTEMD}; then
        sed -i \
            -e 's,/usr/bin,${bindir},g' \
            -e 's,/etc,${sysconfdir},g' \
            -e 's,/var,${localstatedir},g' \
            ${D}${systemd_system_unitdir}/weston.service
        if ${HAS_XWAYLAND}; then
            install -Dm0755 ${WORKDIR}/weston.config ${D}${sysconfdir}/default/weston
        fi
        sed -e 's:@bindir@:${bindir}:g' -e 's:@sbindir@:${sbindir}:g' < ${WORKDIR}/weston-init.service.in > ${WORKDIR}/weston-init.service
        install -m 0644 ${WORKDIR}/weston-init.service ${D}${systemd_system_unitdir}/
    fi
}

SYSTEMD_SERVICE_${PN} += "weston-init.service"