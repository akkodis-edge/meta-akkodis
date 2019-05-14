DESCRIPTION = "Data Respons base Image"
LICENSE = "MIT"

FEATURE_PACKAGES_datarespons-apps = "\
	packagegroup-datarespons-base \
	packagegroup-datarespons-developer \
"

IMAGE_FEATURES = "datarespons-apps ssh-server-openssh empty-root-password package-management"
ROOTFS_PKGMANAGE_remove = "apt"

inherit core-image

ROOT_KEY = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCuOwEngwq2sQAkDGRUASKNhRvSoEcnAO8WH486NJ3leu4Wjjsug9V5IzhLPsbIVEgdyjmKBV+W9JSU8tU/lieCo4zPyUFNGwQ1Pep6XVtBr052OiSsM3Z8yumkXDZi3I50Kvq0inX1LD58e6DaJylK9d0laAqQUtZRBd5/MyoyGZyTe+eTiPkNjPZ36m2OOgxm28IPxDBLGDJj50XlfqDjONKVnIhtPiv38AhDYR/Rh/fmF/UcI29yPfsaHWGrz+tJW0pNRgJPe4fudbrkdPVPfbfCZUH+9PG9+UVzpCTfgCWNXB9Ggd4keZ9YG4Nd6/5XAr/VaggxjxrutUNwfEAt"

ROOTFS_POSTPROCESS_COMMAND_append = "\
						add_ssh_root_key; \
						inhibit_powerkey_shutdown; \
						"

add_ssh_root_key () {
    install -d -m 700 ${IMAGE_ROOTFS}/home/root/.ssh
    echo ${ROOT_KEY} > ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys
    chmod 0600  ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys
}

inhibit_powerkey_shutdown () {
    echo "HandlePowerKey=ignore" >> ${IMAGE_ROOTFS}/etc/systemd/logind.conf
}
