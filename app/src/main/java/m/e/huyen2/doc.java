package m.e.huyen2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class doc extends Activity {
    Button b1;
    InputStream in = new InputStream() {
        public int read() throws IOException {
            return 0;
        }
    };
    TextView t;
    TextView t2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.doc);
        this.t = (TextView) findViewById(R.id.t);
        this.t2 = (TextView) findViewById(R.id.t0);
        getWindow().addFlags(128);
        this.t2.setText("Xuan Kong Feng Shui");
        this.in = getResources().openRawResource(R.raw.phong);
        try {
            byte[] bArr = new byte[this.in.available()];
            do {
            } while (this.in.read(bArr) != -1);
            this.t.setText(new String(bArr));
        } catch (IOException e) {
        }
        this.t.setTextSize(1, 17.0f);
    }
}
