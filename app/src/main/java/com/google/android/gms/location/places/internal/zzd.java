package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.List;

public class zzd implements GeoDataApi {
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new zzl.zzc<zze>(Places.zzaPN, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zzc) this, zze.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        final String str2 = str;
        final LatLngBounds latLngBounds2 = latLngBounds;
        final AutocompleteFilter autocompleteFilter2 = autocompleteFilter;
        return googleApiClient.zza(new zzl.zza<zze>(Places.zzaPN, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zza) this), str2, latLngBounds2, autocompleteFilter2);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, final String... strArr) {
        boolean z = true;
        if (strArr == null || strArr.length < 1) {
            z = false;
        }
        zzx.zzac(z);
        return googleApiClient.zza(new zzl.zzc<zze>(Places.zzaPN, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zzc) this, zze.getContext()), (List<String>) Arrays.asList(strArr));
            }
        });
    }

    public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzf.zzb<zze>(Places.zzaPN, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzf((zzf.zzb) this), str);
            }
        });
    }
}
