package group1.projectgroup1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;
import group1.projectgroup1.bookList;

public class BookListAdapter extends FirebaseRecyclerAdapter<Book, BookListAdapter.bookListViewHolder> implements Filterable {

    public List<Book> mListBook;


    public BookListAdapter(@NonNull List<Book> optionsbookAdapter) {
        super(optionsbookAdapter);
    }

    public BookListAdapter(bookList bookList, int activity_list_item, ArrayList<String> arrayListView) {
        super(bookList);
    }

    public BookListAdapter(void listBook) {
        super();
    }

    @Override
    protected void onBindViewHolder(@NonNull BookListAdapter.bookListViewHolder holder, int position, @NonNull Book model) {
        holder.tvBookNameList.setText(model.getName_Book());
        holder.tvWriter.setText(model.getAuthor_Book());
        holder.tvPrice.setText(model.getPrice_Book());
        Glide.with(holder.imvBooklist.getContext()).load(model.getBook_Cover()).into(holder.imvBooklist);
    }

    @NonNull

    @Override
    public BookListAdapter.bookListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list,parent,false);
        return new BookListAdapter.bookListViewHolder(view);
    }


    public class bookListViewHolder extends RecyclerView.ViewHolder {
        ImageView imvBooklist;
        TextView tvBookNameList, tvWriter, tvPrice;
        public bookListViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBooklist = itemView.findViewById(R.id.ivbooklist);
            tvBookNameList = itemView.findViewById(R.id.tvBookNameinList);
            tvWriter = itemView.findViewById(R.id.tvWriterNameList);
            tvPrice = itemView.findViewById(R.id.feeEachItemm);

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String searhtext = constraint.toString();
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }
}
