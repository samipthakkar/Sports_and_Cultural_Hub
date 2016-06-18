package yasheth.sportsandculturalhub1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class S_News extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    int k=0;
    String username,tflag;
    TextView unamedisp;
    private List<yasheth.sportsandculturalhub1.Details> detailsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private yasheth.sportsandculturalhub1.DetailsAdapter mAdapter;
    private static final String url = "jdbc:mysql://samipsdb.ce5w22sralgz.us-west-2.rds.amazonaws.com:3306/projectdb";
    private static final String user = "samip";
    private static final String password="iamsamip";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_news_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
        username= prefs.getString("uname", "default");
        tflag=prefs.getString("tflag","default");
        unamedisp=(TextView)findViewById(R.id.uname1);
        unamedisp.setText(username+"!");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new yasheth.sportsandculturalhub1.DetailsAdapter(detailsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        Toast.makeText(S_News.this, "Updating News Feed...", Toast.LENGTH_SHORT).show();
        new MyTask().execute();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            alertMessage();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_query) {
            Intent i=new Intent(S_News.this,S_Query.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            alertMessage();

        } else if (id == R.id.nav_sports) {
            if(tflag.equals("1")){
                Intent i = new Intent(S_News.this, T_Sports.class);
                startActivity(i);
            }
            if(tflag.equals("0")){
                Intent i = new Intent(S_News.this, S_Sports.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_cultural) {
            if(tflag.equals("1")){
                Intent i = new Intent(S_News.this, T_Cultural.class);
                startActivity(i);
            }
            if(tflag.equals("0")){
                Intent i = new Intent(S_News.this, S_Cultural.class);
                startActivity(i);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            { switch (which){
                case DialogInterface.BUTTON_POSITIVE: // Yes button clicked
                 Toast.makeText(S_News.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(S_News.this, Login.class);
                    SharedPreferences prefs = getSharedPreferences("content", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.clear();
                    editor.commit();
                    startActivity(i);
                    finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE: // No button clicked do nothing
                 //Toast.makeText(S_News.this, "No Clicked", Toast.LENGTH_LONG).show();
                    break;
            }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Log Out?") .setPositiveButton("Yes", dialogClickListener) .setNegativeButton("No", dialogClickListener).show();
    }

    private class MyTask extends AsyncTask<Void,Void,Void> {
        private int id;
        private java.sql.ResultSet rs=null;
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                rs = st.executeQuery("select * from Announcement order by id_announcement DESC");
                while(rs.next()){
                    String s=rs.getString(2);
                    String d=rs.getString(3);
                    Details movie = new Details(s,d);
                    detailsList.add(movie);
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
                mAdapter.notifyDataSetChanged();
                Toast.makeText(S_News.this, "News Feed Updated", Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }

}


