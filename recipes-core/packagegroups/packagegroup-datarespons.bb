SUMMARY = "Standard packages for Data Respons"
LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-datarespons-base-utils \
	packagegroup-datarespons-cmdline-utils \
	packagegroup-datarespons-base \
	packagegroup-datarespons-policy \
	packagegroup-datarespons-core \
	packagegroup-datarespons-io \
	packagegroup-datarespons-developer \
	packagegroup-datarespons-net \
	packagegroup-datarespons-dev-bin \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-datarespons-pcbios', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'packagegroup-datarespons-efi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
"

RDEPENDS:packagegroup-datarespons-base = "\
	packagegroup-datarespons-core \
	packagegroup-datarespons-cmdline-utils \
	packagegroup-datarespons-net \
	packagegroup-datarespons-policy \
	packagegroup-datarespons-io \
	packagegroup-datarespons-developer \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-datarespons-pcbios', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'packagegroup-datarespons-efi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
"

# Stripped down replacement of packagegroup-core-base-utils.
# Selected in DISTRO by:
# PREFERRED_PROVIDER_virtual/base-utils = "packagegroup-datarespons-base-utils"
# VIRTUAL-RUNTIME_base-utils = "packagegroup-datarespons-base-utils"
RDEPENDS:packagegroup-datarespons-base-utils = "\
	base-passwd \
	bash \
	bind-utils \
	bzip2 \
	coreutils \
	cpio \
	diffutils \
	e2fsprogs \
	findutils \
	gawk \
	grep \
	gzip \
	iproute2 \
	kmod \
	less \
	ncurses-tools \
	net-tools \
	parted \
	patch \
	procps \
	psmisc \
	sed \
	shadow-base \
	tar \
	time \
	unzip \
	util-linux \
	vim-tiny \
	wget \
	which \
	xz \
"

# This is a stripped down version of packagegroup-core-full-cmdline-utils
# to remove utilies such as mc and ed.
RDEPENDS:packagegroup-datarespons-cmdline-utils = " \
	bash \
	bc \
	coreutils \
	cpio \
	e2fsprogs \
	findutils \
	gawk \
	grep \
	net-tools \
	procps \
	sed \
	tar \
	time \
	util-linux \
	shadow \
	sudo \
	iputils \
	iptables \
	module-init-tools \
	openssl \
"

RDEPENDS:packagegroup-datarespons-core = "\
	bash-completion \
	systemd-bash-completion \
	glibc-localedata-i18n \
	glibc-localedata-posix \
	tzdata \
	dbus \	
	login-environment \
	dr-emergency \
	dr-runlevel \
	nvram \
	nvram-hostname \
	picocom \
	dosfstools \
"

RDEPENDS:packagegroup-datarespons-policy = "\
	sysctl-rp-filter \
"

RDEPENDS:packagegroup-datarespons-tpm2 = "\
    ibmtpm20tss \
"
	
RDEPENDS:packagegroup-datarespons-io = "\
	libiio \
	libiio-tests \
	libiio-python3 \
	libgpiod-tools \
"

RDEPENDS:packagegroup-datarespons-developer = "\
	systemd-analyze \
	lsof \
	libasan \
	libubsan \
"

# Packages for binary debugging.
# Separated as some packages significantly increase image size.
RDEPENDS:packagegroup-datarespons-dev-bin = " \
	strace \
	gdb \
	valgrind \
	ldd \
	binutils \
	file \
"

RDEPENDS:packagegroup-datarespons-net = "\
	networkmanager \
	networkmanager-nmcli \
	networkmanager-nmcli-bash-completion \
	ethtool \
"

RDEPENDS:packagegroup-datarespons-wifi = "\
	wpa-supplicant \
	wpa-supplicant-cli \
	wpa-supplicant-passphrase \
	iw \
	rfkill \
"
RDEPENDS:packagegroup-datarespons-cellular = "\
	networkmanager-wwan \
	modemmanager \
	modemmanager-bash-completion \
	rfkill \
"
    
RDEPENDS:packagegroup-datarespons-bt = "\
	bluez5 \
	bluez5-noinst-tools \
	bluez5-testtools \
	rfkill \
"
	
RDEPENDS:packagegroup-datarespons-gps = "\
	gpsd \
	gpsd-conf \
	gps-utils \
	gpsd-gpsctl \
	libgps \
"

RDEPENDS:packagegroup-datarespons-screen = "\
	weston \
	weston-init \
"

RDEPENDS:packagegroup-datarespons-efi = "\
	efitools \
	login-secureboot-check \
	efibootmgr \
	efivar \
"

RDEPENDS:packagegroup-datarespons-pcbios = "\
	dmidecode \
	acpica \
"
