package m.e.huyen2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class dohuong extends Activity implements SensorEventListener {
    String chi;
    TextView dos;
    String list;
    private Sensor mAccelerometer;
    private float mCurrentDegree = 0.0f;
    private float[] mLastAccelerometer = new float[3];
    private boolean mLastAccelerometerSet = false;
    private float[] mLastMagnetometer = new float[3];
    private boolean mLastMagnetometerSet = false;
    private Sensor mMagnetometer;
    private float[] mOrientation = new float[3];
    private float[] mR = new float[9];
    private SensorManager mSensorManager;
    private ImageView mui2;
    private ImageView muiten;
    TextView t2;
    TextView tvt;

    public static float round(float f, int i) {
        if (i >= 0) {
            return new BigDecimal((double) f).setScale(i, RoundingMode.HALF_UP).floatValue();
        }
        throw new IllegalArgumentException();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.huong);
        this.dos = (TextView) findViewById(R.id.po);
        this.t2 = (TextView) findViewById(R.id.t0);
        this.tvt = (TextView) findViewById(R.id.tv);
        this.t2.setTextSize(1, 20.0f);
        PackageManager packageManager = getPackageManager();
        this.mSensorManager = (SensorManager) getSystemService("sensor");
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(1);
        this.mMagnetometer = this.mSensorManager.getDefaultSensor(2);
        this.muiten = (ImageView) findViewById(R.id.pointer);
        if (!packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
            this.tvt.setText("Your phone doesn't has magnetic sensor");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mSensorManager.unregisterListener(this, this.mAccelerometer);
        this.mSensorManager.unregisterListener(this, this.mMagnetometer);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
        this.mSensorManager.registerListener(this, this.mMagnetometer, 1);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == this.mAccelerometer) {
            System.arraycopy(sensorEvent.values, 0, this.mLastAccelerometer, 0, sensorEvent.values.length);
            this.mLastAccelerometerSet = true;
        } else if (sensorEvent.sensor == this.mMagnetometer) {
            System.arraycopy(sensorEvent.values, 0, this.mLastMagnetometer, 0, sensorEvent.values.length);
            this.mLastMagnetometerSet = true;
        }
        if (this.mLastAccelerometerSet && this.mLastMagnetometerSet) {
            SensorManager.getRotationMatrix(this.mR, (float[]) null, this.mLastAccelerometer, this.mLastMagnetometer);
            SensorManager.getOrientation(this.mR, this.mOrientation);
            float degrees = ((float) (Math.toDegrees((double) this.mOrientation[0]) + 360.0d)) % 360.0f;
            RotateAnimation rotateAnimation = new RotateAnimation(this.mCurrentDegree, -degrees, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(250);
            rotateAnimation.setFillAfter(true);
            this.muiten.startAnimation(rotateAnimation);
            this.mCurrentDegree = -degrees;
            this.dos.setText(String.valueOf(round(this.mCurrentDegree, 1) * -1.0f) + 176);
        }
    }
}
