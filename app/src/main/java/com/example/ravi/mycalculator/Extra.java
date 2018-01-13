package com.example.ravi.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.lang.Math;
import java.math.BigInteger;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by Ravi on 02-May-17.
 */

public class Extra extends AppCompatActivity {

    private DecimalFormat decimalFormat;
    Button basin,bacos,batan,bpow,bsin,bcos,btan,breci,blog,bln,bexp,bsqr,bsqrt,bcbrt,bans,bback;
    Double value1,value2;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        setContentView(R.layout.extra);

        basin=(Button)findViewById(R.id.basin);
        bacos=(Button)findViewById(R.id.bacos);
        batan=(Button)findViewById(R.id.batan);
        bpow=(Button)findViewById(R.id.bpow);
        bsin=(Button)findViewById(R.id.bsin);
        bcos=(Button)findViewById(R.id.bcos);
        btan=(Button)findViewById(R.id.btan);
        breci=(Button)findViewById(R.id.breci);
        blog=(Button)findViewById(R.id.blog);
        bln=(Button)findViewById(R.id.bln);
        bexp=(Button)findViewById(R.id.bexp);
        bsqr=(Button)findViewById(R.id.bsqr);
        bsqrt=(Button)findViewById(R.id.bsqrt);
        bcbrt=(Button)findViewById(R.id.bcbrt);
        bans=(Button)findViewById(R.id.bans);
        bback=(Button)findViewById(R.id.bback);
        t2=(TextView) findViewById(R.id.t2);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String value=bundle.getString("pass");

        value1=Double.parseDouble(value);

        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.sin(value1)));
            }
        });
        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.cos(value1)));
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.tan(value1)));
            }
        });
        basin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.asin(value1)));
            }
        });
        bacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.acos(value1)));
            }
        });
        batan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.atan(value1)));
            }
        });
        breci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value2=1/value1;
                t2.setText(decimalFormat.format(value2));
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.log10(value1)));
            }
        });
        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.log(value1)));
            }
        });
        bexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.exp(value1)));
            }
        });
        bsqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value2=value1*value1;
                t2.setText(decimalFormat.format(value2));
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.sqrt(value1)));
            }
        });
        bcbrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(decimalFormat.format(Math.cbrt(value1)));
            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1=Double.parseDouble(t2.getText().toString());
            }
        });
        bpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigInteger fact = new BigInteger("1");
                for(int i=1;i<=value1;i++)
                {
                    fact = fact.multiply(new BigInteger(i + ""));
                }
                t2.setText(fact.toString());
            }
        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.putExtra("return",t2.getText().toString());
                setResult(2,i);
                finish();
            }
        });

    }
}
