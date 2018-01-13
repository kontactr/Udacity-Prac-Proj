package com.example.android.quakereport;

public class Book
{
    String mbookName;
    String mauthorName;
    String mbookURL;


    public Book(String mbookName, String mauthorName, String mbookURL) {
        this.mbookName = mbookName;
        this.mauthorName = mauthorName;
        this.mbookURL = mbookURL;
    }

    public String getMbookName() {
        return mbookName;
    }

    public void setMbookName(String mbookName) {
        this.mbookName = mbookName;
    }

    public String getMauthorName() {
        return mauthorName;
    }

    public void setMauthorName(String mauthorName) {
        this.mauthorName = mauthorName;
    }

    public String getMbookURL() {
        return mbookURL;
    }

    public void setMbookURL(String mbookURL) {
        this.mbookURL = mbookURL;
    }
}