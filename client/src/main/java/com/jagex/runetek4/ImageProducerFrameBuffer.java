package com.jagex.runetek4;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("runetek4.client!di")
public final class ImageProducerFrameBuffer extends FrameBuffer implements ImageProducer, ImageObserver {

	@OriginalMember(owner = "runetek4.client!di", name = "A", descriptor = "Ljava/awt/image/ImageConsumer;")
	private ImageConsumer imageConsumer;

	@OriginalMember(owner = "runetek4.client!di", name = "B", descriptor = "Ljava/awt/image/ColorModel;")
	private ColorModel colorModel;

	@OriginalMember(owner = "runetek4.client!di", name = "addConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public final synchronized void addConsumer(@OriginalArg(0) ImageConsumer consumer) {
		this.imageConsumer = consumer;
		consumer.setDimensions(this.width, this.height);
		consumer.setProperties(null);
		consumer.setColorModel(this.colorModel);
		consumer.setHints(14);
	}

	@OriginalMember(owner = "runetek4.client!di", name = "a", descriptor = "(IIIBI)V")
	private synchronized void method1168(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
		if (this.imageConsumer != null) {
			this.imageConsumer.setPixels(arg2, arg3, arg0, arg1, this.colorModel, this.pixels, arg3 * this.width + arg2, this.width);
			this.imageConsumer.imageComplete(2);
		}
	}

	@OriginalMember(owner = "runetek4.client!di", name = "removeConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public final synchronized void removeConsumer(@OriginalArg(0) ImageConsumer consumer) {
		if (this.imageConsumer == consumer) {
			this.imageConsumer = null;
		}
	}

	@OriginalMember(owner = "runetek4.client!di", name = "a", descriptor = "(IIIILjava/awt/Graphics;I)V")
	@Override
	public final void drawAt(@OriginalArg(0) int width, @OriginalArg(1) int x, @OriginalArg(3) int height, @OriginalArg(4) Graphics graphics, @OriginalArg(5) int y) {
		this.method1168(width, height, x, y);
		@Pc(17) Shape shape = graphics.getClip();
		graphics.clipRect(x, y, width, height);
		graphics.drawImage(this.image, 0, 0, this);
		graphics.setClip(shape);
	}

	@OriginalMember(owner = "runetek4.client!di", name = "startProduction", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public final void startProduction(@OriginalArg(0) ImageConsumer consumer) {
		this.addConsumer(consumer);
	}

	@OriginalMember(owner = "runetek4.client!di", name = "c", descriptor = "(I)V")
	private synchronized void setPixels() {
		if (this.imageConsumer != null) {
			this.imageConsumer.setPixels(0, 0, this.width, this.height, this.colorModel, this.pixels, 0, this.width);
			this.imageConsumer.imageComplete(2);
		}
	}

	@OriginalMember(owner = "runetek4.client!di", name = "isConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)Z")
	@Override
	public final synchronized boolean isConsumer(@OriginalArg(0) ImageConsumer consumer) {
		return this.imageConsumer == consumer;
	}

	@OriginalMember(owner = "runetek4.client!di", name = "a", descriptor = "(IILjava/awt/Graphics;I)V")
	@Override
	public final void draw(@OriginalArg(2) Graphics graphics) {
		this.setPixels();
		graphics.drawImage(this.image, 0, 0, this);
	}

	@OriginalMember(owner = "runetek4.client!di", name = "a", descriptor = "(IZILjava/awt/runetek4.Component;)V")
	@Override
	public final void init(@OriginalArg(0) int height, @OriginalArg(2) int width, @OriginalArg(3) Component component) {
		this.height = height;
		this.pixels = new int[width * height + 1];
		this.width = width;
		this.colorModel = new DirectColorModel(32, 16711680, 65280, 255);
		this.image = component.createImage(this);
		this.setPixels();
		component.prepareImage(this.image, this);
		this.setPixels();
		component.prepareImage(this.image, this);
		this.setPixels();
		component.prepareImage(this.image, this);
		this.makeTarget();
	}

	@OriginalMember(owner = "runetek4.client!di", name = "imageUpdate", descriptor = "(Ljava/awt/Image;IIIII)Z")
	@Override
	public final boolean imageUpdate(@OriginalArg(0) Image image, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		return true;
	}

	@OriginalMember(owner = "runetek4.client!di", name = "requestTopDownLeftRightResend", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public final void requestTopDownLeftRightResend(@OriginalArg(0) ImageConsumer consumer) {
	}
}
