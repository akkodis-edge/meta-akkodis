
do_install_prepend () {
    sed -i -e 's/#RateLimitBurst=1000/RateLimitBurst=10000/' ${S}/src/journal/journald.conf
    sed -i -e 's/#RuntimeWatchdogSec=0/RuntimeWatchdogSec=60/' ${S}/src/core/system.conf.in
    sed -i -e 's/#ShutdownWatchdogSec=10min/ShutdownWatchdogSec=110/' ${S}/src/core/system.conf.in
}
