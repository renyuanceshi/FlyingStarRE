package m.e.huyen2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class luu extends Activity {
    Button b1;
    Button b2;
    Button b3;
    String chi;
    EditText e;
    String list;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.luu);
        this.e = (EditText) findViewById(R.id.e1);
        this.b1 = (Button) findViewById(R.id.b1);
        this.chi = getIntent().getExtras().getString("giocz");
        this.b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String editable = luu.this.e.getText().toString();
                if (editable == null || editable.trim().equals("")) {
                    Toast.makeText(luu.this, "Please enter name of house", 0).show();
                    return;
                }
                luu.this.list = "House of " + editable + ", " + luu.this.chi;
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(luu.this.openFileOutput("danhsach.txt", 32768));
                    outputStreamWriter.append(String.valueOf(luu.this.list) + "\n");
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                luu.this.setResult(3, luu.this.getIntent());
                luu.this.finish();
                Toast.makeText(luu.this, "Data saved", 0).show();
                ((InputMethodManager) luu.this.getSystemService("input_method")).hideSoftInputFromWindow(luu.this.e.getWindowToken(), 0);
            }
        });
        this.b2 = (Button) findViewById(R.id.b2);
        this.b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                luu.this.finish();
            }
        });
    }
}
