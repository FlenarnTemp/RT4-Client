package com.jagex.runetek4;

import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!gg")
public final class TextureOp11 extends TextureOp {

	@OriginalMember(owner = "runetek4.client!gg", name = "V", descriptor = "I")
	private int anInt2220 = 4;

	@OriginalMember(owner = "runetek4.client!gg", name = "R", descriptor = "I")
	private int anInt2216 = 4;

	@OriginalMember(owner = "runetek4.client!gg", name = "<init>", descriptor = "()V")
	public TextureOp11() {
		super(1, false);
	}

	@OriginalMember(owner = "runetek4.client!gg", name = "a", descriptor = "(ILclient!wa;Z)V")
	@Override
	public final void decode(@OriginalArg(1) Packet packet, @OriginalArg(0) int code) {
		if (code == 0) {
			this.anInt2220 = packet.g1();
		} else if (code == 1) {
			this.anInt2216 = packet.g1();
		}
	}

	@OriginalMember(owner = "runetek4.client!gg", name = "a", descriptor = "(IB)[I")
	@Override
	public final int[] method4626(@OriginalArg(0) int arg0) {
		@Pc(19) int[] local19 = this.aClass121_41.get(arg0);
		if (this.aClass121_41.invalid) {
			@Pc(28) int local28 = Texture.width / this.anInt2220;
			@Pc(33) int local33 = Texture.height / this.anInt2216;
			@Pc(44) int[] local44;
			@Pc(50) int local50;
			if (local33 <= 0) {
				local44 = this.method4624(0, 0);
			} else {
				local50 = arg0 % local33;
				local44 = this.method4624(0, Texture.height * local50 / local33);
			}
			for (local50 = 0; local50 < Texture.width; local50++) {
				if (local28 <= 0) {
					local19[local50] = local44[0];
				} else {
					@Pc(80) int local80 = local50 % local28;
					local19[local50] = local44[Texture.width * local80 / local28];
				}
			}
		}
		return local19;
	}

	@OriginalMember(owner = "runetek4.client!gg", name = "b", descriptor = "(II)[[I")
	@Override
	public final int[][] method4638(@OriginalArg(1) int arg0) {
		@Pc(18) int[][] local18 = this.aClass103_41.method3173(arg0);
		if (this.aClass103_41.aBoolean195) {
			@Pc(28) int local28 = Texture.width / this.anInt2220;
			@Pc(33) int local33 = Texture.height / this.anInt2216;
			@Pc(49) int[][] local49;
			if (local33 > 0) {
				@Pc(39) int local39 = arg0 % local33;
				local49 = this.method4634(local39 * Texture.height / local33, 0);
			} else {
				local49 = this.method4634(0, 0);
			}
			@Pc(61) int[] local61 = local49[0];
			@Pc(65) int[] local65 = local49[2];
			@Pc(69) int[] local69 = local18[0];
			@Pc(73) int[] local73 = local49[1];
			@Pc(77) int[] local77 = local18[1];
			@Pc(81) int[] local81 = local18[2];
			for (@Pc(83) int local83 = 0; local83 < Texture.width; local83++) {
				@Pc(94) int local94;
				if (local28 <= 0) {
					local94 = 0;
				} else {
					@Pc(100) int local100 = local83 % local28;
					local94 = local100 * Texture.width / local28;
				}
				local69[local83] = local61[local94];
				local77[local83] = local73[local94];
				local81[local83] = local65[local94];
			}
		}
		return local18;
	}
}
