package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zze {
    public static final zze zzakF = zza((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").zza(zza(8192, 8202));
    public static final zze zzakG = zza((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zze zzakH = zza(0, 127);
    public static final zze zzakI;
    public static final zze zzakJ = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));
    public static final zze zzakK = new zze() {
        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    };
    public static final zze zzakL = new zze() {
        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    };
    public static final zze zzakM = new zze() {
        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final zze zzakN = new zze() {
        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final zze zzakO = new zze() {
        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final zze zzakP = zza(0, 31).zza(zza(127, 159));
    public static final zze zzakQ = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
    public static final zze zzakR = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
    public static final zze zzakS = new zze() {
        public zze zza(zze zze) {
            zzx.zzz(zze);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzx.zzz(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    };
    public static final zze zzakT = new zze() {
        public zze zza(zze zze) {
            return (zze) zzx.zzz(zze);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    private static class zza extends zze {
        List<zze> zzala;

        zza(List<zze> list) {
            this.zzala = list;
        }

        public zze zza(zze zze) {
            ArrayList arrayList = new ArrayList(this.zzala);
            arrayList.add(zzx.zzz(zze));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zze zzd : this.zzala) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze zza2 = zza('0', '9');
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            zza2 = zza2.zza(zza(c, (char) (c + 9)));
        }
        zzakI = zza2;
    }

    public static zze zza(char c, char c2) {
        zzx.zzac(c2 >= c);
        return new zze(c, c2) {
            final /* synthetic */ char zzakX;
            final /* synthetic */ char zzakY;

            {
                this.zzakX = (char) r2;
                this.zzakY = (char) r3;
            }

            public boolean zzd(char c) {
                return this.zzakX <= c && c <= this.zzakY;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzakT;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                return new zze(charSequence.charAt(0), charSequence.charAt(1)) {
                    final /* synthetic */ char zzakU;
                    final /* synthetic */ char zzakV;

                    {
                        this.zzakU = (char) r2;
                        this.zzakV = (char) r3;
                    }

                    public boolean zzd(char c) {
                        return c == this.zzakU || c == this.zzakV;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zze() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zze zzc(char c) {
        return new zze(c) {
            final /* synthetic */ char zzakZ;

            {
                this.zzakZ = (char) r2;
            }

            public zze zza(zze zze) {
                return zze.zzd(this.zzakZ) ? zze : zze.super.zza(zze);
            }

            public boolean zzd(char c) {
                return c == this.zzakZ;
            }
        };
    }

    public zze zza(zze zze) {
        return new zza(Arrays.asList(new zze[]{this, (zze) zzx.zzz(zze)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
