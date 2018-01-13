package com.example.yash.ownonclick;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yash on 10-01-2018.
 */

public class Sample extends View implements View.OnClickListener {

    int a;
    CustomInterface customInterface;
    int ui = 0;
    TextView textView;


    public Sample(Context c, int a) {
        super(c);
        textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setBackgroundColor(Color.WHITE);
        this.a = a;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i(":MainAct",""+widthMeasureSpec+"   "+heightMeasureSpec);
        super.onMeasure(widthMeasureSpec / 2,heightMeasureSpec / 2   );
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setCustomInterface(CustomInterface customInterface){
        this.customInterface = customInterface;
        setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        textView.setText(""+(ui++));
        Toast.makeText(getContext(),"Arrived",Toast.LENGTH_LONG).show();
        Sample sample = (Sample)view;

        sample.customInterface.ownOnClick();
    }
}
