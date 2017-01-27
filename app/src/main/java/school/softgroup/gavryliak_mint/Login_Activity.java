package school.softgroup.gavryliak_mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editlogin,editPass;
    Button btnLogin,btnRegistration;
    String login,password,login_txt,pass_txt,code_pass;
    Toast toast;
    public static final String LOGIN_PASS = "myLOG_PAS";
    public static final String ID = "myID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        editlogin= (EditText) findViewById(R.id.editLogin);
        login=editlogin.getText().toString();
        editPass= (EditText) findViewById(R.id.editPass);
        password=editPass.getText().toString();
        btnLogin= (Button) findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);
        btnRegistration= (Button) findViewById(R.id.btn_Registration);
        btnRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        login_txt=editlogin.getText().toString();
        pass_txt=editPass.getText().toString();
        switch (view.getId()){
            case R.id.btn_Registration:
                toast = Toast.makeText(getApplicationContext(), "Registration", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent_Registration = new Intent(this, Registration_Activity.class);
                startActivity(intent_Registration);
                break;
            case R.id.btn_Login:
                MyApp app = ((MyApp) getApplicationContext());
                if (app.getMyVariable().contains(login_txt)){
                    code_pass=new String( Base64.decode(app.getMyVariable().getString(login_txt,""), Base64.DEFAULT ) );
                if (code_pass.equals(pass_txt)){
                    Intent intent_main_activity=new Intent(this,WelcomeActivity.class);
                    intent_main_activity.putExtra(ID, login_txt);
                    startActivity(intent_main_activity);}else
                    {toast = Toast.makeText(getApplicationContext(),code_pass+ "Password uncorrect!!!!!" +pass_txt,                         Toast.LENGTH_SHORT);
                    toast.show(); }
                }else{toast = Toast.makeText(getApplicationContext(),"Login not found!!!", Toast.LENGTH_SHORT);
                    toast.show(); }
                break;
        }

    };
};
