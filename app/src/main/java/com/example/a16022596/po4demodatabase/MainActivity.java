package com.example.a16022596.po4demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnRetrieve;
    TextView tvResult;
    ArrayAdapter aa;
    ArrayList<Task>taskList;
    DBHelper db;
    ListView lvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DBHelper(this);
        db.getWritableDatabase();



        setContentView(R.layout.activity_main);
        btnInsert = (Button)findViewById(R.id.buttonInsert);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Contextw
                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnRetrieve = (Button)findViewById(R.id.buttonRetrieve);
        tvResult = (TextView)findViewById(R.id.textViewResult);
        lvResult = (ListView)findViewById(R.id.lvResult);


        btnRetrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResult.setText(txt);

                DBHelper db2 = new DBHelper(MainActivity.this);
                taskList = db2.getTasks();
                db2.close();
                aa = new TaskAdapter(MainActivity.this,R.layout.row,taskList);
                lvResult.setAdapter(aa);


            }
        });

    }
}
