
do_install:prepend () {
    sed -i -e 's/#RateLimitBurst=1000/RateLimitBurst=10000/' ${WORKDIR}/journald.conf
    sed -i -e 's/#RuntimeWatchdogSec=0/RuntimeWatchdogSec=60/' ${WORKDIR}/system.conf
    sed -i -e 's/#ShutdownWatchdogSec=10min/ShutdownWatchdogSec=110/' ${WORKDIR}/system.conf
}
