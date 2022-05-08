package group1.projectgroup1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import group1.projectgroup1.Adapter.BookListAdapter;
import group1.projectgroup1.Model.Book;

public class bookList extends AppCompatActivity {
    DatabaseReference booklist;
    RecyclerView rcv_book;
    BookListAdapter arrayAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        booklist = FirebaseDatabase.getInstance().getReference("books");
        rcv_book = findViewById(R.id.rcv_listbook);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv_book.setLayoutManager(layoutManager);

        ArrayList<String> arrayListView = new ArrayList<>();
        arrayAdapter = new BookListAdapter((bookList) getApplicationContext(), android.R.layout.simple_list_item_1, arrayListView);
        rcv_book.setAdapter(arrayAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        rcv_book.addItemDecoration(itemDecoration);

        booklist.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                String value = snapshot.getValue(Book.class).toString();
                arrayListView.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_item, menu);
        SearchManager search = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search_list).getActionView();
        searchView.setSearchableInfo(search.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);




        return true;
    }
}