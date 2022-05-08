package group1.projectgroup1.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.project1.Model.Book;
//import com.example.project1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import group1.projectgroup1.Fragment.CartFragment;
import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    ArrayList<Book> listBook;
    CartFragment context;

    public CartAdapter(CartFragment context,ArrayList<Book> listBook) {
        this.context=context;
        this.listBook = listBook;
        notifyDataSetChanged();
    }

//    public CartAdapter(ArrayList<Book> listBook) {
//        this.listBook = listBook;
//    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Book book_daiNQ = listBook.get(position);
        URL url = null;
        try {
            url = new URL(book_daiNQ.getBook_Cover());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection httpConn = null;
        try {
            assert url != null;
            httpConn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert httpConn != null;
            httpConn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int resCode = 0;
        try {
            resCode = httpConn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (resCode == HttpURLConnection.HTTP_OK) {
            InputStream in = null;
            try {
                in = httpConn.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(in);

            holder.ivBook.setImageBitmap(bitmap);
        }
//        holder.ivBook.setImageResource(listBook.get(position).getResId());
        holder.tvTitle.setText(book_daiNQ.getName_Book());
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivBook;
        private final TextView tvTitle;
        public CartViewHolder( View itemView) {
            super(itemView);
            ivBook=itemView.findViewById(R.id.ivbooklist);
            tvTitle=itemView.findViewById(R.id.tvBookNamelist);
        }
    }
}
