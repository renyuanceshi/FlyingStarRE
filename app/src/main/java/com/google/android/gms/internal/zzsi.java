package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsj;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzsi {

    public static class zza {
        public final zzsj zzbty;
        public final List<Asset> zzbtz;

        public zza(zzsj zzsj, List<Asset> list) {
            this.zzbty = zzsj;
            this.zzbtz = list;
        }
    }

    private static int zza(String str, zzsj.zza.C0156zza[] zzaArr) {
        int i = 14;
        for (zzsj.zza.C0156zza zza2 : zzaArr) {
            if (i == 14) {
                if (zza2.type == 9 || zza2.type == 2 || zza2.type == 6) {
                    i = zza2.type;
                } else if (zza2.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + zza2.type + " for key " + str);
                }
            } else if (zza2.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + zza2.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzsj zzsj = new zzsj();
        ArrayList arrayList = new ArrayList();
        zzsj.zzbtA = zza(dataMap, (List<Asset>) arrayList);
        return new zza(zzsj, arrayList);
    }

    private static zzsj.zza.C0156zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        zzsj.zza.C0156zza zza2 = new zzsj.zza.C0156zza();
        if (obj == null) {
            zza2.type = 14;
        } else {
            zza2.zzbtE = new zzsj.zza.C0156zza.C0157zza();
            if (obj instanceof String) {
                zza2.type = 2;
                zza2.zzbtE.zzbtG = (String) obj;
            } else if (obj instanceof Integer) {
                zza2.type = 6;
                zza2.zzbtE.zzbtK = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                zza2.type = 5;
                zza2.zzbtE.zzbtJ = ((Long) obj).longValue();
            } else if (obj instanceof Double) {
                zza2.type = 3;
                zza2.zzbtE.zzbtH = ((Double) obj).doubleValue();
            } else if (obj instanceof Float) {
                zza2.type = 4;
                zza2.zzbtE.zzbtI = ((Float) obj).floatValue();
            } else if (obj instanceof Boolean) {
                zza2.type = 8;
                zza2.zzbtE.zzbtM = ((Boolean) obj).booleanValue();
            } else if (obj instanceof Byte) {
                zza2.type = 7;
                zza2.zzbtE.zzbtL = ((Byte) obj).byteValue();
            } else if (obj instanceof byte[]) {
                zza2.type = 1;
                zza2.zzbtE.zzbtF = (byte[]) obj;
            } else if (obj instanceof String[]) {
                zza2.type = 11;
                zza2.zzbtE.zzbtP = (String[]) obj;
            } else if (obj instanceof long[]) {
                zza2.type = 12;
                zza2.zzbtE.zzbtQ = (long[]) obj;
            } else if (obj instanceof float[]) {
                zza2.type = 15;
                zza2.zzbtE.zzbtR = (float[]) obj;
            } else if (obj instanceof Asset) {
                zza2.type = 13;
                zza2.zzbtE.zzbtS = (long) zza(list, (Asset) obj);
            } else if (obj instanceof DataMap) {
                zza2.type = 9;
                DataMap dataMap = (DataMap) obj;
                TreeSet treeSet = new TreeSet(dataMap.keySet());
                zzsj.zza[] zzaArr = new zzsj.zza[treeSet.size()];
                Iterator it = treeSet.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    zzaArr[i3] = new zzsj.zza();
                    zzaArr[i3].name = str;
                    zzaArr[i3].zzbtC = zza(list, dataMap.get(str));
                    i2 = i3 + 1;
                }
                zza2.zzbtE.zzbtN = zzaArr;
            } else if (obj instanceof ArrayList) {
                zza2.type = 10;
                ArrayList arrayList = (ArrayList) obj;
                zzsj.zza.C0156zza[] zzaArr2 = new zzsj.zza.C0156zza[arrayList.size()];
                Object obj2 = null;
                int size = arrayList.size();
                int i4 = 0;
                int i5 = 14;
                while (i4 < size) {
                    Object obj3 = arrayList.get(i4);
                    zzsj.zza.C0156zza zza3 = zza(list, obj3);
                    if (zza3.type == 14 || zza3.type == 2 || zza3.type == 6 || zza3.type == 9) {
                        if (i5 == 14 && zza3.type != 14) {
                            i = zza3.type;
                        } else if (zza3.type != i5) {
                            throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                        } else {
                            i = i5;
                            obj3 = obj2;
                        }
                        zzaArr2[i4] = zza3;
                        i4++;
                        i5 = i;
                        obj2 = obj3;
                    } else {
                        throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                    }
                }
                zza2.zzbtE.zzbtO = zzaArr2;
            } else {
                throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
            }
        }
        return zza2;
    }

    public static DataMap zza(zza zza2) {
        DataMap dataMap = new DataMap();
        for (zzsj.zza zza3 : zza2.zzbty.zzbtA) {
            zza(zza2.zzbtz, dataMap, zza3.name, zza3.zzbtC);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzsj.zza.C0156zza.C0157zza zza2, int i) {
        ArrayList arrayList = new ArrayList(zza2.zzbtO.length);
        for (zzsj.zza.C0156zza zza3 : zza2.zzbtO) {
            if (zza3.type == 14) {
                arrayList.add((Object) null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (zzsj.zza zza4 : zza3.zzbtE.zzbtN) {
                    zza(list, dataMap, zza4.name, zza4.zzbtC);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(zza3.zzbtE.zzbtG);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(zza3.zzbtE.zzbtK));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzsj.zza.C0156zza zza2) {
        int i = zza2.type;
        if (i == 14) {
            dataMap.putString(str, (String) null);
            return;
        }
        zzsj.zza.C0156zza.C0157zza zza3 = zza2.zzbtE;
        if (i == 1) {
            dataMap.putByteArray(str, zza3.zzbtF);
        } else if (i == 11) {
            dataMap.putStringArray(str, zza3.zzbtP);
        } else if (i == 12) {
            dataMap.putLongArray(str, zza3.zzbtQ);
        } else if (i == 15) {
            dataMap.putFloatArray(str, zza3.zzbtR);
        } else if (i == 2) {
            dataMap.putString(str, zza3.zzbtG);
        } else if (i == 3) {
            dataMap.putDouble(str, zza3.zzbtH);
        } else if (i == 4) {
            dataMap.putFloat(str, zza3.zzbtI);
        } else if (i == 5) {
            dataMap.putLong(str, zza3.zzbtJ);
        } else if (i == 6) {
            dataMap.putInt(str, zza3.zzbtK);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) zza3.zzbtL);
        } else if (i == 8) {
            dataMap.putBoolean(str, zza3.zzbtM);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) zza3.zzbtS));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzsj.zza zza4 : zza3.zzbtN) {
                zza(list, dataMap2, zza4.name, zza4.zzbtC);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            int zza5 = zza(str, zza3.zzbtO);
            ArrayList zza6 = zza(list, zza3, zza5);
            if (zza5 == 14) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 9) {
                dataMap.putDataMapArrayList(str, zza6);
            } else if (zza5 == 2) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 6) {
                dataMap.putIntegerArrayList(str, zza6);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + zza5);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static zzsj.zza[] zza(DataMap dataMap, List<Asset> list) {
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        zzsj.zza[] zzaArr = new zzsj.zza[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzaArr;
            }
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            zzaArr[i2] = new zzsj.zza();
            zzaArr[i2].name = str;
            zzaArr[i2].zzbtC = zza(list, obj);
            i = i2 + 1;
        }
    }
}
