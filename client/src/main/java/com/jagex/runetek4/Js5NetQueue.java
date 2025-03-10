package com.jagex.runetek4;

import java.io.IOException;

import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.js5.network.Js5NetRequest;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!jb")
public final class Js5NetQueue {

	@OriginalMember(owner = "runetek4.client!jb", name = "A", descriptor = "J")
	private long aLong104;

	@OriginalMember(owner = "runetek4.client!jb", name = "B", descriptor = "Lclient!ma;")
	private BufferedSocket aClass95_1;

	@OriginalMember(owner = "runetek4.client!jb", name = "C", descriptor = "I")
	private int anInt2962;

	@OriginalMember(owner = "runetek4.client!jb", name = "J", descriptor = "Lclient!pm;")
	private Js5NetRequest aClass3_Sub2_Sub5_Sub2_2;

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "Lclient!ce;")
	private final SecondaryLinkedList urgent = new SecondaryLinkedList();

	@OriginalMember(owner = "runetek4.client!jb", name = "q", descriptor = "Lclient!ce;")
	private final SecondaryLinkedList aClass16_3 = new SecondaryLinkedList();

	@OriginalMember(owner = "runetek4.client!jb", name = "v", descriptor = "Lclient!ce;")
	private final SecondaryLinkedList prefetch = new SecondaryLinkedList();

	@OriginalMember(owner = "runetek4.client!jb", name = "z", descriptor = "Lclient!ce;")
	private final SecondaryLinkedList aClass16_5 = new SecondaryLinkedList();

	@OriginalMember(owner = "runetek4.client!jb", name = "E", descriptor = "Lclient!wa;")
	private final Packet aClass3_Sub15_4 = new Packet(4);

	@OriginalMember(owner = "runetek4.client!jb", name = "G", descriptor = "B")
	private byte xorcode = 0;

	@OriginalMember(owner = "runetek4.client!jb", name = "I", descriptor = "I")
	public volatile int errors = 0;

	@OriginalMember(owner = "runetek4.client!jb", name = "H", descriptor = "I")
	public volatile int response = 0;

	@OriginalMember(owner = "runetek4.client!jb", name = "F", descriptor = "Lclient!wa;")
	private final Packet aClass3_Sub15_5 = new Packet(8);

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "(I)Z")
	public final boolean method2316() {
		return this.method2321() >= 20;
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "b", descriptor = "(B)Z")
	public final boolean loop() {
		@Pc(19) int local19;
		if (this.aClass95_1 != null) {
			@Pc(12) long local12 = MonotonicTime.get();
			local19 = (int) (local12 - this.aLong104);
			this.aLong104 = local12;
			if (local19 > 200) {
				local19 = 200;
			}
			this.anInt2962 += local19;
			if (this.anInt2962 > 30000) {
				try {
					this.aClass95_1.closeGracefully();
				} catch (@Pc(43) Exception local43) {
				}
				this.aClass95_1 = null;
			}
		}
		if (this.aClass95_1 == null) {
			return this.getTotalUrgents() == 0 && this.method2321() == 0;
		}
		try {
			this.aClass95_1.method2832();
			@Pc(75) Js5NetRequest local75;
			for (local75 = (Js5NetRequest) this.urgent.method795(); local75 != null; local75 = (Js5NetRequest) this.urgent.prev()) {
				this.aClass3_Sub15_4.pos = 0;
				this.aClass3_Sub15_4.p1b(1);
				this.aClass3_Sub15_4.p3((int) local75.secondaryNodeId);
				this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
				this.aClass16_3.pushBack(local75);
			}
			for (local75 = (Js5NetRequest) this.prefetch.method795(); local75 != null; local75 = (Js5NetRequest) this.prefetch.prev()) {
				this.aClass3_Sub15_4.pos = 0;
				this.aClass3_Sub15_4.p1b(0);
				this.aClass3_Sub15_4.p3((int) local75.secondaryNodeId);
				this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
				this.aClass16_5.pushBack(local75);
			}
			for (@Pc(172) int local172 = 0; local172 < 100; local172++) {
				local19 = this.aClass95_1.available();
				if (local19 < 0) {
					throw new IOException();
				}
				if (local19 == 0) {
					break;
				}
				this.anInt2962 = 0;
				@Pc(196) byte local196 = 0;
				if (this.aClass3_Sub2_Sub5_Sub2_2 == null) {
					local196 = 8;
				} else if (this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 == 0) {
					local196 = 1;
				}
				@Pc(228) int local228;
				@Pc(235) int local235;
				@Pc(283) int local283;
				if (local196 <= 0) {
					local228 = this.aClass3_Sub2_Sub5_Sub2_2.packet.data.length - this.aClass3_Sub2_Sub5_Sub2_2.offset;
					local235 = 512 - this.aClass3_Sub2_Sub5_Sub2_2.anInt4617;
					if (local235 > local228 - this.aClass3_Sub2_Sub5_Sub2_2.packet.pos) {
						local235 = local228 - this.aClass3_Sub2_Sub5_Sub2_2.packet.pos;
					}
					if (local235 > local19) {
						local235 = local19;
					}
					this.aClass95_1.read(this.aClass3_Sub2_Sub5_Sub2_2.packet.pos, local235, this.aClass3_Sub2_Sub5_Sub2_2.packet.data);
					if (this.xorcode != 0) {
						for (local283 = 0; local283 < local235; local283++) {
							this.aClass3_Sub2_Sub5_Sub2_2.packet.data[this.aClass3_Sub2_Sub5_Sub2_2.packet.pos + local283] = (byte) (this.aClass3_Sub2_Sub5_Sub2_2.packet.data[this.aClass3_Sub2_Sub5_Sub2_2.packet.pos + local283] ^ this.xorcode);
						}
					}
					this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 += local235;
					this.aClass3_Sub2_Sub5_Sub2_2.packet.pos += local235;
					if (this.aClass3_Sub2_Sub5_Sub2_2.packet.pos == local228) {
						this.aClass3_Sub2_Sub5_Sub2_2.secondaryRemove();
						this.aClass3_Sub2_Sub5_Sub2_2.awaitingResponse = false;
						this.aClass3_Sub2_Sub5_Sub2_2 = null;
					} else if (this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 == 512) {
						this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 = 0;
					}
				} else {
					local228 = local196 - this.aClass3_Sub15_5.pos;
					if (local19 < local228) {
						local228 = local19;
					}
					this.aClass95_1.read(this.aClass3_Sub15_5.pos, local228, this.aClass3_Sub15_5.data);
					if (this.xorcode != 0) {
						for (local235 = 0; local235 < local228; local235++) {
							this.aClass3_Sub15_5.data[local235 + this.aClass3_Sub15_5.pos] ^= this.xorcode;
						}
					}
					this.aClass3_Sub15_5.pos += local228;
					if (this.aClass3_Sub15_5.pos >= local196) {
						if (this.aClass3_Sub2_Sub5_Sub2_2 == null) {
							this.aClass3_Sub15_5.pos = 0;
							local235 = this.aClass3_Sub15_5.g1();
							local283 = this.aClass3_Sub15_5.g2();
							@Pc(471) int local471 = this.aClass3_Sub15_5.g1();
							@Pc(476) int local476 = this.aClass3_Sub15_5.g4();
							@Pc(480) int local480 = local471 & 0x7F;
							@Pc(491) boolean local491 = (local471 & 0x80) != 0;
							@Pc(501) long local501 = (long) ((local235 << 16) + local283);
							@Pc(509) Js5NetRequest local509;
							if (local491) {
								for (local509 = (Js5NetRequest) this.aClass16_5.method795(); local509 != null && local509.secondaryNodeId != local501; local509 = (Js5NetRequest) this.aClass16_5.prev()) {
								}
							} else {
								for (local509 = (Js5NetRequest) this.aClass16_3.method795(); local509 != null && local501 != local509.secondaryNodeId; local509 = (Js5NetRequest) this.aClass16_3.prev()) {
								}
							}
							if (local509 == null) {
								throw new IOException();
							}
							@Pc(568) int local568 = local480 == 0 ? 5 : 9;
							this.aClass3_Sub2_Sub5_Sub2_2 = local509;
							this.aClass3_Sub2_Sub5_Sub2_2.packet = new Packet(local476 + local568 + this.aClass3_Sub2_Sub5_Sub2_2.offset);
							this.aClass3_Sub2_Sub5_Sub2_2.packet.p1b(local480);
							this.aClass3_Sub2_Sub5_Sub2_2.packet.p4(local476);
							this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 = 8;
							this.aClass3_Sub15_5.pos = 0;
						} else if (this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 != 0) {
							throw new IOException();
						} else if (this.aClass3_Sub15_5.data[0] == -1) {
							this.aClass3_Sub2_Sub5_Sub2_2.anInt4617 = 1;
							this.aClass3_Sub15_5.pos = 0;
						} else {
							this.aClass3_Sub2_Sub5_Sub2_2 = null;
						}
					}
				}
			}
			return true;
		} catch (@Pc(644) IOException local644) {
			try {
				this.aClass95_1.closeGracefully();
			} catch (@Pc(650) Exception local650) {
			}
			this.response = -2;
			this.errors++;
			this.aClass95_1 = null;
			return this.getTotalUrgents() == 0 && this.method2321() == 0;
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "(Z)V")
	public final void serverDrop() {
		if (this.aClass95_1 == null) {
			return;
		}
		try {
			this.aClass3_Sub15_4.pos = 0;
			this.aClass3_Sub15_4.p1b(7);
			this.aClass3_Sub15_4.p3(0);
			this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
		} catch (@Pc(39) IOException local39) {
			try {
				this.aClass95_1.closeGracefully();
			} catch (@Pc(45) Exception local45) {
			}
			this.errors++;
			this.response = -2;
			this.aClass95_1 = null;
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "b", descriptor = "(I)I")
	private int method2321() {
		return this.prefetch.length() + this.aClass16_5.length();
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "(ZZ)V")
	public final void method2322(@OriginalArg(0) boolean arg0) {
		if (this.aClass95_1 == null) {
			return;
		}
		try {
			this.aClass3_Sub15_4.pos = 0;
			this.aClass3_Sub15_4.p1b(arg0 ? 2 : 3);
			this.aClass3_Sub15_4.p3(0);
			this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
		} catch (@Pc(42) IOException local42) {
			try {
				this.aClass95_1.closeGracefully();
			} catch (@Pc(48) Exception local48) {
			}
			this.errors++;
			this.response = -2;
			this.aClass95_1 = null;
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "c", descriptor = "(I)V")
	public final void method2323() {
		if (this.aClass95_1 != null) {
			this.aClass95_1.method2833();
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "(ZLclient!ma;I)V")
	public final void loggedOut(@OriginalArg(0) boolean arg0, @OriginalArg(1) BufferedSocket arg1) {
		if (this.aClass95_1 != null) {
			try {
				this.aClass95_1.closeGracefully();
			} catch (@Pc(14) Exception local14) {
			}
			this.aClass95_1 = null;
		}
		this.aClass95_1 = arg1;
		this.method2331();
		this.method2322(arg0);
		this.aClass3_Sub15_5.pos = 0;
		this.aClass3_Sub2_Sub5_Sub2_2 = null;
		while (true) {
			@Pc(44) Js5NetRequest local44 = (Js5NetRequest) this.aClass16_3.pollFront();
			if (local44 == null) {
				while (true) {
					local44 = (Js5NetRequest) this.aClass16_5.pollFront();
					if (local44 == null) {
						if (this.xorcode != 0) {
							try {
								this.aClass3_Sub15_4.pos = 0;
								this.aClass3_Sub15_4.p1b(4);
								this.aClass3_Sub15_4.p1b(this.xorcode);
								this.aClass3_Sub15_4.p2(0);
								this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
							} catch (@Pc(107) IOException local107) {
								try {
									this.aClass95_1.closeGracefully();
								} catch (@Pc(113) Exception local113) {
								}
								this.response = -2;
								this.errors++;
								this.aClass95_1 = null;
							}
						}
						this.anInt2962 = 0;
						this.aLong104 = MonotonicTime.get();
						return;
					}
					this.prefetch.pushBack(local44);
				}
			}
			this.urgent.pushBack(local44);
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "c", descriptor = "(B)Z")
	public boolean isUrgentsFull() {
		return this.getTotalUrgents() >= 20;
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "d", descriptor = "(B)V")
	public void method2327() {
		try {
			this.aClass95_1.closeGracefully();
		} catch (@Pc(17) Exception local17) {
		}
		this.response = -1;
		this.xorcode = (byte) (Math.random() * 255.0D + 1.0D);
		this.aClass95_1 = null;
		this.errors++;
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "d", descriptor = "(I)I")
	public final int getTotalUrgents() {
		return this.urgent.length() + this.aClass16_3.length();
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "b", descriptor = "(Z)V")
	public final void clientDrop() {
		if (this.aClass95_1 != null) {
			this.aClass95_1.closeGracefully();
		}
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "a", descriptor = "(IIBIZ)Lclient!pm;")
	public final Js5NetRequest method2330(@OriginalArg(1) int arg0, @OriginalArg(2) byte arg1, @OriginalArg(3) int arg2, @OriginalArg(4) boolean arg3) {
		@Pc(7) Js5NetRequest local7 = new Js5NetRequest();
		@Pc(14) long local14 = (long) (arg2 + (arg0 << 16));
		local7.urgent = arg3;
		local7.secondaryNodeId = local14;
		local7.offset = arg1;
		if (arg3) {
			if (this.getTotalUrgents() >= 20) {
				throw new RuntimeException();
			}
			this.urgent.pushBack(local7);
		} else if (this.method2321() < 20) {
			this.prefetch.pushBack(local7);
		} else {
			throw new RuntimeException();
		}
		return local7;
	}

	@OriginalMember(owner = "runetek4.client!jb", name = "e", descriptor = "(B)V")
	private void method2331() {
		if (this.aClass95_1 == null) {
			return;
		}
		try {
			this.aClass3_Sub15_4.pos = 0;
			this.aClass3_Sub15_4.p1b(6);
			this.aClass3_Sub15_4.p3(3);
			this.aClass95_1.write(this.aClass3_Sub15_4.data, 4);
		} catch (@Pc(37) IOException local37) {
			try {
				this.aClass95_1.closeGracefully();
			} catch (@Pc(43) Exception local43) {
			}
			this.errors++;
			this.aClass95_1 = null;
			this.response = -2;
		}
	}
}
