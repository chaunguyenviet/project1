package group1.projectgroup1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.project1.Adapter.BookAdapter;
//import com.example.project1.Adapter.TopAdapterHome;
//import com.example.project1.Model.Book;
//import com.example.project1.R;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import group1.projectgroup1.Adapter.BookAdapter_DaiNQ;
import group1.projectgroup1.Adapter.BotAdapterHome;
import group1.projectgroup1.Adapter.TopAdapterHome_DaiNQ;
import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    DatabaseReference bookdatareferences;

    RecyclerView rcvTop;
    RecyclerView rcvMid;
    RecyclerView rcvBot;

    BookAdapter_DaiNQ bookAdapter_daiNQ;
    TopAdapterHome_DaiNQ topAdapterHome_daiNQ;
    BotAdapterHome botAdapterHome;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvTop = (RecyclerView)view.findViewById(R.id.rcvHome);
        rcvTop.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        rcvMid = (RecyclerView)view.findViewById(R.id.rcvHomeMid);
        rcvMid.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        rcvBot = (RecyclerView)view.findViewById(R.id.rcvHomeBot);
        rcvBot.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<Book> options =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books").orderByChild("recommend_Book").startAt("true"), Book.class)
                        .build();
        bookAdapter_daiNQ = new BookAdapter_DaiNQ(options);
        rcvMid.setAdapter(bookAdapter_daiNQ);

        FirebaseRecyclerOptions<Book> options3 =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books").orderByChild("saleOff_Book").startAt("true"), Book.class)
                        .build();
        botAdapterHome = new BotAdapterHome(options3);
        rcvBot.setAdapter(botAdapterHome);

        FirebaseRecyclerOptions<Book> options2 =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books").orderByChild("view_Book").limitToFirst(3), Book.class)
                        .build();
        topAdapterHome_daiNQ = new TopAdapterHome_DaiNQ(options2);
        rcvTop.setAdapter(topAdapterHome_daiNQ);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bookAdapter_daiNQ.startListening();
        topAdapterHome_daiNQ.startListening();
        botAdapterHome.startListening();
}

    @Override
    public void onStop() {
        super.onStop();
        bookAdapter_daiNQ.stopListening();
        topAdapterHome_daiNQ.stopListening();
        botAdapterHome.stopListening();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}