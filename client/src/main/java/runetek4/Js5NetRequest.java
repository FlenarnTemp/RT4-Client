package runetek4;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import runetek4.core.io.Packet;

@OriginalClass("runetek4.client!pm")
public final class Js5NetRequest extends Js5Request {

	@OriginalMember(owner = "runetek4.client!pm", name = "U", descriptor = "B")
	public byte aByte16;

	@OriginalMember(owner = "runetek4.client!pm", name = "Z", descriptor = "I")
	public int anInt4617;

	@OriginalMember(owner = "runetek4.client!pm", name = "bb", descriptor = "Lclient!wa;")
	public Packet aClass3_Sub15_7;

	@OriginalMember(owner = "runetek4.client!pm", name = "a", descriptor = "(Z)I")
	@Override
	public final int method3553() {
		return this.aClass3_Sub15_7 == null ? 0 : this.aClass3_Sub15_7.offset * 100 / (this.aClass3_Sub15_7.data.length - this.aByte16);
	}

	@OriginalMember(owner = "runetek4.client!pm", name = "b", descriptor = "(Z)[B")
	@Override
	public final byte[] method3554() {
		if (this.aBoolean226 || this.aClass3_Sub15_7.offset < this.aClass3_Sub15_7.data.length - this.aByte16) {
			throw new RuntimeException();
		}
		return this.aClass3_Sub15_7.data;
	}
}
