package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.IMediaBrowserServiceCompat;
import android.support.v4.media.IMediaBrowserServiceCompatCallbacks;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public final class MediaBrowserCompat {
    private final MediaBrowserImplBase mImpl;

    public static class ConnectionCallback {
        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    public static abstract class ItemCallback {
        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    static class MediaBrowserImplBase {
        private static final int CONNECT_STATE_CONNECTED = 2;
        private static final int CONNECT_STATE_CONNECTING = 1;
        private static final int CONNECT_STATE_DISCONNECTED = 0;
        private static final int CONNECT_STATE_SUSPENDED = 3;
        private static final boolean DBG = false;
        private static final String TAG = "MediaBrowserCompat";
        /* access modifiers changed from: private */
        public final ConnectionCallback mCallback;
        /* access modifiers changed from: private */
        public final Context mContext;
        /* access modifiers changed from: private */
        public Bundle mExtras;
        private final Handler mHandler = new Handler();
        /* access modifiers changed from: private */
        public MediaSessionCompat.Token mMediaSessionToken;
        /* access modifiers changed from: private */
        public final Bundle mRootHints;
        /* access modifiers changed from: private */
        public String mRootId;
        /* access modifiers changed from: private */
        public IMediaBrowserServiceCompat mServiceBinder;
        /* access modifiers changed from: private */
        public IMediaBrowserServiceCompatCallbacks mServiceCallbacks;
        /* access modifiers changed from: private */
        public final ComponentName mServiceComponent;
        /* access modifiers changed from: private */
        public MediaServiceConnection mServiceConnection;
        /* access modifiers changed from: private */
        public int mState = 0;
        /* access modifiers changed from: private */
        public final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        private class MediaServiceConnection implements ServiceConnection {
            private MediaServiceConnection() {
            }

            private boolean isCurrent(String str) {
                if (MediaBrowserImplBase.this.mServiceConnection == this) {
                    return true;
                }
                if (MediaBrowserImplBase.this.mState != 0) {
                    Log.i(MediaBrowserImplBase.TAG, str + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                }
                return false;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (isCurrent("onServiceConnected")) {
                    IMediaBrowserServiceCompat unused = MediaBrowserImplBase.this.mServiceBinder = IMediaBrowserServiceCompat.Stub.asInterface(iBinder);
                    IMediaBrowserServiceCompatCallbacks unused2 = MediaBrowserImplBase.this.mServiceCallbacks = MediaBrowserImplBase.this.getNewServiceCallbacks();
                    int unused3 = MediaBrowserImplBase.this.mState = 1;
                    try {
                        MediaBrowserImplBase.this.mServiceBinder.connect(MediaBrowserImplBase.this.mContext.getPackageName(), MediaBrowserImplBase.this.mRootHints, MediaBrowserImplBase.this.mServiceCallbacks);
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserImplBase.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                    }
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                if (isCurrent("onServiceDisconnected")) {
                    IMediaBrowserServiceCompat unused = MediaBrowserImplBase.this.mServiceBinder = null;
                    IMediaBrowserServiceCompatCallbacks unused2 = MediaBrowserImplBase.this.mServiceCallbacks = null;
                    int unused3 = MediaBrowserImplBase.this.mState = 3;
                    MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                }
            }
        }

        private static class ServiceCallbacks extends IMediaBrowserServiceCompatCallbacks.Stub {
            private WeakReference<MediaBrowserImplBase> mMediaBrowser;

            public ServiceCallbacks(MediaBrowserImplBase mediaBrowserImplBase) {
                this.mMediaBrowser = new WeakReference<>(mediaBrowserImplBase);
            }

            public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) {
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onServiceConnected(this, str, token, bundle);
                }
            }

            public void onConnectFailed() {
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onConnectionFailed(this);
                }
            }

            public void onLoadChildren(String str, List list) {
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onLoadChildren(this, str, list);
                }
            }
        }

        private static class Subscription {
            SubscriptionCallback callback;
            final String id;

            Subscription(String str) {
                this.id = str;
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.mServiceComponent = componentName;
                this.mCallback = connectionCallback;
                this.mRootHints = bundle;
            }
        }

        /* access modifiers changed from: private */
        public void forceCloseConnection() {
            if (this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mState = 0;
            this.mServiceConnection = null;
            this.mServiceBinder = null;
            this.mServiceCallbacks = null;
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        /* access modifiers changed from: private */
        public ServiceCallbacks getNewServiceCallbacks() {
            return new ServiceCallbacks(this);
        }

        /* access modifiers changed from: private */
        public static String getStateLabel(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTED";
                case 1:
                    return "CONNECT_STATE_CONNECTING";
                case 2:
                    return "CONNECT_STATE_CONNECTED";
                case 3:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        /* access modifiers changed from: private */
        public boolean isCurrent(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str) {
            if (this.mServiceCallbacks == iMediaBrowserServiceCompatCallbacks) {
                return true;
            }
            if (this.mState != 0) {
                Log.i(TAG, str + " for " + this.mServiceComponent + " with mServiceConnection=" + this.mServiceCallbacks + " this=" + this);
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final void onConnectionFailed(final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    Log.e(MediaBrowserImplBase.TAG, "onConnectFailed for " + MediaBrowserImplBase.this.mServiceComponent);
                    if (MediaBrowserImplBase.this.isCurrent(iMediaBrowserServiceCompatCallbacks, "onConnectFailed")) {
                        if (MediaBrowserImplBase.this.mState != 1) {
                            Log.w(MediaBrowserImplBase.TAG, "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(MediaBrowserImplBase.this.mState) + "... ignoring");
                            return;
                        }
                        MediaBrowserImplBase.this.forceCloseConnection();
                        MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public final void onLoadChildren(final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, final String str, final List list) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (MediaBrowserImplBase.this.isCurrent(iMediaBrowserServiceCompatCallbacks, "onLoadChildren")) {
                        List list = list;
                        List emptyList = list == null ? Collections.emptyList() : list;
                        Subscription subscription = (Subscription) MediaBrowserImplBase.this.mSubscriptions.get(str);
                        if (subscription != null) {
                            subscription.callback.onChildrenLoaded(str, emptyList);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public final void onServiceConnected(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str, MediaSessionCompat.Token token, Bundle bundle) {
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            final String str2 = str;
            final MediaSessionCompat.Token token2 = token;
            final Bundle bundle2 = bundle;
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (MediaBrowserImplBase.this.isCurrent(iMediaBrowserServiceCompatCallbacks2, "onConnect")) {
                        if (MediaBrowserImplBase.this.mState != 1) {
                            Log.w(MediaBrowserImplBase.TAG, "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(MediaBrowserImplBase.this.mState) + "... ignoring");
                            return;
                        }
                        String unused = MediaBrowserImplBase.this.mRootId = str2;
                        MediaSessionCompat.Token unused2 = MediaBrowserImplBase.this.mMediaSessionToken = token2;
                        Bundle unused3 = MediaBrowserImplBase.this.mExtras = bundle2;
                        int unused4 = MediaBrowserImplBase.this.mState = 2;
                        MediaBrowserImplBase.this.mCallback.onConnected();
                        for (String str : MediaBrowserImplBase.this.mSubscriptions.keySet()) {
                            try {
                                MediaBrowserImplBase.this.mServiceBinder.addSubscription(str, MediaBrowserImplBase.this.mServiceCallbacks);
                            } catch (RemoteException e) {
                                Log.d(MediaBrowserImplBase.TAG, "addSubscription failed with RemoteException parentId=" + str);
                            }
                        }
                    }
                }
            });
        }

        public void connect() {
            if (this.mState != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
            } else if (this.mServiceBinder != null) {
                throw new RuntimeException("mServiceBinder should be null. Instead it is " + this.mServiceBinder);
            } else if (this.mServiceCallbacks != null) {
                throw new RuntimeException("mServiceCallbacks should be null. Instead it is " + this.mServiceCallbacks);
            } else {
                this.mState = 1;
                Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                intent.setComponent(this.mServiceComponent);
                final MediaServiceConnection mediaServiceConnection = new MediaServiceConnection();
                this.mServiceConnection = mediaServiceConnection;
                boolean z = false;
                try {
                    z = this.mContext.bindService(intent, this.mServiceConnection, 1);
                } catch (Exception e) {
                    Log.e(TAG, "Failed binding to service " + this.mServiceComponent);
                }
                if (!z) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            if (mediaServiceConnection == MediaBrowserImplBase.this.mServiceConnection) {
                                MediaBrowserImplBase.this.forceCloseConnection();
                                MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                            }
                        }
                    });
                }
            }
        }

        public void disconnect() {
            if (this.mServiceCallbacks != null) {
                try {
                    this.mServiceBinder.disconnect(this.mServiceCallbacks);
                } catch (RemoteException e) {
                    Log.w(TAG, "RemoteException during connect for " + this.mServiceComponent);
                }
            }
            forceCloseConnection();
        }

        /* access modifiers changed from: package-private */
        public void dump() {
            Log.d(TAG, "MediaBrowserCompat...");
            Log.d(TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(TAG, "  mCallback=" + this.mCallback);
            Log.d(TAG, "  mRootHints=" + this.mRootHints);
            Log.d(TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(TAG, "  mServiceBinder=" + this.mServiceBinder);
            Log.d(TAG, "  mServiceCallbacks=" + this.mServiceCallbacks);
            Log.d(TAG, "  mRootId=" + this.mRootId);
            Log.d(TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        public void getItem(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty.");
            } else if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null.");
            } else if (this.mState != 2) {
                Log.i(TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() {
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else {
                try {
                    this.mServiceBinder.getMediaItem(str, new ResultReceiver(this.mHandler) {
                        /* access modifiers changed from: protected */
                        public void onReceiveResult(int i, Bundle bundle) {
                            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                                itemCallback.onError(str);
                                return;
                            }
                            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                            if (!(parcelable instanceof MediaItem)) {
                                itemCallback.onError(str);
                            } else {
                                itemCallback.onItemLoaded((MediaItem) parcelable);
                            }
                        }
                    });
                } catch (RemoteException e) {
                    Log.i(TAG, "Remote error getting media item.");
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                }
            }
        }

        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        public boolean isConnected() {
            return this.mState == 2;
        }

        public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
            if (str == null) {
                throw new IllegalArgumentException("parentId is null");
            } else if (subscriptionCallback == null) {
                throw new IllegalArgumentException("callback is null");
            } else {
                Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    subscription = new Subscription(str);
                    this.mSubscriptions.put(str, subscription);
                }
                subscription.callback = subscriptionCallback;
                if (this.mState == 2) {
                    try {
                        this.mServiceBinder.addSubscription(str, this.mServiceCallbacks);
                    } catch (RemoteException e) {
                        Log.d(TAG, "addSubscription failed with RemoteException parentId=" + str);
                    }
                }
            }
        }

        public void unsubscribe(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("parentId is empty.");
            }
            Subscription remove = this.mSubscriptions.remove(str);
            if (this.mState == 2 && remove != null) {
                try {
                    this.mServiceBinder.removeSubscription(str, this.mServiceCallbacks);
                } catch (RemoteException e) {
                    Log.d(TAG, "removeSubscription failed with RemoteException parentId=" + str);
                }
            }
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        private MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.mFlags = i;
                this.mDescription = mediaDescriptionCompat;
            }
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @NonNull
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.mDescription);
            sb.append('}');
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    public static abstract class SubscriptionCallback {
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        this.mImpl = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        this.mImpl.subscribe(str, subscriptionCallback);
    }

    public void unsubscribe(@NonNull String str) {
        this.mImpl.unsubscribe(str);
    }
}
