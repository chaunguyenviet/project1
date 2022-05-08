package group1.projectgroup1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.project1.Adapter.TestAdapter;
//import com.example.project1.Model.Book;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import group1.projectgroup1.R;

public class MainActivity extends AppCompatActivity {
    Button btnHelloWorld;
//    TextView tvHelloWorld;
//    DatabaseReference reference;
//    ArrayList<Book> books;
//    RecyclerView recyclerViewFeaturedBooks;
//    TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHelloWorld=findViewById(R.id.btnHelloWorld);
        btnHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });
//        tvHelloWorld=findViewById(R.id.tvHelloWorld);
//
//        recyclerViewFeaturedBooks = findViewById(R.id.recyclerViewFeaturedBooks);
//        recyclerViewFeaturedBooks.setHasFixedSize(true);
//        testAdapter = new TestAdapter(this, books);
//        recyclerViewFeaturedBooks.setAdapter(testAdapter);
//
//        reference= FirebaseDatabase.getInstance().getReference().child("books");
//
//        btnHelloWorld.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                books=new ArrayList<>();
//                reference.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                            Toast.makeText(MainActivity.this, "alo", Toast.LENGTH_SHORT).show();
//                            Book book_daiNQ = dataSnapshot.getValue(Book.class);
//                            books.add(book_daiNQ);
//                        }
//                        testAdapter.notifyDataSetChanged();
//
//
//                    }
//
//                    @Override
//                    public void onChildChanged(@NonNull DataSnapshot snapshot, String previousChildName) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
//        });

    }
}