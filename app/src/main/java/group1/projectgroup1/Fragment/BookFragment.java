package group1.projectgroup1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

//import com.example.project1.R;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;


public class BookFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String book_Cover, name_Book, author_Book, price_Book, description_Book;

    public BookFragment() {

    }

    public BookFragment(String book_Cover, String name_Book, String author_Book, String price_Book, String description_Book) {
        this.book_Cover = book_Cover;
        this.name_Book = name_Book;
        this.author_Book = author_Book;
        this.price_Book = price_Book;
        this.description_Book = description_Book;
    }


    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
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
        View v = inflater.inflate(R.layout.fragment_book, container, false);

        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tvTitleDetail = v.findViewById(R.id.tvTitleDetail);
        TextView textView4 = v.findViewById(R.id.textView4);
        TextView textView5 = v.findViewById(R.id.textView5);
        TextView textView6 = v.findViewById(R.id.textView6);

        tvTitleDetail.setText(name_Book);
        textView4.setText(author_Book);
        textView5.setText(price_Book+" Đ");
        textView6.setText(description_Book);
        Glide.with(getContext()).load(book_Cover).into(imageView);

        return v;
    }

    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).addToBackStack(null).commit();
    }
}