package group1.projectgroup1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.project1.Adapter.CategoryAdapterAdmin;
//import com.example.project1.Model.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import group1.projectgroup1.Adapter.CategoryAdapterAdmin;
import group1.projectgroup1.Model.Category;

public class CategoryActivityAdmin extends AppCompatActivity {

    RecyclerView rcvCategory;

    ArrayList<Category> cate_list;
    CategoryAdapterAdmin adapterCate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_admin);
        rcvCategory=findViewById(R.id.rcvCateAdmin);
        loadListCategory();
    }

    private void loadListCategory() {
        cate_list = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("categories");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                cate_list.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    //get data
                    Category category = ds.getValue(Category.class);
                    //add to array
                    cate_list.add(category);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                rcvCategory.setLayoutManager(linearLayoutManager);
                //setup adapter
                adapterCate = new CategoryAdapterAdmin(this,cate_list);
                //set adapter to rcv
                rcvCategory.setAdapter(adapterCate);


            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}