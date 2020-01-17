package m.e.huyen2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ac3 extends Activity {
    ImageView img;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    TextView t;
    TextView t2;
    TextView t3;
    TextView t4;
    int vi;

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ac3);
        this.t = (TextView) findViewById(R.id.t);
        this.t2 = (TextView) findViewById(R.id.t2);
        this.t3 = (TextView) findViewById(R.id.t3);
        this.t4 = (TextView) findViewById(R.id.t5);
        this.t.setTextSize(1, 20.0f);
        this.t2.setTextSize(1, 20.0f);
        this.t3.setTextSize(1, 20.0f);
        this.t4.setTextSize(1, 20.0f);
        this.img = (ImageView) findViewById(R.id.img);
        this.img2 = (ImageView) findViewById(R.id.img2);
        this.img4 = (ImageView) findViewById(R.id.img4);
        this.img5 = (ImageView) findViewById(R.id.img5);
        this.img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=m.e.tutru2&hl=en"));
                ac3.this.startActivity(intent);
            }
        });
        this.img5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=m.e.huyen3&hl=en"));
                ac3.this.startActivity(intent);
            }
        });
        this.img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=m.e.magic&hl=en"));
                ac3.this.startActivity(intent);
            }
        });
        this.img4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=m.e.cuoi&hl=en"));
                ac3.this.startActivity(intent);
            }
        });
    }
}
