package com.jagex.runetek4;

import com.jagex.runetek4.util.MathUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static77 {

	@OriginalMember(owner = "client!gb", name = "L", descriptor = "[I")
	public static final int[] anIntArray194 = new int[10000];

	@OriginalMember(owner = "client!gb", name = "N", descriptor = "[I")
	public static final int[] anIntArray195 = MathUtils.cos;

	@OriginalMember(owner = "client!gb", name = "S", descriptor = "I")
	public static int anInt2138 = 0;

	@OriginalMember(owner = "client!gb", name = "V", descriptor = "[I")
	public static final int[] anIntArray198 = MathUtils.sin;

	@OriginalMember(owner = "client!gb", name = "Z", descriptor = "[I")
	public static final int[] anIntArray199 = new int[10000];

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "([[III)I")
	public static int method1680(@OriginalArg(0) int[][] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(3) int local3 = arg1 >> 7;
		@Pc(7) int local7 = arg2 >> 7;
		if (local3 < 0 || local7 < 0 || local3 >= arg0.length || local7 >= arg0[0].length) {
			return 0;
		}
		@Pc(27) int local27 = arg1 & 0x7F;
		@Pc(31) int local31 = arg2 & 0x7F;
		@Pc(53) int local53 = arg0[local3][local7] * (128 - local27) + arg0[local3 + 1][local7] * local27 >> 7;
		@Pc(79) int local79 = arg0[local3][local7 + 1] * (128 - local27) + arg0[local3 + 1][local7 + 1] * local27 >> 7;
		return local53 * (128 - local31) + local79 * local31 >> 7;
	}
}