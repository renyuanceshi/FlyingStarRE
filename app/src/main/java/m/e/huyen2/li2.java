package m.e.huyen2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class li2 extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> item;

    public li2(Activity activity, ArrayList<String> arrayList) {
        super(activity, R.layout.li3, arrayList);
        this.context = activity;
        this.item = arrayList;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.context.getLayoutInflater().inflate(R.layout.li3, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(R.id.te);
        textView.setText(this.item.get(i));
        textView.setTextSize(1, 17.0f);
        return inflate;
    }
}
