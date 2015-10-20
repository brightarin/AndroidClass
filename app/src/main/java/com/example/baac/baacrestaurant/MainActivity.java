package com.example.baac.baacrestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private UserTABLE objUserTABLE;
    private FoodTABLE objFoodTABLE;
    private OrderTABLE objOrderTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected Database
        createAndConnected();

        //Tester Add New Value
        //testerAdd();

        //Delete All SQLite
        deleteALLSQLite();


    }/// Main Method

    private void deleteALLSQLite() {
        SQLiteDatabase objSQLiteDatabase = openOrCreateDatabase("BAAC.db", MODE_PRIVATE, null);
        objSQLiteDatabase.delete("userTABLE", null, null);
        objSQLiteDatabase.delete("foodTABLE", null, null);
    }

    private void testerAdd() {
        objUserTABLE.addNewUser("testUser", "testPassword", "ทดสอบภาษาไทย");
        objFoodTABLE.addNewFood("ต้มยำกุ้ง", "กุ้ง", "10000");
        objOrderTABLE.addNewOrder("A", "โต๊ะ5", "ต้มยำกุ้ง", "1");

    }

    private void createAndConnected() {

        objUserTABLE = new UserTABLE(this);
        objFoodTABLE = new FoodTABLE(this);
        objOrderTABLE = new OrderTABLE(this);

    }


}   //Main Class
