package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzpj;

public class zzpa implements BleApi {

    private static class zza extends zzpj.zza {
        private final zza.zzb<BleDevicesResult> zzamC;

        private zza(zza.zzb<BleDevicesResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzamC.zzs(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final BleDevice bleDevice) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new ClaimBleDeviceRequest(str, (BleDevice) null, new zzph(this)));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zznz.zza<BleDevicesResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzI */
            public BleDevicesResult zzc(Status status) {
                return BleDevicesResult.zzQ(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new ListClaimedBleDevicesRequest(new zza(this)));
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, final StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza(new zznz.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new StartBleScanRequest(startBleScanRequest, (zzow) new zzph(this)));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, final BleScanCallback bleScanCallback) {
        return googleApiClient.zza(new zznz.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new StopBleScanRequest(bleScanCallback, (zzow) new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznz zznz) throws RemoteException {
                ((zzok) zznz.zzqJ()).zza(new UnclaimBleDeviceRequest(str, new zzph(this)));
            }
        });
    }
}
