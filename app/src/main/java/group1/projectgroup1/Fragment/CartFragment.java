package group1.projectgroup1.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.project1.Adapter.CartAdapter;
//import com.example.project1.Model.Book;
//import com.example.project1.R;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import group1.projectgroup1.Adapter.BookAdapter_DaiNQ;
import group1.projectgroup1.Adapter.CartAdapter;
import group1.projectgroup1.Adapter.CartAdapter_DaiNQ;
import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;


public class CartFragment extends Fragment {
    RecyclerView rcvCart;
    CartAdapter_DaiNQ cartAdapter_daiNQ;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CartFragment() {

    }


    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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

        View view = inflater.inflate(R.layout.fragment_cart, container, false);


        rcvCart = (RecyclerView)view.findViewById(R.id.rcvCart);
        rcvCart.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Book> optionsCart =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), Book.class)
                        .build();
        cartAdapter_daiNQ = new CartAdapter_DaiNQ(optionsCart);
        rcvCart.setAdapter(cartAdapter_daiNQ);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        cartAdapter_daiNQ.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        cartAdapter_daiNQ.stopListening();
    }

}