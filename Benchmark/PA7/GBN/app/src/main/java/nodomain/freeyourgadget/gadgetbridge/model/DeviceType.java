/*  Copyright (C) 2015-2020 Andreas Böhler, Andreas Shimokawa, Carsten
    Pfeiffer, Cre3per, Daniel Dakhno, Daniele Gobbetti, Gordon Williams,
    Jean-François Greffier, João Paulo Barraca, José Rebelo, Kranz, ladbsoft,
    Manuel Ruß, maxirnilian, Pavel, Pavel Elagin, protomors, Quallenauge,
    Sami Alaoui, Sebastian Kranz, Sophanimus, tiparega, Vadim Kaushan

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import nodomain.freeyourgadget.gadgetbridge.R;

/**
 * For every supported device, a device type constant must exist.
 *
 * Note: they key of every constant is stored in the DB, so it is fixed forever,
 * and may not be changed.
 */
public enum DeviceType {
    UNKNOWN(-1, R.drawable.ic_device_unknown, R.drawable.ic_device_unknown_disabled, R.string.devicetype_unknown),
    PEBBLE(1, R.drawable.ic_device_pebble, R.drawable.ic_device_pebble_disabled, R.string.devicetype_pebble),
    MIBAND(10, R.drawable.ic_device_miband, R.drawable.ic_device_miband_disabled, R.string.devicetype_miband),
    MIBAND2(11, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_miband2),
    AMAZFITBIP(12, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bip),
    AMAZFITCOR(13, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_amazfit_cor),
    MIBAND3(14, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_miband3),
    AMAZFITCOR2(15, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_amazfit_cor2),
    MIBAND4(16, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_miband4),
    AMAZFITBIP_LITE(17, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bip_lite),
    AMAZFITGTR(18, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_gtr),
    AMAZFITGTS(19, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_gts),
    AMAZFITBIPS(20, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bips),
    AMAZFITGTR_LITE(21, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_gtr),
    AMAZFITTREX(22, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_trex),
    MIBAND5(23, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_miband5),
    AMAZFITBAND5(24, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_amazfit_band5),
    AMAZFITBIPS_LITE(25, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bips_lite),
    AMAZFITGTR2(26, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_gtr2),
    AMAZFITGTS2(27, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_gts2),
    AMAZFITBIPU(28, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bipu),
    AMAZFITVERGEL(29, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_vergel),
    AMAZFITBIPUPRO(30, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_bipupro),
    AMAZFITNEO(31, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_neo),
    AMAZFITGTS2_MINI(32, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_gts2_mini),
    ZEPP_E(33, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_zepp_e),
    AMAZFITGTR2E(34, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_gtr2e),
    AMAZFITGTS2E(35, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled,R.string .devicetype_amazfit_gts2e),
    AMAZFITX(36, R.drawable.ic_device_miband2, R.drawable.ic_device_miband2_disabled, R.string.devicetype_amazfit_x),
    MIBAND6(37, R.drawable.ic_device_miband6, R.drawable.ic_device_miband6_disabled, R.string.devicetype_miband6),
    AMAZFITTREXPRO(38, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_amazfit_trex_pro),
    AMAZFITPOP(39, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_pop),
    AMAZFITPOPPRO(10040, R.drawable.ic_device_amazfit_bip, R.drawable.ic_device_amazfit_bip_disabled, R.string.devicetype_amazfit_pop_pro),
    HPLUS(40, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_hplus),
    MAKIBESF68(41, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_makibes_f68),
    EXRIZUK8(42, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_exrizu_k8),
    Q8(43, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_q8),
    SG2(44, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_sg2),
    NO1F1(50, R.drawable.ic_device_hplus, R.drawable.ic_device_hplus_disabled, R.string.devicetype_no1_f1),
    TECLASTH30(60, R.drawable.ic_device_h30_h10, R.drawable.ic_device_h30_h10_disabled, R.string.devicetype_teclast_h30),
    Y5(61, R.drawable.ic_device_h30_h10, R.drawable.ic_device_roidmi_disabled, R.string.devicetype_y5),
    XWATCH(70, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_xwatch),
    ZETIME(80, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_mykronoz_zetime),
    ID115(90, R.drawable.ic_device_h30_h10, R.drawable.ic_device_h30_h10_disabled, R.string.devicetype_id115),
    WATCH9(100, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_watch9),
    WATCHX(101, R.drawable.ic_device_watchxplus, R.drawable.ic_device_watchxplus_disabled, R.string.devicetype_watchx),
    WATCHXPLUS(102, R.drawable.ic_device_watchxplus, R.drawable.ic_device_watchxplus_disabled, R.string.devicetype_watchxplus),
    ROIDMI(110, R.drawable.ic_device_roidmi, R.drawable.ic_device_roidmi_disabled, R.string.devicetype_roidmi),
    ROIDMI3(112, R.drawable.ic_device_roidmi, R.drawable.ic_device_roidmi_disabled, R.string.devicetype_roidmi3),
    CASIOGB6900(120, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_casiogb6900),
    CASIOGBX100(121, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_casiogbx100),
    MISCALE2(131, R.drawable.ic_device_miscale2, R.drawable.ic_device_miscale2_disabled, R.string.devicetype_miscale2),
    BFH16(140, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_bfh16),
    MAKIBESHR3(150, R.drawable.ic_device_default, R.drawable.ic_device_hplus_disabled, R.string.devicetype_makibes_hr3),
    BANGLEJS(160, R.drawable.ic_device_banglejs, R.drawable.ic_device_banglejs_disabled, R.string.devicetype_banglejs),
    FOSSILQHYBRID(170, R.drawable.ic_device_zetime, R.drawable.ic_device_zetime_disabled, R.string.devicetype_qhybrid),
    TLW64(180, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_tlw64),
    PINETIME_JF(190, R.drawable.ic_device_pinetime, R.drawable.ic_device_pinetime_disabled, R.string.devicetype_pinetime_jf),
    MIJIA_LYWSD02(200, R.drawable.ic_device_pebble, R.drawable.ic_device_pebble_disabled, R.string.devicetype_mijia_lywsd02),
    LEFUN(210, R.drawable.ic_device_h30_h10, R.drawable.ic_device_h30_h10_disabled, R.string.devicetype_lefun),
    SMAQ2OSS(220, R.drawable.ic_device_default, R.drawable.ic_device_default, R.string.devicetype_smaq2oss),
    FITPRO(230, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_fitpro),
    ITAG(250, R.drawable.ic_device_itag, R.drawable.ic_device_itag_disabled, R.string.devicetype_itag),
    NUTMINI(251, R.drawable.ic_device_itag, R.drawable.ic_device_itag_disabled, R.string.devicetype_nut_mini),
    VIBRATISSIMO(300, R.drawable.ic_device_lovetoy, R.drawable.ic_device_lovetoy_disabled, R.string.devicetype_vibratissimo),
    SONY_SWR12(310, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_sonyswr12),
    LIVEVIEW(320, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_liveview),
    WASPOS(330, R.drawable.ic_device_pebble, R.drawable.ic_device_pebble_disabled, R.string.devicetype_waspos),
    UM25(350, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_um25),
    DOMYOS_T540(400, R.drawable.ic_device_lovetoy, R.drawable.ic_device_lovetoy_disabled, R.string.devicetype_domyos_t540),
    NOTHING_EAR1(410, R.drawable.ic_device_nothingear, R.drawable.ic_device_nothingear_disabled, R.string.devicetype_nothingear1),
    GALAXY_BUDS_PRO(418, R.drawable.ic_device_galaxy_buds_pro, R.drawable.ic_device_galaxy_buds_pro_disabled, R.string.devicetype_galaxybuds_pro),
    GALAXY_BUDS_LIVE(419, R.drawable.ic_device_galaxy_buds_live, R.drawable.ic_device_galaxy_buds_live_disabled, R.string.devicetype_galaxybuds_live),
    GALAXY_BUDS(420, R.drawable.ic_device_galaxy_buds, R.drawable.ic_device_galaxy_buds_disabled, R.string.devicetype_galaxybuds),
    SONY_WH_1000XM3(430, R.drawable.ic_device_sony_overhead, R.drawable.ic_device_sony_overhead_disabled, R.string.devicetype_sony_wh_1000xm3),
    SONY_WF_SP800N(431, R.drawable.ic_device_sony_wf_800n, R.drawable.ic_device_sony_wf_800n_disabled, R.string.devicetype_sony_wf_sp800n),
    SONY_WH_1000XM4(432, R.drawable.ic_device_sony_overhead, R.drawable.ic_device_sony_overhead_disabled, R.string.devicetype_sony_wh_1000xm4),
    SONY_WF_1000XM3(433, R.drawable.ic_device_galaxy_buds, R.drawable.ic_device_galaxy_buds_disabled, R.string.devicetype_sony_wf_1000xm3),
    BOSE_QC35(440, R.drawable.ic_device_headphones, R.drawable.ic_device_headphones_disabled, R.string.devicetype_bose_qc35),
    VESC_NRF(500, R.drawable.ic_device_vesc, R.drawable.ic_device_vesc_disabled, R.string.devicetype_vesc),
    VESC_HM10(501, R.drawable.ic_device_vesc, R.drawable.ic_device_vesc_disabled, R.string.devicetype_vesc),
    TEST(1000, R.drawable.ic_device_default, R.drawable.ic_device_default_disabled, R.string.devicetype_test);

    private final int key;
    @DrawableRes
    private final int defaultIcon;
    @DrawableRes
    private final int disabledIcon;
    @StringRes
    private final int name;

    DeviceType(int key, int defaultIcon, int disabledIcon, int name) {
        this.key = key;
        this.defaultIcon = defaultIcon;
        this.disabledIcon = disabledIcon;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public boolean isSupported() {
        return this != UNKNOWN;
    }

    public static DeviceType fromKey(int key) {
        for (DeviceType type : values()) {
            if (type.key == key) {
                return type;
            }
        }
        return DeviceType.UNKNOWN;
    }

    @StringRes
    public int getName() {
        return name;
    }

    @DrawableRes
    public int getIcon() {
        return defaultIcon;
    }

    @DrawableRes
    public int getDisabledIcon() {
        return disabledIcon;
    }
}
