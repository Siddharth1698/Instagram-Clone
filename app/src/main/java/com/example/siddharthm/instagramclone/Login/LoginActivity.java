package com.example.siddharthm.instagramclone.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.siddharthm.instagramclone.Home.HomeActivity;
import com.example.siddharthm.instagramclone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail,mPassword;
    private TextView mPleaseWait;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mProgressBar = (ProgressBar)findViewById(R.id.loginRequestLoadingProgressbar);
        mPleaseWait = (TextView)findViewById(R.id.pleasewait);

        mEmail = (EditText)findViewById(R.id.input_email);
        mPassword = (EditText)findViewById(R.id.input_password);
        mContext = LoginActivity.this;
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);
        setupFirebaseAuth();
        init();
    }


    /**
     * Setup the firebase auth object
     */
    private boolean isStringNull(String string){
        if (string.equals("")){
            return true;
        }
        else {
            return false;
        }

    }
    private void init(){
        Button btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                if (isStringNull(email) && isStringNull(password)){
                    Toast.makeText(mContext,"You must fill them",Toast.LENGTH_SHORT).show();
                    }else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPleaseWait.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Log.w(TAG, "signInWithEmail:failed", task.getException());

                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed),
                                                Toast.LENGTH_SHORT).show();
                                        mProgressBar.setVisibility(View.GONE);
                                        mPleaseWait.setVisibility(View.GONE);
                                    }
                                    else{
                                        Log.d(TAG, "signInWithEmail: successful login");
                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_success),
                                                Toast.LENGTH_SHORT).show();
                                        mProgressBar.setVisibility(View.GONE);
                                        mPleaseWait.setVisibility(View.GONE);
                                    }

                                    // ...
                                }
                            });

                }

            }
        });
        if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //check if the user is logged in


                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
