package com.example.android.quakereport;


import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>>{

    String make_ori_url;

    public BookLoader(Context context, String make_ori_url) {
        super(context);
        this.make_ori_url = make_ori_url;
    }

    @Override
    public List<Book> loadInBackground() {
         return  QuaryUtils.parseBookJson(QuaryUtils.makeHttp(QuaryUtils.makeUrl(make_ori_url)));
    }
}