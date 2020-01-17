package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.util.ArrayList;

@zzhb
public class zzbi {
    private static boolean zza(Character.UnicodeBlock unicodeBlock) {
        return unicodeBlock == Character.UnicodeBlock.BOPOMOFO || unicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock == Character.UnicodeBlock.HANGUL_JAMO || unicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == Character.UnicodeBlock.HIRAGANA || unicodeBlock == Character.UnicodeBlock.KATAKANA || unicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    static boolean zzi(int i) {
        return Character.isLetter(i) && (zza(Character.UnicodeBlock.of(i)) || zzj(i));
    }

    private static boolean zzj(int i) {
        return (i >= 65382 && i <= 65437) || (i >= 65441 && i <= 65500);
    }

    public static int zzx(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return zznd.zza(bytes, 0, bytes.length, 0);
    }

    public static String[] zzy(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int length = str.length();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < length) {
            int codePointAt = Character.codePointAt(charArray, i);
            int charCount = Character.charCount(codePointAt);
            if (zzi(codePointAt)) {
                if (z) {
                    arrayList.add(new String(charArray, i2, i - i2));
                }
                arrayList.add(new String(charArray, i, charCount));
                z = false;
            } else if (Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                if (!z) {
                    i2 = i;
                }
                z = true;
            } else if (z) {
                arrayList.add(new String(charArray, i2, i - i2));
                z = false;
            }
            i += charCount;
        }
        if (z) {
            arrayList.add(new String(charArray, i2, i - i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
