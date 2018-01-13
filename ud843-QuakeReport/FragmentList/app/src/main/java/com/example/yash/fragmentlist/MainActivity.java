package com.example.yash.fragmentlist;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.add(R.id.linear_layout_1,new BlankFragment(),"frag_list");
        //ft.addToBackStack("frag_list");
        //ft.commit();
        //getFragmentManager().executePendingTransactions();
        FragmentManager fragmentManager = getSupportFragmentManager();
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(fragmentManager));
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {


                    if (position == 0){
                      BlankFragment blankFragment = (BlankFragment)  getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":" + position);
                      blankFragment.setData("Hello Worlddddd");
                    }else{
                        BlankFragment blankFragment = (BlankFragment)  getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":" + position);
                        blankFragment.setData("Hello Worlllllllllllld");
                    }

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });






    }


    @Override
    protected void onResume() {
        super.onResume();


        //Toast.makeText(getApplicationContext(),""+((TextView)findViewById(R.id.text_view_frag)),Toast.LENGTH_SHORT).show();

      /*  ListView listView = findViewById(R.id.list_view1);
        ArrayList<String > arrayList = new ArrayList<>(5);
        for (int k=0;k<5;k++)
            arrayList.add(""+k);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,
                arrayList);

        listView.setAdapter(arrayAdapter);*/

    }
}
