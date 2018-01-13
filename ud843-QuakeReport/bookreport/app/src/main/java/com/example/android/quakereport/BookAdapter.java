package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book>
{
    List<Book> bookList;
    Context context;

    public BookAdapter(Context context , List<Book> bookList)
    {
        super(context,0,bookList);
        this.bookList = bookList;
        this.context = context;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            listItemView = layoutInflater.inflate(R.layout.book_list_items,null);
        }
        Book book = getItem(position);
        ((TextView)listItemView.findViewById(R.id.book_title)).setText(book.getMbookName());
        ((TextView)listItemView.findViewById(R.id.book_author)).setText(book.getMauthorName());

        return listItemView;
    }
}