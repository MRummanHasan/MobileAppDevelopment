package com.example.areeb.myapplication;

        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bmul,badd,bsub,bdiv,b0,beq,bac,bdot;
    TextView ans;
    double var1,var2;
    boolean add,mul,sub,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = (Button) findViewById(R.id.button);
        bdot = (Button) findViewById(R.id.button2);
        beq = (Button) findViewById(R.id.button3);
        b1 = (Button) findViewById(R.id.button4);
        b2 = (Button) findViewById(R.id.button5);
        b3 = (Button) findViewById(R.id.button6);
        b4 = (Button) findViewById(R.id.button7);
        b5 = (Button) findViewById(R.id.button8);
        b6 = (Button) findViewById(R.id.button9);
        b7 = (Button) findViewById(R.id.button10);
        b8 = (Button) findViewById(R.id.button11);
        b9 = (Button) findViewById(R.id.button12);
        badd = (Button) findViewById(R.id.button13);
        bsub = (Button) findViewById(R.id.button14);
        bmul = (Button) findViewById(R.id.button15);
        bdiv = (Button) findViewById(R.id.button16);

        bac = (Button) findViewById(R.id.button17);
        ans = (TextView) findViewById(R.id.Answer);
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText("");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+"0");
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                var1 = Double.parseDouble(ans.getText()+"");
                add = true;
                ans.setText(null);
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                var1 = Double.parseDouble(ans.getText()+"");
                sub = true;
                ans.setText(null);
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                var1 = Double.parseDouble(ans.getText()+"");
                mul = true;
                ans.setText(null);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                var1 = Double.parseDouble(ans.getText()+"");
                div = true;
                ans.setText(null);
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ans.setText(ans.getText()+".");
            }
        });
        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                var2 = Double.parseDouble(ans.getText()+"");
                if (add == true)
                {
                    ans.setText(var1+var2+"");
                    add = false;
                }
                if (sub == true)
                {
                    ans.setText(var1-var2+"");
                    sub = false;
                }
                if (mul == true)
                {
                    ans.setText(var1*var2+"");
                    mul = false;
                }
                if (div == true)
                {
                    ans.setText(var1/var2+"");
                    div = false;
                }
            }
        });
    }

}