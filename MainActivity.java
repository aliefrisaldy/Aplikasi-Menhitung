package com.example.aplikasihitung;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLenght = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            boolean isEmptyfields = false;
            if (TextUtils.isEmpty(inputLenght)){
                isEmptyfields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmptyfields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyfields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyfields){
                double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputHeight) * Double.parseDouble(inputWidth);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
