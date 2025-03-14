package com.jagex.runetek4;

import com.jagex.runetek4.cache.media.component.Component;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static150 {

	@OriginalMember(owner = "runetek4.client!lk", name = "J", descriptor = "Lclient!na;")
	public static final JString aClass100_687 = Static28.parse(")4p=");

	@OriginalMember(owner = "runetek4.client!lk", name = "U", descriptor = "Z")
	public static boolean aBoolean175 = false;

	@OriginalMember(owner = "runetek4.client!lk", name = "V", descriptor = "I")
	public static int anInt3582 = 0;

	@OriginalMember(owner = "runetek4.client!lk", name = "a", descriptor = "(ILclient!ve;)I")
	public static int method2797(@OriginalArg(1) Js5 arg0) {
		@Pc(1) int local1 = 0;
		if (arg0.method4506(Static262.anInt5754)) {
			local1++;
		}
		if (arg0.method4506(Static136.anInt3322)) {
			local1++;
		}
		return local1;
	}

	@OriginalMember(owner = "runetek4.client!lk", name = "a", descriptor = "(IIBLclient!ve;)Lclient!qf;")
	public static Sprite method2800(@OriginalArg(1) int arg0, @OriginalArg(3) Js5 arg1) {
		return Static234.method4016(arg1, 0, arg0) ? Static82.method1764() : null;
	}

	@OriginalMember(owner = "runetek4.client!lk", name = "a", descriptor = "(IIILclient!be;Z)V")
	public static void method2801(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Component arg2, @OriginalArg(4) boolean arg3) {
		@Pc(4) int local4 = arg2.anInt445;
		@Pc(7) int local7 = arg2.anInt459;
		if (arg2.aByte5 == 0) {
			arg2.anInt445 = arg2.baseWidth;
		} else if (arg2.aByte5 == 1) {
			arg2.anInt445 = arg1 - arg2.baseWidth;
		} else if (arg2.aByte5 == 2) {
			arg2.anInt445 = arg2.baseWidth * arg1 >> 14;
		} else if (arg2.aByte5 == 3) {
			if (arg2.INVENTORY == 2) {
				arg2.anInt445 = arg2.baseWidth * 32 + (arg2.baseWidth - 1) * arg2.anInt512;
			} else if (arg2.INVENTORY == 7) {
				arg2.anInt445 = arg2.baseWidth * 115 + arg2.anInt512 * (arg2.baseWidth - 1);
			}
		}
		if (arg2.aByte3 == 0) {
			arg2.anInt459 = arg2.anInt488;
		} else if (arg2.aByte3 == 1) {
			arg2.anInt459 = arg0 - arg2.anInt488;
		} else if (arg2.aByte3 == 2) {
			arg2.anInt459 = arg0 * arg2.anInt488 >> 14;
		} else if (arg2.aByte3 == 3) {
			if (arg2.INVENTORY == 2) {
				arg2.anInt459 = (arg2.anInt488 - 1) * arg2.anInt516 + arg2.anInt488 * 32;
			} else if (arg2.INVENTORY == 7) {
				arg2.anInt459 = arg2.anInt488 * 12 + (arg2.anInt488 - 1) * arg2.anInt516;
			}
		}
		if (arg2.aByte5 == 4) {
			arg2.anInt445 = arg2.anInt473 * arg2.anInt459 / arg2.anInt442;
		}
		if (arg2.aByte3 == 4) {
			arg2.anInt459 = arg2.anInt442 * arg2.anInt445 / arg2.anInt473;
		}
		if (Static121.aBoolean154 && (Static36.method940(arg2).anInt546 != 0 || arg2.INVENTORY == 0)) {
			if (arg2.anInt459 < 5 && arg2.anInt445 < 5) {
				arg2.anInt459 = 5;
				arg2.anInt445 = 5;
			} else {
				if (arg2.anInt445 <= 0) {
					arg2.anInt445 = 5;
				}
				if (arg2.anInt459 <= 0) {
					arg2.anInt459 = 5;
				}
			}
		}
		if (arg2.contentType == 1337) {
			Static280.aClass13_26 = arg2;
		}
		if (arg3 && arg2.anObjectArray17 != null && (local4 != arg2.anInt445 || arg2.anInt459 != local7)) {
			@Pc(305) HookRequest local305 = new HookRequest();
			local305.anObjectArray31 = arg2.anObjectArray17;
			local305.source = arg2;
			Static185.aClass69_101.addTail(local305);
		}
	}

	@OriginalMember(owner = "runetek4.client!lk", name = "a", descriptor = "(ILclient!fl;IIII)V")
	public static void method2804(@OriginalArg(0) int arg0, @OriginalArg(1) AreaSound arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg1.sound == -1 && arg1.sounds == null) {
			return;
		}
		@Pc(20) int local20 = 0;
		if (arg1.anInt2037 < arg0) {
			local20 = arg0 - arg1.anInt2037;
		} else if (arg1.anInt2041 > arg0) {
			local20 = arg1.anInt2041 - arg0;
		}
		if (arg1.anInt2028 < arg4) {
			local20 += arg4 - arg1.anInt2028;
		} else if (arg4 < arg1.anInt2029) {
			local20 += arg1.anInt2029 - arg4;
		}
		if (arg1.radius == 0 || arg1.radius < local20 - 64 || Static30.anInt978 == 0 || arg2 != arg1.level) {
			if (arg1.primaryStream != null) {
				Static204.soundStream.removeSubStream(arg1.primaryStream);
				arg1.primaryStream = null;
			}
			if (arg1.secondaryStream != null) {
				Static204.soundStream.removeSubStream(arg1.secondaryStream);
				arg1.secondaryStream = null;
			}
			return;
		}
		local20 -= 64;
		if (local20 < 0) {
			local20 = 0;
		}
		@Pc(134) int local134 = (arg1.radius - local20) * Static30.anInt978 / arg1.radius;
		if (arg1.primaryStream != null) {
			arg1.primaryStream.method386(local134);
		} else if (arg1.sound >= 0) {
			@Pc(150) SynthSound local150 = Static292.method3988(Static248.aClass153_75, arg1.sound, 0);
			if (local150 != null) {
				@Pc(158) PcmSound local158 = local150.method3989().method2648(Static56.aClass156_1);
				@Pc(163) SoundPcmStream local163 = Static284.method404(local158, local134);
				local163.method396(-1);
				Static204.soundStream.method1343(local163);
				arg1.primaryStream = local163;
			}
		}
		if (arg1.secondaryStream != null) {
			arg1.secondaryStream.method386(local134);
			if (!arg1.secondaryStream.hasNext()) {
				arg1.secondaryStream = null;
			}
		} else if (arg1.sounds != null && (arg1.remainingLoops -= arg3) <= 0) {
			@Pc(219) int local219 = (int) ((double) arg1.sounds.length * Math.random());
			@Pc(227) SynthSound local227 = Static292.method3988(Static248.aClass153_75, arg1.sounds[local219], 0);
			if (local227 != null) {
				@Pc(236) PcmSound local236 = local227.method3989().method2648(Static56.aClass156_1);
				@Pc(241) SoundPcmStream local241 = Static284.method404(local236, local134);
				local241.method396(0);
				Static204.soundStream.method1343(local241);
				arg1.remainingLoops = (int) ((double) (arg1.maxInterval - arg1.minInterval) * Math.random()) + arg1.minInterval;
				arg1.secondaryStream = local241;
			}
		}
	}

}
