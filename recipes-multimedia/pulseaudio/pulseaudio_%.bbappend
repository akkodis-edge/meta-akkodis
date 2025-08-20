# Do not allow autostarting pulseaudio. Use pulseaudio-system.
do_compile:append () {
	set_cfg_value src/pulse/client.conf autospawn no
}
