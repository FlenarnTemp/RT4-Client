package com.jagex.runetek4;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static20 {

	@OriginalMember(owner = "client!bj", name = "r", descriptor = "I")
	public static int cameraOffsetZModifier = 2;

	@OriginalMember(owner = "client!bj", name = "s", descriptor = "I")
	public static int anInt660 = -1;

	@OriginalMember(owner = "client!bj", name = "t", descriptor = "[S")
	public static final short[] aShortArray5 = new short[] { -4160, -4163, -8256, -8259, 22461 };

	@OriginalMember(owner = "client!bj", name = "V", descriptor = "I")
	public static final int anInt671 = 3353893;

	@OriginalMember(owner = "client!bj", name = "Y", descriptor = "I")
	public static int anInt673 = 0;

	@OriginalMember(owner = "client!bj", name = "d", descriptor = "(B)V")
	public static void method601() {
		Static36.aClass133_3.removeAll();
		Static140.aClass16_7.method802();
		Static215.aClass16_9.method802();
	}

	@OriginalMember(owner = "client!bj", name = "a", descriptor = "(III)J")
	public static long method602(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(7) Ground local7 = Static130.levelTiles[arg0][arg1][arg2];
		return local7 == null || local7.groundDecor == null ? 0L : local7.groundDecor.key;
	}
}
