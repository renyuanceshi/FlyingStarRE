package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

public final class PlusShare {
    public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
    public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
    public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
    public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
    public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
    public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
    public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
    public static final String KEY_CALL_TO_ACTION_LABEL = "label";
    public static final String KEY_CALL_TO_ACTION_URL = "url";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
    public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

    public static class Builder {
        private final Context mContext;
        private final Intent mIntent = new Intent().setAction("android.intent.action.SEND");
        private boolean zzbeg;
        private ArrayList<Uri> zzbeh;

        public Builder(Activity activity) {
            this.mContext = activity;
            this.mIntent.addFlags(524288);
            if (activity != null && activity.getComponentName() != null) {
                this.zzbeg = true;
            }
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder addCallToAction(String str, Uri uri, String str2) {
            zzx.zza(this.zzbeg, (Object) "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
            zzx.zzb(uri != null && !TextUtils.isEmpty(uri.toString()), (Object) "Must provide a call to action URL");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_LABEL, str);
            }
            bundle.putString(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            if (!TextUtils.isEmpty(str2)) {
                zzx.zza(PlusShare.zzfD(str2), (Object) "The specified deep-link ID was malformed.");
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_DEEP_LINK_ID, str2);
            }
            this.mIntent.putExtra(PlusShare.EXTRA_CALL_TO_ACTION, bundle);
            this.mIntent.putExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, true);
            this.mIntent.setType("text/plain");
            return this;
        }

        public Builder addStream(Uri uri) {
            Uri uri2 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return setStream(uri);
            }
            if (this.zzbeh == null) {
                this.zzbeh = new ArrayList<>();
            }
            this.zzbeh.add(uri2);
            this.zzbeh.add(uri);
            return this;
        }

        public Intent getIntent() {
            boolean z = true;
            boolean z2 = this.zzbeh != null && this.zzbeh.size() > 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
            boolean booleanExtra = this.mIntent.getBooleanExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, false);
            zzx.zza(!z2 || !booleanExtra, (Object) "Call-to-action buttons are only available for URLs.");
            zzx.zza(!booleanExtra || this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL), (Object) "The content URL is required for interactive posts.");
            if (booleanExtra && !this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL) && !this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                zzx.zza(PlusShare.zzfD(this.mIntent.getStringExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)), (Object) "The specified deep-link ID was malformed.");
            }
            if (!z2 && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.zzbeh == null || this.zzbeh.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", this.zzbeh.get(0));
                }
                this.zzbeh = null;
            }
            if (z2 && !equals) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.zzbeh == null || this.zzbeh.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.zzbeh);
                }
            }
            if ("com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction())) {
                this.mIntent.setPackage("com.google.android.gms");
                return this.mIntent;
            } else if (!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
                this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
                this.mIntent.setPackage("com.google.android.gms");
                return this.mIntent;
            } else {
                this.mIntent.setPackage("com.google.android.apps.plus");
                return this.mIntent;
            }
        }

        public Builder setContentDeepLinkId(String str) {
            return setContentDeepLinkId(str, (String) null, (String) null, (Uri) null);
        }

        public Builder setContentDeepLinkId(String str, String str2, String str3, Uri uri) {
            zzx.zzb(this.zzbeg, (Object) "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
            zzx.zzb(!TextUtils.isEmpty(str), (Object) "The deepLinkId parameter is required.");
            Bundle zza = PlusShare.zza(str2, str3, uri);
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID, str);
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_METADATA, zza);
            this.mIntent.setType("text/plain");
            return this;
        }

        public Builder setContentUrl(Uri uri) {
            String str = null;
            if (uri != null) {
                str = uri.toString();
            }
            if (TextUtils.isEmpty(str)) {
                this.mIntent.removeExtra(PlusShare.EXTRA_CONTENT_URL);
            } else {
                this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_URL, str);
            }
            return this;
        }

        public Builder setRecipients(Person person, List<Person> list) {
            this.mIntent.putExtra(PlusShare.EXTRA_SENDER_ID, person != null ? person.getId() : "0");
            int size = list != null ? list.size() : 0;
            if (size == 0) {
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
            } else {
                ArrayList arrayList = new ArrayList(size);
                ArrayList arrayList2 = new ArrayList(size);
                for (Person next : list) {
                    arrayList.add(next.getId());
                    arrayList2.add(next.getDisplayName());
                }
                this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", arrayList);
                this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", arrayList2);
            }
            return this;
        }

        public Builder setStream(Uri uri) {
            this.zzbeh = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public Builder setType(String str) {
            this.mIntent.setType(str);
            return this;
        }
    }

    @Deprecated
    protected PlusShare() {
        throw new AssertionError();
    }

    public static Person createPerson(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
        } else if (!TextUtils.isEmpty(str2)) {
            return new PersonEntity(str2, str, (PersonEntity.ImageEntity) null, 0, (String) null);
        } else {
            throw new IllegalArgumentException("Display name must not be empty.");
        }
    }

    public static String getDeepLinkId(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return null;
        }
        return intent.getData().getQueryParameter(PARAM_CONTENT_DEEP_LINK_ID);
    }

    public static Bundle zza(String str, String str2, Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_TITLE, str);
        bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str2);
        if (uri != null) {
            bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, uri.toString());
        }
        return bundle;
    }

    protected static boolean zzfD(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
            return false;
        } else if (!str.contains(" ")) {
            return true;
        } else {
            Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
            return false;
        }
    }
}
