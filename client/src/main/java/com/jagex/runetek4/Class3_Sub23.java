package com.jagex.runetek4;

import com.jagex.runetek4.node.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("runetek4.client!lb")
public final class Class3_Sub23 extends Node {

	@OriginalMember(owner = "runetek4.client!lb", name = "t", descriptor = "I")
	public final int anInt3468;

	@OriginalMember(owner = "runetek4.client!lb", name = "C", descriptor = "I")
	public final int anInt3476;

	@OriginalMember(owner = "runetek4.client!lb", name = "<init>", descriptor = "(II)V")
	public Class3_Sub23(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anInt3468 = arg1;
		this.anInt3476 = arg0;
	}
}
