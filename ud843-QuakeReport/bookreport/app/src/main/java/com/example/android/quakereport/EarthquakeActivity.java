/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<List<Book>>{

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    ArrayAdapter<Book> baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ListView listView  = (ListView)findViewById(R.id.listview1);
        listView.setEmptyView(((TextView)findViewById(R.id.zero)));
        baseAdapter  = new BookAdapter(getApplicationContext(), new ArrayList<Book>());
        listView.setAdapter(baseAdapter);



        ((Button)findViewById(R.id.search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String make_ori_url = "https://www.googleapis.com/books/v1/volumes?q=" +
                        ((EditText)findViewById(R.id.editText1)).getText().toString()+"&maxResults=10";

                Bundle bundle = new Bundle();
                bundle.putString("url",make_ori_url);

               // if(getSupportLoaderManager().getLoader(0) == null){
               //     getLoaderManager().initLoader(0,bundle,EarthquakeActivity.this).forceLoad();
                //}else{
                    getLoaderManager().restartLoader(0,bundle,EarthquakeActivity.this).forceLoad();
                //}


            }
        });


    }

    public void updateUI(List<Book> bookList)
    {

        baseAdapter.clear();

        ListView listView = (ListView)findViewById(R.id.listview1);

        ((TextView)findViewById(R.id.zero)).setText("No Results");

        if (bookList != null && !bookList.isEmpty()) {
            baseAdapter.addAll(bookList);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = ((Book) baseAdapter.getItem(position)).getMbookURL();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        }); }

    }



    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {

        findViewById(R.id.progress).setVisibility(View.VISIBLE);
        baseAdapter.clear();
        return new BookLoader(getApplicationContext(),args.getString("url"));
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
            Log.i("Log-Result-",data.get(0).getMbookName());
            findViewById(R.id.progress).setVisibility(View.INVISIBLE);
            updateUI(data);




    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
            loader = null;
    }
}
