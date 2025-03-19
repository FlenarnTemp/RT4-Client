package com.jagex.runetek4;

import com.jagex.runetek4.media.renderable.actor.Player;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static2 {

	@OriginalMember(owner = "runetek4.client!aa", name = "m", descriptor = "I")
	public static int anInt15;

	@OriginalMember(owner = "runetek4.client!aa", name = "t", descriptor = "[Lclient!pc;")
	public static MaterialRenderer[] anInterface4Array1;

	@OriginalMember(owner = "runetek4.client!aa", name = "l", descriptor = "Z")
	public static boolean membersWorld = false;

	@OriginalMember(owner = "runetek4.client!aa", name = "a", descriptor = "(IIIIIZIIIIII)Z")
	public static boolean method8(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(11) int arg10) {
		@Pc(3) int local3;
		@Pc(8) int local8;
		for (local3 = 0; local3 < 104; local3++) {
			for (local8 = 0; local8 < 104; local8++) {
				Static145.anIntArrayArray25[local3][local8] = 0;
				Static167.anIntArrayArray31[local3][local8] = 99999999;
			}
		}
		Static145.anIntArrayArray25[arg10][arg3] = 99;
		Static167.anIntArrayArray31[arg10][arg3] = 0;
		local8 = arg3;
		local3 = arg10;
		@Pc(53) byte local53 = 0;
		PathFinder.queueX[0] = arg10;
		@Pc(59) boolean local59 = false;
		@Pc(61) int local61 = 0;
		@Pc(64) int local64 = local53 + 1;
		PathFinder.queueZ[0] = arg3;
		@Pc(71) int[][] local71 = PathFinder.collisionMaps[Player.plane].flags;
		@Pc(193) int local193;
		while (local61 != local64) {
			local3 = PathFinder.queueX[local61];
			local8 = PathFinder.queueZ[local61];
			local61 = local61 + 1 & 0xFFF;
			if (arg8 == local3 && arg4 == local8) {
				local59 = true;
				break;
			}
			if (arg1 != 0) {
				if ((arg1 < 5 || arg1 == 10) && PathFinder.collisionMaps[Player.plane].isAtWall(arg4, local3, local8, arg8, arg1 - 1, 2, arg7)) {
					local59 = true;
					break;
				}
				if (arg1 < 10 && PathFinder.collisionMaps[Player.plane].isAtWallDecor(arg4, arg1 - 1, arg8, local8, 2, arg7, local3)) {
					local59 = true;
					break;
				}
			}
			if (arg0 != 0 && arg6 != 0 && PathFinder.collisionMaps[Player.plane].isInsideOrOutsideRect(arg8, local8, local3, 2, arg0, arg2, arg4, arg6)) {
				local59 = true;
				break;
			}
			local193 = Static167.anIntArrayArray31[local3][local8] + 1;
			if (local3 > 0 && Static145.anIntArrayArray25[local3 - 1][local8] == 0 && (local71[local3 - 1][local8] & 0x12C010E) == 0 && (local71[local3 - 1][local8 + 1] & 0x12C0138) == 0) {
				PathFinder.queueX[local64] = local3 - 1;
				PathFinder.queueZ[local64] = local8;
				local64 = local64 + 1 & 0xFFF;
				Static145.anIntArrayArray25[local3 - 1][local8] = 2;
				Static167.anIntArrayArray31[local3 - 1][local8] = local193;
			}
			if (local3 < 102 && Static145.anIntArrayArray25[local3 + 1][local8] == 0 && (local71[local3 + 2][local8] & 0x12C0183) == 0 && (local71[local3 + 2][local8 + 1] & 0x12C01E0) == 0) {
				PathFinder.queueX[local64] = local3 + 1;
				PathFinder.queueZ[local64] = local8;
				local64 = local64 + 1 & 0xFFF;
				Static145.anIntArrayArray25[local3 + 1][local8] = 8;
				Static167.anIntArrayArray31[local3 + 1][local8] = local193;
			}
			if (local8 > 0 && Static145.anIntArrayArray25[local3][local8 - 1] == 0 && (local71[local3][local8 - 1] & 0x12C010E) == 0 && (local71[local3 + 1][local8 - 1] & 0x12C0183) == 0) {
				PathFinder.queueX[local64] = local3;
				PathFinder.queueZ[local64] = local8 - 1;
				Static145.anIntArrayArray25[local3][local8 - 1] = 1;
				Static167.anIntArrayArray31[local3][local8 - 1] = local193;
				local64 = local64 + 1 & 0xFFF;
			}
			if (local8 < 102 && Static145.anIntArrayArray25[local3][local8 + 1] == 0 && (local71[local3][local8 + 2] & 0x12C0138) == 0 && (local71[local3 + 1][local8 + 2] & 0x12C01E0) == 0) {
				PathFinder.queueX[local64] = local3;
				PathFinder.queueZ[local64] = local8 + 1;
				Static145.anIntArrayArray25[local3][local8 + 1] = 4;
				local64 = local64 + 1 & 0xFFF;
				Static167.anIntArrayArray31[local3][local8 + 1] = local193;
			}
			if (local3 > 0 && local8 > 0 && Static145.anIntArrayArray25[local3 - 1][local8 - 1] == 0 && (local71[local3 - 1][local8] & 0x12C0138) == 0 && (local71[local3 - 1][local8 - 1] & 0x12C010E) == 0 && (local71[local3][local8 - 1] & 0x12C0183) == 0) {
				PathFinder.queueX[local64] = local3 - 1;
				PathFinder.queueZ[local64] = local8 - 1;
				Static145.anIntArrayArray25[local3 - 1][local8 - 1] = 3;
				Static167.anIntArrayArray31[local3 - 1][local8 - 1] = local193;
				local64 = local64 + 1 & 0xFFF;
			}
			if (local3 < 102 && local8 > 0 && Static145.anIntArrayArray25[local3 + 1][local8 - 1] == 0 && (local71[local3 + 1][local8 - 1] & 0x12C010E) == 0 && (local71[local3 + 2][local8 - 1] & 0x12C0183) == 0 && (local71[local3 + 2][local8] & 0x12C01E0) == 0) {
				PathFinder.queueX[local64] = local3 + 1;
				PathFinder.queueZ[local64] = local8 - 1;
				local64 = local64 + 1 & 0xFFF;
				Static145.anIntArrayArray25[local3 + 1][local8 - 1] = 9;
				Static167.anIntArrayArray31[local3 + 1][local8 - 1] = local193;
			}
			if (local3 > 0 && local8 < 102 && Static145.anIntArrayArray25[local3 - 1][local8 + 1] == 0 && (local71[local3 - 1][local8 + 1] & 0x12C010E) == 0 && (local71[local3 - 1][local8 + 2] & 0x12C0138) == 0 && (local71[local3][local8 + 2] & 0x12C01E0) == 0) {
				PathFinder.queueX[local64] = local3 - 1;
				PathFinder.queueZ[local64] = local8 + 1;
				Static145.anIntArrayArray25[local3 - 1][local8 + 1] = 6;
				Static167.anIntArrayArray31[local3 - 1][local8 + 1] = local193;
				local64 = local64 + 1 & 0xFFF;
			}
			if (local3 < 102 && local8 < 102 && Static145.anIntArrayArray25[local3 + 1][local8 + 1] == 0 && (local71[local3 + 1][local8 + 2] & 0x12C0138) == 0 && (local71[local3 + 2][local8 + 2] & 0x12C01E0) == 0 && (local71[local3 + 2][local8 + 1] & 0x12C0183) == 0) {
				PathFinder.queueX[local64] = local3 + 1;
				PathFinder.queueZ[local64] = local8 + 1;
				local64 = local64 + 1 & 0xFFF;
				Static145.anIntArrayArray25[local3 + 1][local8 + 1] = 12;
				Static167.anIntArrayArray31[local3 + 1][local8 + 1] = local193;
			}
		}
		BZip2State.tryMoveNearest = 0;
		@Pc(921) int local921;
		if (!local59) {
			if (!arg5) {
				return false;
			}
			local193 = 1000;
			local921 = 100;
			for (@Pc(928) int local928 = arg8 - 10; local928 <= arg8 + 10; local928++) {
				for (@Pc(942) int local942 = arg4 - 10; local942 <= arg4 + 10; local942++) {
					if (local928 >= 0 && local942 >= 0 && local928 < 104 && local942 < 104 && Static167.anIntArrayArray31[local928][local942] < 100) {
						@Pc(978) int local978 = 0;
						@Pc(980) int local980 = 0;
						if (local928 < arg8) {
							local978 = arg8 - local928;
						} else if (local928 > arg0 + arg8 - 1) {
							local978 = local928 + 1 - arg0 - arg8;
						}
						if (arg4 > local942) {
							local980 = arg4 - local942;
						} else if (local942 > arg4 + arg6 - 1) {
							local980 = local942 + 1 - arg4 - arg6;
						}
						@Pc(1057) int local1057 = local978 * local978 + local980 * local980;
						if (local1057 < local193 || local193 == local1057 && Static167.anIntArrayArray31[local928][local942] < local921) {
							local8 = local942;
							local921 = Static167.anIntArrayArray31[local928][local942];
							local193 = local1057;
							local3 = local928;
						}
					}
				}
			}
			if (local193 == 1000) {
				return false;
			}
			if (arg10 == local3 && local8 == arg3) {
				return false;
			}
			BZip2State.tryMoveNearest = 1;
		}
		@Pc(1121) byte local1121 = 0;
		PathFinder.queueX[0] = local3;
		local61 = local1121 + 1;
		PathFinder.queueZ[0] = local8;
		local193 = local921 = Static145.anIntArrayArray25[local3][local8];
		while (arg10 != local3 || arg3 != local8) {
			if (local921 != local193) {
				PathFinder.queueX[local61] = local3;
				PathFinder.queueZ[local61++] = local8;
				local921 = local193;
			}
			if ((local193 & 0x2) != 0) {
				local3++;
			} else if ((local193 & 0x8) != 0) {
				local3--;
			}
			if ((local193 & 0x1) != 0) {
				local8++;
			} else if ((local193 & 0x4) != 0) {
				local8--;
			}
			local193 = Static145.anIntArrayArray25[local3][local8];
		}
		if (local61 > 0) {
			ClientProt.method3502(local61, arg9);
			return true;
		} else if (arg9 == 1) {
			return false;
		} else {
			return true;
		}
	}

	@OriginalMember(owner = "runetek4.client!aa", name = "a", descriptor = "(IZI)V")
	public static void method10(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		Protocol.outboundBuffer.pIsaac1(132);
		Protocol.outboundBuffer.p4rme(arg1);
		Protocol.outboundBuffer.p2_alt1(arg0);
	}

}
