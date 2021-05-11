package de.btu.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        Button button = findViewById(R.id.button_start_work_instructions);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWorkInstructions();
            }
        });
    }

    private void startWorkInstructions() {
        Intent intent = new Intent(this, WorkInstructionActivity.class);
        startActivity(intent);
    }
}