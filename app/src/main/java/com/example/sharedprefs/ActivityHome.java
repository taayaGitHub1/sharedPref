package com.example.sharedprefs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {
    Button homeAddData;
    TextView homeTotalStudentCount;
    ListView homeListViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeAddData = findViewById(R.id.addDataButton);
        homeTotalStudentCount = findViewById(R.id.totalStudentCount);
        homeListViewData = findViewById(R.id.listViewData);

        homeAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityHome.this);
                LayoutInflater inflater = getLayoutInflater();
                View convetview = inflater.inflate(R.layout.add_data, null);
                builder.setView(convetview);
                AlertDialog a = builder.create();
                a.show();

                //add_data ko component haru tanera link garya using convetview by id
                EditText name, faculty, address;
                Button cancelbtn, savebtn;

                name = convetview.findViewById(R.id.Name);
                faculty = convetview.findViewById(R.id.Faculty);
                address = convetview.findViewById(R.id.Address);
                cancelbtn = convetview.findViewById(R.id.cancelButton);
                savebtn = convetview.findViewById(R.id.saveButton);

                cancelbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.dismiss();
                    }
                });

                savebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseModel data = new DatabaseModel();
                        data.setName(name.getText().toString());
                        data.setAddress(address.getText().toString());
                        data.setFaculty(faculty.getText().toString());

                        DatabaseHelper he = new DatabaseHelper(ActivityHome.this);
                        he.insertData(data);
                        a.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<DatabaseModel> data = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(ActivityHome.this);
        data = db.readData();
        homeTotalStudentCount.setText("total students = "+data.size());
    }
}
