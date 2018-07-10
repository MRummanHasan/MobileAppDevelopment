package com.example.glab.a10_jul_018;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn ;
    private EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name_editText);
        age = (EditText)findViewById(R.id.age_editText);
        btn = (Button)findViewById(R.id.submit_button);

        final DBHelper db = new DBHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = db.Insert_UserData(new UserData(name.getText().toString(),Integer.parseInt(age.getText().toString())));
                if (result > 0)
                {
                    Toast.makeText(MainActivity.this, "Saved....", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}