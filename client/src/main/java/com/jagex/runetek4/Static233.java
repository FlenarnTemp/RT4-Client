package com.jagex.runetek4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jagex.runetek4.core.io.PacketBit;
import com.jagex.runetek4.dash3d.entity.LocMergeEntity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static233 {

	@OriginalMember(owner = "runetek4.client!t", name = "l", descriptor = "Lclient!ma;")
	public static BufferedSocket aClass95_4;

	@OriginalMember(owner = "runetek4.client!t", name = "o", descriptor = "I")
	public static int anInt5217;

	@OriginalMember(owner = "runetek4.client!t", name = "A", descriptor = "I")
	public static int anInt5225;

	@OriginalMember(owner = "runetek4.client!t", name = "G", descriptor = "[Lclient!ek;")
	public static SoftwareIndexedSprite[] aClass36_Sub1Array1;

	@OriginalMember(owner = "runetek4.client!t", name = "m", descriptor = "Z")
	public static volatile boolean focus_in = true;

	@OriginalMember(owner = "runetek4.client!t", name = "p", descriptor = "Lclient!n;")
	public static final NodeCache aClass99_31 = new NodeCache(64);

	@OriginalMember(owner = "runetek4.client!t", name = "v", descriptor = "[Lclient!na;")
	public static final JString[] aClass100Array160 = new JString[500];

	@OriginalMember(owner = "runetek4.client!t", name = "w", descriptor = "[J")
	public static final long[] aLongArray9 = new long[100];

	@OriginalMember(owner = "runetek4.client!t", name = "x", descriptor = "Z")
	public static boolean aBoolean254 = false;

	@OriginalMember(owner = "runetek4.client!t", name = "y", descriptor = "I")
	public static int anInt5223 = 0;

	@OriginalMember(owner = "runetek4.client!t", name = "z", descriptor = "I")
	public static int anInt5224 = 0;

	@OriginalMember(owner = "runetek4.client!t", name = "C", descriptor = "Lclient!na;")
	public static final JString aClass100_994 = Static28.parse(")3");

	@OriginalMember(owner = "runetek4.client!t", name = "E", descriptor = "[I")
	public static final int[] updatedVarcstrs = new int[32];

	@OriginalMember(owner = "runetek4.client!t", name = "F", descriptor = "I")
	public static int js5PrevErrors = 0;

	@OriginalMember(owner = "runetek4.client!t", name = "b", descriptor = "(I)V")
	public static void method3999() {
		Static67.aClass99_20.method3104();
	}

	@OriginalMember(owner = "runetek4.client!t", name = "a", descriptor = "(IIIZIII)V")
	public static void method4000(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
		@Pc(3) int local3 = 0;
		@Pc(5) Class102[] local5 = Static143.aClass102Array1;
		while (local5.length > local3) {
			@Pc(17) Class102 local17 = local5[local3];
			if (local17 != null && local17.anInt4058 == 2) {
				Static198.method1026(arg0 >> 1, arg4, (local17.anInt4046 - Static142.originZ << 7) + local17.anInt4047, local17.anInt4050 * 2, arg2 >> 1, local17.anInt4045 + (local17.anInt4053 - Static225.originX << 7), arg3);
				if (Static65.anInt1951 > -1 && Static83.loopCycle % 20 < 10) {
					Static276.aClass3_Sub2_Sub1Array11[local17.anInt4048].drawSprite(arg1 + Static65.anInt1951 - 12, arg5 + -28 - -Static16.anInt548);
				}
			}
			local3++;
		}
	}

	@OriginalMember(owner = "runetek4.client!t", name = "b", descriptor = "(B)V")
	public static void method4001() {
		Static93.aClass99_13.method3103();
		Static125.aClass99_18.method3103();
		Static262.aClass99_35.method3103();
	}

	@OriginalMember(owner = "runetek4.client!t", name = "a", descriptor = "(ZB)V")
	public static void method4002(@OriginalArg(0) boolean arg0) {
		@Pc(19) byte local19;
		@Pc(21) byte[][] local21;
		if (GlRenderer.enabled && arg0) {
			local21 = Static19.aByteArrayArray4;
			local19 = 1;
		} else {
			local19 = 4;
			local21 = Static156.aByteArrayArray11;
		}
		for (@Pc(29) int local29 = 0; local29 < local19; local29++) {
			Static107.method2261();
			for (@Pc(36) int local36 = 0; local36 < 13; local36++) {
				for (@Pc(43) int local43 = 0; local43 < 13; local43++) {
					@Pc(56) int local56 = Static187.anIntArrayArrayArray18[local29][local36][local43];
					if (local56 != -1) {
						@Pc(67) int local67 = local56 >> 24 & 0x3;
						if (!arg0 || local67 == 0) {
							@Pc(77) int local77 = local56 >> 1 & 0x3;
							@Pc(83) int local83 = local56 >> 14 & 0x3FF;
							@Pc(89) int local89 = local56 >> 3 & 0x7FF;
							@Pc(99) int local99 = local89 / 8 + (local83 / 8 << 8);
							for (@Pc(101) int local101 = 0; local101 < Static238.anIntArray470.length; local101++) {
								if (Static238.anIntArray470[local101] == local99 && local21[local101] != null) {
									Static217.method3771(Static148.levelCollisionMap, local29, local21[local101], local67, local77, local36 * 8, local43 * 8, arg0, (local83 & 0x7) * 8, (local89 & 0x7) * 8);
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "runetek4.client!t", name = "a", descriptor = "(BJII)Z")
	public static boolean method4003(@OriginalArg(1) long arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
		@Pc(12) int local12 = (int) arg0 >> 14 & 0x1F;
		@Pc(24) int local24 = (int) arg0 >> 20 & 0x3;
		@Pc(31) int local31 = (int) (arg0 >>> 32) & Integer.MAX_VALUE;
		if (local12 == 10 || local12 == 11 || local12 == 22) {
			@Pc(46) LocMergeEntity local46 = Static271.get(local31);
			@Pc(62) int local62;
			@Pc(59) int local59;
			if (local24 == 0 || local24 == 2) {
				local59 = local46.length;
				local62 = local46.width;
			} else {
				local59 = local46.width;
				local62 = local46.length;
			}
			@Pc(73) int local73 = local46.forceapproach;
			if (local24 != 0) {
				local73 = (local73 << local24 & 0xF) + (local73 >> 4 - local24);
			}
			Static102.tryMove(Static173.localPlayer.pathTileZ[0], 0, local59, true, local73, arg2, local62, 0, 2, arg1, Static173.localPlayer.pathTileX[0]);
		} else {
			Static102.tryMove(Static173.localPlayer.pathTileZ[0], local24, 0, true, 0, arg2, 0, local12 + 1, 2, arg1, Static173.localPlayer.pathTileX[0]);
		}
		Static25.y = Static60.mouseClickY;
		Static17.crossCycle = 0;
		Static70.crossMode = 2;
		Static122.x = aClass6.mouseClickX;
		return true;
	}

	@OriginalMember(owner = "runetek4.client!t", name = "a", descriptor = "(Lclient!i;II)V")
	public static void loop(@OriginalArg(0) PacketBit arg0) {
		while (true) {
			@Pc(18) ReflectionCheck local18 = (ReflectionCheck) Static204.aClass69_113.head();
			if (local18 == null) {
				return;
			}
			@Pc(23) boolean local23 = false;
			@Pc(25) int local25;
			for (local25 = 0; local25 < local18.anInt1725; local25++) {
				if (local18.aClass212Array2[local25] != null) {
					if (local18.aClass212Array2[local25].status == 2) {
						local18.anIntArray138[local25] = -5;
					}
					if (local18.aClass212Array2[local25].status == 0) {
						local23 = true;
					}
				}
				if (local18.aClass212Array1[local25] != null) {
					if (local18.aClass212Array1[local25].status == 2) {
						local18.anIntArray138[local25] = -6;
					}
					if (local18.aClass212Array1[local25].status == 0) {
						local23 = true;
					}
				}
			}
			if (local23) {
				return;
			}
			arg0.pIsaac1(163);
			arg0.p1(0);
			local25 = arg0.position;
			arg0.p4(local18.anInt1732);
			for (@Pc(121) int local121 = 0; local121 < local18.anInt1725; local121++) {
				if (local18.anIntArray138[local121] == 0) {
					try {
						@Pc(151) int local151 = local18.anIntArray139[local121];
						@Pc(168) Field local168;
						@Pc(195) int local195;
						if (local151 == 0) {
							local168 = (Field) local18.aClass212Array2[local121].result;
							local195 = local168.getInt(null);
							arg0.p1(0);
							arg0.p4(local195);
						} else if (local151 == 1) {
							local168 = (Field) local18.aClass212Array2[local121].result;
							local168.setInt(null, local18.anIntArray137[local121]);
							arg0.p1(0);
						} else if (local151 == 2) {
							local168 = (Field) local18.aClass212Array2[local121].result;
							local195 = local168.getModifiers();
							arg0.p1(0);
							arg0.p4(local195);
						}
						@Pc(234) Method local234;
						if (local151 == 3) {
							local234 = (Method) local18.aClass212Array1[local121].result;
							@Pc(239) byte[][] local239 = local18.aByteArrayArrayArray6[local121];
							@Pc(243) Object[] local243 = new Object[local239.length];
							for (@Pc(245) int local245 = 0; local245 < local239.length; local245++) {
								@Pc(259) ObjectInputStream local259 = new ObjectInputStream(new ByteArrayInputStream(local239[local245]));
								local243[local245] = local259.readObject();
							}
							@Pc(272) Object local272 = local234.invoke(null, local243);
							if (local272 == null) {
								arg0.p1(0);
							} else if (local272 instanceof Number) {
								arg0.p1(1);
								arg0.p8(((Number) local272).longValue());
							} else if (local272 instanceof JString) {
								arg0.p1(2);
								arg0.pjstr((JString) local272);
							} else {
								arg0.p1(4);
							}
						} else if (local151 == 4) {
							local234 = (Method) local18.aClass212Array1[local121].result;
							local195 = local234.getModifiers();
							arg0.p1(0);
							arg0.p4(local195);
						}
					} catch (@Pc(338) ClassNotFoundException local338) {
						arg0.p1(-10);
					} catch (@Pc(344) InvalidClassException local344) {
						arg0.p1(-11);
					} catch (@Pc(350) StreamCorruptedException local350) {
						arg0.p1(-12);
					} catch (@Pc(356) OptionalDataException local356) {
						arg0.p1(-13);
					} catch (@Pc(362) IllegalAccessException local362) {
						arg0.p1(-14);
					} catch (@Pc(368) IllegalArgumentException local368) {
						arg0.p1(-15);
					} catch (@Pc(374) InvocationTargetException local374) {
						arg0.p1(-16);
					} catch (@Pc(380) SecurityException local380) {
						arg0.p1(-17);
					} catch (@Pc(386) IOException local386) {
						arg0.p1(-18);
					} catch (@Pc(392) NullPointerException local392) {
						arg0.p1(-19);
					} catch (@Pc(398) Exception local398) {
						arg0.p1(-20);
					} catch (@Pc(404) Throwable local404) {
						arg0.p1(-21);
					}
				} else {
					arg0.p1(local18.anIntArray138[local121]);
				}
			}
			arg0.pCrc32(local25);
			arg0.p1len(arg0.position - local25);
			local18.unlink();
		}
	}
}
