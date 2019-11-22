/*
 * Check if session active. Return 0 for OK.
 */

#include <errno.h>
#include <stdio.h>
#include <string.h>
#include <wayland-client.h>

int main(int argc, char **argv)
{
	(void) argc;
	(void) argv;

	struct wl_display* display = NULL;

	display = wl_display_connect(NULL);
	if (!display) {
		fprintf(stderr, "failed to create display: %s\n",
			strerror(errno));
		return -1;
	}

	wl_display_disconnect(display);

	return 0;
}
