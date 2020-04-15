package com.indunil.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,email,mobile, address;
Button save,history,adapterShow;
    DB Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=(Button)findViewById(R.id.btnUp);
        history=(Button)findViewById(R.id.btnHis);
        adapterShow=(Button)findViewById(R.id.btnAdapterView);
        name=(EditText) findViewById(R.id.txtName);
        email=(EditText) findViewById(R.id.txtEmail);
        mobile=(EditText) findViewById(R.id.txtMobile);
        address =(EditText) findViewById(R.id.txtAdress);

        Db=new DB(MainActivity.this);
        createDb();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String m=mobile.getText().toString();
                String a= address.getText().toString();
                saveValues(n,m,e,a);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistory();
            }
        });
        adapterShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowValues();
            }
        });
    }

    public void createDb(){
        try
        {
            Db.getReadableDatabase();
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();

        }
    }
    public void saveValues(String name, String mobile,String email,String adress){
        try
        {
            SQLiteDatabase sq=Db.getWritableDatabase();
            if(sq!=null){
                ContentValues contentValues=new ContentValues();
                contentValues.put("Name",name);
                contentValues.put("Mobile",mobile);
                contentValues.put("Email",email);
                contentValues.put("Address",adress);
                long checkIfWueryRuns= sq.insert("test_TB",null,contentValues);
                if(checkIfWueryRuns!=-1){
                    Toast.makeText(MainActivity.this,"Values Inserted",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this,"Values not inserted",Toast.LENGTH_LONG).show();

                }
            }
            else {
                Toast.makeText(MainActivity.this,"Database is null",Toast.LENGTH_LONG).show();

            }
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();

        }
    }


    public void openHistory(){
        Intent h=new Intent(MainActivity.this,ViewActivity.class);
        startActivity(h);
    }
    public void openShowValues(){
        Intent h=new Intent(MainActivity.this,ShowValuesActivity.class);
        startActivity(h);
    }
}
