SUMMARY = "Standard packages for Akkodis Edge"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-akkodis-base-utils \
	packagegroup-akkodis-cmdline-utils \
	packagegroup-akkodis-base \
	packagegroup-akkodis-policy \
	packagegroup-akkodis-core \
	packagegroup-akkodis-io \
	packagegroup-akkodis-developer \
	packagegroup-akkodis-net \
	packagegroup-akkodis-dev-bin \
	packagegroup-akkodis-gps \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-akkodis-pcbios', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', '3g', 'packagegroup-akkodis-cellular', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'packagegroup-akkodis-screen', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'packagegroup-akkodis-wifi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'packagegroup-akkodis-bt', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'alsa', 'packagegroup-akkodis-sound', '',d)} \
"

RDEPENDS:packagegroup-akkodis-base = "\
	packagegroup-akkodis-core \
	packagegroup-akkodis-cmdline-utils \
	packagegroup-akkodis-net \
	packagegroup-akkodis-policy \
	packagegroup-akkodis-io \
	packagegroup-akkodis-developer \
	packagegroup-akkodis-gps \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-akkodis-pcbios', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', '3g', 'packagegroup-akkodis-cellular', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'packagegroup-akkodis-screen', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'wifi', 'packagegroup-akkodis-wifi', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'bluetooth', 'packagegroup-akkodis-bt', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'alsa', 'packagegroup-akkodis-sound', '',d)} \
"

# Stripped down replacement of packagegroup-core-base-utils.
# Selected in DISTRO by:
# PREFERRED_PROVIDER_virtual/base-utils = "packagegroup-akkodis-base-utils"
# VIRTUAL-RUNTIME_base-utils = "packagegroup-akkodis-base-utils"
RDEPENDS:packagegroup-akkodis-base-utils = "\
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
	vim-vimrc \
	vim-common \
	wget \
	which \
	xz \
"

# This is a stripped down version of packagegroup-core-full-cmdline-utils
# to remove utilies such as mc and ed.
RDEPENDS:packagegroup-akkodis-cmdline-utils = " \
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

RDEPENDS:packagegroup-akkodis-core = "\
	bash-completion \
	systemd-bash-completion \
	glibc-localedata-i18n \
	glibc-localedata-posix \
	tzdata \
	dbus \	
	login-environment \
	akkodis-apps \
	nvram \
	nvram-hostname \
	picocom \
	dosfstools \
	auditd \
	image-tools \
"

RDEPENDS:packagegroup-akkodis-policy = "\
	sysctl-rp-filter \
"
	
RDEPENDS:packagegroup-akkodis-io = "\
	libiio \
	libiio-tests \
	libiio-python3 \
	libgpiod-tools \
"

RDEPENDS:packagegroup-akkodis-developer = "\
	systemd-analyze \
	lsof \
	libasan \
	libubsan \
"

# Packages for binary debugging.
# Separated as some packages significantly increase image size.
RDEPENDS:packagegroup-akkodis-dev-bin = " \
	strace \
	gdb \
	valgrind \
	ldd \
	binutils \
	file \
"

RDEPENDS:packagegroup-akkodis-net = "\
	networkmanager \
	networkmanager-nmcli \
	networkmanager-nmcli-bash-completion \
	ethtool \
"

RDEPENDS:packagegroup-akkodis-wifi = "\
	wpa-supplicant \
	wpa-supplicant-cli \
	wpa-supplicant-passphrase \
	iw \
	rfkill \
"
RDEPENDS:packagegroup-akkodis-cellular = "\
	networkmanager-wwan \
	modemmanager \
	modemmanager-bash-completion \
	rfkill \
"
    
RDEPENDS:packagegroup-akkodis-bt = "\
	bluez5 \
	bluez5-noinst-tools \
	bluez5-testtools \
	rfkill \
"
	
RDEPENDS:packagegroup-akkodis-gps = "\
	gpsd \
	gpsd-conf \
	gps-utils \
	gpsd-gpsctl \
	libgps \
"

RDEPENDS:packagegroup-akkodis-screen = "\
	weston \
	weston-init \
	weston-delay \
"

RDEPENDS:packagegroup-akkodis-sound = "\
	pulseaudio \
	pulseaudio-system \
	pulseaudio-server \
	pulseaudio-pa-info \
	pulseaudio-misc \
	alsa-utils \
"

RDEPENDS:packagegroup-akkodis-pcbios = "\
	dmidecode \
	acpica \
	efitools \
	login-secureboot-check \
	efibootmgr \
	efivar \
"
