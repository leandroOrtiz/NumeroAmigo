package com.leodrumers.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    EditText first, second;
    TextView answer;
    public int op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (EditText)findViewById(R.id.first);
        second = (EditText)findViewById(R.id.second);
        answer = (TextView)findViewById(R.id.answer);


        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.options,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


    }

    public void doit(View v){
        if (first.getText().toString().equals("") || second.getText().toString().equals("")){
            answer.setText("Ingrese un valor valido");
        }else {
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        op = (int) id;
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    //public void operar(double firstNumber, double secondNumber, long id){
    public void operar(View v){
        doit(v);
        if (first.getText().toString().equals("") || second.getText().toString().equals("")){
            answer.setText("Ingrese un valor valido");
        }else {
            final double firstNumber = Double.parseDouble(first.getText().toString());
            final double secondNumber = Double.parseDouble(second.getText().toString());

            double total = 0;
            if (op == 0) {
                answer.setText("Escoja una opcion Valida del Spinner");
            }
            //int op = (int) id;
            switch (op) {
                case 1:
                    total = firstNumber + secondNumber;
                    answer.setText("El resultado es " + total);
                    break;
                case 2:
                    total = firstNumber - secondNumber;
                    answer.setText("El resultado es " + total);
                    break;
                case 3:
                    total = firstNumber * secondNumber;
                    answer.setText("El resultado es " + total);
                    break;
                case 4:
                    if (secondNumber != 0) {
                        total = firstNumber / secondNumber;
                        answer.setText("El resultado es " + total);
                    } else {
                        answer.setText("No se puede dividir por 0");
                    }
                    break;
                default:
                    //Toast.makeText(getBaseContext(), "Seleccione una obcion valida " + op, Toast.LENGTH_LONG).show();

            }
        }
    }


}
