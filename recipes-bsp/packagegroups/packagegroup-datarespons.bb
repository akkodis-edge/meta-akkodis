SUMMARY = "Standard packages for Data Respons"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-datarespons-base \
	packagegroup-datarespons-utils \
	packagegroup-datarespons-core \
	packagegroup-datarespons-io \
	packagegroup-datarespons-developer \
	packagegroup-datarespons-net \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
"

RDEPENDS_packagegroup-datarespons-base = "\
	packagegroup-datarespons-core \
	packagegroup-datarespons-net \
	packagegroup-datarespons-utils \
	packagegroup-datarespons-io \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
"
RDEPENDS_packagegroup-datarespons-utils = "\
	dr-emergency \
	dr-hostname \
	dr-runlevel \
	nvram \
"

RDEPENDS_packagegroup-datarespons-tpm2 = "\
    ibmtpm20tss \
    tpm2-conf \
"
	
RDEPENDS_packagegroup-datarespons-io = "\
	libiio \
	libiio-iiod \
	libiio-tests \
	libiio-python \
"

RDEPENDS_packagegroup-datarespons-core = "\
	bash-completion \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-bash-completion', '',d)} \	
	findutils \
	glibc-localedata-i18n \
	glibc-localedata-posix \
	less \
	bc \
	tar \
	bzip2 \
	gzip \
	rng-tools \
	util-linux-uuidgen \
	util-linux \
	tzdata \
	iputils \
	procps \
	dbus \	
"

RDEPENDS_packagegroup-datarespons-developer = "\
	gdb \
	strace \
	ldd \
"

RDEPENDS_packagegroup-datarespons-net = "\
	networkmanager \
	networkmanager-bash-completion \
"

RDEPENDS_packagegroup-datarespons-wifi = "\
	wpa-supplicant \
	wpa-supplicant-cli \
	wpa-supplicant-passphrase \
	crda \
	iw \
	rfkill \
"
RDEPENDS_packagegroup-datarespons-cellular = "\
	modemmanager \
	modemmanager-bash-completion \
	rfkill \
"
    
RDEPENDS_packagegroup-datarespons-bt = "\
	bluez5 \
	bluez5-noinst-tools \
	bluez5-testtools \
	rfkill \
"
	
RDEPENDS_packagegroup-datarespons-gps = "\
	gpsd \
	gpsd-conf \
	gps-utils \
	gpsd-gpsctl \
	libgps \
"

RDEPENDS_packagegroup-datarespons-screen = "\
	weston \
	weston-init \
	weston-examples \
	gtk+3-demo \
	clutter-1.0-examples \
	fbtest \
	glmark2 \
"
