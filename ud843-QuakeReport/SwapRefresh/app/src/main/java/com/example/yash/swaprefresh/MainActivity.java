package com.example.yash.swaprefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


class element{
   static boolean flag = false;
}



public class MainActivity extends AppCompatActivity {

    int i = 0;

    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         swipeRefreshLayout =  findViewById(R.id.srefresh1);
        textView = ((TextView)findViewById(R.id.text1));
         swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.GRAY,Color.GREEN,Color.CYAN);

         new Thread(){
             public void run()
             {
                 for (int i1 =0 ; i1<5; i1++) {
                     try {

                         Log.i("Log-Thread-1",Thread.currentThread().getName());
                         Thread.sleep(1000);

                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 element.flag = true;
             }


         }.start();

        updateUI();



         /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                TextView textView =  findViewById(R.id.text1);
                for(int j=0;j<100000;j++)
                    textView.setText(""+Thread.currentThread().getName());
               // updateUI();





            }

    });*/
}

    private void updateUI()  {
        //swipeRefreshLayout.setRefreshing(false);
        while (!element.flag){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textView.setText(""+i++);

        }
        Toast.makeText(getApplicationContext(),""+element.flag,Toast.LENGTH_SHORT).show();
    }
}
