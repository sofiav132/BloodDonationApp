package com.example.blooddonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileEditActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String UserID;
    private EditText editFullName, editNIK, editPhoneNumber;
    private CircleImageView editProfileImage;
    private FirebaseUser users;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        users = FirebaseAuth.getInstance().getCurrentUser();
        editFullName = findViewById(R.id.editFullName);
        editNIK = findViewById(R.id.editNIK);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editProfileImage = findViewById(R.id.editProfileImage);
        UserID = users.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    editFullName.setText(snapshot.child("name").getValue().toString());
                    editNIK.setText(snapshot.child("NIK").getValue().toString());
                    editPhoneNumber.setText(snapshot.child("phonenumber").getValue().toString());

                    Glide.with(getApplicationContext()).load(snapshot.child("profilepictureurl").getValue().toString()).into(editProfileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void updateUser(View v){
        String fullName = editFullName.getText().toString();
        String NIK = editNIK.getText().toString();
        String phoneNumber = editPhoneNumber.getText().toString();

        HashMap map = new HashMap();
        map.put("name", fullName);
        map.put("phonenumber", phoneNumber);
        map.put("NIK", NIK);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        reference.child(UserID).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(ProfileEditActivity.this, "Your profile has been successfully updated!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileEditActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}