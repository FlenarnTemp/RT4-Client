package com.jagex.runetek4;

import com.jagex.runetek4.util.ArrayUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static222 {

	@OriginalMember(owner = "runetek4.client!sa", name = "Y", descriptor = "I")
	public static volatile int anInt4973 = 0;

	@OriginalMember(owner = "runetek4.client!sa", name = "c", descriptor = "(III)I")
	public static int method3825(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		@Pc(12) int local12 = arg0 >>> 31;
		return (arg0 + local12) / arg1 - local12;
	}

	@OriginalMember(owner = "runetek4.client!sa", name = "a", descriptor = "(IIIBI)V")
	public static void method3826(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
		if (arg3 <= arg2) {
			ArrayUtils.fillRange(ObjTypeList.anIntArrayArray10[arg1], arg3, arg2, arg0);
		} else {
			ArrayUtils.fillRange(ObjTypeList.anIntArrayArray10[arg1], arg2, arg3, arg0);
		}
	}
}
