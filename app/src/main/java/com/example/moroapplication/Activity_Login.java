package com.example.moroapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.util.Arrays;

public class Activity_Login extends AppCompatActivity {

    //nút FB
    private LoginButton btnFb;
    private CallbackManager callbackManager;
    //nút GG
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    FrameLayout FB, GG;
    Button btnLogin, btnRegister, btnForgotPass;
    SignInButton btnGg;
    TextInputEditText edtEmail, edtPass;
    AccountDB DB;
    CheckBox chkRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        FB = findViewById(R.id.FB);
        GG = findViewById(R.id.GG);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnForgotPass = findViewById(R.id.btnForgotPass);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        chkRemember = findViewById(R.id.chkRemember);
        btnFb = findViewById(R.id.btnFb);
        btnGg = findViewById(R.id.btnGg);

        DB = new AccountDB(this);
        addEvents();

        //nút FB
        btnFb.setReadPermissions(Arrays.asList("email", "public_profile"));
        FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == FB){
                    btnFb.performClick();
            }}
        });
        setFBLoginButton();
        
        // Nút GG
        GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == GG){
                    btnGg.performClick();
                    signIn();
                }
            }
        });
        

        }

    private void signIn() {
    }

    private void setFBLoginButton() {
        btnFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                
                results();
                
                Toast.makeText(Activity_Login.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_Login.this, Activity_Homepage.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                Toast.makeText(Activity_Login.this, "Hủy đăng nhập", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(Activity_Login.this, "Đã xảy ra lỗi, vui lòng thử lại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void results() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.getJSONObject().toString());

            }
        });

        Bundle p = new Bundle();
        p.putString("fields", "id, name, email ");
        graphRequest.setParameters(p);
        graphRequest.executeAsync();
    }

    private void addEvents() {
        // Quên mật khẩu
        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_Forgot_Pass.class));
            }
        });
        // Đăng ký tài khoản
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_Register.class));
            }
        });

        //remember me
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals("true")){
            Intent intent = new Intent(Activity_Login.this, Activity_Homepage.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(Activity_Login.this, "Hãy đăng nhập", Toast.LENGTH_SHORT).show();
        }

        //Đăng nhập bằng tài khoản
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=edtEmail.getText().toString();
                String pass=edtPass.getText().toString();

                //kiểm tra email và pass có trống hay không
                if(email.equals("")||pass.equals(""))
                    Toast.makeText(Activity_Login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkemailpass = DB.checkemailpassword(email,pass);
                    if(checkemailpass==true){
                        Toast.makeText(Activity_Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Activity_Login.this, Activity_Homepage.class);
                        startActivity(intent);
                        //remember me
                        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "true");
                        editor.apply();
                    }
                    else{
                        Toast.makeText(Activity_Login.this, "Đăng nhập không thành công, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        chkRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }

            }
        });
    }

//        private void signIn() {
//            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }
//
//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//            callbackManager.onActivityResult(requestCode, resultCode, data);
//            super.onActivityResult(requestCode, resultCode, data);
//
//            // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//            if (requestCode == RC_SIGN_IN) {
//                // The Task returned from this call is always completed, no need to attach
//                // a listener.
//                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                handleSignInResult(task);
//            }
//        }
//        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//            try {
//                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//                GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//                if (acct != null) {
//                    String personName = acct.getDisplayName();
//                    String personGivenName = acct.getGivenName();
//                    String personFamilyName = acct.getFamilyName();
//                    String personEmail = acct.getEmail();
//                    String personId = acct.getId();
//                    Uri personPhoto = acct.getPhotoUrl();
//
//                }
//                Intent intent = new Intent(Activity_Login.this, HomePage.class);
//                startActivity(intent);
//
//                // Signed in successfully, show authenticated UI.
////
//            } catch (ApiException e) {
//                // The ApiException status code indicates the detailed failure reason.
//                // Please refer to the GoogleSignInStatusCodes class reference for more information.
//                Log.d("message", e.toString());
//            }
//        }
//
//        AccessTokenTracker t = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//                if(currentAccessToken == null) {
//                    Toast.makeText(Activity_Login.this, "Bạn đã đăng xuất", Toast.LENGTH_SHORT).show();
//                }else{
//                    loaduserProfile(currentAccessToken);
//                }
//
//                if (t != null) {//<- IMPORTANT
//                    Intent intent = new Intent(Activity_Login.this, HomePage.class);
//                    startActivity(intent);
//                    finish();//<- IMPORTANT
//                }
//            }
//        };
//
//        private void loaduserProfile(AccessToken newAccessToken) {
//            GraphRequest request = GraphRequest.newMeRequest(newAccessToken, (this::onCompleted));
//            Bundle parameters = new Bundle();
//            parameters.putString("fields", "email,name,id");
//            request.setParameters(parameters);
//            request.executeAsync();
//        }
//
//    private void onCompleted(JSONObject object, GraphResponse response) {
//        if (object != null) {
//            try {
//                String email = object.getString("email");
//                String id = object.getString("id");
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}