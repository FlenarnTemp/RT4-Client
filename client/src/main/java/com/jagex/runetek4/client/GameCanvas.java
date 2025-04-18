package com.jagex.runetek4.client;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tm")
public final class GameCanvas extends Canvas {

	@OriginalMember(owner = "client!tm", name = "m", descriptor = "Ljava/awt/Component;")
	private final Component component;

	@OriginalMember(owner = "client!tm", name = "<init>", descriptor = "(Ljava/awt/Component;)V")
	public GameCanvas(@OriginalArg(0) Component component) {
		this.component = component;
	}

	@OriginalMember(owner = "client!tm", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics graphics) {
		this.component.update(graphics);
	}

	@OriginalMember(owner = "client!tm", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		this.component.paint(arg0);
	}
}
