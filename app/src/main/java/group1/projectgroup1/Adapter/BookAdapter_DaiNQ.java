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

public class BookAdapter_DaiNQ extends FirebaseRecyclerAdapter<Book, BookAdapter_DaiNQ.bookViewHolder> {

    public BookAdapter_DaiNQ(@NonNull FirebaseRecyclerOptions<Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookAdapter_DaiNQ.bookViewHolder holder, int position, @NonNull Book model) {
        holder.tvBookName.setText(model.getName_Book());
        holder.tvBookAuthor.setText(model.getAuthor_Book());
        Glide.with(holder.ivBook.getContext()).load(model.getBook_Cover()).into(holder.ivBook);
    }

    @NonNull

    @Override
    public BookAdapter_DaiNQ.bookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_home_mid,parent,false);
        return new BookAdapter_DaiNQ.bookViewHolder(view);
    }

    public class bookViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvBookName,tvBookAuthor;

        public bookViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBook = itemView.findViewById(R.id.ivBook);
            tvBookName = itemView.findViewById(R.id.tvBookNameinList);
            tvBookAuthor=itemView.findViewById(R.id.tvBookAuthor);
        }
    }
}
