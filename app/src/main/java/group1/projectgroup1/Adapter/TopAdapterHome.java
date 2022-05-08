package group1.projectgroup1.Adapter;

import android.content.Context;
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

import group1.projectgroup1.Fragment.HomeFragment;
import group1.projectgroup1.Model.Book;
import group1.projectgroup1.R;


public class TopAdapterHome extends RecyclerView.Adapter<TopAdapterHome.MyViewHolder> {
    ArrayList<Book> listBook;
    Context context;

    public TopAdapterHome(HomeFragment context, ArrayList<Book> listBook) {
//        this.context = context;
        this.listBook = listBook;
        notifyDataSetChanged();
    }

    //    public TopAdapterHome(ArrayList<Book> listBook) {
//    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_book_home_top, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
        return (listBook == null) ? 0 : listBook.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivBook;
        private final TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivBook = itemView.findViewById(R.id.imgBook1);
            tvTitle = itemView.findViewById(R.id.tvTitle);


        }
    }
}
