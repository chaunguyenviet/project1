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

public class BookAdapter extends FirebaseRecyclerAdapter<Book, BookAdapter.bookAdapterViewHolder> {

    public BookAdapter(@NonNull FirebaseRecyclerOptions<Book> optionsbookAdapter) {
        super(optionsbookAdapter);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookAdapter.bookAdapterViewHolder holder, int position, @NonNull Book model) {
        holder.tvBookName.setText(model.getName_Book());
        holder.tvBookAuthor.setText(model.getAuthor_Book());
        Glide.with(holder.ivBook.getContext()).load(model.getBook_Cover()).into(holder.ivBook);
    }

    @NonNull

    @Override
    public BookAdapter.bookAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_home_mid,parent,false);
        return new BookAdapter.bookAdapterViewHolder(view);
    }

    public class bookAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvBookName,tvBookAuthor;

        public bookAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBook = itemView.findViewById(R.id.ivBook);
            tvBookName = itemView.findViewById(R.id.tvBookNameinList);
            tvBookAuthor=itemView.findViewById(R.id.tvBookAuthor);
        }
    }
}