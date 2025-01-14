package com.lokesh.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Text text;
    EditText editText;
    Button add,sub,Mult,Div,one,two,three,clear,four,five,six,equle,seven,eight,nine,zero;
    String input="";
    String operation="";
    double num1=0 ,num2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        Mult=findViewById(R.id.Mult);
        Div=findViewById(R.id.Div);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        clear=findViewById(R.id.clear);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        equle=findViewById(R.id.equle);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);

        View.OnClickListener numberListener= new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button button=(Button) v;
                input+=button.getText().toString();
                editText.setText(input);

            }
        };

        one.setOnClickListener(numberListener);
        two.setOnClickListener(numberListener);
        three.setOnClickListener(numberListener);
        four.setOnClickListener(numberListener);
        five.setOnClickListener(numberListener);
        six.setOnClickListener(numberListener);
        seven.setOnClickListener(numberListener);
        eight.setOnClickListener(numberListener);
        nine.setOnClickListener(numberListener);
        zero.setOnClickListener(numberListener);

        View.OnClickListener operetorLister = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Button button=(Button) v;
                if (!input.isEmpty()){
                    num1=Double.parseDouble(input);
                    operation=button.getText().toString();
                    editText.setText(operation);
                    input="";
                }
            }
        };
        add.setOnClickListener(operetorLister);
        sub.setOnClickListener(operetorLister);
        Mult.setOnClickListener(operetorLister);
        Div.setOnClickListener(operetorLister);

        equle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!input.isEmpty() && !operation.isEmpty()){
                    num2=Double.parseDouble(input);
                    double result=calculate(num1,num2,operation);
                    editText.setText(String.valueOf(result));
                    input=String.valueOf(result);
                    operation="";
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                input="";
                operation="";
                num1=num2=0;
                editText.setText("");

            }
        });
    }
    public double calculate(double a, double b, String op){
        switch (op){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;

        }

    }
}