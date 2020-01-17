package m.e.huyen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class danhsach extends Activity {
    static int ag = 0;
    /* access modifiers changed from: private */
    public ArrayAdapter<String> adapter;
    ArrayList<String> az = new ArrayList<>();
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    ArrayList<String> col = new ArrayList<>();
    ArrayList<String> col2 = new ArrayList<>();
    int dem = 0;
    EditText e;
    /* access modifiers changed from: private */
    public ListView lv;
    String na6;
    TextView t;
    TextView t2;
    TextView t3;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == 3) {
                this.col.clear();
                this.col = intent.getExtras().getStringArrayList("iz");
                this.adapter = new li2(this, this.col);
                this.lv.setAdapter(this.adapter);
                this.lv.setItemChecked(ag, true);
            }
            if (i2 == 4) {
                this.col.clear();
                this.col = intent.getExtras().getStringArrayList("iz");
                this.adapter = new ArrayAdapter<>(this, 17367045, this.col);
                this.lv.setAdapter(this.adapter);
                int size = this.col.size();
                this.lv.setItemChecked(size - 1, true);
                ag = size - 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.danhsach);
        this.lv = (ListView) findViewById(R.id.list);
        this.lv.setChoiceMode(1);
        this.t = (TextView) findViewById(R.id.te);
        this.t2 = (TextView) findViewById(R.id.te2);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput("danhsach.txt")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                this.col.add(readLine);
            }
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.adapter = new li2(this, this.col);
        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                danhsach.ag = i;
                danhsach.this.dem = 1;
                danhsach.this.deleteFile("danh2.txt");
            }
        });
        this.lv.setAdapter(this.adapter);
        this.b3 = (Button) findViewById(R.id.b3);
        this.b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (danhsach.this.dem == 0) {
                    Toast.makeText(danhsach.this, "Choose one house", 0).show();
                    return;
                }
                danhsach.this.deleteFile("danhsach.txt");
                SparseBooleanArray checkedItemPositions = danhsach.this.lv.getCheckedItemPositions();
                for (int i = 0; i < danhsach.this.lv.getCount(); i++) {
                    if (checkedItemPositions.get(i)) {
                        danhsach.this.col.remove(i);
                    }
                    danhsach.this.adapter.notifyDataSetChanged();
                }
                danhsach.this.lv.clearChoices();
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(danhsach.this.openFileOutput("danh2.txt", 32768));
                    for (int i2 = 0; i2 < danhsach.this.col.size(); i2++) {
                        outputStreamWriter.append(String.valueOf(danhsach.this.col.get(i2)) + "\n");
                    }
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(danhsach.this.openFileInput("danh2.txt")));
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(danhsach.this.openFileOutput("danhsach.txt", 32768));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        outputStreamWriter2.append(String.valueOf(readLine) + "\n");
                        outputStreamWriter2.flush();
                    }
                    outputStreamWriter2.close();
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                danhsach.this.dem = 0;
                Toast.makeText(danhsach.this, "Data deleted", 0).show();
            }
        });
        this.b4 = (Button) findViewById(R.id.b4);
        this.b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                danhsach.this.finish();
            }
        });
        this.b2 = (Button) findViewById(R.id.b2);
        this.b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (danhsach.this.dem == 0) {
                    Toast.makeText(danhsach.this, "Choose one house", 0).show();
                    return;
                }
                Intent intent = new Intent(danhsach.this.getBaseContext(), sua.class);
                Bundle bundle = new Bundle();
                bundle.putInt("giocz", danhsach.ag);
                bundle.putStringArrayList("ghi", danhsach.this.col);
                intent.putExtras(bundle);
                danhsach.this.startActivityForResult(intent, 1);
            }
        });
        this.b1 = (Button) findViewById(R.id.b1);
        this.b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (danhsach.this.dem == 0) {
                    Toast.makeText(danhsach.this, "Choose one house", 0).show();
                    return;
                }
                Intent intent = danhsach.this.getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("giocz", danhsach.ag);
                bundle.putStringArrayList("ghi", danhsach.this.col);
                intent.putExtras(bundle);
                danhsach.this.setResult(3, intent);
                danhsach.this.finish();
            }
        });
        this.b1.setTextSize(1, 15.0f);
        this.b2.setTextSize(1, 15.0f);
        this.b3.setTextSize(1, 15.0f);
        this.b4.setTextSize(1, 15.0f);
    }
}
