package com.jagex.runetek4;

import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static21 {

	@OriginalMember(owner = "client!bk", name = "a", descriptor = "(BI)V")
	public static void method619(@OriginalArg(1) int arg0) {
		Static257.aFloatArray2[0] = (float) (arg0 >> 16 & 0xFF) / 255.0F;
		Static257.aFloatArray2[1] = (float) (arg0 >> 8 & 0xFF) / 255.0F;
		Static257.aFloatArray2[2] = (float) (arg0 & 0xFF) / 255.0F;
		MaterialManager.resetArgument(3);
		MaterialManager.resetArgument(4);
	}

	@OriginalMember(owner = "client!bk", name = "a", descriptor = "(BLclient!wa;)Lclient!re;")
	public static TextureOp29SubOp3 method620(@OriginalArg(1) Packet arg0) {
		return new TextureOp29SubOp3(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g1());
	}
}
