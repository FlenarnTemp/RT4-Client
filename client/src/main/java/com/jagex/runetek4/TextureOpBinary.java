package com.jagex.runetek4;

import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!ca")
public final class TextureOpBinary extends TextureOp {

	@OriginalMember(owner = "runetek4.client!ca", name = "T", descriptor = "I")
	private int anInt861 = 4096;

	@OriginalMember(owner = "runetek4.client!ca", name = "P", descriptor = "I")
	private int anInt857 = 0;

	@OriginalMember(owner = "runetek4.client!ca", name = "<init>", descriptor = "()V")
	public TextureOpBinary() {
		super(1, true);
	}

	@OriginalMember(owner = "runetek4.client!ca", name = "a", descriptor = "(IB)[I")
	@Override
	public final int[] method4626(@OriginalArg(0) int arg0) {
		@Pc(19) int[] local19 = this.aClass121_41.get(arg0);
		if (this.aClass121_41.invalid) {
			@Pc(29) int[] local29 = this.method4624(0, arg0);
			for (@Pc(31) int local31 = 0; local31 < Texture.width; local31++) {
				@Pc(38) int local38 = local29[local31];
				local19[local31] = this.anInt857 <= local38 && local38 <= this.anInt861 ? 4096 : 0;
			}
		}
		return local19;
	}

	@OriginalMember(owner = "runetek4.client!ca", name = "a", descriptor = "(ILclient!wa;Z)V")
	@Override
	public final void decode(@OriginalArg(1) Packet packet, @OriginalArg(0) int code) {
		if (code == 0) {
			this.anInt857 = packet.g2();
		} else if (code == 1) {
			this.anInt861 = packet.g2();
		}
	}
}
