package com.example.baac.baacrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by BAAC on 19/10/2558.
 */
public class OrderTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String ORDER_TABLE = "orderTABLE";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_OFFICER = "Officer";
    public static final String COLUMN_DESK = "Desk";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_ITEM = "Item";

    public OrderTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }//Constructor

    public long addNewOrder(String strOfficer, String strDesk, String strFood, String strItem) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_OFFICER, strOfficer);
        objContentValues.put(COLUMN_DESK, strDesk);
        objContentValues.put(COLUMN_FOOD, strFood);
        objContentValues.put(COLUMN_ITEM, strItem);

        return readSqLiteDatabase.insert(ORDER_TABLE, null, objContentValues);
    }


}
