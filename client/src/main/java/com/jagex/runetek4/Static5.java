package com.jagex.runetek4;

import com.jagex.runetek4.media.renderable.Entity;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static5 {

	@OriginalMember(owner = "runetek4.client!af", name = "a", descriptor = "Lclient!ve;")
	public static Js5 aClass153_1;

	@OriginalMember(owner = "runetek4.client!af", name = "g", descriptor = "Lclient!na;")
	public static final JString HINT_MAPEDGE = JString.parse("hint_mapedge");

	@OriginalMember(owner = "runetek4.client!af", name = "l", descriptor = "[S")
	public static final short[] aShortArray2 = new short[] { 30, 6, 31, 29, 10, 44, 37, 57 };

	@OriginalMember(owner = "runetek4.client!af", name = "m", descriptor = "Lclient!na;")
	public static final JString aClass100_10 = JString.parse("<br>");

	@OriginalMember(owner = "runetek4.client!af", name = "a", descriptor = "(ILjava/lang/String;)V")
	public static void method31(@OriginalArg(1) String arg0) {
		System.out.println("Error: " + Static40.method1014("%0a", "\n", arg0));
	}

	@OriginalMember(owner = "runetek4.client!af", name = "b", descriptor = "(B)V")
	public static void method34() {
		WorldMap.clear(false);
		System.gc();
		client.processGameStatus(25);
	}

	@OriginalMember(owner = "runetek4.client!af", name = "a", descriptor = "(IIIIIILclient!th;IJ)Z")
	public static boolean method35(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6, @OriginalArg(8) long arg7) {
		if (arg6 == null) {
			return true;
		} else {
			@Pc(11) int local11 = arg1 * 128 + arg4 * 64;
			@Pc(19) int local19 = arg2 * 128 + arg5 * 64;
			return Static105.addLoc(arg0, arg1, arg2, arg4, arg5, local11, local19, arg3, arg6, 0, false, arg7);
		}
	}
}
