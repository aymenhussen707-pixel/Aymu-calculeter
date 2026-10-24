package com.aymu.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    EditText first, second;
    TextView result;
    Spinner operation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 40, 24, 24);

        TextView title = new TextView(this);
        title.setText("AYMU CALCULATOR");
        title.setTextSize(26);
        layout.addView(title);

        first = new EditText(this);
        first.setHint("First number");
        first.setInputType(8194);
        layout.addView(first);

        operation = new Spinner(this);
        String[] ops = {"+", "-", "×", "÷"};
        operation.setAdapter(new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item, ops));
        layout.addView(operation);

        second = new EditText(this);
        second.setHint("Second number");
        second.setInputType(8194);
        layout.addView(second);

        Button calculate = new Button(this);
        calculate.setText("CALCULATE");
        layout.addView(calculate);

        result = new TextView(this);
        result.setTextSize(22);
        layout.addView(result);

        calculate.setOnClickListener(v -> calculate());
        setContentView(layout);
    }

    void calculate() {
        try {
            double a = Double.parseDouble(first.getText().toString());
            double b = Double.parseDouble(second.getText().toString());
            String op = operation.getSelectedItem().toString();
            double r;

            switch (op) {
                case "+": r = a + b; break;
                case "-": r = a - b; break;
                case "×": r = a * b; break;
                case "÷":
                    if (b == 0) {
                        result.setText("Cannot divide by zero");
                        return;
                    }
                    r = a / b;
                    break;
                default: return;
            }
            result.setText("Result: " + r);
        } catch (Exception e) {
            result.setText("Enter both numbers");
        }
    }
}
