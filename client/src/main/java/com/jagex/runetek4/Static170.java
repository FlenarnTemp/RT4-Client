package com.jagex.runetek4;

import com.jagex.runetek4.cache.def.VarPlayerDefinition;
import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.dash3d.entity.Entity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static170 {

	@OriginalMember(owner = "runetek4.client!nh", name = "eb", descriptor = "I")
	public static int anInt3245;

	@OriginalMember(owner = "runetek4.client!nh", name = "Z", descriptor = "I")
	public static int anInt3241 = 128;

	@OriginalMember(owner = "runetek4.client!nh", name = "fb", descriptor = "[I")
	public static final int[] anIntArray306 = new int[] { 4, 4, 1, 2, 6, 4, 2, 49, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	@OriginalMember(owner = "runetek4.client!nh", name = "hb", descriptor = "Lclient!na;")
	public static final JString FPS = Static28.parse("::fps ");

	@OriginalMember(owner = "runetek4.client!nh", name = "a", descriptor = "(IIIII)I")
	public static int method2569(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
		@Pc(22) int local22 = 65536 - MathUtils.anIntArray225[arg2 * 1024 / arg3] >> 1;
		return (arg0 * (65536 - local22) >> 16) + (arg1 * local22 >> 16);
	}

	@OriginalMember(owner = "runetek4.client!nh", name = "a", descriptor = "(IIIILclient!th;JZ)V")
	public static void method2570(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) Entity arg4, @OriginalArg(5) long arg5, @OriginalArg(6) boolean arg6) {
		if (arg4 == null) {
			return;
		}
		@Pc(6) GroundDecor local6 = new GroundDecor();
		local6.entity = arg4;
		local6.xFine = arg1 * 128 + 64;
		local6.zFine = arg2 * 128 + 64;
		local6.anInt733 = arg3;
		local6.key = arg5;
		local6.aBoolean49 = arg6;
		if (Static130.levelTiles[arg0][arg1][arg2] == null) {
			Static130.levelTiles[arg0][arg1][arg2] = new Ground(arg0, arg1, arg2);
		}
		Static130.levelTiles[arg0][arg1][arg2].groundDecor = local6;
	}

	@OriginalMember(owner = "runetek4.client!nh", name = "a", descriptor = "(I[B)Z")
	public static boolean method2572(@OriginalArg(1) byte[] arg0) {
		@Pc(13) Packet local13 = new Packet(arg0);
		@Pc(17) int local17 = local13.g1();
		if (local17 != 1) {
			return false;
		}
		@Pc(33) boolean local33 = local13.g1() == 1;
		if (local33) {
			Static97.method1962(local13);
		}
		Static69.method1546(local13);
		return true;
	}

	@OriginalMember(owner = "runetek4.client!nh", name = "a", descriptor = "(IIIIIIIIIIIII)V")
	public static void method2574(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(11) int arg10, @OriginalArg(12) int arg11) {
		@Pc(7) Class3_Sub8 local7 = new Class3_Sub8();
		local7.angle = arg6;
		local7.anInt1205 = arg3;
		local7.anInt1187 = arg1;
		local7.anInt1200 = arg5;
		local7.anInt1192 = arg2;
		local7.anInt1190 = arg8;
		local7.anInt1197 = arg10;
		local7.anInt1204 = arg4;
		local7.anInt1189 = arg11;
		local7.anInt1188 = arg7;
		local7.anInt1191 = arg0;
		local7.anInt1198 = arg9;
		Static128.aClass69_77.addTail(local7);
	}

	@OriginalMember(owner = "runetek4.client!nh", name = "a", descriptor = "(BII)V")
	public static void method2575(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		VarPlayerDefinition.varPlayerCache[arg1] = arg0;
		@Pc(20) LongNode local20 = (LongNode) Static199.aClass133_20.getNode((long) arg1);
		if (local20 == null) {
			local20 = new LongNode(4611686018427387905L);
			Static199.aClass133_20.pushNode(local20, (long) arg1);
		} else if (local20.aLong55 != 4611686018427387905L) {
			local20.aLong55 = MonotonicTime.get() + 500L | 0x4000000000000000L;
		}
	}
}
