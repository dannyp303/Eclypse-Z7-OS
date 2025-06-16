SUMMARY = "u-dma-buf kernel module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://u-dma-buf.c \
           file://Makefile"

S = "${WORKDIR}"

inherit module
MODULE_NAME = "u-dma-buf"

# Install module into image's /lib/modules path
do_install() {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 u-dma-buf.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

FILES_${PN} += "${base_libdir}/modules/${KERNEL_VERSION}/extra/u-dma-buf.ko"

