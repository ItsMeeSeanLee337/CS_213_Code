package com.example.fc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FC extends AppCompatActivity {

    Button f2c, c2f;
    EditText fval, cval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc);

        f2c = findViewById(R.id.f2c);
        c2f = findViewById(R.id.c2f);
        fval = findViewById(R.id.fval);
        cval = findViewById(R.id.cval);

        f2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float fv = Float.parseFloat(fval.getText().toString());
                    float cv = (fv - 32) * 5 / 9;
                    String cvtxt = String.format("%5.1f", cv);
                    cval.setText(cvtxt);
                } catch (Exception e) {
                    Toast.makeText(FC.this, "Incorrect fahrenheit value", Toast.LENGTH_LONG).show();
                }
            }
        });

        c2f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float cv = Float.parseFloat(cval.getText().toString());
                    float fv = cv*9/5 + 32;
                    String fvtxt = String.format("%5.1f", fv);
                    fval.setText(fvtxt);
                } catch (Exception e) {
                    Toast.makeText(FC.this, "Incorrect celsius value", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}