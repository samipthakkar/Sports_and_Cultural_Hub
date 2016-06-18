package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    EditText editTextTo, editTextSubject, editTextMessage;
    Button send;
    CheckBox check;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);
        SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
        String to= prefs.getString("emailto", "default");


        editTextTo=(EditText)findViewById(R.id.emailto);
        editTextTo.setText(to);
        editTextSubject=(EditText)findViewById(R.id.emailsubject);
        editTextMessage=(EditText)findViewById(R.id.emailbody);
        check=(CheckBox)findViewById(R.id.emailcheck);
        send=(Button)findViewById(R.id.sendemail);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (check.isChecked()) {
                    String to = editTextTo.getText().toString();
                    String subject = editTextSubject.getText().toString();
                    String message = editTextMessage.getText().toString();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, message);

                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client like GMail,YahooMail"));
                    finish();
                }
            }

        });


    }
}