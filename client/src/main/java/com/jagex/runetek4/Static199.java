package com.jagex.runetek4;

import com.jagex.runetek4.core.datastruct.HashTable;
import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.config.FloType;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static199 {

	@OriginalMember(owner = "runetek4.client!qc", name = "cb", descriptor = "I")
	public static int anInt4675;

	@OriginalMember(owner = "runetek4.client!qc", name = "K", descriptor = "Lclient!sc;")
	public static HashTable aClass133_20 = new HashTable(16);

	@OriginalMember(owner = "runetek4.client!qc", name = "ab", descriptor = "[I")
	public static final int[] anIntArray417 = new int[1000];

	@OriginalMember(owner = "runetek4.client!qc", name = "a", descriptor = "(ZI)Lclient!ni;")
	public static FloType method3593(@OriginalArg(1) int arg0) {
		@Pc(10) FloType local10 = (FloType) Static83.aClass99_3.get((long) arg0);
		if (local10 != null) {
			return local10;
		}
		@Pc(27) byte[] local27 = Static182.aClass153_77.getfile(1, arg0);
		local10 = new FloType();
		if (local27 != null) {
			local10.decode(new Packet(local27));
		}
		Static83.aClass99_3.put(local10, (long) arg0);
		return local10;
	}

	@OriginalMember(owner = "runetek4.client!qc", name = "a", descriptor = "(BI)I")
	public static int method3594(@OriginalArg(1) int arg0) {
		return arg0 >> 11 & 0x7F;
	}

	@OriginalMember(owner = "runetek4.client!qc", name = "a", descriptor = "(ZLclient!ve;)V")
	public static void init(@OriginalArg(1) Js5 arg0) {
		Static35.aClass153_22 = arg0;
		Static98.anInt2510 = Static35.aClass153_22.getGroupCapacity(4);
	}
}
