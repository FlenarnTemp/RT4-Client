package com.jagex.runetek4;

import com.jagex.runetek4.media.renderable.actor.Player;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static256 {

	@OriginalMember(owner = "runetek4.client!um", name = "a", descriptor = "(Z)V")
	public static void method4392() {
		Player.overrideChat = 0;
		@Pc(17) int local17 = Camera.originX + (PlayerList.self.xFine >> 7);
		@Pc(25) int local25 = (PlayerList.self.zFine >> 7) + Camera.originZ;
		if (local17 >= 3053 && local17 <= 3156 && local25 >= 3056 && local25 <= 3136) {
			Player.overrideChat = 1;
		}
		if (local17 >= 3072 && local17 <= 3118 && local25 >= 9492 && local25 <= 9535) {
			Player.overrideChat = 1;
		}
		if (Player.overrideChat == 1 && local17 >= 3139 && local17 <= 3199 && local25 >= 3008 && local25 <= 3062) {
			Player.overrideChat = 0;
		}
	}

	@OriginalMember(owner = "runetek4.client!um", name = "c", descriptor = "(III)Z")
	public static boolean method4394(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		for (@Pc(1) int local1 = 0; local1 < Static215.anInt4870; local1++) {
			@Pc(8) Class120 local8 = Static247.aClass120Array2[local1];
			@Pc(17) int local17;
			@Pc(29) int local29;
			@Pc(39) int local39;
			@Pc(49) int local49;
			@Pc(59) int local59;
			if (local8.anInt4462 == 1) {
				local17 = local8.anInt4460 - arg0;
				if (local17 > 0) {
					local29 = local8.anInt4458 + (local8.anInt4454 * local17 >> 8);
					local39 = local8.anInt4449 + (local8.anInt4450 * local17 >> 8);
					local49 = local8.anInt4444 + (local8.anInt4459 * local17 >> 8);
					local59 = local8.anInt4447 + (local8.anInt4463 * local17 >> 8);
					if (arg2 >= local29 && arg2 <= local39 && arg1 >= local49 && arg1 <= local59) {
						return true;
					}
				}
			} else if (local8.anInt4462 == 2) {
				local17 = arg0 - local8.anInt4460;
				if (local17 > 0) {
					local29 = local8.anInt4458 + (local8.anInt4454 * local17 >> 8);
					local39 = local8.anInt4449 + (local8.anInt4450 * local17 >> 8);
					local49 = local8.anInt4444 + (local8.anInt4459 * local17 >> 8);
					local59 = local8.anInt4447 + (local8.anInt4463 * local17 >> 8);
					if (arg2 >= local29 && arg2 <= local39 && arg1 >= local49 && arg1 <= local59) {
						return true;
					}
				}
			} else if (local8.anInt4462 == 3) {
				local17 = local8.anInt4458 - arg2;
				if (local17 > 0) {
					local29 = local8.anInt4460 + (local8.anInt4448 * local17 >> 8);
					local39 = local8.anInt4445 + (local8.anInt4456 * local17 >> 8);
					local49 = local8.anInt4444 + (local8.anInt4459 * local17 >> 8);
					local59 = local8.anInt4447 + (local8.anInt4463 * local17 >> 8);
					if (arg0 >= local29 && arg0 <= local39 && arg1 >= local49 && arg1 <= local59) {
						return true;
					}
				}
			} else if (local8.anInt4462 == 4) {
				local17 = arg2 - local8.anInt4458;
				if (local17 > 0) {
					local29 = local8.anInt4460 + (local8.anInt4448 * local17 >> 8);
					local39 = local8.anInt4445 + (local8.anInt4456 * local17 >> 8);
					local49 = local8.anInt4444 + (local8.anInt4459 * local17 >> 8);
					local59 = local8.anInt4447 + (local8.anInt4463 * local17 >> 8);
					if (arg0 >= local29 && arg0 <= local39 && arg1 >= local49 && arg1 <= local59) {
						return true;
					}
				}
			} else if (local8.anInt4462 == 5) {
				local17 = arg1 - local8.anInt4444;
				if (local17 > 0) {
					local29 = local8.anInt4460 + (local8.anInt4448 * local17 >> 8);
					local39 = local8.anInt4445 + (local8.anInt4456 * local17 >> 8);
					local49 = local8.anInt4458 + (local8.anInt4454 * local17 >> 8);
					local59 = local8.anInt4449 + (local8.anInt4450 * local17 >> 8);
					if (arg0 >= local29 && arg0 <= local39 && arg2 >= local49 && arg2 <= local59) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
