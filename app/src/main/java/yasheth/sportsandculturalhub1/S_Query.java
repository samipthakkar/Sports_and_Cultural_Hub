package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class S_Query extends AppCompatActivity {

    EditText  editTextSubject, editTextMessage;
    Button send;
    CheckBox check;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_query_layout);

        SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
        final String tflag=prefs.getString("tflag","default");

        editTextSubject=(EditText)findViewById(R.id.inf1);
        editTextMessage=(EditText)findViewById(R.id.inf2);
        check=(CheckBox)findViewById(R.id.emailcheck);
        send=(Button)findViewById(R.id.btnsubmitquery);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (check.isChecked()) {
                    String to;
                    if(tflag.equals("1")){
                        to="sportsandculturalhub@gmail.com";}
                    else{
                        to="yogeshjani@charusat.ac.in";}

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


    @Override
    public void onBackPressed(){
      super.onBackPressed();
    }

}