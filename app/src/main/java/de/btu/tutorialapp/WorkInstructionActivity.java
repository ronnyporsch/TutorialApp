package de.btu.tutorialapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import de.btu.tutorialapp.databinding.ActivityWorkInstructionBinding;

/**
 * this activity is used to display work instructions to the user
 */
public class WorkInstructionActivity extends AppCompatActivity {

    ActivityWorkInstructionBinding binding;

    private final List<WorkInstruction> workInstructionsToDisplay = new LinkedList<>();
    private int currentWorkInstructionToDisplay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGUI();
        initWorkInstructions();
        updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
    }

    /**
     * adds all work instructions that are to be displayed to a list. the order in which the work instructions
     * are displayed corresponds to their position in the list
     */
    private void initWorkInstructions() {
        workInstructionsToDisplay.add(new WorkInstruction("use the screwdriver", ContextCompat.getDrawable(getApplicationContext(), R.drawable.screwdriver)));
        workInstructionsToDisplay.add(new WorkInstruction("take a break", ContextCompat.getDrawable(getApplicationContext(), R.drawable.break_icon)));
        workInstructionsToDisplay.add(new WorkInstruction("use the chainsaw", ContextCompat.getDrawable(getApplicationContext(), R.drawable.chainsaw)));
    }

    /**
     * initializes the graphical user interface by binding it to a layout file and setting onClickListeners for all buttons
     */
    private void initGUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_instruction);
        binding.buttonNext.setOnClickListener(v -> {
            if (currentWorkInstructionToDisplay < workInstructionsToDisplay.size() - 1) {
                currentWorkInstructionToDisplay++;
                updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
            } else
                Toast.makeText(getApplicationContext(), "all instructions have been completed", Toast.LENGTH_SHORT).show();
        });

        binding.buttonPrevious.setOnClickListener(v -> {
            if (currentWorkInstructionToDisplay > 0) {
                currentWorkInstructionToDisplay--;
                updateDisplayedWorkInstruction(currentWorkInstructionToDisplay);
            } else
                Toast.makeText(getApplicationContext(), "this is the first instruction", Toast.LENGTH_SHORT).show();
        });

        binding.buttonQuit.setOnClickListener(v -> finish());
    }

    /**
     * updates the imageView and textView with a new work instruction
     * @param numberOfTheInstruction the position in the list of work instructions that shall be displayed
     */
    private void updateDisplayedWorkInstruction(int numberOfTheInstruction) {
        binding.textViewWorkDescription.setText(String.format(Locale.getDefault(), "Step %d: %s", numberOfTheInstruction + 1, workInstructionsToDisplay.get(numberOfTheInstruction).getDescription()));
        binding.imageView.setImageDrawable(workInstructionsToDisplay.get(numberOfTheInstruction).getImage());
    }


}