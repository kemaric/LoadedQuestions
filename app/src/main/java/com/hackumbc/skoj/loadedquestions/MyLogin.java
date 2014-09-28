package com.hackumbc.skoj.loadedquestions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.simplelogin.FirebaseSimpleLoginError;
import com.firebase.simplelogin.FirebaseSimpleLoginUser;
import com.firebase.simplelogin.SimpleLogin;
import com.firebase.simplelogin.SimpleLoginAuthenticatedHandler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A login screen that offers login via email/password and via Google+ sign in.
 * <p/>
 * ************ IMPORTANT SETUP NOTES: ************
 * In order for Google+ sign in to work with your app, you must first go to:
 * https://developers.google.com/+/mobile/android/getting-started#step_1_enable_the_google_api
 * and follow the steps in "Step 1" to create an OAuth 2.0 client for your package.
 */
public class MyLogin extends ActionBarActivity{

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView,userEmail,fname,lname,confirmpass;
    private View mProgressView;
    private View mEmailLoginFormView;
    private SignInButton mPlusSignInButton;
    private View mSignOutButtons;
    private View mLoginFormView;
    private Button confirmreg, defaultRegButton,defaultLoginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Starting login", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_login);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mEmailLoginFormView = findViewById(R.id.email_login_form);
        userEmail = (EditText) findViewById(R.id.email);
        defaultLoginB = (Button) findViewById(R.id.default_login_button);
        mPasswordView = (EditText) findViewById(R.id.password);
        final Intent loginIntent = this.getIntent();
        Button registrationButton = (Button) findViewById(R.id.email_registration_button);
        registrationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyLogin.this, RegisterUser.class));
            }
        });

        defaultLoginB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase myRef = new Firebase("https://fiery-torch-865.firebaseio.com/");
                SimpleLogin authClient = new SimpleLogin(myRef, getApplicationContext());
                authClient.loginWithEmail(userEmail.getText().toString(), mPasswordView.getText().toString(), new SimpleLoginAuthenticatedHandler() {
                    public void authenticated(FirebaseSimpleLoginError error, FirebaseSimpleLoginUser user) {
                        if (error != null) {
                            // There was an error logging into this account
                            Toast.makeText(getApplicationContext(), "There was an error logging into this account!", Toast.LENGTH_LONG);

                        } else {
                            // We are now logged in
                            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_LONG);
                            Intent mainActivityIntent = new Intent(MyLogin.this, MyActivity.class);
                            //Bundle new
                            startActivity(mainActivityIntent);
                        }
                    }
                });
            }
        });
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}


