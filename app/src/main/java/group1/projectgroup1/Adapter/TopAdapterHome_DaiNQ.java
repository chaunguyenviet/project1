package group1.projectgroup1.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import group1.projectgroup1.BookActivity;
import group1.projectgroup1.Fragment.BookFragment;
import group1.projectgroup1.Fragment.HomeFragment;
import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;

public class TopAdapterHome_DaiNQ extends FirebaseRecyclerAdapter<Book, TopAdapterHome_DaiNQ.BookViewHolder> {



    public TopAdapterHome_DaiNQ(@NonNull FirebaseRecyclerOptions<Book> options2) {
        super(options2);
    }

    @Override
    protected void onBindViewHolder(@NonNull TopAdapterHome_DaiNQ.BookViewHolder holder, int position, @NonNull Book model) {
        holder.tvTitle.setText(model.getName_Book());
        Glide.with(holder.imgBook1.getContext()).load(model.getBook_Cover()).into(holder.imgBook1);
        holder.btnBookTopHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new BookFragment(model.getBook_Cover(),model.getName_Book(),model.getAuthor_Book(),model.getPrice_Book(),model.getDescription_Book())).addToBackStack(null).commit();
            }
        });
    }

    @NonNull

    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_home_top,parent,false);
        return new BookViewHolder(view);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook1;
        TextView tvTitle;
        Button btnBookTopHome;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook1 = itemView.findViewById(R.id.imgBook1);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            btnBookTopHome=itemView.findViewById(R.id.btnBookTopHome);

        }
    }
}
