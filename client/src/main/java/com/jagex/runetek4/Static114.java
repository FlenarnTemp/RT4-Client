package com.jagex.runetek4;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static114 {

	@OriginalMember(owner = "runetek4.client!j", name = "L", descriptor = "I")
	public static int anInt5844 = 0;

	@OriginalMember(owner = "runetek4.client!j", name = "O", descriptor = "[I")
	public static final int[] anIntArray565 = new int[] { 1, -1, -1, 1 };

	@OriginalMember(owner = "runetek4.client!j", name = "a", descriptor = "([BI)Lclient!dd;")
	public static SoftwareFont method4635(@OriginalArg(0) byte[] arg0) {
		if (arg0 == null) {
			return null;
		} else {
			@Pc(22) SoftwareFont local22 = new SoftwareFont(arg0, Static274.anIntArray440, Static269.anIntArray252, Static254.anIntArray488, Static26.anIntArray66, aClass6.aByteArrayArray5);
			Static75.method1631();
			return local22;
		}
	}

}
