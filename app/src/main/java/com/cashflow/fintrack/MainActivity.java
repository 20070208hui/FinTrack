package com.cashflow.fintrack;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        }

        public void onClick(View view){
            if(view.getId() == R.id.main_btn_menu){

            }
            else if(view.getId() == R.id.main_btn_statistic){

            }
            else if (view.getId() == R.id.main_btn_add) {

                Intent it2 = new Intent(this, recordingActivity.class);
                startActivity(it2);
            } else if (view.getId() == R.id.main_btn_profile) {

            }
            else if (view.getId() == R.id.main_btn_setting){

            }
        }
    }

