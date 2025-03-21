package com.jagex.runetek4.input;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.jagex.runetek4.*;
import com.jagex.runetek4.util.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!uf")
public final class Keyboard implements KeyListener, FocusListener {

	public static final int KEY_SHIFT = 81;
	public static final int KEY_CTRL = 82;
	public static final int KEY_ENTER = 84;
	public static final int KEY_BACK_SPACE = 85;
	public static final int KEY_ALT = 86;
	public static final int KEY_LEFT = 96;
	public static final int KEY_RIGHT = 97;
	public static final int KEY_UP = 98;
	public static final int KEY_DOWN = 99;

	@OriginalMember(owner = "runetek4.client!pb", name = "q", descriptor = "[Z")
	public static final boolean[] pressedKeys = new boolean[112];

	@OriginalMember(owner = "client!bg", name = "A", descriptor = "[I")
	public static final int[] eventQueue = new int[128];

	@OriginalMember(owner = "runetek4.client!s", name = "e", descriptor = "[I")
	public static final int[] typedCodeQueue = new int[128];

	@OriginalMember(owner = "runetek4.client!vh", name = "u", descriptor = "[I")
	public static final int[] typedCharQueue = new int[128];
	@OriginalMember(owner = "runetek4.client!pl", name = "c", descriptor = "[I")
	public static final int[] CODE_MAP = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	@OriginalMember(owner = "runetek4.client!hn", name = "Z", descriptor = "I")
	public static int keyCode;

	@OriginalMember(owner = "runetek4.client!j", name = "L", descriptor = "I")
	public static int eventQueueWriterIndex = 0;

	@OriginalMember(owner = "runetek4.client!sg", name = "c", descriptor = "I")
	public static int eventQueueReaderIndex = 0;

	@OriginalMember(owner = "client!ec", name = "q", descriptor = "I")
	public static int typedQueueWriterIndex = 0;

	@OriginalMember(owner = "runetek4.client!hn", name = "V", descriptor = "I")
	public static int typedQueueReaderIndex = 0;

	@OriginalMember(owner = "client!an", name = "ab", descriptor = "Lclient!uf;")
	public static Keyboard instance = new Keyboard();

	@OriginalMember(owner = "runetek4.client!si", name = "eb", descriptor = "I")
	public static volatile int idleLoops = 0;

	@OriginalMember(owner = "client!sh", name = "h", descriptor = "I")
	public static int prevTypedQueueWriterIndex = 0;

	@OriginalMember(owner = "runetek4.client!pi", name = "Y", descriptor = "I")
	public static int keyChar;

	static {
		Arrays.fill(MiniMenu.CODE_MAP, -1);
		MiniMenu.CODE_MAP[KeyEvent.VK_BACK_SPACE] = 85;
		MiniMenu.CODE_MAP[KeyEvent.VK_TAB] = 80;
		MiniMenu.CODE_MAP[KeyEvent.VK_ENTER] = 84;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_CLEAR] = 91;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_SHIFT] = 81;
		MiniMenu.CODE_MAP[KeyEvent.VK_CONTROL] = 82;
		MiniMenu.CODE_MAP[KeyEvent.VK_ALT] = 86;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_ESCAPE] = 13;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_SPACE] = 83;
		MiniMenu.CODE_MAP[KeyEvent.VK_PAGE_UP] = 104;
		MiniMenu.CODE_MAP[KeyEvent.VK_PAGE_DOWN] = 105;
		MiniMenu.CODE_MAP[KeyEvent.VK_END] = 103;
		MiniMenu.CODE_MAP[KeyEvent.VK_HOME] = 102;
		MiniMenu.CODE_MAP[KeyEvent.VK_LEFT] = 96;
		MiniMenu.CODE_MAP[KeyEvent.VK_UP] = 98;
		MiniMenu.CODE_MAP[KeyEvent.VK_RIGHT] = 97;
		MiniMenu.CODE_MAP[KeyEvent.VK_DOWN] = 99;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_0] = 25;
		MiniMenu.CODE_MAP[KeyEvent.VK_1] = 16;
		MiniMenu.CODE_MAP[KeyEvent.VK_2] = 17;
		MiniMenu.CODE_MAP[KeyEvent.VK_3] = 18;
		MiniMenu.CODE_MAP[KeyEvent.VK_4] = 19;
		MiniMenu.CODE_MAP[KeyEvent.VK_5] = 20;
		MiniMenu.CODE_MAP[KeyEvent.VK_6] = 21;
		MiniMenu.CODE_MAP[KeyEvent.VK_7] = 22;
		MiniMenu.CODE_MAP[KeyEvent.VK_8] = 23;
		MiniMenu.CODE_MAP[KeyEvent.VK_9] = 24;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_A] = 48;
		MiniMenu.CODE_MAP[KeyEvent.VK_B] = 68;
		MiniMenu.CODE_MAP[KeyEvent.VK_C] = 66;
		MiniMenu.CODE_MAP[KeyEvent.VK_D] = 50;
		MiniMenu.CODE_MAP[KeyEvent.VK_E] = 34;
		MiniMenu.CODE_MAP[KeyEvent.VK_F] = 51;
		MiniMenu.CODE_MAP[KeyEvent.VK_G] = 52;
		MiniMenu.CODE_MAP[KeyEvent.VK_H] = 53;
		MiniMenu.CODE_MAP[KeyEvent.VK_I] = 39;
		MiniMenu.CODE_MAP[KeyEvent.VK_J] = 54;
		MiniMenu.CODE_MAP[KeyEvent.VK_K] = 55;
		MiniMenu.CODE_MAP[KeyEvent.VK_L] = 56;
		MiniMenu.CODE_MAP[KeyEvent.VK_M] = 70;
		MiniMenu.CODE_MAP[KeyEvent.VK_N] = 69;
		MiniMenu.CODE_MAP[KeyEvent.VK_O] = 40;
		MiniMenu.CODE_MAP[KeyEvent.VK_P] = 41;
		MiniMenu.CODE_MAP[KeyEvent.VK_Q] = 32;
		MiniMenu.CODE_MAP[KeyEvent.VK_R] = 35;
		MiniMenu.CODE_MAP[KeyEvent.VK_S] = 49;
		MiniMenu.CODE_MAP[KeyEvent.VK_T] = 36;
		MiniMenu.CODE_MAP[KeyEvent.VK_U] = 38;
		MiniMenu.CODE_MAP[KeyEvent.VK_V] = 67;
		MiniMenu.CODE_MAP[KeyEvent.VK_W] = 33;
		MiniMenu.CODE_MAP[KeyEvent.VK_X] = 65;
		MiniMenu.CODE_MAP[KeyEvent.VK_Y] = 37;
		MiniMenu.CODE_MAP[KeyEvent.VK_Z] = 64;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD0] = 228;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD1] = 231;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD2] = 227;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD3] = 233;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD4] = 224;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD5] = 219;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD6] = 225;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD7] = 230;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD8] = 226;
		MiniMenu.CODE_MAP[KeyEvent.VK_NUMPAD9] = 232;
		MiniMenu.CODE_MAP[KeyEvent.VK_MULTIPLY] = 89;
		MiniMenu.CODE_MAP[KeyEvent.VK_ADD] = 87;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_SUBTRACT] = 88;
		MiniMenu.CODE_MAP[KeyEvent.VK_DECIMAL] = 229;
		MiniMenu.CODE_MAP[KeyEvent.VK_DIVIDE] = 90;
		MiniMenu.CODE_MAP[KeyEvent.VK_F1] = 1;
		MiniMenu.CODE_MAP[KeyEvent.VK_F2] = 2;
		MiniMenu.CODE_MAP[KeyEvent.VK_F3] = 3;
		MiniMenu.CODE_MAP[KeyEvent.VK_F4] = 4;
		MiniMenu.CODE_MAP[KeyEvent.VK_F5] = 5;
		MiniMenu.CODE_MAP[KeyEvent.VK_F6] = 6;
		MiniMenu.CODE_MAP[KeyEvent.VK_F7] = 7;
		MiniMenu.CODE_MAP[KeyEvent.VK_F8] = 8;
		MiniMenu.CODE_MAP[KeyEvent.VK_F9] = 9;
		MiniMenu.CODE_MAP[KeyEvent.VK_F10] = 10;
		MiniMenu.CODE_MAP[KeyEvent.VK_F11] = 11;
		MiniMenu.CODE_MAP[KeyEvent.VK_F12] = 12;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_DELETE] = 101;
		//
		MiniMenu.CODE_MAP[KeyEvent.VK_INSERT] = 100;
	}

	public static boolean getKey(int key) {
		return pressedKeys[MiniMenu.CODE_MAP[key]];
	}

	@OriginalMember(owner = "client!ch", name = "a", descriptor = "(Ljava/awt/Component;I)V")
	public static void stop(@OriginalArg(0) Component component) {
		component.removeKeyListener(instance);
		component.removeFocusListener(instance);
		eventQueueWriterIndex = -1;
	}

	@OriginalMember(owner = "client!ag", name = "h", descriptor = "(I)V")
    public static void quit() {
        if (instance != null) {
            @Pc(4) Keyboard local4 = instance;
            synchronized (instance) {
                instance = null;
            }
        }
    }

	@OriginalMember(owner = "client!mf", name = "e", descriptor = "(I)V")
	public static void init() {
		if (SignLink.javaVendor.toLowerCase().contains("microsoft")) {
			MiniMenu.CODE_MAP[187] = 27;
			MiniMenu.CODE_MAP[223] = 28;
			MiniMenu.CODE_MAP[221] = 43;
			MiniMenu.CODE_MAP[188] = 71;
			MiniMenu.CODE_MAP[222] = 59;
			MiniMenu.CODE_MAP[192] = 58;
			MiniMenu.CODE_MAP[191] = 73;
			MiniMenu.CODE_MAP[219] = 42;
			MiniMenu.CODE_MAP[190] = 72;
			MiniMenu.CODE_MAP[186] = 57;
			MiniMenu.CODE_MAP[220] = 74;
			MiniMenu.CODE_MAP[189] = 26;
			return;
		}

		if (SignLink.setFocusTraversalKeysEnabled == null) {
			MiniMenu.CODE_MAP[KeyEvent.VK_BACK_QUOTE] = 58;
			MiniMenu.CODE_MAP[KeyEvent.VK_QUOTE] = 59;
		} else {
			MiniMenu.CODE_MAP[KeyEvent.VK_QUOTE] = 58;
			MiniMenu.CODE_MAP[KeyEvent.VK_BACK_QUOTE] = 28;
			MiniMenu.CODE_MAP[520] = 59;
		}

		MiniMenu.CODE_MAP[KeyEvent.VK_MINUS] = 26;
		MiniMenu.CODE_MAP[KeyEvent.VK_EQUALS] = 27;
		MiniMenu.CODE_MAP[KeyEvent.VK_OPEN_BRACKET] = 42;
		MiniMenu.CODE_MAP[KeyEvent.VK_SEMICOLON] = 57;
		MiniMenu.CODE_MAP[KeyEvent.VK_CLOSE_BRACKET] = 43;
		MiniMenu.CODE_MAP[KeyEvent.VK_COMMA] = 71;
		MiniMenu.CODE_MAP[KeyEvent.VK_BACK_SLASH] = 74;
		MiniMenu.CODE_MAP[KeyEvent.VK_PERIOD] = 72;
		MiniMenu.CODE_MAP[KeyEvent.VK_SLASH] = 73;
	}

	@OriginalMember(owner = "client!bi", name = "a", descriptor = "(BLjava/awt/runetek4.Component;)V")
	public static void start(@OriginalArg(1) Component component) {
		@Pc(10) Method method = SignLink.setFocusTraversalKeysEnabled;
		if (method != null) {
			try {
				method.invoke(component, Boolean.FALSE);
			} catch (@Pc(25) Throwable local25) {
			}
		}
		component.addKeyListener(instance);
		component.addFocusListener(instance);
	}

	@OriginalMember(owner = "client!c", name = "d", descriptor = "(I)Z")
	public static boolean nextKey() {
		@Pc(6) Keyboard local6 = instance;
		synchronized (instance) {
			if (prevTypedQueueWriterIndex == typedQueueReaderIndex) {
				return false;
			} else {
				keyCode = typedCodeQueue[typedQueueReaderIndex];
				keyChar = typedCharQueue[typedQueueReaderIndex];
				typedQueueReaderIndex = typedQueueReaderIndex + 1 & 0x7F;
				return true;
			}
		}
	}

    @OriginalMember(owner = "client!fc", name = "b", descriptor = "(I)V")
    public static void loop() {
        @Pc(12) Keyboard local12 = instance;
        synchronized (instance) {
            typedQueueReaderIndex = prevTypedQueueWriterIndex;
            idleLoops++;
            @Pc(23) int key;
            if (eventQueueWriterIndex < 0) {
                for (key = 0; key < 112; key++) {
                    pressedKeys[key] = false;
                }
                eventQueueWriterIndex = eventQueueReaderIndex;
            } else {
                while (eventQueueWriterIndex != eventQueueReaderIndex) {
                    key = eventQueue[eventQueueReaderIndex];
                    eventQueueReaderIndex = eventQueueReaderIndex + 1 & 0x7F;
                    if (key >= 0) {
                        pressedKeys[key] = true;
                    } else {
                        pressedKeys[~key] = false;
                    }
                }
            }
            prevTypedQueueWriterIndex = typedQueueWriterIndex;
        }
    }

	@OriginalMember(owner = "runetek4.client!pk", name = "f", descriptor = "(B)I")
	public static int getIdleLoops() {
		return idleLoops;
	}

	@OriginalMember(owner = "runetek4.client!kk", name = "a", descriptor = "(ZLjava/awt/event/KeyEvent;)I")
	public static int getKeyChar(@OriginalArg(1) KeyEvent event) {
		@Pc(6) int c = event.getKeyChar();
		if (c == 8364) {
			return 128;
		} else {
			if (c <= 0 || c >= 256) {
				c = -1;
			}
			return c;
		}
	}

	@OriginalMember(owner = "client!uf", name = "keyPressed", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public synchronized void keyPressed(@OriginalArg(0) KeyEvent event) {
		if (instance == null) {
			return;
		}
		idleLoops = 0;
		@Pc(7) int code = event.getKeyCode();
		if (code >= 0 && CODE_MAP.length > code) {
			code = CODE_MAP[code];
			if ((code & 0x80) != 0) {
				code = -1;
			}
		} else {
			code = -1;
		}
		if (eventQueueWriterIndex >= 0 && code >= 0) {
			eventQueue[eventQueueWriterIndex] = code;
			eventQueueWriterIndex = eventQueueWriterIndex + 1 & 0x7F;
			if (eventQueueWriterIndex == eventQueueReaderIndex) {
				eventQueueWriterIndex = -1;
			}
		}
		@Pc(68) int index;
		if (code >= 0) {
			index = typedQueueWriterIndex + 1 & 0x7F;
			if (index != typedQueueReaderIndex) {
				typedCodeQueue[typedQueueWriterIndex] = code;
				typedCharQueue[typedQueueWriterIndex] = -1;
				typedQueueWriterIndex = index;
			}
		}
		index = event.getModifiers();
		if ((index & 0xA) != 0 || code == KEY_BACK_SPACE || code == KEY_ENTER) {
			event.consume();
		}
	}

	@OriginalMember(owner = "client!uf", name = "keyTyped", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public void keyTyped(@OriginalArg(0) KeyEvent event) {
		if (instance != null) {
			@Pc(9) int c = getKeyChar(event);
			if (c >= 0) {
				@Pc(21) int index = typedQueueWriterIndex + 1 & 0x7F;
				if (typedQueueReaderIndex != index) {
					typedCodeQueue[typedQueueWriterIndex] = -1;
					typedCharQueue[typedQueueWriterIndex] = c;
					typedQueueWriterIndex = index;
				}
			}
		}
		event.consume();
	}

	@OriginalMember(owner = "client!uf", name = "keyReleased", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public synchronized void keyReleased(@OriginalArg(0) KeyEvent event) {
		if (instance != null) {
			idleLoops = 0;
			@Pc(11) int c = event.getKeyCode();
			if (c >= 0 && CODE_MAP.length > c) {
				c = CODE_MAP[c] & 0xFFFFFF7F;
			} else {
				c = -1;
			}
			if (eventQueueWriterIndex >= 0 && c >= 0) {
				eventQueue[eventQueueWriterIndex] = ~c;
				eventQueueWriterIndex = eventQueueWriterIndex + 1 & 0x7F;
				if (eventQueueReaderIndex == eventQueueWriterIndex) {
					eventQueueWriterIndex = -1;
				}
			}
		}
		event.consume();
	}

	@OriginalMember(owner = "client!uf", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public void focusGained(@OriginalArg(0) FocusEvent focusEvent) {
	}

	@OriginalMember(owner = "client!uf", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public synchronized void focusLost(@OriginalArg(0) FocusEvent focusEvent) {
		if (instance != null) {
			eventQueueWriterIndex = -1;
		}
	}
}
