package group1.projectgroup1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//import com.example.project1.R;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import group1.projectgroup1.Model.User;
import group1.projectgroup1.R;

public class ProfileFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference database;
    User user;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView tvUserNameProfile = v.findViewById(R.id.tvUserNameProfile);
        TextView tvEmailProfile = v.findViewById(R.id.tvEmailProfile);
        TextView tvUserNameIndexProfile = v.findViewById(R.id.tvUserNameIndexProfile);
        TextView tvEmailIndexProfile = v.findViewById(R.id.tvEmailIndexProfile);
        TextView tvPhoneNumberIndexProfile = v.findViewById(R.id.tvPhoneNumberIndexProfile);
        ImageView imgUserProfile = v.findViewById(R.id.imgUserProfile);

        firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference().child("users");

        Bundle bundle = getArguments();

       if (bundle!=null){
           database.addChildEventListener(new ChildEventListener() {
               @Override
               public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                   for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                       User user = dataSnapshot.getValue(User.class);
                       if (user.getEmail_User().equals(bundle.getString("email2"))) {
                           tvUserNameProfile.setText(user.getName_User());
                           tvEmailProfile.setText(user.getEmail_User());
                           tvUserNameIndexProfile.setText(user.getName_User());
                           tvEmailIndexProfile.setText(user.getEmail_User());
                           tvPhoneNumberIndexProfile.setText(user.getPhone_User());
                           Glide.with(getContext()).load(user.getImage_Cover()).into(imgUserProfile);
                           Toast.makeText(getContext(), "Abc", Toast.LENGTH_SHORT).show();
                       }

                   }
               }

               @Override
               public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

               }

               @Override
               public void onChildRemoved(@NonNull DataSnapshot snapshot) {

               }

               @Override
               public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });
       }


        return v;
    }
}