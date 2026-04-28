# SPDX-FileCopyrightText: Copyright (c) 2026 Jason Perlow
# SPDX-License-Identifier: Apache-2.0
#
# nclawzero-image-cixpi -- first-pass headless image for Cix Sky1 / MS-R1.

SUMMARY = "nclawzero Cix Sky1 edge image"
DESCRIPTION = "Headless nclawzero image scaffold for the Cix Sky1 / CP8180 Minisforum MS-R1 target."
LICENSE = "Apache-2.0"

inherit core-image

COMPATIBLE_MACHINE = "(cixpi)"

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    cix-sky1-firmware \
    linux-firmware \
    kernel-modules \
"

IMAGE_LINGUAS = ""
SYSTEMD_DEFAULT_TARGET ?= "multi-user.target"
IMAGE_ROOTFS_EXTRA_SPACE = "524288"
