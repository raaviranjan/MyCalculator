package com.example.ravi.mycalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,badd,bsub,bmul,bdiv,bequal,bdel,bpow,bmore,bpi,bansw;
    TextView t1;
    EditText e1;
    //private char add,sub,mul,div;
    private static final char add='+';
    private static final char sub = '-';
    private static final char mul= '*';
    private static final char div= '/';
    boolean pow;
    //int resultcode,requestcode;

    double valueone=Double.NaN;
    double valuetwo,value3;
    private DecimalFormat decimalFormat;
    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        setContentView(R.layout.activity_main);
        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        bpi=(Button)findViewById(R.id.bpi);
        bdot=(Button)findViewById(R.id.bdot);
        badd=(Button)findViewById(R.id.badd);
        bsub=(Button)findViewById(R.id.bsub);
        bmul=(Button)findViewById(R.id.bmul);
        bdiv=(Button)findViewById(R.id.bdiv);
        bpow=(Button) findViewById(R.id.bpow);
        bdel=(Button)findViewById(R.id.bdel);
        bmore=(Button)findViewById(R.id.bmore);
        bequal=(Button)findViewById(R.id.bequal);
        bansw=(Button)findViewById(R.id.bansw);
        t1=(TextView)findViewById(R.id.t1);
        e1=(EditText)findViewById(R.id.e1);


        b0.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText()+"9");
            }
        });
        bansw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("Ans");
            }
        });
        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("Pi");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                String str=e1.getText().toString();
                //int num=Integer.parseInt(str.substring(str.length()-1));
                char sstr=str.charAt(str.length()-1);
                if(sstr!='.')
                    e1.setText(e1.getText()+".");
                else
                    bdot.setEnabled(false);
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = add;
                if(e1.getText().toString().equals("Pi"))
                    t1.setText("Pi+");
                else
                    t1.setText(valueone + "+");
                e1.setText(null);

            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = sub;
                if(e1.getText().toString().equals("Pi"))
                    t1.setText("Pi-");
                else
                    t1.setText(valueone + "-");
                e1.setText(null);
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = mul;
                if(e1.getText().toString().equals("Pi"))
                    t1.setText("Pi*");
                else
                    t1.setText(valueone + "*");
                e1.setText(null);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = div;
                if(e1.getText().toString().equals("Pi"))
                    t1.setText("Pi/");
                else
                    t1.setText(valueone + "/");
                e1.setText(null);
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pow==true)
                {
                    valuetwo=Double.parseDouble(e1.getText()+"");
                    valueone=Math.pow(valueone,valuetwo);
                    pow=false;
                    t1.setText(t1.getText() + decimalFormat.format(valuetwo) + "=" + decimalFormat.format(valueone));
                    valueone = Double.NaN;
                    e1.setText(null);
                }

                else {
                    computeCalculation();
                    t1.setText(t1.getText() + decimalFormat.format(valuetwo) + "=" + decimalFormat.format(valueone));
                    e1.setText(null);
                    value3=valueone;
                    valueone = Double.NaN;
                    CURRENT_ACTION = '0';
                }
            }
        });
        bpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().matches(""))
                    Toast.makeText(MainActivity.this,"Enter a number", Toast.LENGTH_SHORT).show();
                else
                {
                    valueone=Double.parseDouble(e1.getText()+"");
                    pow=true;
                    t1.setText(valueone + "^");
                    e1.setText(null);
                }
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0)
                {
                    CharSequence currenttext=e1.getText();
                    e1.setText(currenttext.subSequence(0,currenttext.length()-1));
                }
                else
                {
                    valueone=Double.NaN;
                    valuetwo=Double.NaN;
                    e1.setText("");
                    t1.setText("");
                }
            }
        });
        bmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(e1.getText().toString().matches(""))
                {
                    Toast.makeText(MainActivity.this,"Enter a number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent myIntent = new Intent(MainActivity.this, Extra.class);
                    String s;
                    if(e1.getText().toString().equals("Pi"))
                    {
                        s="3.1415926536";
                        myIntent.putExtra("pass", s);
                    }
                    else if(e1.getText().toString().equals("Ans"))
                    {
                        s=Double.toString(value3);
                        myIntent.putExtra("pass", s);
                    }
                    else
                        myIntent.putExtra("pass",e1.getText().toString());
                    startActivityForResult(myIntent,1);
                }

            }
        });
    }




    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        if(resultcode==2 && requestcode==1)
        {
            String message=data.getStringExtra("return");
            e1.setText(message);

        }
    }
    private void computeCalculation() {
        if(!Double.isNaN(valueone)) {
            valuetwo = Double.parseDouble(e1.getText().toString());
            e1.setText(null);

            if(CURRENT_ACTION == add)
                valueone = this.valueone + valuetwo;
            else if(CURRENT_ACTION == sub)
                valueone = this.valueone - valuetwo;
            else if(CURRENT_ACTION == mul)
                valueone = this.valueone * valuetwo;
            else if(CURRENT_ACTION == div)
                valueone = this.valueone / valuetwo;
        }
        else {
            try {
                if(e1.getText().toString().equals("Pi"))
                    valueone=3.1415926536;
                else if(e1.getText().toString().equals("Ans"))
                    valueone=value3;
                else
                    valueone = Double.parseDouble(e1.getText().toString());
            }
            catch (Exception e){}
        }
    }

}
