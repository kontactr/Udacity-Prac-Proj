package com.example.yash.samplefragment;

import android.app.*;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll1,new BlankFragment(),"frag1");
        fragmentTransaction.addToBackStack("frag1");
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();



        BlankFragment blankFragment = (BlankFragment) fragmentManager.findFragmentByTag("frag1");
        Log.i("Frag1",""+ fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());



        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll1,new BlankFragment(),"frag2");
        fragmentManager.popBackStack();
        fragmentTransaction.addToBackStack("frag2");
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

        Log.i("Frag1",""+ fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());



        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list_view1,new ListFragment(),"list_frag");
        fragmentTransaction.addToBackStack("list_frag");
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

        Log.i("Frag1",""+ fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());

        //ListView listView = findViewById(R.id.frag_list);



        //Log.i("Frag1",""+listView);

        //fragmentManager.executePendingTransactions();



    }
}
