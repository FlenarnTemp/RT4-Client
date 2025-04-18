package com.jagex.runetek4.config.types.quickchat;

import com.jagex.runetek4.JString;
import com.jagex.runetek4.LruHashTable;
import com.jagex.runetek4.QuickChatCommandDecoder;
import com.jagex.runetek4.core.io.Packet;
import com.jagex.runetek4.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public class QuickChatPhraseTypeList {

    @OriginalMember(owner = "runetek4.client!ud", name = "P", descriptor = "Lclient!gn;")
    public static final LruHashTable types = new LruHashTable(64);

    @OriginalMember(owner = "client!ck", name = "C", descriptor = "I")
    public static int anInt1047 = 0;

    @OriginalMember(owner = "runetek4.client!le", name = "e", descriptor = "I")
    public static int anInt3490 = 0;

    @OriginalMember(owner = "runetek4.client!vf", name = "n", descriptor = "Lclient!ve;")
    public static Js5 configClientLarge;

    @OriginalMember(owner = "runetek4.client!id", name = "j", descriptor = "Lclient!of;")
    public static QuickChatCommandDecoder decoder = null;

    @OriginalMember(owner = "runetek4.client!te", name = "y", descriptor = "Lclient!ve;")
    public static Js5 configClientSmall;

    @OriginalMember(owner = "runetek4.client!sj", name = "b", descriptor = "(II)Lclient!cb;")
    public static QuickChatPhraseType get(@OriginalArg(1) int id) {
        @Pc(10) QuickChatPhraseType quickChatPhrase = (QuickChatPhraseType) types.get((long) id);
        if (quickChatPhrase != null) {
            return quickChatPhrase;
        }

        @Pc(27) byte[] bytes;
        if (id >= 32768) {
            bytes = configClientLarge.getfile(1, id & 0x7FFF);
        } else {
            bytes = configClientSmall.getfile(1, id);
        }

        QuickChatPhraseType quickChatPhraseType = new QuickChatPhraseType();
        if (bytes != null) {
            quickChatPhraseType.decode(new Packet(bytes));
        }
        if (id >= 32768) {
            quickChatPhraseType.postDecode();
        }
        types.put(quickChatPhraseType, (long) id);
        return quickChatPhraseType;
    }

    @OriginalMember(owner = "client!ej", name = "a", descriptor = "(Lclient!ve;ILclient!ve;Lclient!of;)V")
    public static void init(@OriginalArg(0) Js5 arg0, @OriginalArg(2) Js5 arg1, @OriginalArg(3) QuickChatCommandDecoder arg2) {
        configClientLarge = arg0;
        decoder = arg2;
        configClientSmall = arg1;
        if (configClientSmall != null) {
            anInt3490 = configClientSmall.getGroupCapacity(1);
        }
        if (configClientLarge != null) {
            anInt1047 = configClientLarge.getGroupCapacity(1);
        }
    }

    @OriginalMember(owner = "client!ha", name = "a", descriptor = "([IJIZ)Lclient!na;")
    public static JString method1838(@OriginalArg(0) int[] arg0, @OriginalArg(1) long arg1, @OriginalArg(2) int arg2) {
        if (decoder != null) {
            @Pc(17) JString local17 = decoder.decode(arg2, arg0, arg1);
            if (local17 != null) {
                return local17;
            }
        }
        return JString.method2929(arg1);
    }
}
