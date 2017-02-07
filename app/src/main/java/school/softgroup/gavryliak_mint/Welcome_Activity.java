package school.softgroup.gavryliak_mint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Welcome_Activity extends AppCompatActivity {

    public static final String CURRENT_USER = "current_user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_black_24dp);
        MyApp.getInstance().setFm(getSupportFragmentManager());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddDialogFragment().show(MyApp.getInstance().getFm(),
                        "fruit_add");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), R.string.action_search,Toast.LENGTH_SHORT).show();
                break;
            case R.id.log_out:
               if (MyApp.getInstance().getMySPREF().contains(CURRENT_USER)){
                    SharedPreferences.Editor editor = MyApp.getInstance().getMySPREF().edit();
                    editor.remove(CURRENT_USER);
                    editor.apply();
                    Intent intent=new Intent(this,Login_Activity.class);
                    startActivity(intent);}
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
