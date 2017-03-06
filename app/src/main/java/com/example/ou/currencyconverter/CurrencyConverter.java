package com.example.ou.currencyconverter;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter extends AppCompatActivity {
    Button btnClear, btnConverter;
    EditText edtDollars, edtVnds;
    private final double USD2VND = 22850;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnConverter = (Button)findViewById(R.id.btnConverter);
        edtDollars = (EditText)findViewById(R.id.edtDollars);
        edtVnds = (EditText)findViewById(R.id.edtVnds);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtVnds.setText("");
                edtDollars.setText("");
            }
        });
        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usdStr = edtDollars.getText().toString();
                double usd = Double.valueOf(usdStr);
                double vnd = usd * USD2VND;
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
                String vndStr = String.valueOf(nf.format(vnd));
                edtVnds.setText(vndStr);
            }
        });
    }


}
