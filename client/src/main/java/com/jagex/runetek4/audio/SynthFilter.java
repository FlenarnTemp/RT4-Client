package com.jagex.runetek4.audio;

import com.jagex.runetek4.Static174;
import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!nl")
public final class SynthFilter {

	@OriginalMember(owner = "runetek4.client!nl", name = "e", descriptor = "[I")
	public final int[] num_pairs = new int[2];

	@OriginalMember(owner = "runetek4.client!nl", name = "c", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray15 = new int[2][2][4];

	@OriginalMember(owner = "runetek4.client!nl", name = "a", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray14 = new int[2][2][4];

	@OriginalMember(owner = "runetek4.client!nl", name = "h", descriptor = "[I")
	private final int[] anIntArray369 = new int[2];

	@OriginalMember(owner = "runetek4.client!nl", name = "a", descriptor = "(Lclient!wa;Lclient!ff;)V")
	public final void decode(@OriginalArg(0) Packet arg0, @OriginalArg(1) SynthEnvelope arg1) {
		@Pc(3) int local3 = arg0.g1();
		this.num_pairs[0] = local3 >> 4;
		this.num_pairs[1] = local3 & 0xF;
		if (local3 == 0) {
			this.anIntArray369[0] = this.anIntArray369[1] = 0;
			return;
		}
		this.anIntArray369[0] = arg0.g2();
		this.anIntArray369[1] = arg0.g2();
		@Pc(37) int local37 = arg0.g1();
		@Pc(39) int local39;
		@Pc(44) int local44;
		for (local39 = 0; local39 < 2; local39++) {
			for (local44 = 0; local44 < this.num_pairs[local39]; local44++) {
				this.anIntArrayArrayArray14[local39][0][local44] = arg0.g2();
				this.anIntArrayArrayArray15[local39][0][local44] = arg0.g2();
			}
		}
		for (local39 = 0; local39 < 2; local39++) {
			for (local44 = 0; local44 < this.num_pairs[local39]; local44++) {
				if ((local37 & 0x1 << local39 * 4 << local44) == 0) {
					this.anIntArrayArrayArray14[local39][1][local44] = this.anIntArrayArrayArray14[local39][0][local44];
					this.anIntArrayArrayArray15[local39][1][local44] = this.anIntArrayArrayArray15[local39][0][local44];
				} else {
					this.anIntArrayArrayArray14[local39][1][local44] = arg0.g2();
					this.anIntArrayArrayArray15[local39][1][local44] = arg0.g2();
				}
			}
		}
		if (local37 != 0 || this.anIntArray369[1] != this.anIntArray369[0]) {
			arg1.decode_shape(arg0);
		}
	}

	@OriginalMember(owner = "runetek4.client!nl", name = "a", descriptor = "(IF)I")
	public final int method3251(@OriginalArg(0) int arg0, @OriginalArg(1) float arg1) {
		@Pc(20) float local20;
		if (arg0 == 0) {
			local20 = (float) this.anIntArray369[0] + (float) (this.anIntArray369[1] - this.anIntArray369[0]) * arg1;
			@Pc(24) float local24 = local20 * 0.0030517578F;
			Static174.aFloat22 = (float) Math.pow(0.1D, (double) (local24 / 20.0F));
			Static174.inv_unity = (int) (Static174.aFloat22 * 65536.0F);
		}
		if (this.num_pairs[arg0] == 0) {
			return 0;
		}
		local20 = this.method3253(arg0, 0, arg1);
		Static174.aFloatArrayArray2[arg0][0] = -2.0F * local20 * (float) Math.cos((double) this.method3254(arg0, 0, arg1));
		Static174.aFloatArrayArray2[arg0][1] = local20 * local20;
		@Pc(77) int local77;
		for (local77 = 1; local77 < this.num_pairs[arg0]; local77++) {
			local20 = this.method3253(arg0, local77, arg1);
			@Pc(102) float local102 = -2.0F * local20 * (float) Math.cos((double) this.method3254(arg0, local77, arg1));
			@Pc(106) float local106 = local20 * local20;
			Static174.aFloatArrayArray2[arg0][local77 * 2 + 1] = Static174.aFloatArrayArray2[arg0][local77 * 2 - 1] * local106;
			Static174.aFloatArrayArray2[arg0][local77 * 2] = Static174.aFloatArrayArray2[arg0][local77 * 2 - 1] * local102 + Static174.aFloatArrayArray2[arg0][local77 * 2 - 2] * local106;
			for (@Pc(162) int local162 = local77 * 2 - 1; local162 >= 2; local162--) {
				Static174.aFloatArrayArray2[arg0][local162] += Static174.aFloatArrayArray2[arg0][local162 - 1] * local102 + Static174.aFloatArrayArray2[arg0][local162 - 2] * local106;
			}
			Static174.aFloatArrayArray2[arg0][1] += Static174.aFloatArrayArray2[arg0][0] * local102 + local106;
			Static174.aFloatArrayArray2[arg0][0] += local102;
		}
		if (arg0 == 0) {
			for (local77 = 0; local77 < this.num_pairs[0] * 2; local77++) {
				Static174.aFloatArrayArray2[0][local77] *= Static174.aFloat22;
			}
		}
		for (local77 = 0; local77 < this.num_pairs[arg0] * 2; local77++) {
			Static174.coef[arg0][local77] = (int) (Static174.aFloatArrayArray2[arg0][local77] * 65536.0F);
		}
		return this.num_pairs[arg0] * 2;
	}

	@OriginalMember(owner = "runetek4.client!nl", name = "a", descriptor = "(IIF)F")
	private float method3253(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) float arg2) {
		@Pc(30) float local30 = (float) this.anIntArrayArrayArray15[arg0][0][arg1] + arg2 * (float) (this.anIntArrayArrayArray15[arg0][1][arg1] - this.anIntArrayArrayArray15[arg0][0][arg1]);
		@Pc(34) float local34 = local30 * 0.0015258789F;
		return 1.0F - (float) Math.pow(10.0D, (double) (-local34 / 20.0F));
	}

	@OriginalMember(owner = "runetek4.client!nl", name = "b", descriptor = "(IIF)F")
	private float method3254(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) float arg2) {
		@Pc(30) float local30 = (float) this.anIntArrayArrayArray14[arg0][0][arg1] + arg2 * (float) (this.anIntArrayArrayArray14[arg0][1][arg1] - this.anIntArrayArrayArray14[arg0][0][arg1]);
		@Pc(34) float local34 = local30 * 1.2207031E-4F;
		return Static174.method3250(local34);
	}
}
