FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://system-user.dtsi"

do_patch_components_dts() {
    DTS="${TOPDIR}/../components/plnx_workspace/device-tree/device-tree/system-top.dts"

    if [ ! -f "$DTS" ]; then
        bbwarn "⚠️ $DTS not found"
        return
    fi

    if grep -q 'pl.dtsi' "$DTS"; then
        bbplain "ℹ️ pl.dtsi already present"
    else
        sed -i '/pcw.dtsi/a #include "pl.dtsi"' "$DTS"
        bbplain "✅ Patched $DTS with #include \"pl.dtsi\""
    fi
}
addtask patch_components_dts after do_configure before do_compile
