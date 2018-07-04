package appone.com.example.rumman.appone;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView headingtxt,totalTxt, aftrDisTxt;
    EditText custNameTxt, custNumberTxt, quantityTxt, DiscTxt;
    Spinner spinner;
    Button saveBtn;
    String[] spinArray = {"Select Product", "Shirt Rs500", "Tshirt Rs300"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headingtxt = (TextView) findViewById(R.id.HeadingBox);
        custNameTxt = (EditText) findViewById(R.id.CustNameBox);
        custNumberTxt = (EditText) findViewById(R.id.CustPhoneBox);
        quantityTxt = (EditText) findViewById(R.id.QuantityBox);
        totalTxt = (TextView) findViewById(R.id.TotalBox);
        DiscTxt = (EditText) findViewById(R.id.DiscountBox);
        aftrDisTxt = (TextView) findViewById(R.id.AfterDiscountBox);
        spinner = (Spinner) findViewById(R.id.spinnerBox);
        saveBtn = (Button) findViewById(R.id.saveButton);

        // setting adapter to use spinner
        ArrayAdapter arrAdaptr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinArray);
        spinner.setAdapter(arrAdaptr);

        quantityTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (spinner.getSelectedItem().toString().equals("Shirt Rs500"))
                {
                    int prod = 500;
                    //int q = Integer.parseInt(quantityTxt.getText().toString()); // error dey rha hy *******************************
                    int q = 5;
                    int ans = prod * q;
                    String t = Integer.toString(ans);
                    totalTxt.setText(t);
                }
                else if (spinner.getSelectedItem().toString().equals("Tshirt Rs300")) {
                    int prod = 300;
                    //int q = Integer(quantityTxt.getText().toString()); // error dey rha hy *******************************
                    int q = 2;
                    int ans = prod * q;
                    String t = Integer.toString(ans);
                    totalTxt.setText(t);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select Product", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!custNameTxt.getText().toString().isEmpty() && !custNumberTxt.getText().toString().isEmpty() && spinner.getSelectedItem().toString() != "Select Product" && !quantityTxt.getText().toString().isEmpty() && !DiscTxt.getText().toString().isEmpty()) {


                    //sp declared
                    SharedPreferences sp = getSharedPreferences("custLog", MODE_WORLD_READABLE);

                    Date c = Calendar.getInstance().getTime();
                    System.out.println("Current time => " + c);
                    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    String formattedDate = df.format(c);

                    String userKaData = custNameTxt.getText().toString()+" "+custNumberTxt.getText().toString() +" "+ spinner.getSelectedItem().toString()+" "+quantityTxt.getText().toString() +" "+DiscTxt.getText().toString() +" "+formattedDate;
                    String currentWaqt;



                    sp.edit().putString( userKaData, "").apply();
                    Toast.makeText(MainActivity.this, "User Added Succesfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill all text boxes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
