package com.jagex.runetek4;

import com.jagex.runetek4.cache.media.component.Component;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static205 {

	@OriginalMember(owner = "runetek4.client!qj", name = "i", descriptor = "[I")
	public static final int[] keyChars = new int[128];

	@OriginalMember(owner = "runetek4.client!qj", name = "a", descriptor = "(Lclient!be;BI)Lclient!na;")
	public static JString method3677(@OriginalArg(0) Component arg0, @OriginalArg(2) int arg1) {
		if (!Static36.method940(arg0).method503(arg1) && arg0.anObjectArray29 == null) {
			return null;
		} else if (arg0.aClass100Array18 == null || arg0.aClass100Array18.length <= arg1 || arg0.aClass100Array18[arg1] == null || arg0.aClass100Array18[arg1].trim().length() == 0) {
			return Static121.aBoolean154 ? Static34.method882(new JString[] { Static207.aClass100_903, Static123.method2423(arg1) }) : null;
		} else {
			return arg0.aClass100Array18[arg1];
		}
	}
}
