package edu.cnm.deepdive.unitconverter;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner fromSpinner = findViewById(R.id.spinner_from);
        Spinner toSpinner = findViewById(R.id.spinner_to);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
    }
public void convert(View view) {

    Spinner fromSpinner = findViewById(R.id.spinner_from);
    Spinner toSpinner = findViewById(R.id.spinner_to);
    EditText fromEditText = (EditText) findViewById(R.id.editText_from);
    EditText toEditText = (EditText) findViewById(R.id.editText_to);

    // Get the string from the Spinners and number from the EditText
    String fromString = (String) fromSpinner.getSelectedItem();
    String toString = (String) toSpinner.getSelectedItem();
    double input = Double.valueOf(fromEditText.getText().toString());

    // Convert the strings to something in our Unit enu,
    Unit fromUnit = Unit.fromString(fromString);
    Unit toUnit = Unit.fromString(toString);

    // Create a converter object and convert!
    Converter converter = new Converter(fromUnit, toUnit);
    double result = converter.convert(input);
    toEditText.setText(String.valueOf(result));

}

}
