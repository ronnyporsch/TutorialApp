package de.btu.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class WorkInstructionActivity extends AppCompatActivity {


    private Button buttonQuit;
    private Button buttonNext;
    private Button buttonPrevious;
    private ImageView imageView;
    private TextView textView;

    private List<WorkInstruction> workInstructionsToDisplay = new LinkedList<>();
    private int currentWorkInstructionToDisplay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGUI();
        initWorkInstructions();
        updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
    }

    private void initWorkInstructions() {
        workInstructionsToDisplay.add(new WorkInstruction("use the screwdriver", ContextCompat.getDrawable(getApplicationContext(), R.drawable.screwdriver)));
        workInstructionsToDisplay.add(new WorkInstruction("take a break", ContextCompat.getDrawable(getApplicationContext(), R.drawable.btu_logo)));
        workInstructionsToDisplay.add(new WorkInstruction("use the chainsaw", ContextCompat.getDrawable(getApplicationContext(), R.drawable.chainsaw)));
    }

    private void initGUI() {
        setContentView(R.layout.activity_work_instruction);
        buttonQuit = findViewById(R.id.button_quit);
        buttonNext = findViewById(R.id.button_switch_to_next_instruction);
        buttonPrevious = findViewById(R.id.button_switch_to_previous_instruction);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView_work_instruction);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentWorkInstructionToDisplay < workInstructionsToDisplay.size() - 1) {
                    currentWorkInstructionToDisplay++;
                    updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
                } else
                    Toast.makeText(getApplicationContext(), "all instructions have been completed", Toast.LENGTH_SHORT).show();
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentWorkInstructionToDisplay > 0) {
                    currentWorkInstructionToDisplay--;
                    updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
                } else
                    Toast.makeText(getApplicationContext(), "this is the first instruction", Toast.LENGTH_SHORT).show();
            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateDisplayedWorkInstruction(int numberOfTheInstruction) {
        textView.setText(workInstructionsToDisplay.get(numberOfTheInstruction).getDescription());
        imageView.setImageDrawable(workInstructionsToDisplay.get(numberOfTheInstruction).getImage());
    }


}