package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class Login extends AppCompatActivity {

    Toast toast=null;
    EditText etusername;
    EditText etpassword;
    String username,password;
    String tflag="2";

    private static final String url = "jdbc:mysql://samipsdb.ce5w22sralgz.us-west-2.rds.amazonaws.com:3306/projectdb";
    private static final String user = "samip";
    private static final String pass ="iamsamip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }

    @Override
    public void onBackPressed() {
        alertMessage();
    }
    public void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            { switch (which){
                case DialogInterface.BUTTON_POSITIVE: // Yes button clicked
                    Toast.makeText(Login.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                    finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE: // No button clicked do nothing
                    Toast.makeText(Login.this, "Good Choice", Toast.LENGTH_LONG).show();
                    break;
            }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit? :(") .setPositiveButton("Yes", dialogClickListener) .setNegativeButton("No", dialogClickListener).show();
    }


    public void onclick(View v)
    {

        etusername=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);
        username=etusername.getText().toString();
        password=etpassword.getText().toString();

        if(v.getId()==R.id.btnsignup)
        {
            Intent i=new Intent(Login.this,SignUp.class);
            startActivity(i);
        }
        if(v.getId()==R.id.btnsignin)
        {
            int flag=0;
            if (!isRequired(username)) {
                etusername.setError("Please enter username");
                flag++;
            }

            if (!isRequired(password)) {
                etpassword.setError("Please enter password");
                flag++;
            }

            if(flag==0){
            toast=Toast.makeText(getApplicationContext(), "Authenticating.. \nPlease Wait...", Toast.LENGTH_SHORT);
            toast.show();
            new MyTask().execute();
            }

        }
    }
    private class MyTask extends AsyncTask<Void,Void,Void> {
        private ResultSet rs;
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                String sql="select * from Student where `Student_username`='"+username+"' and `Student_password`='"+password+"'";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    tflag=rs.getString(9);
                }
                if(!(tflag.equals("0"))){
                    Statement st2 = con.createStatement();
                    String sql1 = "select * from Faculty where `Faculty_username`='" +username+ "' and `Faculty_password`='" +password+ "'";
                    rs = st2.executeQuery(sql1);
                    while(rs.next())
                    {
                        tflag=rs.getString(7);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {

                if(tflag.equals("1")||tflag.equals("0")) {
                    toast=Toast.makeText(getApplicationContext(), "Login Successful!\nUpdating News Feed", Toast.LENGTH_SHORT);
                    Intent i=new Intent(Login.this,S_News.class);
                    SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("uname", username);
                    editor.putString("tflag",tflag);
                    editor.commit();
                    startActivity(i);
                    finish();
                }
                else{
                    toast=Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_LONG);
                }
                toast.show();

            super.onPostExecute(aVoid);
        }
    }
    private boolean isRequired(String det) {
        if (det.length() != 0) {
            return true;
        }
        return false;
    }
}


