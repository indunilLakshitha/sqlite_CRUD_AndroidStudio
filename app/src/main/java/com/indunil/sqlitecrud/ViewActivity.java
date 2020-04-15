package com.indunil.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    RecyclerView his;
    Button click;
    TextView history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        click=(Button)findViewById(R.id.btnGetHistory);
        history=(TextView) findViewById(R.id.txthis);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showHistory();
            }
        });

    }


    public  void showHistory(){
        try {
            DB DBObject=new DB(ViewActivity.this);
            SQLiteDatabase sqLiteDatabase =DBObject.getReadableDatabase();
            if(sqLiteDatabase!=null){
                Cursor cursor =sqLiteDatabase.rawQuery("select * from test_TB",null);
                StringBuffer stringBuffer=new StringBuffer();
                if(cursor.getCount()==0){
                    Toast.makeText(ViewActivity.this,"no data returned",Toast.LENGTH_LONG).show();

                }
                else {
                    while (cursor.moveToNext())
                    {
                        stringBuffer.append("ID: "+cursor.getInt(0)+"\n");
                        stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                        stringBuffer.append("Mobile: "+cursor.getString(2)+"\n");
                        stringBuffer.append("Email: "+cursor.getString(3)+"\n");
                        stringBuffer.append("Address: "+cursor.getString(4)+"\n");
                    }
                    history.setText(stringBuffer);

                }
            }
            else {
                Toast.makeText(ViewActivity.this,"database is null",Toast.LENGTH_LONG).show();

            }
        }
        catch (Exception e){

        }
    }
}
