package rs.elfak.mosis.aleksadjordjevic.myplaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity
{
    EditText txtEmail, txtPassword;
    Button btnLogin;
    ProgressDialog mDialog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmailL);
        txtPassword = findViewById(R.id.txtPasswordL);
        btnLogin = findViewById(R.id.btnLoginL);
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userLogin();
            }
        });
    }

    protected void userLogin()
    {
        mDialog = new ProgressDialog(LoginActivity.this);
        mDialog.setMessage("Please wait...");
        mDialog.show();

        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if(checkInputError(email,password))
        {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    mDialog.dismiss();

                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                        sendToMain();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"There was an error. Try again later.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
            mDialog.dismiss();

    }

    public boolean checkInputError(String email,String password)
    {
        if(email.isEmpty())
        {
            txtEmail.setError("Please enter your Email.");
            txtEmail.requestFocus();
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            txtEmail.setError("Please enter a valid Email address.");
            txtEmail.requestFocus();
            return false;
        }

        if (password.isEmpty())
        {
            txtPassword.setError("Please enter your password.");
            txtPassword.requestFocus();
            return false;
        }

        return true;
    }

    public void sendToMain()
    {
        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }
}
