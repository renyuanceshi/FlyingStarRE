.class Lcom/google/android/gms/location/internal/zzd$8;
.super Lcom/google/android/gms/location/internal/zzd$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/location/internal/zzd;->requestLocationUpdates(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/location/LocationRequest;Landroid/app/PendingIntent;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzaOq:Landroid/app/PendingIntent;

.field final synthetic zzaOv:Lcom/google/android/gms/location/LocationRequest;

.field final synthetic zzaOx:Lcom/google/android/gms/location/internal/zzd;


# direct methods
.method constructor <init>(Lcom/google/android/gms/location/internal/zzd;Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/location/LocationRequest;Landroid/app/PendingIntent;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/location/internal/zzd$8;->zzaOx:Lcom/google/android/gms/location/internal/zzd;

    iput-object p3, p0, Lcom/google/android/gms/location/internal/zzd$8;->zzaOv:Lcom/google/android/gms/location/LocationRequest;

    iput-object p4, p0, Lcom/google/android/gms/location/internal/zzd$8;->zzaOq:Landroid/app/PendingIntent;

    invoke-direct {p0, p2}, Lcom/google/android/gms/location/internal/zzd$zza;-><init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic zza(Lcom/google/android/gms/common/api/Api$zzb;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/location/internal/zzl;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/location/internal/zzd$8;->zza(Lcom/google/android/gms/location/internal/zzl;)V

    return-void
.end method

.method protected zza(Lcom/google/android/gms/location/internal/zzl;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/location/internal/zzd$zzb;

    invoke-direct {v0, p0}, Lcom/google/android/gms/location/internal/zzd$zzb;-><init>(Lcom/google/android/gms/common/api/internal/zza$zzb;)V

    iget-object v1, p0, Lcom/google/android/gms/location/internal/zzd$8;->zzaOv:Lcom/google/android/gms/location/LocationRequest;

    iget-object v2, p0, Lcom/google/android/gms/location/internal/zzd$8;->zzaOq:Landroid/app/PendingIntent;

    invoke-virtual {p1, v1, v2, v0}, Lcom/google/android/gms/location/internal/zzl;->zza(Lcom/google/android/gms/location/LocationRequest;Landroid/app/PendingIntent;Lcom/google/android/gms/location/internal/zzg;)V

    return-void
.end method
