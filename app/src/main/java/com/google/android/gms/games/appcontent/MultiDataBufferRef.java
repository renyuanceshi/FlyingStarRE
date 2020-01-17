package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends zzc {
    protected final ArrayList<DataHolder> zzaDN;

    protected MultiDataBufferRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList.get(i), i2);
        this.zzaDN = arrayList;
    }
}
