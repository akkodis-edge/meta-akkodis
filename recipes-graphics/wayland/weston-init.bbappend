do_install:prepend() {
    # Disable screen locking
    sed -i 's/.*#locking=.*/locking=false/g' ${S}/weston.ini
    
    # Disable screen fade to black
    sed -i '/^[core].*/a idle-time=0' ${S}/weston.ini
}
