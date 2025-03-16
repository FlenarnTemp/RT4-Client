package com.jagex.runetek4;

import java.io.UnsupportedEncodingException;

import com.jagex.runetek4.cache.cs.ClientScript;
import com.jagex.runetek4.cache.media.Font;
import com.jagex.runetek4.game.client.logic.DelayedStateChange;
import com.jagex.runetek4.cache.media.component.Component;
import com.jagex.runetek4.dash3d.entity.Npc;
import com.jagex.runetek4.media.renderable.actor.Player;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static127 {

	@OriginalMember(owner = "runetek4.client!k", name = "j", descriptor = "I")
	public static int anInt3126;

	@OriginalMember(owner = "runetek4.client!k", name = "l", descriptor = "[I")
	public static int[] anIntArray292;

	@OriginalMember(owner = "runetek4.client!k", name = "c", descriptor = "Z")
	public static boolean aBoolean159 = false;

	@OriginalMember(owner = "runetek4.client!k", name = "t", descriptor = "I")
	public static int anInt3132 = 0;

	@OriginalMember(owner = "runetek4.client!k", name = "a", descriptor = "(IIBLclient!ve;Lclient!ve;)Lclient!rk;")
	public static Font getFont(@OriginalArg(1) int arg0, @OriginalArg(3) Js5 arg1, @OriginalArg(4) Js5 arg2) {
		return Static234.method4016(arg1, 0, arg0) ? Static29.method799(arg2.getfile(arg0, 0)) : null;
	}

	@OriginalMember(owner = "runetek4.client!k", name = "a", descriptor = "(IIIIZIZ)V")
	public static void method2463(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) int arg5) {
		if (Static80.anInt4701 == arg2 && arg1 == Static52.anInt1695 && (Static41.anInt1316 == arg0 || Static138.allLevelsvisible())) {
			return;
		}
		Static80.anInt4701 = arg2;
		Static52.anInt1695 = arg1;
		Static41.anInt1316 = arg0;
		if (Static138.allLevelsvisible()) {
			Static41.anInt1316 = 0;
		}
		if (arg4) {
			client.processGameStatus(28);
		} else {
			client.processGameStatus(25);
		}
		Fonts.drawTextOnScreen(true, LocalizedText.LOADING);
		@Pc(53) int local53 = Camera.originZ;
		@Pc(55) int local55 = Camera.originX;
		Camera.originZ = arg1 * 8 - 48;
		Camera.originX = (arg2 - 6) * 8;
		Static158.aClass3_Sub2_Sub4_3 = Static29.method803(Static80.anInt4701 * 8, Static52.anInt1695 * 8);
		@Pc(81) int dz = Camera.originZ - local53;
		@Pc(86) int dx = Camera.originX - local55;
		Static235.aMapElementTypeList_2 = null;
		@Pc(96) int i;
		@Pc(103) Npc local103;
		@Pc(109) int j;
		if (arg4) {
			NpcList.npcCount = 0;
			for (i = 0; i < 32768; i++) {
				local103 = NpcList.npcs[i];
				if (local103 != null) {
					local103.xFine -= dx * 128;
					local103.zFine -= dz * 128;
					if (local103.xFine >= 0 && local103.xFine <= 13184 && local103.zFine >= 0 && local103.zFine <= 13184) {
						for (j = 0; j < 10; j++) {
							local103.movementQueueX[j] -= dx;
							local103.movementQueueZ[j] -= dz;
						}
						Static33.npcIds[NpcList.npcCount++] = i;
					} else {
						NpcList.npcs[i].method2698(null);
						NpcList.npcs[i] = null;
					}
				}
			}
		} else {
			for (i = 0; i < 32768; i++) {
				local103 = NpcList.npcs[i];
				if (local103 != null) {
					for (j = 0; j < 10; j++) {
						local103.movementQueueX[j] -= dx;
						local103.movementQueueZ[j] -= dz;
					}
					local103.xFine -= dx * 128;
					local103.zFine -= dz * 128;
				}
			}
		}
		for (i = 0; i < 2048; i++) {
			@Pc(265) Player player = PlayerList.players[i];
			if (player != null) {
				for (j = 0; j < 10; j++) {
					player.movementQueueX[j] -= dx;
					player.movementQueueZ[j] -= dz;
				}
				player.xFine -= dx * 128;
				player.zFine -= dz * 128;
			}
		}
		Player.plane = arg0;
		PlayerList.self.teleport(arg5, false, arg3);
		@Pc(322) byte endTileX = 104;
		@Pc(324) byte startTileX = 0;
		@Pc(326) byte startTileZ = 0;
		@Pc(328) byte dirZ = 1;
		@Pc(330) byte endTileZ = 104;
		@Pc(332) byte dirX = 1;
		if (dz < 0) {
			dirZ = -1;
			endTileZ = -1;
			startTileZ = 103;
		}
		if (dx < 0) {
			dirX = -1;
			startTileX = 103;
			endTileX = -1;
		}
		for (@Pc(358) int x = startTileX; x != endTileX; x += dirX) {
			for (@Pc(367) int z = startTileZ; z != endTileZ; z += dirZ) {
				@Pc(378) int lastX = dx + x;
				@Pc(382) int lastZ = z + dz;
				for (@Pc(384) int level = 0; level < 4; level++) {
					if (lastX >= 0 && lastZ >= 0 && lastX < 104 && lastZ < 104) {
						SceneGraph.objStacks[level][x][z] = SceneGraph.objStacks[level][lastX][lastZ];
					} else {
						SceneGraph.objStacks[level][x][z] = null;
					}
				}
			}
		}
		for (@Pc(451) ChangeLocRequest loc = (ChangeLocRequest) ChangeLocRequest.queue.head(); loc != null; loc = (ChangeLocRequest) ChangeLocRequest.queue.next()) {
			loc.z -= dz;
			loc.x -= dx;
			if (loc.x < 0 || loc.z < 0 || loc.x >= 104 || loc.z >= 104) {
				loc.unlink();
			}
		}
		if (arg4) {
			Camera.renderX -= dx * 128;
			Camera.renderZ -= dz * 128;
			Camera.anInt4232 -= dz;
			Camera.anInt5449 -= dx;
			Camera.anInt5765 -= dz;
			Camera.anInt5375 -= dx;
		} else {
			Camera.cameraType = 1;
		}
		SoundPlayer.size = 0;
		if (LoginManager.mapFlagX != 0) {
			LoginManager.mapFlagZ -= dz;
			LoginManager.mapFlagX -= dx;
		}
		if (GlRenderer.enabled && arg4 && (Math.abs(dx) > 104 || Math.abs(dz) > 104)) {
			FogManager.setInstantFade();
		}
		LightingManager.anInt2875 = -1;
		SceneGraph.spotanims.clear();
		SceneGraph.projectiles.clear();
	}

	@OriginalMember(owner = "runetek4.client!k", name = "a", descriptor = "(B)Lclient!da;")
	public static DelayedStateChange poll() {
		@Pc(10) DelayedStateChange local10 = (DelayedStateChange) Static215.aClass16_9.head();
		if (local10 != null) {
			local10.unlink();
			local10.clear();
			return local10;
		}
		do {
			local10 = (DelayedStateChange) Static140.aClass16_7.head();
			if (local10 == null) {
				return null;
			}
			if (local10.method1009() > MonotonicTime.currentTimeMillis()) {
				return null;
			}
			local10.unlink();
			local10.clear();
		} while ((Long.MIN_VALUE & local10.secondaryNodeId) == 0L);
		return local10;
	}

	@OriginalMember(owner = "runetek4.client!k", name = "a", descriptor = "(Lclient!be;Lclient!na;I)Lclient!na;")
	public static JString method2465(@OriginalArg(0) Component arg0, @OriginalArg(1) JString arg1) {
		if (arg1.indexOf(Static49.aClass100_352) == -1) {
			return arg1;
		}
		while (true) {
			@Pc(14) int local14 = arg1.indexOf(Static23.aClass100_133);
			if (local14 == -1) {
				while (true) {
					local14 = arg1.indexOf(Static276.aClass100_1097);
					if (local14 == -1) {
						while (true) {
							local14 = arg1.indexOf(Static160.aClass100_761);
							if (local14 == -1) {
								while (true) {
									local14 = arg1.indexOf(Static96.aClass100_520);
									if (local14 == -1) {
										while (true) {
											local14 = arg1.indexOf(Static235.aClass100_1002);
											if (local14 == -1) {
												while (true) {
													local14 = arg1.indexOf(Static122.aClass100_591);
													if (local14 == -1) {
														return arg1;
													}
													@Pc(246) JString local246 = JString.EMPTY;
													if (Static232.aClass212_5 != null) {
														local246 = IdkTypeList.method3341(Static232.aClass212_5.intArg2);
														try {
															if (Static232.aClass212_5.result != null) {
																@Pc(265) byte[] local265 = ((String) Static232.aClass212_5.result).getBytes("ISO-8859-1");
																local246 = JString.decodeString(local265, local265.length, 0);
															}
														} catch (@Pc(274) UnsupportedEncodingException local274) {
														}
													}
													arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), local246, arg1.substring(local14 + 4) });
												}
											}
											arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), Static262.method4510(ClientScript.executeClientscript(4, arg0)), arg1.substring(local14 + 2) });
										}
									}
									arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), Static262.method4510(ClientScript.executeClientscript(3, arg0)), arg1.substring(local14 + 2) });
								}
							}
							arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), Static262.method4510(ClientScript.executeClientscript(2, arg0)), arg1.substring(local14 + 2) });
						}
					}
					arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), Static262.method4510(ClientScript.executeClientscript(1, arg0)), arg1.substring(local14 + 2) });
				}
			}
			arg1 = JString.concatenate(new JString[] { arg1.substring(local14, 0), Static262.method4510(ClientScript.executeClientscript(0, arg0)), arg1.substring(local14 + 2) });
		}
	}

}
