package com.jagex.runetek4;

import com.jagex.runetek4.cache.CacheArchive;
import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!ke")
public final class TextureOp16 extends TextureOp {

	@OriginalMember(owner = "runetek4.client!ke", name = "V", descriptor = "I")
	private int anInt3292 = 32768;

	@OriginalMember(owner = "runetek4.client!ke", name = "<init>", descriptor = "()V")
	public TextureOp16() {
		super(3, false);
	}

	@OriginalMember(owner = "runetek4.client!ke", name = "b", descriptor = "(II)[[I")
	@Override
	public final int[][] method4638(@OriginalArg(1) int arg0) {
		@Pc(17) int[][] local17 = this.aClass103_41.method3173(arg0);
		if (this.aClass103_41.aBoolean195) {
			@Pc(28) int[] local28 = this.method4624(1, arg0);
			@Pc(34) int[] local34 = this.method4624(2, arg0);
			@Pc(38) int[] local38 = local17[2];
			@Pc(42) int[] local42 = local17[1];
			@Pc(46) int[] local46 = local17[0];
			for (@Pc(48) int local48 = 0; local48 < Texture.width; local48++) {
				@Pc(61) int local61 = local28[local48] * 255 >> 12 & 0xFF;
				@Pc(70) int local70 = local34[local48] * this.anInt3292 >> 12;
				@Pc(78) int local78 = local70 * Static130.anIntArray299[local61] >> 12;
				@Pc(86) int local86 = Static119.anIntArray282[local61] * local70 >> 12;
				@Pc(94) int local94 = (local78 >> 12) + local48 & Texture.widthMask;
				@Pc(103) int local103 = Texture.heightMask & arg0 + (local86 >> 12);
				@Pc(109) int[][] local109 = this.method4634(local103, 0);
				local46[local48] = local109[0][local94];
				local42[local48] = local109[1][local94];
				local38[local48] = local109[2][local94];
			}
		}
		return local17;
	}

	@OriginalMember(owner = "runetek4.client!ke", name = "a", descriptor = "(IB)[I")
	@Override
	public final int[] method4626(@OriginalArg(0) int arg0) {
		@Pc(19) int[] local19 = this.aClass121_41.get(arg0);
		if (this.aClass121_41.invalid) {
			@Pc(29) int[] local29 = this.method4624(1, arg0);
			@Pc(35) int[] local35 = this.method4624(2, arg0);
			for (@Pc(37) int local37 = 0; local37 < Texture.width; local37++) {
				@Pc(49) int local49 = this.anInt3292 * local35[local37] >> 12;
				@Pc(57) int local57 = local29[local37] >> 4 & 0xFF;
				@Pc(65) int local65 = Static130.anIntArray299[local57] * local49 >> 12;
				@Pc(73) int local73 = Static119.anIntArray282[local57] * local49 >> 12;
				@Pc(81) int local81 = Texture.widthMask & (local65 >> 12) + local37;
				@Pc(89) int local89 = Texture.heightMask & (local73 >> 12) + arg0;
				@Pc(95) int[] local95 = this.method4624(0, local89);
				local19[local37] = local95[local81];
			}
		}
		return local19;
	}

	@OriginalMember(owner = "runetek4.client!ke", name = "a", descriptor = "(ILclient!wa;Z)V")
	@Override
	public final void decode(@OriginalArg(1) Packet packet, @OriginalArg(0) int code) {
		if (code == 0) {
			this.anInt3292 = packet.g2() << 4;
		} else if (code == 1) {
			this.aBoolean309 = packet.g1() == 1;
		}
	}

	@OriginalMember(owner = "runetek4.client!ke", name = "e", descriptor = "(I)V")
	@Override
	public final void postDecode() {
		CacheArchive.method185();
	}
}
