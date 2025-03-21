package com.jagex.runetek4;

import com.jagex.runetek4.cache.CacheArchive;
import com.jagex.runetek4.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!ag")
public final class TextureOp1 extends TextureOp {

	@OriginalMember(owner = "runetek4.client!ag", name = "S", descriptor = "I")
	private int anInt100 = 0;

	@OriginalMember(owner = "runetek4.client!ag", name = "X", descriptor = "I")
	private int anInt105 = 0;

	@OriginalMember(owner = "runetek4.client!ag", name = "W", descriptor = "I")
	private int anInt104 = 1;

	@OriginalMember(owner = "runetek4.client!ag", name = "<init>", descriptor = "()V")
	public TextureOp1() {
		super(0, true);
	}

	@OriginalMember(owner = "runetek4.client!ag", name = "a", descriptor = "(IB)[I")
	@Override
	public final int[] method4626(@OriginalArg(0) int arg0) {
		@Pc(11) int[] local11 = this.aClass121_41.get(arg0);
		if (this.aClass121_41.invalid) {
			@Pc(20) int local20 = Texture.heightFractions[arg0];
			@Pc(26) int local26 = local20 - 2048 >> 1;
			for (@Pc(28) int local28 = 0; local28 < Texture.width; local28++) {
				@Pc(35) int local35 = Texture.widthFractions[local28];
				@Pc(41) int local41 = local35 - 2048 >> 1;
				@Pc(68) int local68;
				if (this.anInt105 == 0) {
					local68 = (local35 - local20) * this.anInt104;
				} else {
					@Pc(58) int local58 = local41 * local41 + local26 * local26 >> 12;
					local68 = (int) (Math.sqrt((double) ((float) local58 / 4096.0F)) * 4096.0D);
					local68 = (int) ((double) (local68 * this.anInt104) * 3.141592653589793D);
				}
				local68 -= local68 & 0xFFFFF000;
				if (this.anInt100 == 0) {
					local68 = Static119.anIntArray282[local68 >> 4 & 0xFF] + 4096 >> 1;
				} else if (this.anInt100 == 2) {
					local68 -= 2048;
					if (local68 < 0) {
						local68 = -local68;
					}
					local68 = 2048 - local68 << 1;
				}
				local11[local28] = local68;
			}
		}
		return local11;
	}

	@OriginalMember(owner = "runetek4.client!ag", name = "e", descriptor = "(I)V")
	@Override
	public final void postDecode() {
		CacheArchive.method185();
	}

	@OriginalMember(owner = "runetek4.client!ag", name = "a", descriptor = "(ILclient!wa;Z)V")
	@Override
	public final void decode(@OriginalArg(1) Packet packet, @OriginalArg(0) int code) {
		if (code == 0) {
			this.anInt105 = packet.g1();
		} else if (code == 1) {
			this.anInt100 = packet.g1();
		} else if (code == 3) {
			this.anInt104 = packet.g1();
		}
	}
}
