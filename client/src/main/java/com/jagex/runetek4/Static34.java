package com.jagex.runetek4;

import com.jagex.runetek4.cache.def.SpotAnimDefinition;
import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.cache.media.SeqType;
import com.jagex.runetek4.dash3d.entity.PathingEntity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static34 {

	@OriginalMember(owner = "runetek4.client!ck", name = "F", descriptor = "I")
	public static int anInt1049;

	@OriginalMember(owner = "runetek4.client!ck", name = "J", descriptor = "[[[B")
	public static byte[][][] aByteArrayArrayArray3;

    @OriginalMember(owner = "runetek4.client!ck", name = "b", descriptor = "Lclient!na;")
	private static final JString aClass100_195 = JString.parse("Discard");

	@OriginalMember(owner = "client!ck", name = "d", descriptor = "[I")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_X = new int[] { 1, 0, -1, 0 };

	@OriginalMember(owner = "client!ck", name = "k", descriptor = "I")
	public static volatile int anInt1034 = 0;

	@OriginalMember(owner = "client!ck", name = "o", descriptor = "Lclient!na;")
	private static final JString LOADED_WORLD_LIST_DATA = JString.parse("Loaded world list data");

	@OriginalMember(owner = "client!ck", name = "D", descriptor = "Lclient!na;")
	public static JString aClass100_203 = null;

	@OriginalMember(owner = "client!ck", name = "a", descriptor = "(BI)Lclient!eg;")
	public static SpotAnimDefinition method877(@OriginalArg(1) int arg0) {
		@Pc(10) SpotAnimDefinition local10 = (SpotAnimDefinition) Static279.aClass99_38.get((long) arg0);
		if (local10 != null) {
			return local10;
		}
		@Pc(26) byte[] local26 = Static132.aClass153_48.getfile(Static206.method3681(arg0), Static133.method4010(arg0));
		local10 = new SpotAnimDefinition();
		local10.anInt1751 = arg0;
		if (local26 != null) {
			local10.readValues(new Packet(local26));
		}
		Static279.aClass99_38.put(local10, (long) arg0);
		return local10;
	}

	@OriginalMember(owner = "client!ck", name = "a", descriptor = "(Lclient!fe;I)V")
	public static void method879(@OriginalArg(0) PathingEntity arg0) {
		arg0.seqStretches = false;
		@Pc(18) SeqType seq;
		if (arg0.movementSeqId != -1) {
			seq = SeqTypeList.getAnimationSequence(arg0.movementSeqId);
			if (seq == null || seq.anIntArray473 == null) {
				arg0.movementSeqId = -1;
			} else {
				arg0.anInt3396++;
				if (seq.anIntArray473.length > arg0.anInt3407 && arg0.anInt3396 > seq.frames[arg0.anInt3407]) {
					arg0.anInt3396 = 1;
					arg0.anInt3407++;
					arg0.anInt3388++;
					SoundPlayer.playSeqSound(arg0.zFine, seq, arg0.xFine, arg0 == PlayerList.self, arg0.anInt3407);
				}
				if (arg0.anInt3407 >= seq.anIntArray473.length) {
					arg0.anInt3407 = 0;
					arg0.anInt3396 = 0;
					SoundPlayer.playSeqSound(arg0.zFine, seq, arg0.xFine, PlayerList.self == arg0, arg0.anInt3407);
				}
				arg0.anInt3388 = arg0.anInt3407 + 1;
				if (arg0.anInt3388 >= seq.anIntArray473.length) {
					arg0.anInt3388 = 0;
				}
			}
		}
		@Pc(156) int local156;
		if (arg0.spotanimFrame != -1 && client.loop >= arg0.spotanimLastCycle) {
			local156 = method877(arg0.spotanimFrame).animationId;
			if (local156 == -1) {
				arg0.spotanimFrame = -1;
			} else {
				@Pc(165) SeqType local165 = SeqTypeList.getAnimationSequence(local156);
				if (local165 == null || local165.anIntArray473 == null) {
					arg0.spotanimFrame = -1;
				} else {
					if (arg0.spotanimId < 0) {
						arg0.spotanimId = 0;
						SoundPlayer.playSeqSound(arg0.zFine, local165, arg0.xFine, PlayerList.self == arg0, 0);
					}
					arg0.anInt3361++;
					if (arg0.spotanimId < local165.anIntArray473.length && local165.frames[arg0.spotanimId] < arg0.anInt3361) {
						arg0.spotanimId++;
						arg0.anInt3361 = 1;
						SoundPlayer.playSeqSound(arg0.zFine, local165, arg0.xFine, PlayerList.self == arg0, arg0.spotanimId);
					}
					if (arg0.spotanimId >= local165.anIntArray473.length) {
						arg0.spotanimFrame = -1;
					}
					arg0.anInt3418 = arg0.spotanimId + 1;
					if (local165.anIntArray473.length <= arg0.anInt3418) {
						arg0.anInt3418 = -1;
					}
				}
			}
		}
		if (arg0.primarySeqId != -1 && arg0.anInt3420 <= 1) {
			seq = SeqTypeList.getAnimationSequence(arg0.primarySeqId);
			if (seq.anInt5363 == 1 && arg0.anInt3405 > 0 && client.loop >= arg0.anInt3395 && client.loop > arg0.anInt3386) {
				arg0.anInt3420 = 1;
				return;
			}
		}
		if (arg0.primarySeqId != -1 && arg0.anInt3420 == 0) {
			seq = SeqTypeList.getAnimationSequence(arg0.primarySeqId);
			if (seq == null || seq.anIntArray473 == null) {
				arg0.primarySeqId = -1;
			} else {
				arg0.anInt3360++;
				if (arg0.anInt3425 < seq.anIntArray473.length && arg0.anInt3360 > seq.frames[arg0.anInt3425]) {
					arg0.anInt3360 = 1;
					arg0.anInt3425++;
					SoundPlayer.playSeqSound(arg0.zFine, seq, arg0.xFine, arg0 == PlayerList.self, arg0.anInt3425);
				}
				if (seq.anIntArray473.length <= arg0.anInt3425) {
					arg0.anInt3425 -= seq.replayoff;
					arg0.anInt3371++;
					if (arg0.anInt3371 >= seq.replaycount) {
						arg0.primarySeqId = -1;
					} else if (arg0.anInt3425 >= 0 && seq.anIntArray473.length > arg0.anInt3425) {
						SoundPlayer.playSeqSound(arg0.zFine, seq, arg0.xFine, PlayerList.self == arg0, arg0.anInt3425);
					} else {
						arg0.primarySeqId = -1;
					}
				}
				arg0.anInt3373 = arg0.anInt3425 + 1;
				if (arg0.anInt3373 >= seq.anIntArray473.length) {
					arg0.anInt3373 -= seq.replayoff;
					if (seq.replaycount <= arg0.anInt3371 + 1) {
						arg0.anInt3373 = -1;
					} else if (arg0.anInt3373 < 0 || arg0.anInt3373 >= seq.anIntArray473.length) {
						arg0.anInt3373 = -1;
					}
				}
				arg0.seqStretches = seq.stretches;
			}
		}
		if (arg0.anInt3420 > 0) {
			arg0.anInt3420--;
		}
		for (local156 = 0; local156 < arg0.aClass147Array3.length; local156++) {
			@Pc(545) Class147 local545 = arg0.aClass147Array3[local156];
			if (local545 != null) {
				if (local545.anInt5408 > 0) {
					local545.anInt5408--;
				} else {
					@Pc(570) SeqType local570 = SeqTypeList.getAnimationSequence(local545.anInt5396);
					if (local570 == null || local570.anIntArray473 == null) {
						arg0.aClass147Array3[local156] = null;
					} else {
						local545.anInt5404++;
						if (local545.anInt5399 < local570.anIntArray473.length && local545.anInt5404 > local570.frames[local545.anInt5399]) {
							local545.anInt5399++;
							local545.anInt5404 = 1;
							SoundPlayer.playSeqSound(arg0.zFine, local570, arg0.xFine, arg0 == PlayerList.self, local545.anInt5399);
						}
						if (local570.anIntArray473.length <= local545.anInt5399) {
							local545.anInt5400++;
							local545.anInt5399 -= local570.replayoff;
							if (local570.replaycount <= local545.anInt5400) {
								arg0.aClass147Array3[local156] = null;
							} else if (local545.anInt5399 >= 0 && local545.anInt5399 < local570.anIntArray473.length) {
								SoundPlayer.playSeqSound(arg0.zFine, local570, arg0.xFine, PlayerList.self == arg0, local545.anInt5399);
							} else {
								arg0.aClass147Array3[local156] = null;
							}
						}
						local545.anInt5398 = local545.anInt5399 + 1;
						if (local570.anIntArray473.length <= local545.anInt5398) {
							local545.anInt5398 -= local570.replayoff;
							if (local545.anInt5400 + 1 >= local570.replaycount) {
								local545.anInt5398 = -1;
							} else if (local545.anInt5398 < 0 || local570.anIntArray473.length <= local545.anInt5398) {
								local545.anInt5398 = -1;
							}
						}
					}
				}
			}
		}
	}

}
