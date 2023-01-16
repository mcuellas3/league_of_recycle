package com.example.league_of_recycle;

import static android.app.ProgressDialog.show;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.gbuttons.GoogleSignInButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class LoginActivity extends AppCompatActivity {

    TextView registrateAqui;
    Button lectorQR;

    // TODO ESTO ES DEL LOGIN DE GOOGLE
    GoogleSignInButton googleBtn;
    GoogleSignInOptions gOptions;
    GoogleSignInClient gClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registrateAqui = (TextView) findViewById(R.id.others2);
        lectorQR = (Button) findViewById(R.id.lectorQR);
        //login google
        googleBtn = findViewById(R.id.googleBtn);

        registrateAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        lectorQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(LoginActivity.this, ScanerActivity.class);
                startActivity(j);
            }
        });

        //Inside OnCreate LOGIN GOOGLE
        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClient = GoogleSignIn.getClient(this, gOptions);

        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (gAccount != null){
            finish();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>(){
            @Override
            public void  onActivityResult(ActivityResult result){
                if (result.getResultCode()== Activity.RESULT_OK){
                    Intent data = result.getData();
                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                    try {
                        task.getResult(ApiException.class);
                        finish();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);


                    }catch (ApiException e){
                        Toast.makeText(LoginActivity.this, "Algo salio mal", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = gClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            }
        });

    }
}