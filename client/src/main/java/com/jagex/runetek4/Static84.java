package com.jagex.runetek4;

import com.jagex.runetek4.cache.media.Font;
import com.jagex.runetek4.node.CachedNode;
import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.cache.media.SeqType;
import com.jagex.runetek4.media.renderable.actor.Player;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static84 {

	@OriginalMember(owner = "client!gk", name = "j", descriptor = "I")
	public static int anInt2257;

	@OriginalMember(owner = "client!gk", name = "l", descriptor = "Lclient!qf;")
	public static Sprite aClass3_Sub2_Sub1_4;

	@OriginalMember(owner = "client!gk", name = "a", descriptor = "(IIBLclient!e;)V")
	public static void getPlayerExtended(@OriginalArg(0) int flags, @OriginalArg(1) int arg1, @OriginalArg(3) Player player) {
		@Pc(13) int chatFlags;
		@Pc(17) int staffModLevel;
		@Pc(24) int local24;
		if ((flags & 0x80) != 0) {

			chatFlags = Protocol.inboundBuffer.g2le();
			staffModLevel = Protocol.inboundBuffer.g1();
			@Pc(21) int len = Protocol.inboundBuffer.g1();
			local24 = Protocol.inboundBuffer.offset;

			@Pc(35) boolean quickChat = (chatFlags & 0x8000) != 0;

			if (player.username != null && player.appearance != null) {
				@Pc(48) long encodedUsername = player.username.encode37();
				@Pc(50) boolean ignored = false;
				if (staffModLevel <= 1) {
					if (!quickChat && (LoginManager.playerUnderage && !LoginManager.parentalChatConsent || LoginManager.worldQuickChat)) {
						ignored = true;
					} else {
						for (@Pc(69) int i = 0; i < IgnoreList.ignoreCount; i++) {
							if (IgnoreList.encodedIgnores[i] == encodedUsername) {
								ignored = true;
								break;
							}
						}
					}
				}
				if (!ignored && Player.overrideChat == 0) {
					Static270.CHAT_PACKET.offset = 0;
					Protocol.inboundBuffer.gBytesRev(Static270.CHAT_PACKET.data, len);
					Static270.CHAT_PACKET.offset = 0;

					@Pc(106) int phraseId = -1;

					@Pc(127) JString message;
					if (quickChat) {
						@Pc(112) QuickChatPhrase quickChatPhrase = QuickChatPhrase.decode(Static270.CHAT_PACKET);
						chatFlags &= 0x7FFF;
						phraseId = quickChatPhrase.anInt439;
						message = quickChatPhrase.aQuickChatPhraseType_1.method770(Static270.CHAT_PACKET);
					} else {
						message = Font.escape(Static65.method1497(Static270.CHAT_PACKET).encodeMessage());
					}
					player.chatMessage = message.trim();
					player.chatEffect = chatFlags & 0xFF;
					player.chatLoops = 150;
					player.chatColor = chatFlags >> 8;
					if (staffModLevel == 2) {
						Chat.add(phraseId, quickChat ? 17 : 1, message, null, JString.concatenate(new JString[] { Static44.aClass100_336, player.getUsername() }));
					} else if (staffModLevel == 1) {
						Chat.add(phraseId, quickChat ? 17 : 1, message, null, JString.concatenate(new JString[] { Static65.aClass100_435, player.getUsername() }));
					} else {
						Chat.add(phraseId, quickChat ? 17 : 2, message, null, player.getUsername());
					}
				}
			}
			Protocol.inboundBuffer.offset = local24 + len;
		}
		if ((flags & 0x1) != 0) {
			chatFlags = Protocol.inboundBuffer.gSmart1or2();
			staffModLevel = Protocol.inboundBuffer.g1add();
			player.method2686(staffModLevel, client.loop, chatFlags);
			player.anInt3378 = client.loop + 300;
			player.anInt3372 = Protocol.inboundBuffer.g1_alt3();
		}
		if ((flags & 0x8) != 0) {
			chatFlags = Protocol.inboundBuffer.g2();
			if (chatFlags == 65535) {
				chatFlags = -1;
			}
			staffModLevel = Protocol.inboundBuffer.g1();
			Static186.method3415(staffModLevel, chatFlags, player);
		}
		if ((flags & 0x4) != 0) {
			chatFlags = Protocol.inboundBuffer.g1add();
			@Pc(309) byte[] local309 = new byte[chatFlags];
			@Pc(314) Packet local314 = new Packet(local309);
			Protocol.inboundBuffer.gdata(chatFlags, local309);
			PlayerList.PLAYER_APPEARANCE_PACKET[arg1] = local314;
			player.read(local314);
		}
		if ((flags & 0x2) != 0) {
			player.targetId = Protocol.inboundBuffer.g2sub();
			if (player.targetId == 65535) {
				player.targetId = -1;
			}
		}
		if ((flags & 0x400) != 0) {
			player.anInt3380 = Protocol.inboundBuffer.p1neg();
			player.anInt3428 = Protocol.inboundBuffer.g1();
			player.anInt3416 = Protocol.inboundBuffer.g1add();
			player.anInt3392 = Protocol.inboundBuffer.g1();
			player.anInt3395 = Protocol.inboundBuffer.g2le() + client.loop;
			player.anInt3386 = Protocol.inboundBuffer.g2le() + client.loop;
			player.anInt3431 = Protocol.inboundBuffer.p1neg();
			player.movementQueueSize = 1;
			player.anInt3405 = 0;
		}
		if ((flags & 0x20) != 0) {
			player.chatMessage = Protocol.inboundBuffer.gjstr();
			if (player.chatMessage.charAt(0) == 126) {
				player.chatMessage = player.chatMessage.substring(1);
				Chat.addMessage(player.getUsername(), 2, player.chatMessage);
			} else if (player == PlayerList.self) {
				Chat.addMessage(player.getUsername(), 2, player.chatMessage);
			}
			player.chatEffect = 0;
			player.chatColor = 0;
			player.chatLoops = 150;
		}
		if ((flags & 0x200) != 0) {
			chatFlags = Protocol.inboundBuffer.gSmart1or2();
			staffModLevel = Protocol.inboundBuffer.g1_alt3();
			player.method2686(staffModLevel, client.loop, chatFlags);
		}
		if ((flags & 0x800) != 0) {
			chatFlags = Protocol.inboundBuffer.p1neg();
			@Pc(502) int[] local502 = new int[chatFlags];
			@Pc(505) int[] local505 = new int[chatFlags];
			@Pc(508) int[] local508 = new int[chatFlags];
			for (@Pc(510) int local510 = 0; local510 < chatFlags; local510++) {
				@Pc(521) int local521 = Protocol.inboundBuffer.g2le();
				if (local521 == 65535) {
					local521 = -1;
				}
				local502[local510] = local521;
				local505[local510] = Protocol.inboundBuffer.g1add();
				local508[local510] = Protocol.inboundBuffer.g2();
			}
			Static32.method865(local505, local502, player, local508);
		}
		if ((flags & 0x100) != 0) {
			chatFlags = Protocol.inboundBuffer.g2le();
			if (chatFlags == 65535) {
				chatFlags = -1;
			}
			staffModLevel = Protocol.inboundBuffer.p4rme();
			@Pc(573) boolean local573 = true;
			if (chatFlags != -1 && player.spotanimFrame != -1 && SeqTypeList.getAnimationSequence(Static34.method877(chatFlags).animationId).priority < SeqTypeList.getAnimationSequence(Static34.method877(player.spotanimFrame).animationId).priority) {
				local573 = false;
			}
			if (local573) {
				player.spotanimLastCycle = (staffModLevel & 0xFFFF) + client.loop;
				player.anInt3361 = 0;
				player.spotanimId = 0;
				player.spotanimFrame = chatFlags;
				if (player.spotanimLastCycle > client.loop) {
					player.spotanimId = -1;
				}
				player.spotanimOffset = staffModLevel >> 16;
				player.anInt3418 = 1;
				if (player.spotanimFrame != -1 && client.loop == player.spotanimLastCycle) {
					local24 = Static34.method877(player.spotanimFrame).animationId;
					if (local24 != -1) {
						@Pc(663) SeqType local663 = SeqTypeList.getAnimationSequence(local24);
						if (local663 != null && local663.anIntArray473 != null) {
							SoundPlayer.playSeqSound(player.zFine, local663, player.xFine, player == PlayerList.self, 0);
						}
					}
				}
			}
		}
		if ((flags & 0x40) != 0) {
			player.anInt3382 = Protocol.inboundBuffer.g2();
			player.anInt3363 = Protocol.inboundBuffer.g2leadd();
		}
	}

	@OriginalMember(owner = "client!gk", name = "a", descriptor = "([BI)V")
	public static void method1770(@OriginalArg(0) byte[] arg0) {
		@Pc(4) Packet local4 = new Packet(arg0);
		local4.offset = arg0.length - 2;
		Static165.anInt4038 = local4.g2();
		SpriteLoader.innerHeights = new int[Static165.anInt4038];
		SpriteLoader.innerWidths = new int[Static165.anInt4038];
		SpriteLoader.xOffsets = new int[Static165.anInt4038];
		Static159.aBooleanArray87 = new boolean[Static165.anInt4038];
		Static64.aByteArrayArray9 = new byte[Static165.anInt4038][];
		SpriteLoader.yOffsets = new int[Static165.anInt4038];
		SpriteLoader.pixels = new byte[Static165.anInt4038][];
		local4.offset = arg0.length - Static165.anInt4038 * 8 - 7;
		Static124.anInt3080 = local4.g2();
		Static227.anInt5091 = local4.g2();
		@Pc(66) int local66 = (local4.g1() & 0xFF) + 1;
		@Pc(68) int local68;
		for (local68 = 0; local68 < Static165.anInt4038; local68++) {
			SpriteLoader.xOffsets[local68] = local4.g2();
		}
		for (local68 = 0; local68 < Static165.anInt4038; local68++) {
			SpriteLoader.yOffsets[local68] = local4.g2();
		}
		for (local68 = 0; local68 < Static165.anInt4038; local68++) {
			SpriteLoader.innerWidths[local68] = local4.g2();
		}
		for (local68 = 0; local68 < Static165.anInt4038; local68++) {
			SpriteLoader.innerHeights[local68] = local4.g2();
		}
		local4.offset = arg0.length + 3 - Static165.anInt4038 * 8 - local66 * 3 - 7;
		Static259.anIntArray513 = new int[local66];
		for (local68 = 1; local68 < local66; local68++) {
			Static259.anIntArray513[local68] = local4.g3();
			if (Static259.anIntArray513[local68] == 0) {
				Static259.anIntArray513[local68] = 1;
			}
		}
		local4.offset = 0;
		for (local68 = 0; local68 < Static165.anInt4038; local68++) {
			@Pc(195) int local195 = SpriteLoader.innerWidths[local68];
			@Pc(199) int local199 = SpriteLoader.innerHeights[local68];
			@Pc(203) int local203 = local195 * local199;
			@Pc(206) byte[] local206 = new byte[local203];
			@Pc(208) boolean local208 = false;
			SpriteLoader.pixels[local68] = local206;
			@Pc(215) byte[] local215 = new byte[local203];
			Static64.aByteArrayArray9[local68] = local215;
			@Pc(223) int local223 = local4.g1();
			@Pc(232) int local232;
			if ((local223 & 0x1) == 0) {
				for (local232 = 0; local232 < local203; local232++) {
					local206[local232] = local4.g1s();
				}
				if ((local223 & 0x2) != 0) {
					for (local232 = 0; local232 < local203; local232++) {
						@Pc(343) byte local343 = local215[local232] = local4.g1s();
						local208 |= local343 != -1;
					}
				}
			} else {
				local232 = 0;
				label88: while (true) {
					@Pc(241) int local241;
					if (local232 >= local195) {
						if ((local223 & 0x2) == 0) {
							break;
						}
						local232 = 0;
						while (true) {
							if (local232 >= local195) {
								break label88;
							}
							for (local241 = 0; local241 < local199; local241++) {
								@Pc(291) byte local291 = local215[local195 * local241 + local232] = local4.g1s();
								local208 |= local291 != -1;
							}
							local232++;
						}
					}
					for (local241 = 0; local241 < local199; local241++) {
						local206[local232 + local241 * local195] = local4.g1s();
					}
					local232++;
				}
			}
			Static159.aBooleanArray87[local68] = local208;
		}
	}

	@OriginalMember(owner = "client!gk", name = "a", descriptor = "(Lclient!rg;Lclient!rg;B)V")
	public static void method1772(@OriginalArg(0) CachedNode arg0, @OriginalArg(1) CachedNode arg1) {
		if (arg1.nextCachedNode != null) {
			arg1.unlinkCachedNode();
		}
		arg1.nextCachedNode = arg0;
		arg1.previousCachedNode = arg0.previousCachedNode;
		arg1.nextCachedNode.previousCachedNode = arg1;
		arg1.previousCachedNode.nextCachedNode = arg1;
	}
}
