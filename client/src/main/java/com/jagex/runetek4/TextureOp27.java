package com.jagex.runetek4;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("runetek4.client!rl")
public final class TextureOp27 extends TextureOp {

	@OriginalMember(owner = "runetek4.client!rl", name = "<init>", descriptor = "()V")
	public TextureOp27() {
		super(0, true);
	}

	@OriginalMember(owner = "runetek4.client!rl", name = "a", descriptor = "(IB)[I")
	@Override
	public final int[] method4626(@OriginalArg(0) int arg0) {
		return Texture.widthFractions;
	}
}
