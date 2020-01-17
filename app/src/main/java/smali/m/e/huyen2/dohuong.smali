.class public Lm/e/huyen2/dohuong;
.super Landroid/app/Activity;
.source "dohuong.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# instance fields
.field chi:Ljava/lang/String;

.field dos:Landroid/widget/TextView;

.field list:Ljava/lang/String;

.field private mAccelerometer:Landroid/hardware/Sensor;

.field private mCurrentDegree:F

.field private mLastAccelerometer:[F

.field private mLastAccelerometerSet:Z

.field private mLastMagnetometer:[F

.field private mLastMagnetometerSet:Z

.field private mMagnetometer:Landroid/hardware/Sensor;

.field private mOrientation:[F

.field private mR:[F

.field private mSensorManager:Landroid/hardware/SensorManager;

.field private mui2:Landroid/widget/ImageView;

.field private muiten:Landroid/widget/ImageView;

.field t2:Landroid/widget/TextView;

.field tvt:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x3

    .line 20
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 29
    new-array v0, v1, [F

    iput-object v0, p0, Lm/e/huyen2/dohuong;->mLastAccelerometer:[F

    .line 30
    new-array v0, v1, [F

    iput-object v0, p0, Lm/e/huyen2/dohuong;->mLastMagnetometer:[F

    .line 31
    iput-boolean v2, p0, Lm/e/huyen2/dohuong;->mLastAccelerometerSet:Z

    .line 32
    iput-boolean v2, p0, Lm/e/huyen2/dohuong;->mLastMagnetometerSet:Z

    .line 33
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lm/e/huyen2/dohuong;->mR:[F

    .line 34
    new-array v0, v1, [F

    iput-object v0, p0, Lm/e/huyen2/dohuong;->mOrientation:[F

    .line 35
    const/4 v0, 0x0

    iput v0, p0, Lm/e/huyen2/dohuong;->mCurrentDegree:F

    .line 20
    return-void
.end method

.method public static round(FI)F
    .locals 4
    .param p0, "value"    # F
    .param p1, "places"    # I

    .prologue
    .line 116
    if-gez p1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 118
    :cond_0
    new-instance v0, Ljava/math/BigDecimal;

    float-to-double v2, p0

    invoke-direct {v0, v2, v3}, Ljava/math/BigDecimal;-><init>(D)V

    .line 119
    .local v0, "bd":Ljava/math/BigDecimal;
    sget-object v1, Ljava/math/RoundingMode;->HALF_UP:Ljava/math/RoundingMode;

    invoke-virtual {v0, p1, v1}, Ljava/math/BigDecimal;->setScale(ILjava/math/RoundingMode;)Ljava/math/BigDecimal;

    move-result-object v0

    .line 120
    invoke-virtual {v0}, Ljava/math/BigDecimal;->floatValue()F

    move-result v1

    return v1
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0
    .param p1, "sensor"    # Landroid/hardware/Sensor;
    .param p2, "accuracy"    # I

    .prologue
    .line 114
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 38
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    const v2, 0x7f03001d

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->setContentView(I)V

    .line 43
    const v2, 0x7f0a00cd

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lm/e/huyen2/dohuong;->dos:Landroid/widget/TextView;

    .line 44
    const v2, 0x7f0a00cb

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lm/e/huyen2/dohuong;->t2:Landroid/widget/TextView;

    .line 47
    const v2, 0x7f0a00cf

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lm/e/huyen2/dohuong;->tvt:Landroid/widget/TextView;

    .line 48
    iget-object v2, p0, Lm/e/huyen2/dohuong;->t2:Landroid/widget/TextView;

    const/high16 v3, 0x41a00000    # 20.0f

    invoke-virtual {v2, v4, v3}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 49
    invoke-virtual {p0}, Lm/e/huyen2/dohuong;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 52
    .local v0, "PM":Landroid/content/pm/PackageManager;
    const-string v2, "sensor"

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/SensorManager;

    iput-object v2, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    .line 53
    iget-object v2, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v2, v4}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/dohuong;->mAccelerometer:Landroid/hardware/Sensor;

    .line 54
    iget-object v2, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/dohuong;->mMagnetometer:Landroid/hardware/Sensor;

    .line 56
    const v2, 0x7f0a00ce

    invoke-virtual {p0, v2}, Lm/e/huyen2/dohuong;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lm/e/huyen2/dohuong;->muiten:Landroid/widget/ImageView;

    .line 59
    const-string v2, "android.hardware.sensor.compass"

    invoke-virtual {v0, v2}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    .line 60
    .local v1, "ac":Z
    if-nez v1, :cond_0

    .line 61
    iget-object v2, p0, Lm/e/huyen2/dohuong;->tvt:Landroid/widget/TextView;

    const-string v3, "Your phone doesn\'t has magnetic sensor"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    :cond_0
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 71
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 72
    iget-object v0, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lm/e/huyen2/dohuong;->mAccelerometer:Landroid/hardware/Sensor;

    invoke-virtual {v0, p0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V

    .line 73
    iget-object v0, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lm/e/huyen2/dohuong;->mMagnetometer:Landroid/hardware/Sensor;

    invoke-virtual {v0, p0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V

    .line 74
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 65
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 66
    iget-object v0, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lm/e/huyen2/dohuong;->mAccelerometer:Landroid/hardware/Sensor;

    invoke-virtual {v0, p0, v1, v2}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    .line 67
    iget-object v0, p0, Lm/e/huyen2/dohuong;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lm/e/huyen2/dohuong;->mMagnetometer:Landroid/hardware/Sensor;

    invoke-virtual {v0, p0, v1, v2}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    .line 68
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 14
    .param p1, "event"    # Landroid/hardware/SensorEvent;

    .prologue
    const/high16 v4, 0x3f000000    # 0.5f

    const/4 v10, 0x0

    const/4 v3, 0x1

    .line 78
    iget-object v1, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    iget-object v2, p0, Lm/e/huyen2/dohuong;->mAccelerometer:Landroid/hardware/Sensor;

    if-ne v1, v2, :cond_2

    .line 79
    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    iget-object v2, p0, Lm/e/huyen2/dohuong;->mLastAccelerometer:[F

    iget-object v5, p1, Landroid/hardware/SensorEvent;->values:[F

    array-length v5, v5

    invoke-static {v1, v10, v2, v10, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 80
    iput-boolean v3, p0, Lm/e/huyen2/dohuong;->mLastAccelerometerSet:Z

    .line 85
    :cond_0
    :goto_0
    iget-boolean v1, p0, Lm/e/huyen2/dohuong;->mLastAccelerometerSet:Z

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lm/e/huyen2/dohuong;->mLastMagnetometerSet:Z

    if-eqz v1, :cond_1

    .line 86
    iget-object v1, p0, Lm/e/huyen2/dohuong;->mR:[F

    const/4 v2, 0x0

    iget-object v5, p0, Lm/e/huyen2/dohuong;->mLastAccelerometer:[F

    iget-object v6, p0, Lm/e/huyen2/dohuong;->mLastMagnetometer:[F

    invoke-static {v1, v2, v5, v6}, Landroid/hardware/SensorManager;->getRotationMatrix([F[F[F[F)Z

    .line 87
    iget-object v1, p0, Lm/e/huyen2/dohuong;->mR:[F

    iget-object v2, p0, Lm/e/huyen2/dohuong;->mOrientation:[F

    invoke-static {v1, v2}, Landroid/hardware/SensorManager;->getOrientation([F[F)[F

    .line 88
    iget-object v1, p0, Lm/e/huyen2/dohuong;->mOrientation:[F

    aget v8, v1, v10

    .line 89
    .local v8, "azimuthInRadians":F
    float-to-double v10, v8

    invoke-static {v10, v11}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v10

    const-wide v12, 0x4076800000000000L    # 360.0

    add-double/2addr v10, v12

    double-to-float v1, v10

    const/high16 v2, 0x43b40000    # 360.0f

    rem-float v7, v1, v2

    .line 90
    .local v7, "azimuthInDegress":F
    new-instance v0, Landroid/view/animation/RotateAnimation;

    .line 91
    iget v1, p0, Lm/e/huyen2/dohuong;->mCurrentDegree:F

    .line 92
    neg-float v2, v7

    move v5, v3

    move v6, v4

    .line 90
    invoke-direct/range {v0 .. v6}, Landroid/view/animation/RotateAnimation;-><init>(FFIFIF)V

    .line 97
    .local v0, "ra":Landroid/view/animation/RotateAnimation;
    const-wide/16 v4, 0xfa

    invoke-virtual {v0, v4, v5}, Landroid/view/animation/RotateAnimation;->setDuration(J)V

    .line 99
    invoke-virtual {v0, v3}, Landroid/view/animation/RotateAnimation;->setFillAfter(Z)V

    .line 101
    iget-object v1, p0, Lm/e/huyen2/dohuong;->muiten:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 102
    neg-float v1, v7

    iput v1, p0, Lm/e/huyen2/dohuong;->mCurrentDegree:F

    .line 104
    iget v9, p0, Lm/e/huyen2/dohuong;->mCurrentDegree:F

    .line 105
    .local v9, "g":F
    invoke-static {v9, v3}, Lm/e/huyen2/dohuong;->round(FI)F

    move-result v1

    const/high16 v2, -0x40800000    # -1.0f

    mul-float v9, v1, v2

    .line 106
    iget-object v1, p0, Lm/e/huyen2/dohuong;->dos:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/16 v3, 0xb0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 109
    .end local v0    # "ra":Landroid/view/animation/RotateAnimation;
    .end local v7    # "azimuthInDegress":F
    .end local v8    # "azimuthInRadians":F
    .end local v9    # "g":F
    :cond_1
    return-void

    .line 81
    :cond_2
    iget-object v1, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    iget-object v2, p0, Lm/e/huyen2/dohuong;->mMagnetometer:Landroid/hardware/Sensor;

    if-ne v1, v2, :cond_0

    .line 82
    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    iget-object v2, p0, Lm/e/huyen2/dohuong;->mLastMagnetometer:[F

    iget-object v5, p1, Landroid/hardware/SensorEvent;->values:[F

    array-length v5, v5

    invoke-static {v1, v10, v2, v10, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 83
    iput-boolean v3, p0, Lm/e/huyen2/dohuong;->mLastMagnetometerSet:Z

    goto :goto_0
.end method
