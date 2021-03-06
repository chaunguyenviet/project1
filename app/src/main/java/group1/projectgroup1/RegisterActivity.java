package group1.projectgroup1;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    EditText etFullName, etEmail, etPass, etConfirmPass;
    Button btnRegister, btnRegisterGoogle;
    TextView tvGoBack;
    FirebaseAuth auth;
    ProgressBar progressBar;
    String emailCheck = "[a-z9-z0-9._-]+@[a-z]+\\.+[a-z]+";
    String userId;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etConfirmPass = findViewById(R.id.etConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegisterGoogle = findViewById(R.id.btnGoogleRegister);
        tvGoBack = findViewById(R.id.tvBackLogin);
        dialog = new ProgressDialog(this);

        auth = FirebaseAuth.getInstance();


        //Go Back Login
        tvGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, group1.projectgroup1.LoginActivity.class));
            }
        });

        //btn Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerAuth();
            }
        });
    }

    private String name = "", email = "", password = "", confirmPassword = "";

    //check form
    private void PerAuth() {
        name = etFullName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPass.getText().toString().trim();
        confirmPassword = etConfirmPass.getText().toString().trim();
        if (!email.matches(emailCheck)) {
            etEmail.setError("Email kh??ng h???p l???");
            return;
        }
        else if (password.isEmpty()) {
            etPass.setError("M???t kh???u kh??ng h???p l???");
            return;
        }
        else if (!password.equals(confirmPassword)) {
            etConfirmPass.setError("M???t kh???u kh??ng kh???p");
            return;
        }else {
            dialog.setMessage("Xin vui l??ng ?????i ...");
            dialog.setTitle("??ang kh???i t???o");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
//            createUser();
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "????ng k?? th??nh c??ng", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, group1.projectgroup1.LoginActivity.class));
                    } else {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "????ng k?? th???t b???i", Toast.LENGTH_LONG).show();
                        Log.d("ThatBai", task.getException().getMessage());
                    }
                }
            });
//            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        dialog.dismiss();
//                        Toast.makeText(RegisterActivity.this, "????ng k?? th??nh c??ng", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                    } else {
//                        dialog.dismiss();
//                        Toast.makeText(RegisterActivity.this, "????ng k?? th???t b???i", Toast.LENGTH_LONG).show();
//                        Log.d("ThatBai", task.getException().getMessage());
//                    }
//                }
//            });
        }
    }

    private void createUser() {

        //Create user
//        fAuth.createUserWithEmailAndPassword(email, password)
//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        inFo();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure( Exception e) {
//                        dialog.dismiss();
//
//                    }
//                });


    }

    private void inFo() {
        dialog.setMessage("??ang l??u user");
        long time = System.currentTimeMillis();
        userId = auth.getUid();
        //setup
        Map<String, Object> user = new HashMap<>();
        user.put("uid", userId);
        user.put("fullName", name);
        user.put("Email", email);
        user.put("avatar", "");//later
        user.put("role", "user");
        user.put("time", time);
        //set to db

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        ref.child(userId)
                .setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"Th??nh c??ng",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, group1.projectgroup1.LoginActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"L???i"+e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
    }


}