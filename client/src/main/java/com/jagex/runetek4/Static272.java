package com.jagex.runetek4;

import com.jagex.runetek4.cache.def.VarbitDefinition;
import com.jagex.runetek4.cache.def.VarPlayerDefinition;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static272 {

	@OriginalMember(owner = "runetek4.client!wd", name = "a", descriptor = "Lclient!gn;")
	public static final LruHashTable aClass54_14 = new LruHashTable(64);

	@OriginalMember(owner = "runetek4.client!wd", name = "d", descriptor = "[I")
	public static final int[] anIntArray451 = new int[] { 8, 11, 4, 6, 9, 7, 10, 0 };

	@OriginalMember(owner = "runetek4.client!wd", name = "e", descriptor = "Lclient!na;")
	public static final JString aClass100_989 = JString.parse("cookieprefix");

	@OriginalMember(owner = "runetek4.client!wd", name = "a", descriptor = "(BII)V")
	public static void method3995(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(14) VarbitDefinition local14 = VarbitDefinition.getDefinition(arg1);
		@Pc(17) int local17 = local14.index;
		@Pc(20) int local20 = local14.anInt3323;
		@Pc(23) int local23 = local14.anInt3318;
		@Pc(29) int local29 = VarbitDefinition.varbitMasks[local20 - local23];
		if (arg0 < 0 || local29 < arg0) {
			arg0 = 0;
		}
		local29 <<= local23;
		ObjTypeList.method2575(arg0 << local23 & local29 | ~local29 & VarPlayerDefinition.varPlayerCache[local17], local17);
	}
}
