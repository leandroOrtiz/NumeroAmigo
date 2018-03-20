package com.leodrumers.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.leodrumers.spinner.Operate;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    EditText first, second;
    TextView answer;
    Operate option = new Operate();

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
        double result;
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

                    answer.setText("El resultado es " + Long.toString((int) firstNumber,(int) secondNumber));
                    break;
                case 2:
                    if (option.multiple(firstNumber,secondNumber))
                        answer.setText(secondNumber + " es multiplo de: "+ firstNumber);
                    else
                        answer.setText(secondNumber + " No es multiplo de: "+ firstNumber);
                    break;
                case 3:
                    if(option.friends(firstNumber) == secondNumber && option.friends(secondNumber) == firstNumber ){
                        answer.setText("Los numero son amigos");
                    }
                    else{
                        answer.setText("Los numeros no son amigos");
                    }
                    break;
                case 4:
                    result =  option.potency(firstNumber,secondNumber);
                    answer.setText("El resultado es " + result);
                    break;
                default:
                    //Toast.makeText(getBaseContext(), "Seleccione una obcion valida " + op, Toast.LENGTH_LONG).show();

            }
        }
    }


}
