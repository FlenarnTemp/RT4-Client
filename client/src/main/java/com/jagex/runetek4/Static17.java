package com.jagex.runetek4;

import com.jagex.runetek4.core.io.PacketBit;
import com.jagex.runetek4.cache.media.component.Component;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static17 {

	@OriginalMember(owner = "client!bg", name = "g", descriptor = "Lclient!i;")
	public static final PacketBit aClass3_Sub15_Sub1_2 = new PacketBit(5000);

	@OriginalMember(owner = "client!bg", name = "z", descriptor = "Lclient!na;")
	public static final JString aClass100_101 = Static28.parse("k");

	@OriginalMember(owner = "client!bg", name = "A", descriptor = "[I")
	public static final int[] anIntArray53 = new int[128];

	@OriginalMember(owner = "client!bg", name = "M", descriptor = "I")
	public static int crossCycle = 0;

	@OriginalMember(owner = "client!bg", name = "N", descriptor = "Lclient!na;")
	public static final JString MAPFUNCTION = Static28.parse("mapfunction");

	@OriginalMember(owner = "client!bg", name = "a", descriptor = "(B)V")
	public static void method527() {
		Static57.in.accessBits();
		@Pc(11) int local11 = Static57.in.gBit(1);
		if (local11 == 0) {
			return;
		}
		@Pc(23) int local23 = Static57.in.gBit(2);
		if (local23 == 0) {
			Static44.entityUpdateIds[Static116.entityUpdateCount++] = 2047;
			return;
		}
		@Pc(54) int local54;
		@Pc(64) int local64;
		if (local23 == 1) {
			local54 = Static57.in.gBit(3);
			Static173.localPlayer.method2684(1, local54);
			local64 = Static57.in.gBit(1);
			if (local64 == 1) {
				Static44.entityUpdateIds[Static116.entityUpdateCount++] = 2047;
			}
		} else if (local23 == 2) {
			if (Static57.in.gBit(1) == 1) {
				local54 = Static57.in.gBit(3);
				Static173.localPlayer.method2684(2, local54);
				local64 = Static57.in.gBit(3);
				Static173.localPlayer.method2684(2, local64);
			} else {
				local54 = Static57.in.gBit(3);
				Static173.localPlayer.method2684(0, local54);
			}
			local54 = Static57.in.gBit(1);
			if (local54 == 1) {
				Static44.entityUpdateIds[Static116.entityUpdateCount++] = 2047;
			}
		} else if (local23 == 3) {
			local54 = Static57.in.gBit(7);
			local64 = Static57.in.gBit(1);
			Static55.currentLevel = Static57.in.gBit(2);
			@Pc(163) int local163 = Static57.in.gBit(1);
			if (local163 == 1) {
				Static44.entityUpdateIds[Static116.entityUpdateCount++] = 2047;
			}
			@Pc(181) int local181 = Static57.in.gBit(7);
			Static173.localPlayer.teleport(local181, local64 == 1, local54);
		}
	}

	@OriginalMember(owner = "client!bg", name = "d", descriptor = "(II)Z")
	public static boolean method530(@OriginalArg(0) int arg0) {
		return arg0 == 198 || arg0 == 230 || arg0 == 156 || arg0 == 140 || arg0 == 223;
	}

	@OriginalMember(owner = "client!bg", name = "a", descriptor = "(Lclient!be;ZI)V")
	public static void method531(@OriginalArg(0) Component arg0, @OriginalArg(1) boolean arg1) {
		@Pc(20) int local20 = arg0.anInt486 == 0 ? arg0.anInt445 : arg0.anInt486;
		@Pc(32) int local32 = arg0.anInt491 == 0 ? arg0.anInt459 : arg0.anInt491;
		Static266.method4190(arg0.anInt507, arg1, local20, local32, Component.cachedComponents[arg0.anInt507 >> 16]);
		if (arg0.createdComponents != null) {
			Static266.method4190(arg0.anInt507, arg1, local20, local32, arg0.createdComponents);
		}
		@Pc(66) Class3_Sub31 local66 = (Class3_Sub31) Static119.aClass133_9.getNode((long) arg0.anInt507);
		if (local66 != null) {
			Static234.method4017(local32, arg1, local66.anInt5878, local20);
		}
	}
}
