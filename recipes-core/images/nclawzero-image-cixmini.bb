# SPDX-FileCopyrightText: Copyright (c) 2026 Jason Perlow
# SPDX-License-Identifier: Apache-2.0
#
# nclawzero-image-cixmini -- first-pass headless image for Cix Sky1 / MS-R1.

SUMMARY = "nclawzero Cix Sky1 edge image"
DESCRIPTION = "Headless nclawzero image scaffold for the Cix Sky1 / CP8180 Minisforum MS-R1 target."
LICENSE = "Apache-2.0"

inherit core-image

COMPATIBLE_MACHINE = "(cixmini)"

# debug-tweaks is intentionally NOT in the canonical image — it leaves the
# root password unset and is a Layer Index review concern. Dev builds can
# opt in via local.conf:
#     EXTRA_IMAGE_FEATURES = "debug-tweaks empty-root-password allow-empty-password"
IMAGE_FEATURES += " \
    ssh-server-openssh \
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
