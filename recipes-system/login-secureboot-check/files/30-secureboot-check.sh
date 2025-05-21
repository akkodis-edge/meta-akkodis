#!/bin/sh

echo ""
if [ -d /sys/firmware/efi ]; then
	echo "Platform booted in EFI mode"
	efi-keytool
else
	echo "Platform booted in legacy mode"
fi
echo ""
