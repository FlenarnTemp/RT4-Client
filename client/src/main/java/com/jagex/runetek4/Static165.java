package com.jagex.runetek4;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static165 {

	@OriginalMember(owner = "runetek4.client!nb", name = "h", descriptor = "I")
	public static int anInt4038;

	@OriginalMember(owner = "runetek4.client!nb", name = "o", descriptor = "I")
	public static int anInt4042;

	@OriginalMember(owner = "runetek4.client!nb", name = "j", descriptor = "I")
	public static volatile int anInt4039 = -1;

	@OriginalMember(owner = "runetek4.client!nb", name = "m", descriptor = "Lclient!na;")
	public static final JString LOGO = JString.parse("logo");

	@OriginalMember(owner = "runetek4.client!nb", name = "a", descriptor = "(IIIIIIIIII)V")
	public static void method3162(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8) {
		if (arg0 == arg1 && arg8 == arg2 && arg7 == arg6 && arg4 == arg5) {
			PreciseSleep.method3982(arg3, arg4, arg0, arg8, arg6);
			return;
		}
		@Pc(32) int local32 = arg0;
		@Pc(36) int local36 = arg8 * 3;
		@Pc(40) int local40 = arg0 * 3;
		@Pc(42) int local42 = arg8;
		@Pc(46) int local46 = arg1 * 3;
		@Pc(50) int local50 = arg2 * 3;
		@Pc(54) int local54 = arg7 * 3;
		@Pc(58) int local58 = arg5 * 3;
		@Pc(66) int local66 = local46 + arg6 - local54 - arg0;
		@Pc(76) int local76 = local54 + local40 - local46 - local46;
		@Pc(85) int local85 = local50 + arg4 - local58 - arg8;
		@Pc(95) int local95 = local36 + local58 - local50 - local50;
		@Pc(100) int local100 = local46 - local40;
		@Pc(105) int local105 = local50 - local36;
		for (@Pc(107) int local107 = 128; local107 <= 4096; local107 += 128) {
			@Pc(118) int local118 = local107 * local107 >> 12;
			@Pc(124) int local124 = local107 * local118 >> 12;
			@Pc(128) int local128 = local95 * local118;
			@Pc(132) int local132 = local124 * local85;
			@Pc(136) int local136 = local118 * local76;
			@Pc(140) int local140 = local66 * local124;
			@Pc(144) int local144 = local100 * local107;
			@Pc(156) int local156 = arg0 + (local136 + local140 + local144 >> 12);
			@Pc(160) int local160 = local107 * local105;
			@Pc(172) int local172 = arg8 + (local160 + local132 + local128 >> 12);
			PreciseSleep.method3982(arg3, local172, local32, local42, local156);
			local32 = local156;
			local42 = local172;
		}
	}

	@OriginalMember(owner = "runetek4.client!nb", name = "a", descriptor = "(IIIIII)V")
	public static void method3163(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4) {
		if (arg1 == arg4) {
			Static82.method1760(arg4, arg2, arg0, arg3);
		} else if (Static172.anInt4164 <= arg2 - arg4 && arg2 + arg4 <= FloorUnderlayTypeList.anInt5063 && arg3 - arg1 >= Static267.anInt5773 && arg3 + arg1 <= Static106.anInt2869) {
			Static72.method1568(arg3, arg2, arg4, arg1, arg0);
		} else {
			Static35.method898(arg0, arg1, arg4, arg2, arg3);
		}
	}

}
