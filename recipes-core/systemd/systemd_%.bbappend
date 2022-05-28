
do_configure:prepend() {
    echo "FallbackNTP=1.pool.ntp.org 2.pool.ntp.org time1.google.com 0.cn.pool.ntp.org" >> ${S}/src/timesync/timesyncd.conf.in
}