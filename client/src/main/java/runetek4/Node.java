package runetek4;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("runetek4.client!ab")
public class Node {

	@OriginalMember(owner = "runetek4.client!ab", name = "a", descriptor = "J")
	public long aLong192;

	@OriginalMember(owner = "runetek4.client!ab", name = "d", descriptor = "Lclient!ab;")
	public Node aClass3_222;

	@OriginalMember(owner = "runetek4.client!ab", name = "l", descriptor = "Lclient!ab;")
	public Node aClass3_223;

	@OriginalMember(owner = "runetek4.client!ab", name = "a", descriptor = "(I)Z")
	public final boolean method4654() {
		return this.aClass3_223 != null;
	}

	@OriginalMember(owner = "runetek4.client!ab", name = "b", descriptor = "(I)V")
	public final void method4658() {
		if (this.aClass3_223 != null) {
			this.aClass3_223.aClass3_222 = this.aClass3_222;
			this.aClass3_222.aClass3_223 = this.aClass3_223;
			this.aClass3_223 = null;
			this.aClass3_222 = null;
		}
	}
}