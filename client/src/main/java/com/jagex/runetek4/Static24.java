package com.jagex.runetek4;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static24 {

	@OriginalMember(owner = "client!bn", name = "eb", descriptor = "I")
	public static int anInt773 = 0;

	@OriginalMember(owner = "client!bn", name = "a", descriptor = "(IIB)I")
	public static int method670(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(47) int local47 = Static138.method2695(arg0 - 1, arg1 + -1) + Static138.method2695(arg0 + 1, arg1 + -1) + Static138.method2695(arg0 + -1, arg1 - -1) + Static138.method2695(arg0 + 1, arg1 - -1);
		@Pc(76) int local76 = Static138.method2695(arg0 - 1, arg1) + Static138.method2695(arg0 + 1, arg1) + Static138.method2695(arg0, arg1 + -1) + Static138.method2695(arg0, arg1 + 1);
		@Pc(81) int local81 = Static138.method2695(arg0, arg1);
		return local76 / 8 + local47 / 16 + local81 / 4;
	}

}
