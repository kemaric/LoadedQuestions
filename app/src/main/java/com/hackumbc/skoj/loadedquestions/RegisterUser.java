package com.hackumbc.skoj.loadedquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.simplelogin.FirebaseSimpleLoginError;
import com.firebase.simplelogin.FirebaseSimpleLoginUser;
import com.firebase.simplelogin.SimpleLogin;
import com.firebase.simplelogin.SimpleLoginAuthenticatedHandler;

/**
 * Created by Owner on 9/28/2014.
 */
public class RegisterUser extends Activity {
    Button confirmreg;
    EditText userEmail,mPasswordView,confirmpass;
    Button confirmRegistration;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setContentView(R.layout.activity_registration);
        userEmail = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        confirmpass = (EditText) findViewById(R.id.confirm_password);


        confirmreg =  (Button) findViewById(R.id.confirm_registration);
        confirmreg.setOnClickListener(new View.OnClickListener() {
            @Override

            //Registering a user
            public void onClick(View v) {

                Firebase myRef = new Firebase("https://fiery-torch-865.firebaseio.com/");
                SimpleLogin authClient = new SimpleLogin(myRef, getApplicationContext());
                authClient.createUser(userEmail.getText().toString(), confirmpass.getText().toString(),
                        new SimpleLoginAuthenticatedHandler() {
                            public void authenticated(FirebaseSimpleLoginError error, FirebaseSimpleLoginUser user) {
                                if(error != null) {
                                    // There was an error creating this account
                                    Toast.makeText(getApplicationContext(), "Error creating account!", Toast.LENGTH_LONG);
                                }
                                else {
                                    // We created a new user account
                                    Toast.makeText(getApplicationContext(),"Created  account!",Toast.LENGTH_LONG);
                                   startActivity(new Intent(RegisterUser.this,LoginActivity.class));
                                }
                            }
                        });

            }
        });

    }

   /** SimpleLogin authClient = new SimpleLogin(myRef, getApplicationContex());
    authClient.createUser("email@example.com", "very secret", new SimpleLoginAuthenticatedHandler() {
        public void authenticated(FirebaseSimpleLoginError error, FirebaseSimpleLoginUser user) {
            if(error != null) {
                // There was an error creating this account
            }
            else {
                // We created a new user account
            }
        }
    });**/
}
