package com.jagex.runetek4;

import com.jagex.runetek4.cache.media.ImageRGB;
import com.jagex.runetek4.js5.CacheArchive;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static167 {

	@OriginalMember(owner = "runetek4.client!nd", name = "s", descriptor = "I")
	public static int eyeTileX;

	@OriginalMember(owner = "runetek4.client!nd", name = "y", descriptor = "Lclient!mm;")
	public static ImageRGB aClass3_Sub2_Sub1_Sub1_3;

	@OriginalMember(owner = "runetek4.client!nd", name = "b", descriptor = "Lclient!na;")
	public static final JString aClass100_780 = Static28.parse("Clientscript error in: ");

	@OriginalMember(owner = "runetek4.client!nd", name = "q", descriptor = "[[I")
	public static final int[][] anIntArrayArray31 = new int[104][104];

	@OriginalMember(owner = "runetek4.client!nd", name = "r", descriptor = "Lclient!na;")
	public static final JString aClass100_781 = Static28.parse("zap");

	@OriginalMember(owner = "runetek4.client!nd", name = "x", descriptor = "Lclient!na;")
	public static final JString aClass100_783 = Static28.parse(")4p=");

	@OriginalMember(owner = "runetek4.client!nd", name = "a", descriptor = "(ZLclient!qb;)V")
	public static void method3170(@OriginalArg(1) PcmStream arg0) {
		if (arg0.aClass3_Sub16_5 != null) {
			arg0.aClass3_Sub16_5.anInt3313 = 0;
		}
		arg0.aBoolean292 = false;
		for (@Pc(14) PcmStream local14 = arg0.method4406(); local14 != null; local14 = arg0.method4409()) {
			method3170(local14);
		}
	}

	@OriginalMember(owner = "runetek4.client!nd", name = "a", descriptor = "(ILclient!ve;)V")
	public static void method3172(@OriginalArg(1) CacheArchive arg0) {
		Static262.anInt5754 = arg0.method4482(Static27.aClass100_165);
		Static136.anInt3322 = arg0.method4482(Static165.LOGO);
	}
}
