package com.example.android.quakereport;

import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuaryUtils {

    @Nullable
    public static URL makeUrl(String url)
    {
        try {

            return new URL(url.replaceAll(" ", "%20"));
        } catch (MalformedURLException e) {
            Log.i("Exception-",e.toString());
        }
        return null;
    }

    public static String makeHttp(URL url)
    {
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        String response = "";




        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200)
            {
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp = bufferedReader.readLine();
                while (temp != null)
                {
                    response += temp;
                    temp = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {

        }finally {
            httpURLConnection.disconnect();
            return response;
        }


    }

    public static List<Book> parseBookJson(String response)
    {
        List<Book> bookList = new ArrayList<Book>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0 ; i < (10 < jsonArray.length()  ? 10 : jsonArray.length()) ; i++ )
            {
                jsonObject = jsonArray.getJSONObject(i);
                String book_url = jsonObject.getJSONObject("accessInfo").getString("webReaderLink");
                jsonObject = jsonObject.getJSONObject("volumeInfo");
                String book_name = jsonObject.getString("title");
                JSONArray jsonArray1 = jsonObject.getJSONArray("authors");
                String book_author = "";
                for (int i1 = 0 ; i1 < (2 < jsonArray1.length() ? 2 : jsonArray1.length()); i1++)
                        book_author += jsonArray1.getString(i1) + " ";


                bookList.add(new Book(book_name , book_author , book_url));

            }
                return bookList;

        } catch (JSONException e) {
            return null;
        }


    }




} 