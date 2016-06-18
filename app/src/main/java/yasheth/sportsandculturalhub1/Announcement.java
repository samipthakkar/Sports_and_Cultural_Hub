package yasheth.sportsandculturalhub1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Announcement extends AppCompatActivity {
    private static final String url = "jdbc:mysql://samipsdb.ce5w22sralgz.us-west-2.rds.amazonaws.com:3306/projectdb";
    private static final String user = "samip";
    private static final String pass ="iamsamip";
    private EditText activitysub;
    private EditText activitydesc;
    private CheckBox check;
    private String Subject;
    private String Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_layout);
    }
    public void onclick(View v) {
        activitysub = (EditText) findViewById(R.id.etsubject);
        activitydesc = (EditText) findViewById(R.id.etshortdesc);
        check=(CheckBox)findViewById(R.id.announcementcheck);
        Subject = activitysub.getText().toString();
        Description = activitydesc.getText().toString();
        if(check.isChecked()){
            Toast toast= Toast.makeText(getApplicationContext(), "Just a sec...", Toast.LENGTH_LONG);
            toast.show();
            new MyTask().execute();
        }
    }
    private class MyTask extends AsyncTask<Void,Void,Void> {
        private int id;

        private java.sql.ResultSet rs=null;
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                Statement st1=con.createStatement();
                st.executeUpdate("insert into Announcement(`Announcement_Subject`,`Announcement_Description`)" + "values('"+Subject+"','"+Description+"')");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
                Toast toast= Toast.makeText(getApplicationContext(), "Announcement done\nWill be posted on News Feed Soon!", Toast.LENGTH_LONG);
                toast.show();
                Intent i=new Intent(Announcement.this,S_News.class);
                startActivity(i);
                finish();
            super.onPostExecute(aVoid);
        }
    }

}
