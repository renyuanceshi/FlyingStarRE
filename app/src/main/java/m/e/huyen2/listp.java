package m.e.huyen2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class listp extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] item;
    int so;

    public listp(Activity activity, String[] strArr, int i) {
        super(activity, R.layout.lim, strArr);
        this.so = i;
        this.context = activity;
        this.item = strArr;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.context.getLayoutInflater().inflate(R.layout.lim, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(R.id.tem);
        textView.setText(this.item[i]);
        textView.setTextSize(1, 15.0f);
        if (this.so == 1) {
            textView.setTextColor(Color.parseColor("#8C001A"));
        }
        return inflate;
    }
}
