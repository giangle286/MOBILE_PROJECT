package com.example.moroapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.example.moroapplication.databinding.ActivityLoginBinding;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity_Login extends AppCompatActivity {

    ActivityLoginBinding binding;

    //nút FB
    private LoginButton btnFb;
    private CallbackManager callbackManager;
    //nút GG
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    FrameLayout FB, GG;
    Button btnLogin, btnRegister, btnForgotPass;
    AccountDB DB;
    TextInputEditText edtEmail, edtPass;
    CheckBox chkRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        //setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FB = binding.FB;
        GG = binding.GG;
        btnLogin = binding.btnLogin;
        btnRegister = binding.btnRegister;
        btnForgotPass = binding.btnForgotPass;
        edtEmail = binding.edtEmail;
        edtPass = binding.edtPass;
        chkRemember = binding.chkRemember;

        DB = new AccountDB(this);

 // Đăng nhập bằng Facebook
        callbackManager = CallbackManager.Factory.create();
        binding.btnFb.setReadPermissions("email");
        // Callback registration
        FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == FB) {
                    btnFb.performClick();
                }
            }
        });

            btnFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    Log.d("Moro", "Đăng nhập thành công!" + loginResult);
                }

                @Override
                public void onCancel() {
                    Log.d("Moro", "Hủy đăng nhập!");
                }

                @Override
                public void onError(FacebookException error) {
                    Log.d("Moro", "Đăng nhập không thành công" + error);
                }
            });
            LoginManager.getInstance().logOut();
            //Đăng nhập bằng Google
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            SignInButton signInButton = findViewById(R.id.sign_in_button);
            signInButton.setSize(SignInButton.SIZE_WIDE);
            GG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view == GG) {
                        signInButton.performClick();
                        signIn();
                        // thông báo đăng nhập thành công
                        Toast.makeText(Activity_Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //remember me
            SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
            String checkbox = preferences.getString("remember", "");
            if (checkbox.equals("true")){
                Intent intent = new Intent(Activity_Login.this, HomePage.class);
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
                            Intent intent = new Intent(Activity_Login.this, HomePage.class);
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

            //chuyển đến trang đăng ký
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_Register.class));
            }
        });

            // quên mật khẩu
            btnForgotPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Activity_Login.this, Activity_Forgot_Pass.class));
                }
            });
        }

        private void signIn() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {

            callbackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);

            // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                // The Task returned from this call is always completed, no need to attach
                // a listener.
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }
        }
        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
            try {
                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
                GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
                if (acct != null) {
                    String personName = acct.getDisplayName();
                    String personGivenName = acct.getGivenName();
                    String personFamilyName = acct.getFamilyName();
                    String personEmail = acct.getEmail();
                    String personId = acct.getId();
                    Uri personPhoto = acct.getPhotoUrl();

                }
                Intent intent = new Intent(Activity_Login.this, HomePage.class);
                startActivity(intent);

                // Signed in successfully, show authenticated UI.
//
            } catch (ApiException e) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.
                Log.d("message", e.toString());
            }
        }

        AccessTokenTracker t = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if(currentAccessToken == null) {
                    Toast.makeText(Activity_Login.this, "Bạn đã đăng xuất", Toast.LENGTH_SHORT).show();
                }else{
                    loaduserProfile(currentAccessToken);
                }

                if (t != null) {//<- IMPORTANT
                    Intent intent = new Intent(Activity_Login.this, HomePage.class);
                    startActivity(intent);
                    finish();//<- IMPORTANT
                }
            }
        };

        private void loaduserProfile(AccessToken newAccessToken) {
            GraphRequest request = GraphRequest.newMeRequest(newAccessToken, (this::onCompleted));
            Bundle parameters = new Bundle();
            parameters.putString("fields", "email,name,id");
            request.setParameters(parameters);
            request.executeAsync();
        }

    private void onCompleted(JSONObject object, GraphResponse response) {
        if (object != null) {
            try {
                String email = object.getString("email");
                String id = object.getString("id");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}