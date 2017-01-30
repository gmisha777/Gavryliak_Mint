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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText inputLogin,inputPass,reinputPass;
    Button submit;
    String login, password,repass;
    String code_pass;
    Matcher matcher;
    public static final Pattern pattern_email = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
    public static final Pattern pattern_login = Pattern.compile("^[a-z0-9_-]{3,15}$");
    public static final Pattern pattern_password = Pattern.compile("^[a-z0-9_-]{3,15}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registration_);
        inputLogin= (EditText) findViewById(R.id.inputLogin);
        inputPass= (EditText) findViewById(R.id.inputPassword);
        reinputPass= (EditText) findViewById(R.id.reinputPassword);
        submit= (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);}

    @Override
    public void onClick(View view) {
        login=inputLogin.getText().toString();
        password=inputPass.getText().toString();
        repass=reinputPass.getText().toString();
        MyApp app = ((MyApp) getApplicationContext());
            if (check_Login(login)&&check_Pass(password,repass)){
                if (!app.getMySPREF().contains(login)){
                    SharedPreferences.Editor ed = app.getMySPREF().edit();
                    code_pass= Base64.encodeToString(password.getBytes(), Base64.DEFAULT );
                    ed.putString(login, String.valueOf(code_pass));
                    ed.commit();
                    Intent intent=new Intent(this,Login_Activity.class);
                    startActivity(intent);}
                else {Toast.makeText(getApplicationContext(), "This login or eMail was allready registered!!!", Toast.LENGTH_SHORT).show();}
            }
    }

    private boolean check_Login(String login){
        boolean check;
        if (login.contains("@")) {
            matcher = pattern_email.matcher(login);
            check= matcher.matches();}
        else {matcher = pattern_login.matcher(login);
            check= matcher.matches();}
        if (check) {return true;}
        else {Toast.makeText(getApplicationContext(), "This login or eMail isn't correct!", Toast.LENGTH_SHORT).show();
            return false;}
    }

   private  boolean check_Pass(String pass, String rePass){
       if (pass.equals(rePass)){
           matcher = pattern_password.matcher(pass);
           if (matcher.matches()){return true;}
           else {Toast.makeText(getApplicationContext(), "Passwords isn't correct!", Toast.LENGTH_SHORT).show();
                return  false;}}
       else {Toast.makeText(getApplicationContext(), "Passwords aren't the same!", Toast.LENGTH_SHORT).show();
           return  false;
       }
   }
}
