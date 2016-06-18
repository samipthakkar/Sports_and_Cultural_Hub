package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T_Cultural_Indi extends AppCompatActivity {

    String culture;
    String emailto;
    private ResultSet rs;
    private static final String url = "jdbc:mysql://samipsdb.ce5w22sralgz.us-west-2.rds.amazonaws.com:3306/projectdb";
    private static final String user = "samip";
    private static final String password="iamsamip";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b=getIntent().getExtras();
        culture=b.getString("CULTURE");
        String desc=b.getString("DESC");
        String id=b.getString("ID");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_cultural_indi_layout);
        TextView s_head=(TextView)findViewById(R.id.t_head);
        s_head.setText(culture);
        s_head=(TextView)findViewById(R.id.t_desc);
        s_head.setText(desc);

        if(id.equals("1"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_solodance);
        }
        else if(id.equals("2"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_groupdance);
        }
        else if(id.equals("3"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_singing);
        }
        else if(id.equals("4"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_drama);
        }
        else if(id.equals("5"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_fashion);
        }
        else if(id.equals("6"))
        {
            ImageView cov=(ImageView)findViewById(R.id.t_cov);
            cov.setBackgroundResource(R.drawable.cov_musicband);
        }
    }

    public void onClick(View v) {
        if(v.getId()==R.id.btnannouncecultural)
        {
            Intent i=new Intent(T_Cultural_Indi.this,Announcement.class);
            startActivity(i);
            finish();
        }
        if(v.getId()==R.id.btnpushemailcultural)
        {
            Toast toast= Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_LONG);
            toast.show();
            new MyTask().execute();
        }
        if(v.getId()==R.id.btnpushcultural)
        {
            Toast.makeText(T_Cultural_Indi.this, "Push Notification Feature Coming Soon!", Toast.LENGTH_SHORT).show();
        }

    }
    private class MyTask extends AsyncTask<Void, Void, Void> {

        int eflag=0;

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                String sql = "select Student_emailid from `Registration` where `Activity`='"+culture+"'";
                rs = st.executeQuery(sql);
                if(!rs.next()){

                    eflag++;
                }
                else {
                    do {
                        emailto = emailto + ";" + rs.getString(1);
                    }while (rs.next());
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
           if(eflag==0) {
               emailto = emailto.substring(5);
               Intent i = new Intent(T_Cultural_Indi.this, Email.class);
               SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
               SharedPreferences.Editor editor = prefs.edit();
               editor.putString("emailto", emailto);
               editor.commit();
               startActivity(i);
               finish();
           }
           else{
               Toast toast= Toast.makeText(getApplicationContext(), "No registered Students", Toast.LENGTH_SHORT);
               toast.show();
           }
            super.onPostExecute(aVoid);
        }

    }

}

