#!/bin/sh

if [ $# -lt 1 ]; then
	echo "Usage: status-led [red|green|off]"
	exit 1
fi

case $1 in
	red)
		echo 1 > /sys/class/leds/status-red/brightness
		echo 0 > /sys/class/leds/status-green/brightness
		;;
		
	green)
		echo 1 > /sys/class/leds/status-green/brightness
		echo 0 > /sys/class/leds/status-red/brightness
		;;
	
	off)
		echo 0 > /sys/class/leds/status-green/brightness
		echo 0 > /sys/class/leds/status-red/brightness
		;;	
esac
