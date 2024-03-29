package com.jagex.runetek4;

import com.jagex.runetek4.js5.index.Js5Index;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("runetek4.client!v")
public abstract class Js5ResourceProvider {

	@OriginalMember(owner = "runetek4.client!v", name = "<init>", descriptor = "()V")
	protected Js5ResourceProvider() {
	}

	@OriginalMember(owner = "runetek4.client!v", name = "b", descriptor = "(I)Lclient!ii;")
	public abstract Js5Index fetchIndex();

	@OriginalMember(owner = "runetek4.client!v", name = "a", descriptor = "(II)V")
	public abstract void method522(@OriginalArg(0) int arg0);

	@OriginalMember(owner = "runetek4.client!v", name = "b", descriptor = "(II)I")
	public abstract int getPercentageComplete(@OriginalArg(0) int group);

	@OriginalMember(owner = "runetek4.client!v", name = "c", descriptor = "(II)[B")
	public abstract byte[] method525(@OriginalArg(0) int arg0);
}
