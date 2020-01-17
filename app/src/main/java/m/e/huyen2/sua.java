package m.e.huyen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class sua extends Activity {
    private ArrayAdapter<String> adap2;
    private ArrayAdapter<String> adap3;
    private ArrayAdapter<String> adap4;
    private ArrayAdapter<String> adap5;
    private ArrayAdapter<String> adapter;
    Button b1;
    Button b2;
    ArrayList<String> co = new ArrayList<>();
    ArrayList<String> col = new ArrayList<>();
    String[] data = {"4(1924-1943)", "5(1944-1963)", "6(1964-1983)", "7(1984-2003)", "8(2004-2023)", "9(2024-2043)", "1(2044-2063)", "2(2064-2083)", "3(2084-2103)"};
    String[] data2 = {"357-3", "4-7.5", "7.5-11", "12-18", "19-22.5", "22.5-26", "27-33", "34-37.5", "37.5-41", "42-48", "49-52.5", "52.5-56", "57-63", "64-67.5", "67.5-71", "72-78", "79-82.5", "82.5-86", "87-93", "94-97.5", "97.5-101", "102-108", "109-112.5", "112.5-116", "117-123", "124-127.5", "127.5-131", "132-138", "139-142.5", "142.5-146", "147-153", "154-157.5", "157.5-161", "162-168", "169-172.5", "172.5-176", "177-183", "184-187.5", "187.5-191", "192-198", "199-202.5", "202.5-206", "207-213", "214-217.5", "217.5-221", "222-228", "229-232.5", "232.5-236", "237-243", "244-247.5", "247.5-251", "252-258", "259-262.5", "262.5-266", "267-273", "274-277.5", "277.5-281", "282-288", "289-292.5", "292.5-296", "297-303", "304-307.5", "307.5-311", "312-318", "319-322.5", "322.5-326", "327-333", "334-337.5", "337.5-341", "342-348", "349-352.5", "352.5-356"};
    EditText e;
    EditText e2;
    String giod;
    String giv;
    /* access modifiers changed from: private */
    public Spinner sp;
    /* access modifiers changed from: private */
    public Spinner sp2;
    private Spinner sp3;
    private Spinner sp4;
    private Spinner sp5;
    TextView t;
    int thudo;
    int thuvan;
    int x3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sua);
        Bundle extras = getIntent().getExtras();
        this.x3 = extras.getInt("giocz");
        this.col = extras.getStringArrayList("ghi");
        String[] split = this.col.get(this.x3).split(",");
        String trim = split[1].trim().split(" ")[0].trim();
        String str = split[2].trim().split(" ")[1];
        for (int i = 0; i < this.data2.length; i++) {
            if (trim.equals(this.data2[i])) {
                this.thudo = i;
            }
        }
        for (int i2 = 0; i2 < this.data.length; i2++) {
            if (str.equals(this.data[i2])) {
                this.thuvan = i2;
            }
        }
        this.e2 = (EditText) findViewById(R.id.e2);
        this.e2.setText(split[0]);
        this.b1 = (Button) findViewById(R.id.b1);
        this.sp = (Spinner) findViewById(R.id.spin1);
        this.sp2 = (Spinner) findViewById(R.id.spin2);
        this.adapter = new ArrayAdapter<>(this, R.layout.spint, R.id.te, this.data);
        this.adap2 = new ArrayAdapter<>(this, R.layout.spint2, R.id.te2, this.data2);
        this.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                sua.this.giv = sua.this.sp.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp.setAdapter(this.adapter);
        this.sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                sua.this.giod = sua.this.sp2.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp2.setAdapter(this.adap2);
        this.sp.setSelection(this.thuvan);
        this.sp2.setSelection(this.thudo);
        this.b2 = (Button) findViewById(R.id.b2);
        this.b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sua.this.finish();
            }
        });
        this.b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    String editable = sua.this.e2.getText().toString();
                    if (editable == null || editable.trim().equals("")) {
                        Toast.makeText(sua.this, "Please enter the name", 0).show();
                        return;
                    }
                    sua.this.deleteFile("danhsach.txt");
                    sua.this.col.set(sua.this.x3, String.valueOf(editable) + ", " + sua.this.giod + " degrees, " + "period " + sua.this.giv);
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(sua.this.openFileOutput("danhsach.txt", 32768));
                        for (int i = 0; i < sua.this.col.size(); i++) {
                            outputStreamWriter.append(String.valueOf(sua.this.col.get(i)) + "\n");
                        }
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    Toast.makeText(sua.this, "Data changed", 0).show();
                    Intent intent = sua.this.getIntent();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("iz", sua.this.col);
                    intent.putExtras(bundle);
                    sua.this.setResult(3, intent);
                    sua.this.finish();
                } catch (NumberFormatException e3) {
                    Toast.makeText(sua.this, "N\u0103m nh\u1eadp v\u00e0o kh\u00f4ng h\u1ee3p l\u1ec7", 0).show();
                    e3.printStackTrace();
                }
            }
        });
        this.b1.setTextSize(1, 15.0f);
        this.b2.setTextSize(1, 15.0f);
    }
}
