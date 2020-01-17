package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    private void zzm(String str, String str2, String str3) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        create.show();
    }

    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            zzbg.zzaJ("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzp(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.zzaK(str);
                zzm("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                zzbg.zzaJ("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            zzbg.zzaJ("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            zzbg.e("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
