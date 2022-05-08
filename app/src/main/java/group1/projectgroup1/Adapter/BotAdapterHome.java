package group1.projectgroup1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;

public class BotAdapterHome extends FirebaseRecyclerAdapter<Book, BotAdapterHome.BotBookViewHolder> {

    public BotAdapterHome(@NonNull FirebaseRecyclerOptions<Book> options3) {
        super(options3);
    }

    @Override
    protected void onBindViewHolder(@NonNull BotAdapterHome.BotBookViewHolder holder, int position, @NonNull Book model) {
        holder.tvBookName.setText(model.getName_Book());
        holder.tvBookAuthor.setText(model.getAuthor_Book());
        Glide.with(holder.ivBook.getContext()).load(model.getBook_Cover()).into(holder.ivBook);
    }

    @NonNull

    @Override
    public BotAdapterHome.BotBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_home_mid,parent,false);
        return new BotAdapterHome.BotBookViewHolder(view);
    }

    public class BotBookViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvBookName,tvBookAuthor;

        public BotBookViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBook = itemView.findViewById(R.id.ivBook);
            tvBookName = itemView.findViewById(R.id.tvBookNameinList);
            tvBookAuthor=itemView.findViewById(R.id.tvBookAuthor);
        }
    }
}
