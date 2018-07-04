package calculatorapp.com.example.rumman.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView txtview;
    private Button btn1;
    private Button btn2;
    private Button btnPlus;
    private Button btnEqual;
    private float VALUE_ONE, VALUE_TWO;
    private String VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtview = (TextView)findViewById(R.id.textViewInputBar);

        btn1 = (Button) findViewById(R.id.buttonOne);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview.setText(txtview.getText() + "1");
            }
        });

        btn2 = (Button) findViewById(R.id.buttonTwo);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview.setText(txtview.getText() + "2");
            }
        });

        btnPlus = (Button) findViewById(R.id.buttonAdd);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                VALUE_ONE = Float.parseFloat(txtview.getText().toString());
//                txtview.setText("");
                txtview.setText(txtview.getText() + "+");
            }
        });

        btnEqual = (Button) findViewById(R.id.buttonEquals);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VALUE = txtview.getText().toString();
                double result = new ExpressionBuilder(VALUE).build().evaluate();
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show(); // second parametr is a message to disp
                txtview.setText(txtview.getText() + "2");
            }
        });




    }
}
