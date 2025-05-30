package com.jagex.runetek4;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!ti")
public final class BufferedImageFrameBuffer extends FrameBuffer {

	@OriginalMember(owner = "runetek4.client!ti", name = "p", descriptor = "Ljava/awt/runetek4.Component;")
	private Component component;

	@OriginalMember(owner = "runetek4.client!ti", name = "a", descriptor = "(IILjava/awt/Graphics;I)V")
	@Override
	public final void draw(@OriginalArg(2) Graphics graphics) {
		graphics.drawImage(this.image, 0, 0, this.component);
	}

	@OriginalMember(owner = "runetek4.client!ti", name = "a", descriptor = "(IZILjava/awt/runetek4.Component;)V")
	@Override
	public final void init(@OriginalArg(0) int height, @OriginalArg(2) int width, @OriginalArg(3) Component component) {
		this.pixels = new int[width * height + 1];
		this.height = height;
		this.width = width;
		@Pc(22) DataBufferInt buffer = new DataBufferInt(this.pixels, this.pixels.length);
		@Pc(30) DirectColorModel model = new DirectColorModel(32, 16711680, 65280, 255);
		@Pc(40) WritableRaster raster = Raster.createWritableRaster(model.createCompatibleSampleModel(this.width, this.height), buffer, null);
		this.image = new BufferedImage(model, raster, false, new Hashtable());
		this.component = component;
		this.makeTarget();
	}

	@OriginalMember(owner = "runetek4.client!ti", name = "a", descriptor = "(IIIILjava/awt/Graphics;I)V")
	@Override
	public final void drawAt(@OriginalArg(0) int width, @OriginalArg(1) int x, @OriginalArg(3) int height, @OriginalArg(4) Graphics graphics, @OriginalArg(5) int y) {
		@Pc(2) Shape clip = graphics.getClip();
		graphics.clipRect(x, y, width, height);
		graphics.drawImage(this.image, 0, 0, this.component);
		graphics.setClip(clip);
	}
}
