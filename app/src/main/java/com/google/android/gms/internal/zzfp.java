package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public class zzfp extends zzfs {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzxA;

    public zzfp(zzjp zzjp, Map<String, String> map) {
        super(zzjp, "storePicture");
        this.zzxA = map;
        this.mContext = zzjp.zzhP();
    }

    public void execute() {
        if (this.mContext == null) {
            zzam("Activity context is not available");
        } else if (!zzr.zzbC().zzM(this.mContext).zzdl()) {
            zzam("Feature is not supported by the device.");
        } else {
            final String str = this.zzxA.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzam("Image url cannot be empty.");
            } else if (!URLUtil.isValidUrl(str)) {
                zzam("Invalid image url: " + str);
            } else {
                final String zzal = zzal(str);
                if (!zzr.zzbC().zzaE(zzal)) {
                    zzam("Image type not recognized: " + zzal);
                    return;
                }
                AlertDialog.Builder zzL = zzr.zzbC().zzL(this.mContext);
                zzL.setTitle(zzr.zzbF().zzd(R.string.store_picture_title, "Save image"));
                zzL.setMessage(zzr.zzbF().zzd(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                zzL.setPositiveButton(zzr.zzbF().zzd(R.string.accept, "Accept"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            ((DownloadManager) zzfp.this.mContext.getSystemService("download")).enqueue(zzfp.this.zzf(str, zzal));
                        } catch (IllegalStateException e) {
                            zzfp.this.zzam("Could not store picture.");
                        }
                    }
                });
                zzL.setNegativeButton(zzr.zzbF().zzd(R.string.decline, "Decline"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        zzfp.this.zzam("User canceled the download.");
                    }
                });
                zzL.create().show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String zzal(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* access modifiers changed from: package-private */
    public DownloadManager.Request zzf(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzr.zzbE().zza(request);
        return request;
    }
}
