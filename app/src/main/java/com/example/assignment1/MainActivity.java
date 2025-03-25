
//----------------- Assignment number 1 - Yarden Golani -----------------
package com.example.assignment1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    // Local variables
    private EditText editTextInput;
    private Spinner spinnerConversion;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerConversion = findViewById(R.id.spinnerConversion);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversion.setAdapter(adapter);

        // Set the button click listener
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String input = editTextInput.getText().toString();
        if (input.isEmpty()) {
            textViewResult.setText("Please enter a value!");
            return;
        }
        double value = Double.parseDouble(input);
        String type = spinnerConversion.getSelectedItem().toString();
        double result;
        String unit = "";

        switch (type) {
            case "Centimeter to Meter":
                result = value / 100;
                unit = " m";
                break;
            case "Meter to Kilometer":
                result = value / 1000;
                unit = " km";
                break;
            case "Celsius to Fahrenheit":
                result = (value * 9.0 / 5.0) + 32;
                unit = " °F";
                break;
            case "Fahrenheit to Celsius":
                result = (value - 32) * 5.0 / 9.0;
                unit = " °C";
                break;
            case "Gram to Kilogram":
                result = value / 1000;
                unit = " kg";
                break;
            default:
                return;
        }
        textViewResult.setText("Result: " + result + unit);
    }
}
