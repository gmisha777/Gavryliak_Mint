package school.softgroup.gavryliak_mint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText inputLogin,inputEmail,inputPass,reinputPass;
    Button submit;
   // SharedPreferences sharedPreferences;
    String login,email, password,repass;
    Toast toast;
    String code_pass;
    public static final String LOGIN_PASS = "myLOG_PAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registration_);
        inputLogin= (EditText) findViewById(R.id.inputLogin);
        inputEmail= (EditText) findViewById(R.id.inputEmail);
        inputPass= (EditText) findViewById(R.id.inputPassword);
        reinputPass= (EditText) findViewById(R.id.reinputPassword);
        submit= (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        login=inputLogin.getText().toString();
        email=inputEmail.getText().toString();
        password=inputPass.getText().toString();
        repass=reinputPass.getText().toString();
        MyApp app = ((MyApp) getApplicationContext());
    if (check_Email(email)&&check_Pass(password,repass)){
        if (!app.getMyVariable().contains(login)&&!app.getMyVariable().contains(email)){
        SharedPreferences.Editor ed = app.getMyVariable().edit();
            code_pass= Base64.encodeToString(password.getBytes(), Base64.DEFAULT );
            ed.putString(login, String.valueOf(code_pass));
            ed.commit();
            ed.putString(email, password);
            ed.commit();
            Intent intent=new Intent(this,Login_Activity.class);
            startActivity(intent);
       } else
        {
            toast = Toast.makeText(getApplicationContext(), "This login or eMail was allready registered!!!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    }

   private boolean check_Email(String eMail){
     if (eMail.contains("@")) {return true; } else
     {toast = Toast.makeText(getApplicationContext(), "Email isn't valid!!!", Toast.LENGTH_SHORT);
         toast.show();
         return false;}
   }
   private  boolean check_Pass(String pass, String rePass){

       if (pass.length() > 4&&pass.equals(rePass)) {return true;} else
       {
           toast = Toast.makeText(getApplicationContext(), "Password incorrect!!!", Toast.LENGTH_SHORT);
           toast.show();
           return false ;}
   }
}
