package com.jagex.runetek4;

import com.jagex.runetek4.core.datastruct.IterableMap;
import com.jagex.runetek4.core.datastruct.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!gn")
public final class LruHashTable {

	@OriginalMember(owner = "runetek4.client!gn", name = "l", descriptor = "Lclient!rg;")
	private SecondaryNode aClass3_Sub2_37 = new SecondaryNode();

	@OriginalMember(owner = "runetek4.client!gn", name = "s", descriptor = "Lclient!ce;")
	private final SecondaryLinkedList aClass16_1 = new SecondaryLinkedList();

	@OriginalMember(owner = "runetek4.client!gn", name = "u", descriptor = "I")
	private int anInt2314;

	@OriginalMember(owner = "runetek4.client!gn", name = "r", descriptor = "I")
	private final int anInt2313;

	@OriginalMember(owner = "runetek4.client!gn", name = "q", descriptor = "Lclient!sc;")
	private final IterableMap aClass133_5;

	@OriginalMember(owner = "runetek4.client!gn", name = "<init>", descriptor = "(I)V")
	public LruHashTable(@OriginalArg(0) int arg0) {
		@Pc(13) int local13 = 1;
		this.anInt2314 = arg0;
		while (arg0 > local13 + local13) {
			local13 += local13;
		}
		this.anInt2313 = arg0;
		this.aClass133_5 = new IterableMap(local13);
	}

	@OriginalMember(owner = "runetek4.client!gn", name = "a", descriptor = "(JI)Lclient!rg;")
	public final SecondaryNode method1806(@OriginalArg(0) long arg0) {
		@Pc(16) SecondaryNode local16 = (SecondaryNode) this.aClass133_5.getNode(arg0);
		if (local16 != null) {
			this.aClass16_1.method798(local16);
		}
		return local16;
	}

	@OriginalMember(owner = "runetek4.client!gn", name = "a", descriptor = "(I)Lclient!ab;")
	public final Node method1808() {
		return this.aClass133_5.peekFront();
	}

	@OriginalMember(owner = "runetek4.client!gn", name = "a", descriptor = "(Lclient!rg;JB)V")
	public final void method1811(@OriginalArg(0) SecondaryNode arg0, @OriginalArg(1) long arg1) {
		if (this.anInt2314 == 0) {
			@Pc(14) SecondaryNode local14 = this.aClass16_1.method796();
			local14.remove();
			local14.method4365();
			if (this.aClass3_Sub2_37 == local14) {
				local14 = this.aClass16_1.method796();
				local14.remove();
				local14.method4365();
			}
		} else {
			this.anInt2314--;
		}
		this.aClass133_5.pushNode(arg0, arg1);
		this.aClass16_1.method798(arg0);
	}

	@OriginalMember(owner = "runetek4.client!gn", name = "b", descriptor = "(I)Lclient!ab;")
	public final Node method1813() {
		return this.aClass133_5.prev();
	}

	@OriginalMember(owner = "runetek4.client!gn", name = "c", descriptor = "(I)V")
	public final void method1815() {
		this.aClass16_1.method802();
		this.aClass133_5.removeAll();
		this.aClass3_Sub2_37 = new SecondaryNode();
		this.anInt2314 = this.anInt2313;
	}
}
