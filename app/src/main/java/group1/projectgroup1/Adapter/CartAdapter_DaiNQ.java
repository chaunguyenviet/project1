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

public class CartAdapter_DaiNQ  extends FirebaseRecyclerAdapter<Book, CartAdapter_DaiNQ.cartViewHolder>  {
    public CartAdapter_DaiNQ(@NonNull FirebaseRecyclerOptions<Book> optionsCart) {
        super(optionsCart);
    }

    @Override
    protected void onBindViewHolder(@NonNull CartAdapter_DaiNQ.cartViewHolder holder, int position, @NonNull Book model) {
        holder.tvTitleCart.setText(model.getName_Book());
        holder.textView19.setText(model.getPrice_Book());
        Glide.with(holder.ivCart.getContext()).load(model.getBook_Cover()).into(holder.ivCart);
    }

    @NonNull

    @Override
    public CartAdapter_DaiNQ.cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_cart,parent,false);
        return new CartAdapter_DaiNQ.cartViewHolder(view);
    }

    public class cartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCart;
        TextView tvTitleCart,textView19;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCart = itemView.findViewById(R.id.ivbooklist);
            tvTitleCart = itemView.findViewById(R.id.tvBookNamelist);
            textView19=itemView.findViewById(R.id.textView19);
        }
    }
}
