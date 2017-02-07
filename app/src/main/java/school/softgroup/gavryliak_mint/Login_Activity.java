package school.softgroup.gavryliak_mint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView error_text;
    EditText editlogin,editPass;
    Button btnLogin,btnRegistration;
    String login,password,login_txt,pass_txt,code_pass;
    public static final String ID = "myID";
    public static final String CURRENT_USER = "current_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        editlogin= (EditText) findViewById(R.id.editLogin);
        login=editlogin.getText().toString();
        editPass= (EditText) findViewById(R.id.editPass);
        password=editPass.getText().toString();
        error_text= (TextView) findViewById(R.id.error_txt);
        btnLogin= (Button) findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);
        btnRegistration= (Button) findViewById(R.id.btn_Registration);
        btnRegistration.setOnClickListener(this);
        if (MyApp.getInstance().getMySPREF().contains(CURRENT_USER)){
            if (MyApp.getInstance().getMySPREF().contains(new String(Base64.decode(MyApp.getInstance().getMySPREF().getString(CURRENT_USER,""),Base64.DEFAULT)))){
                Intent intent_welcome_activity_temp=new Intent(this,Welcome_Activity.class);
                intent_welcome_activity_temp.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intent_welcome_activity_temp);
                finish();
            }
        }
    }

    @Override
    public void onClick(View view) {
        login_txt=editlogin.getText().toString();
        pass_txt=editPass.getText().toString();
        switch (view.getId()){
            case R.id.btn_Registration:
                Intent intent_Registration = new Intent(this, Registration_Activity.class);
                startActivity(intent_Registration);
                break;
            case R.id.btn_Login:
                if (MyApp.getInstance().getMySPREF().contains(login_txt)){
                    code_pass=new String( Base64.decode(MyApp.getInstance().getMySPREF().getString(login_txt,""), Base64.DEFAULT ));
                    if (code_pass.equals(pass_txt)){
                        Intent intent_welcome_activity=new Intent(this,Welcome_Activity.class);
                        intent_welcome_activity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        //intent_welcome_activity.putExtra(ID, login_txt);
                            //add current user to sharedPreferences
                            String current_user = Base64.encodeToString(login_txt.getBytes(), Base64.DEFAULT );
                            SharedPreferences.Editor ed = MyApp.getInstance().getMySPREF().edit();
                            ed.putString(CURRENT_USER, String.valueOf(current_user));
                            ed.commit();
                        startActivity(intent_welcome_activity);
                        finish();
                    }
                    else{
                        error_text.setVisibility(View.VISIBLE);
                        error_text.setText("Password uncorrect!");
                       }
                }
                else{error_text.setVisibility(View.VISIBLE);
                    error_text.setText("Login not found!");}
                break;
        }
    }
}
