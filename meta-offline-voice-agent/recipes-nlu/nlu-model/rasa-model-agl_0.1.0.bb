SUMMARY = "Dataset and a pre-trained model for the AGL voice assistant RASA based NLU intent engine."
HOMEPAGE = "https://github.com/malik727/rasa-model-agl"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e01060a5557fe6a4b57f5ea6dc048d9"

SRC_URI = " \
    git://gerrit.automotivelinux.org/gerrit/src/rasa-model-agl;protocol=https;branch=${AGL_BRANCH} \
"

# Fixed, not ${AUTOREV}: a release must build the same source. Tip of master on 2026-11-23. On a release branch
# of this layer, set AGL_BRANCH and this revision together (the revision must be on that branch).
SRCREV = "59857bd999cccee100ff87ac51705e48227cb06c"

do_install() {
    install -d ${D}/usr/share/nlu/rasa
    cp -R ${S}/* ${D}/usr/share/nlu/rasa/
}

FILES:${PN} += " /usr/share/nlu/rasa"
