package com.jagex.runetek4;

import com.jagex.runetek4.config.NPCType;
import com.jagex.runetek4.dash3d.entity.NPCEntity;
import com.jagex.runetek4.dash3d.entity.PathingEntity;
import com.jagex.runetek4.dash3d.entity.PlayerEntity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static142 {

	@OriginalMember(owner = "runetek4.client!lc", name = "n", descriptor = "I")
	public static int originZ;

	@OriginalMember(owner = "runetek4.client!lc", name = "e", descriptor = "Lclient!n;")
	public static final NodeCache aClass99_23 = new NodeCache(64);

	@OriginalMember(owner = "runetek4.client!lc", name = "l", descriptor = "I")
	public static int anInt3482 = -1;

	@OriginalMember(owner = "runetek4.client!lc", name = "m", descriptor = "Lclient!na;")
	public static final JString aClass100_667 = Static28.parse("settings=");

	@OriginalMember(owner = "runetek4.client!lc", name = "a", descriptor = "(IIIIIII)V")
	public static void method2726(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		Static277.anInt5854 = 0;
		@Pc(5) int local5;
		@Pc(642) int local642;
		@Pc(74) int local74;
		@Pc(265) int local265;
		@Pc(310) int local310;
		@Pc(359) int local359;
		@Pc(639) int local639;
		for (local5 = -1; local5 < Static267.playerCount + Static272.npcCount; local5++) {
			@Pc(17) PathingEntity local17;
			if (local5 == -1) {
				local17 = Static173.localPlayer;
			} else if (Static267.playerCount > local5) {
				local17 = Static159.players[Static105.playerIds[local5]];
			} else {
				local17 = Static175.npcs[Static33.npcIds[local5 - Static267.playerCount]];
			}
			if (local17 != null && local17.isVisible()) {
				@Pc(58) NPCType local58;
				if (local17 instanceof NPCEntity) {
					local58 = ((NPCEntity) local17).type;
					if (local58.multinpc != null) {
						local58 = local58.getMultiNPC();
					}
					if (local58 == null) {
						continue;
					}
				}
				@Pc(161) int local161;
				if (local5 >= Static267.playerCount) {
					local58 = ((NPCEntity) local17).type;
					if (local58.multinpc != null) {
						local58 = local58.getMultiNPC();
					}
					if (local58.anInt3732 >= 0 && Static138.aClass3_Sub2_Sub1Array5.length > local58.anInt3732) {
						if (local58.overlayheight == -1) {
							local265 = local17.height() + 15;
						} else {
							local265 = local58.overlayheight + 15;
						}
						Static180.method3326(arg4 >> 1, arg3, local17, arg5, local265, arg1 >> 1);
						if (Static65.anInt1951 > -1) {
							Static138.aClass3_Sub2_Sub1Array5[local58.anInt3732].drawSprite(arg2 + Static65.anInt1951 - 12, arg0 + -30 - -Static16.anInt548);
						}
					}
					@Pc(308) Class102[] local308 = Static143.aClass102Array1;
					for (local310 = 0; local310 < local308.length; local310++) {
						@Pc(322) Class102 local322 = local308[local310];
						if (local322 != null && local322.anInt4058 == 1 && local322.anInt4057 == Static33.npcIds[local5 - Static267.playerCount] && Static83.loopCycle % 20 < 10) {
							if (local58.overlayheight == -1) {
								local359 = local17.height() + 15;
							} else {
								local359 = local58.overlayheight + 15;
							}
							Static180.method3326(arg4 >> 1, arg3, local17, arg5, local359, arg1 >> 1);
							if (Static65.anInt1951 > -1) {
								Static276.aClass3_Sub2_Sub1Array11[local322.anInt4048].drawSprite(arg2 + Static65.anInt1951 - 12, Static16.anInt548 + -28 + arg0);
							}
						}
					}
				} else {
					local74 = 30;
					@Pc(77) PlayerEntity local77 = (PlayerEntity) local17;
					if (local77.anInt1669 != -1 || local77.anInt1649 != -1) {
						Static180.method3326(arg4 >> 1, arg3, local17, arg5, local17.height() + 15, arg1 >> 1);
						if (Static65.anInt1951 > -1) {
							if (local77.anInt1669 != -1) {
								Static219.aClass3_Sub2_Sub1Array9[local77.anInt1669].drawSprite(Static65.anInt1951 + arg2 - 12, arg0 + -30 + Static16.anInt548);
								local74 += 25;
							}
							if (local77.anInt1649 != -1) {
								Static138.aClass3_Sub2_Sub1Array5[local77.anInt1649].drawSprite(arg2 + Static65.anInt1951 - 12, arg0 - (-Static16.anInt548 + local74));
								local74 += 25;
							}
						}
					}
					if (local5 >= 0) {
						@Pc(159) Class102[] local159 = Static143.aClass102Array1;
						for (local161 = 0; local161 < local159.length; local161++) {
							@Pc(173) Class102 local173 = local159[local161];
							if (local173 != null && local173.anInt4058 == 10 && Static105.playerIds[local5] == local173.anInt4057) {
								Static180.method3326(arg4 >> 1, arg3, local17, arg5, local17.height() + 15, arg1 >> 1);
								if (Static65.anInt1951 > -1) {
									Static276.aClass3_Sub2_Sub1Array11[local173.anInt4048].drawSprite(arg2 + Static65.anInt1951 - 12, arg0 + (Static16.anInt548 - local74));
								}
							}
						}
					}
				}
				if (local17.chatMessage != null && (local5 >= Static267.playerCount || Static59.anInt1812 == 0 || Static59.anInt1812 == 3 || Static59.anInt1812 == 1 && Static98.method1965(((PlayerEntity) local17).name))) {
					Static180.method3326(arg4 >> 1, arg3, local17, arg5, local17.height(), arg1 >> 1);
					if (Static65.anInt1951 > -1 && Static277.anInt5854 < Static191.anInt4506) {
						Static191.anIntArray389[Static277.anInt5854] = Static280.aClass3_Sub2_Sub9_43.method2858(local17.chatMessage) / 2;
						Static191.anIntArray387[Static277.anInt5854] = Static280.aClass3_Sub2_Sub9_43.anInt3626;
						Static191.anIntArray385[Static277.anInt5854] = Static65.anInt1951;
						Static191.anIntArray392[Static277.anInt5854] = Static16.anInt548;
						Static191.anIntArray390[Static277.anInt5854] = local17.chatColor;
						Static191.anIntArray391[Static277.anInt5854] = local17.chatEffect;
						Static191.anIntArray384[Static277.anInt5854] = local17.chatLoops;
						Static191.aClass100Array132[Static277.anInt5854] = local17.chatMessage;
						Static277.anInt5854++;
					}
				}
				if (local17.anInt3378 > Static83.loopCycle) {
					@Pc(508) Sprite local508 = Static116.aClass3_Sub2_Sub1Array3[0];
					@Pc(512) Sprite local512 = Static116.aClass3_Sub2_Sub1Array3[1];
					if (local17 instanceof NPCEntity) {
						@Pc(518) NPCEntity local518 = (NPCEntity) local17;
						@Pc(528) Sprite[] local528 = (Sprite[]) Static73.aClass99_10.get((long) local518.type.anInt3736);
						if (local528 == null) {
							local528 = Static209.method3708(local518.type.anInt3736, Static209.aClass153_86);
							if (local528 != null) {
								Static73.aClass99_10.put(local528, (long) local518.type.anInt3736);
							}
						}
						if (local528 != null && local528.length == 2) {
							local512 = local528[1];
							local508 = local528[0];
						}
						@Pc(571) NPCType local571 = local518.type;
						if (local571.overlayheight == -1) {
							local310 = local17.height();
						} else {
							local310 = local571.overlayheight;
						}
					} else {
						local310 = local17.height();
					}
					Static180.method3326(arg4 >> 1, arg3, local17, arg5, local508.anInt1859 + local310 + 10, arg1 >> 1);
					if (Static65.anInt1951 > -1) {
						local161 = Static65.anInt1951 + arg2 - (local508.anInt1867 >> 1);
						local359 = Static16.anInt548 + arg0 - 3;
						local508.drawSprite(local161, local359);
						local639 = local508.anInt1867 * local17.anInt3372 / 255;
						local642 = local508.anInt1859;
						if (GlRenderer.enabled) {
							Static46.method1183(local161, local359, local161 + local639, local359 + local642);
						} else {
							Static129.method2498(local161, local359, local161 + local639, local642 + local359);
						}
						local512.drawSprite(local161, local359);
						if (GlRenderer.enabled) {
							Static46.method1187(arg2, arg0, arg1 + arg2, arg0 - -arg4);
						} else {
							Static129.method2496(arg2, arg0, arg1 + arg2, arg4 + arg0);
						}
					}
				}
				for (local74 = 0; local74 < 4; local74++) {
					if (local17.anIntArray319[local74] > Static83.loopCycle) {
						if (local17 instanceof NPCEntity) {
							@Pc(725) NPCEntity local725 = (NPCEntity) local17;
							@Pc(728) NPCType local728 = local725.type;
							if (local728.overlayheight == -1) {
								local265 = local17.height() / 2;
							} else {
								local265 = local728.overlayheight / 2;
							}
						} else {
							local265 = local17.height() / 2;
						}
						Static180.method3326(arg4 >> 1, arg3, local17, arg5, local265, arg1 >> 1);
						if (Static65.anInt1951 > -1) {
							if (local74 == 1) {
								Static16.anInt548 -= 20;
							}
							if (local74 == 2) {
								Static16.anInt548 -= 10;
								Static65.anInt1951 -= 15;
							}
							if (local74 == 3) {
								Static16.anInt548 -= 10;
								Static65.anInt1951 += 15;
							}
							Static213.aClass3_Sub2_Sub1Array8[local17.anIntArray321[local74]].drawSprite(arg2 + Static65.anInt1951 - 12, arg0 + Static16.anInt548 - 12);
							Static114.aClass3_Sub2_Sub9_42.method2875(Static123.method2423(local17.anIntArray322[local74]), Static65.anInt1951 + arg2 - 1, Static16.anInt548 + 3 + arg0, 16777215, 0);
						}
					}
				}
			}
		}
		for (local5 = 0; local5 < Static277.anInt5854; local5++) {
			local74 = Static191.anIntArray392[local5];
			@Pc(859) int local859 = Static191.anIntArray385[local5];
			local310 = Static191.anIntArray387[local5];
			local265 = Static191.anIntArray389[local5];
			@Pc(869) boolean local869 = true;
			while (local869) {
				local869 = false;
				for (local359 = 0; local359 < local5; local359++) {
					if (Static191.anIntArray392[local359] - Static191.anIntArray387[local359] < local74 + 2 && local74 - local310 < Static191.anIntArray392[local359] - -2 && local859 - local265 < Static191.anIntArray385[local359] + Static191.anIntArray389[local359] && Static191.anIntArray385[local359] - Static191.anIntArray389[local359] < local265 + local859 && Static191.anIntArray392[local359] - Static191.anIntArray387[local359] < local74) {
						local74 = Static191.anIntArray392[local359] - Static191.anIntArray387[local359];
						local869 = true;
					}
				}
			}
			Static65.anInt1951 = Static191.anIntArray385[local5];
			Static16.anInt548 = Static191.anIntArray392[local5] = local74;
			@Pc(962) JString local962 = Static191.aClass100Array132[local5];
			if (Static79.chatEffectsDisabled == 0) {
				local639 = 16776960;
				if (Static191.anIntArray390[local5] < 6) {
					local639 = Static16.CHAT_COLORS[Static191.anIntArray390[local5]];
				}
				if (Static191.anIntArray390[local5] == 6) {
					local639 = Static136.anInt3325 % 20 >= 10 ? 16776960 : 16711680;
				}
				if (Static191.anIntArray390[local5] == 7) {
					local639 = Static136.anInt3325 % 20 < 10 ? 255 : 65535;
				}
				if (Static191.anIntArray390[local5] == 8) {
					local639 = Static136.anInt3325 % 20 >= 10 ? 8454016 : 45056;
				}
				if (Static191.anIntArray390[local5] == 9) {
					local642 = 150 - Static191.anIntArray384[local5];
					if (local642 < 50) {
						local639 = local642 * 1280 + 16711680;
					} else if (local642 < 100) {
						local639 = 16776960 + 16384000 - local642 * 327680;
					} else if (local642 < 150) {
						local639 = local642 * 5 + 65280 - 500;
					}
				}
				if (Static191.anIntArray390[local5] == 10) {
					local642 = 150 - Static191.anIntArray384[local5];
					if (local642 < 50) {
						local639 = local642 * 5 + 16711680;
					} else if (local642 < 100) {
						local639 = 16711935 - (local642 - 50) * 327680;
					} else if (local642 < 150) {
						local639 = local642 * 327680 + 255 + 500 - local642 * 5 - 32768000;
					}
				}
				if (Static191.anIntArray390[local5] == 11) {
					local642 = 150 - Static191.anIntArray384[local5];
					if (local642 < 50) {
						local639 = 16777215 - local642 * 327685;
					} else if (local642 < 100) {
						local639 = local642 * 327685 + 65280 - 16384250;
					} else if (local642 < 150) {
						local639 = 16777215 + 32768000 - local642 * 327680;
					}
				}
				if (Static191.anIntArray391[local5] == 0) {
					Static280.aClass3_Sub2_Sub9_43.method2875(local962, Static65.anInt1951 + arg2, arg0 + Static16.anInt548, local639, 0);
				}
				if (Static191.anIntArray391[local5] == 1) {
					Static280.aClass3_Sub2_Sub9_43.method2872(local962, arg2 + Static65.anInt1951, Static16.anInt548 + arg0, local639, Static136.anInt3325);
				}
				if (Static191.anIntArray391[local5] == 2) {
					Static280.aClass3_Sub2_Sub9_43.method2871(local962, arg2 + Static65.anInt1951, arg0 - -Static16.anInt548, local639, Static136.anInt3325);
				}
				if (Static191.anIntArray391[local5] == 3) {
					Static280.aClass3_Sub2_Sub9_43.method2868(local962, arg2 + Static65.anInt1951, Static16.anInt548 + arg0, local639, Static136.anInt3325, 150 - Static191.anIntArray384[local5]);
				}
				if (Static191.anIntArray391[local5] == 4) {
					local642 = (150 - Static191.anIntArray384[local5]) * (Static280.aClass3_Sub2_Sub9_43.method2858(local962) + 100) / 150;
					if (GlRenderer.enabled) {
						Static46.method1183(Static65.anInt1951 + arg2 - 50, arg0, Static65.anInt1951 + arg2 + 50, arg4 + arg0);
					} else {
						Static129.method2498(arg2 + Static65.anInt1951 - 50, arg0, Static65.anInt1951 + arg2 + 50, arg4 + arg0);
					}
					Static280.aClass3_Sub2_Sub9_43.method2857(local962, arg2 + Static65.anInt1951 + 50 - local642, arg0 + Static16.anInt548, local639, 0);
					if (GlRenderer.enabled) {
						Static46.method1187(arg2, arg0, arg1 + arg2, arg4 + arg0);
					} else {
						Static129.method2496(arg2, arg0, arg2 + arg1, arg0 + arg4);
					}
				}
				if (Static191.anIntArray391[local5] == 5) {
					@Pc(1372) int local1372 = 0;
					local642 = 150 - Static191.anIntArray384[local5];
					if (GlRenderer.enabled) {
						Static46.method1183(arg2, Static16.anInt548 + arg0 - Static280.aClass3_Sub2_Sub9_43.anInt3626 - 1, arg1 + arg2, arg0 + Static16.anInt548 + 5);
					} else {
						Static129.method2498(arg2, Static16.anInt548 + arg0 - Static280.aClass3_Sub2_Sub9_43.anInt3626 - 1, arg2 + arg1, Static16.anInt548 + arg0 + 5);
					}
					if (local642 < 25) {
						local1372 = local642 - 25;
					} else if (local642 > 125) {
						local1372 = local642 - 125;
					}
					Static280.aClass3_Sub2_Sub9_43.method2875(local962, Static65.anInt1951 + arg2, local1372 + arg0 + Static16.anInt548, local639, 0);
					if (GlRenderer.enabled) {
						Static46.method1187(arg2, arg0, arg2 + arg1, arg0 + arg4);
					} else {
						Static129.method2496(arg2, arg0, arg2 + arg1, arg0 + arg4);
					}
				}
			} else {
				Static280.aClass3_Sub2_Sub9_43.method2875(local962, arg2 + Static65.anInt1951, arg0 + Static16.anInt548, 16776960, 0);
			}
		}
	}

	@OriginalMember(owner = "runetek4.client!lc", name = "a", descriptor = "(B)I")
	public static int getIdleLoops() {
		return Static93.anInt2467;
	}
}
