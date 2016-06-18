package yasheth.sportsandculturalhub1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUp extends AppCompatActivity {
    String email="",pass="",confpass="",fullname="",mobile="",rollno="",username="",dept="";
    private EditText etemail,etrollno,etusername,etdept,etpass,etconfirmpass,etfullname,etmobile;

    private static final String url = "jdbc:mysql://samipsdb.ce5w22sralgz.us-west-2.rds.amazonaws.com:3306/projectdb";
    private static final String user = "samip";
    private static final String password = "iamsamip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
    }

    public void onclick(View v) {
        int flag = 0;
        etemail = (EditText) findViewById(R.id.detemail);
        etpass = (EditText) findViewById(R.id.detpass);
        etconfirmpass = (EditText) findViewById(R.id.detconfirmpass);
        etfullname = (EditText) findViewById(R.id.detfullname);
        etmobile = (EditText) findViewById(R.id.detmobile);
        etrollno = (EditText) findViewById(R.id.detidno);
        etusername = (EditText) findViewById(R.id.detuname);
        etdept = (EditText) findViewById(R.id.detdept);

        System.out.println("Inside onclick");

        email = etemail.getText().toString();
        pass = etpass.getText().toString();
        confpass = etconfirmpass.getText().toString();
        fullname = etfullname.getText().toString();
        mobile = etmobile.getText().toString();
        rollno=etrollno.getText().toString();
        username=etusername.getText().toString();
        dept=etdept.getText().toString();


        if (!isRequired(fullname)) {
            etfullname.setError("Please enter your Full Name");
            flag++;
        }
        if (!isRequired(username)) {
            etusername.setError("Please enter username");
            flag++;
        }

        if (!isRequired(dept)) {
            etdept.setError("Please enter your Department");
            flag++;
        }

        if (!isNumber(mobile)) {
            etmobile.setError("Invalid Mobile number");
            flag++;
        }

        if (!isValidEmail(email)) {
            etemail.setError("Invalid Email");
            flag++;
        }

        if (!isValidPassword(pass)) {
            etpass.setError("Invalid Password");
            flag++;
        }

        if (!pass.equals(confpass)) {
            etconfirmpass.setError("The Confirmation Password doesnt match");
            flag++;
        }


        if (flag == 0) {
            Toast toast= Toast.makeText(getApplicationContext(), "Submiting form.. \nPlease Wait...", Toast.LENGTH_SHORT);
            toast.show();
            new MyTask().execute();
        }
    }

    private boolean isRequired(String det) {
        if (det.length() != 0) {
            return true;
        }
        return false;
    }

    private boolean isNumber(String det) {
        String MOBILE_PATTERN = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
        if (det.length() != 0) {
            Pattern pattern = Pattern.compile(MOBILE_PATTERN);
            Matcher matcher = pattern.matcher(det);
            return matcher.matches();
        } else
            return false;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {

        private java.sql.ResultSet rs = null;
        int supflag=0;
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                rs=st.executeQuery("select * from Student where `Student_username`='"+username+"'");
                if(rs.next()){
                  supflag++;
                }
               else {
                    st.executeQuery("insert into Student(`Student_password`,`Student_name`,`Student_phoneno`,`Student_username`,`Student_emailid`,`Student_dept`,`Student_Rollno`)" + "values('" + pass + "','" + fullname + "','" + mobile + "','" + username + "','" + email + "','" + dept + "','" + rollno + "')");
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
            try {
                if(supflag==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG);
                    toast.show();
                    Intent i = new Intent(SignUp.this, Login.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "User with same username exists", Toast.LENGTH_LONG);
                    toast.show();
                    etusername.setError("username taken");
                }
            } catch (Exception e) {

                e.printStackTrace();

            }
            super.onPostExecute(aVoid);
        }
    }
}