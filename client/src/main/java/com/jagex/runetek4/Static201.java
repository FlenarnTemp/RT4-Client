package com.jagex.runetek4;

import com.jagex.runetek4.cache.media.component.Component;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static201 {

	@OriginalMember(owner = "runetek4.client!qf", name = "S", descriptor = "I")
	public static int anInt1864;

	@OriginalMember(owner = "runetek4.client!qf", name = "M", descriptor = "I")
	public static int idleNetCycles = 0;

	@OriginalMember(owner = "runetek4.client!qf", name = "N", descriptor = "Lclient!na;")
	public static final JString CARDMEM = Static28.parse("::cardmem");

	@OriginalMember(owner = "runetek4.client!qf", name = "Q", descriptor = "Lclient!na;")
	public static final JString aClass100_407 = Static28.parse(" )2> <col=ffff00>");

	@OriginalMember(owner = "runetek4.client!qf", name = "R", descriptor = "Lclient!na;")
	public static final JString aClass100_408 = Static28.parse(" )2> ");

	@OriginalMember(owner = "runetek4.client!qf", name = "X", descriptor = "Lclient!be;")
	public static Component aClass13_13 = null;

	@OriginalMember(owner = "runetek4.client!qf", name = "a", descriptor = "(BII)Lclient!be;")
	public static Component method1418(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(7) Component local7 = Component.getComponent(arg0);
		if (arg1 == -1) {
			return local7;
		} else if (local7 == null || local7.createdComponents == null || local7.createdComponents.length <= arg1) {
			return null;
		} else {
			return local7.createdComponents[arg1];
		}
	}
}
