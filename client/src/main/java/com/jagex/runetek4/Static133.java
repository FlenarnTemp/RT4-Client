package com.jagex.runetek4;

import com.jagex.runetek4.scene.InteractiveObject;
import com.jagex.runetek4.scene.tile.SceneTile;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static133 {

	@OriginalMember(owner = "runetek4.client!kf", name = "f", descriptor = "I")
	public static int anInt5230;

	@OriginalMember(owner = "runetek4.client!kf", name = "c", descriptor = "J")
	public static long clickTime = 0L;

	@OriginalMember(owner = "runetek4.client!kf", name = "d", descriptor = "[Lclient!cl;")
	public static final AnimFrameset[] aClass3_Sub2_Sub7Array7 = new AnimFrameset[14];

	@OriginalMember(owner = "runetek4.client!kf", name = "l", descriptor = "I")
	public static int anInt5235 = 0;

	@OriginalMember(owner = "runetek4.client!kf", name = "b", descriptor = "(III)Lclient!ec;")
	public static InteractiveObject method4008(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(7) SceneTile local7 = Static130.levelTiles[arg0][arg1][arg2];
		if (local7 == null) {
			return null;
		}
		for (@Pc(13) int local13 = 0; local13 < local7.entityCount; local13++) {
			@Pc(22) InteractiveObject local22 = local7.interactiveObjects[local13];
			if ((local22.hash >> 29 & 0x3L) == 2L && local22.anInt1701 == arg1 && local22.anInt1696 == arg2) {
				return local22;
			}
		}
		return null;
	}

	@OriginalMember(owner = "runetek4.client!kf", name = "a", descriptor = "(II)I")
	public static int method4010(@OriginalArg(0) int arg0) {
		return arg0 & 0xFF;
	}

	@OriginalMember(owner = "runetek4.client!kf", name = "a", descriptor = "(Lclient!na;I)V")
	public static void method4011(@OriginalArg(0) JString arg0) {
		for (@Pc(15) Map local15 = (Map) Static228.aClass69_120.head(); local15 != null; local15 = (Map) Static228.aClass69_120.next()) {
			if (local15.aClass100_138.method3108(arg0)) {
				Static269.aClass3_Sub2_Sub4_2 = local15;
				return;
			}
		}
	}

	@OriginalMember(owner = "runetek4.client!kf", name = "a", descriptor = "(IIBII)V")
	public static void method4012(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
		for (@Pc(12) int local12 = 0; local12 < Static24.anInt766; local12++) {
			if (Static224.anIntArray443[local12] + Static264.anIntArray410[local12] > arg0 && arg1 + arg0 > Static264.anIntArray410[local12] && arg2 < Static67.anIntArray320[local12] + Static50.anIntArray133[local12] && Static50.anIntArray133[local12] < arg2 + arg3) {
				Static186.aBooleanArray100[local12] = true;
			}
		}
	}
}
