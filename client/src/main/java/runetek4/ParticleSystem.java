package runetek4;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import runetek4.core.io.Packet;

@OriginalClass("runetek4.client!ga")
public final class ParticleSystem extends ParticleNode {

	static {
		new SecondaryHashTable(8);
		new Packet(131056);
	}

	@OriginalMember(owner = "runetek4.client!ga", name = "d", descriptor = "()V")
	public final void method1646() {
	}
}
