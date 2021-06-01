package de.btu.tutorialapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import de.btu.tutorialapp.databinding.ActivityMainBinding;

/**
 * this is the entrypoint of the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.buttonStartWorkInstructions.setOnClickListener(v -> startWorkInstructionActivity());
    }

    /**
     * calls another window which is then used to display work instructions
     */
    private void startWorkInstructionActivity() {
        Intent intent = new Intent(this, WorkInstructionActivity.class);
        startActivity(intent);
    }
}