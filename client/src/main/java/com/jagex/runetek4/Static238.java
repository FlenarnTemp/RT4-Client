package com.jagex.runetek4;

import com.jagex.runetek4.game.client.logic.DelayedStateChange;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static238 {

	@OriginalMember(owner = "runetek4.client!te", name = "y", descriptor = "Lclient!ve;")
	public static Js5 configClientSmall;

	@OriginalMember(owner = "runetek4.client!te", name = "H", descriptor = "[I")
	public static int[] anIntArray470;

	@OriginalMember(owner = "runetek4.client!te", name = "B", descriptor = "[I")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_Z = new int[] { 0, -1, 0, 1 };

	@OriginalMember(owner = "runetek4.client!te", name = "C", descriptor = "I")
	public static int anInt5316 = 64;

	@OriginalMember(owner = "runetek4.client!te", name = "a", descriptor = "(IZ)V")
	public static void method4142() {
		Static67.aClass99_20.clear(5);
	}

	@OriginalMember(owner = "runetek4.client!te", name = "a", descriptor = "(III)Lclient!da;")
	public static DelayedStateChange method4143(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(13) DelayedStateChange local13 = (DelayedStateChange) Static36.aClass133_3.getNode((long) arg1 | (long) arg0 << 32);
		if (local13 == null) {
			local13 = new DelayedStateChange(arg0, arg1);
			Static36.aClass133_3.pushNode(local13, local13.nodeId);
		}
		return local13;
	}

	@OriginalMember(owner = "runetek4.client!te", name = "b", descriptor = "(Lclient!na;I)Z")
	public static boolean method4144(@OriginalArg(0) JString arg0) {
		if (arg0 == null) {
			return false;
		}
		for (@Pc(11) int local11 = 0; local11 < Static35.ignoreCount; local11++) {
			if (arg0.equalsIgnoreCase(Static193.ignoreName[local11])) {
				return true;
			}
		}
		return false;
	}

	@OriginalMember(owner = "runetek4.client!te", name = "e", descriptor = "(I)V")
	public static void method4145() {
		Static151.method2809();
		Static2.anInterface4Array1 = new MaterialRenderer[7];
		Static2.anInterface4Array1[1] = new SpecularMaterialRenderer();
		Static2.anInterface4Array1[2] = new LiquidMaterialRenderer();
		Static2.anInterface4Array1[3] = new UnderwaterMaterialRenderer();
		Static2.anInterface4Array1[4] = new WaterMaterialRenderer();
		Static2.anInterface4Array1[5] = new WaterfallMaterialRenderer();
		Static2.anInterface4Array1[6] = new UnlitMaterialRenderer();
	}
}
