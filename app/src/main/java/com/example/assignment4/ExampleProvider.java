package com.example.assignment4;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.Nullable;

public class ExampleProvider extends ContentProvider {
    static final Uri CONTENT_URI = Uri.parse("content://com.example.assignment4.ExampleProvider/currencies");

    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        db = getContext().openOrCreateDatabase("bank", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS currencies");

        db.execSQL("CREATE TABLE currencies(" +
                "id INT NOT NULL PRIMARY KEY, " +
                "name VARCHAR(32), " +
                "color VARCHAR(32))");

        db.execSQL("INSERT INTO currencies VALUES(10, 'USD', 'The official currency of the United States introduced in 1972')");
        db.execSQL("INSERT INTO currencies VALUES(11, 'CAD', 'The official currency of Canada introduced in 1858')");
        db.execSQL("INSERT INTO currencies VALUES(12, 'Euro', 'The official currency of Europe introduced in 1999')");
        db.execSQL("INSERT INTO currencies VALUES(13, 'GBP', 'The official currency of Great Britain introduced in 1489')");
        db.execSQL("INSERT INTO currencies VALUES(14, 'CHF', 'The official currency of Switzerland introduced in 1798')");
        db.execSQL("INSERT INTO currencies VALUES(15, 'CNY', 'The official currency of China introduced in 1948')");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables("currencies");
        Cursor cr = null;

        if (uri.compareTo(CONTENT_URI) == 0)
            cr = queryBuilder.query(db, projection, selection, selectionArgs, null,
                    null, sortOrder);

        return cr;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
