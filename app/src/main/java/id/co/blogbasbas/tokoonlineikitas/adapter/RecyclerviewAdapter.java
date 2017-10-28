package id.co.blogbasbas.tokoonlineikitas.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.blogbasbas.tokoonlineikitas.DetailItemActivity;
import id.co.blogbasbas.tokoonlineikitas.R;

/**
 * Created by Server on 27/10/2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder> {

    private final Context context;
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name
    String [] judul1 ={" Programing Android","Android Beginner","Android Dasar","Android DB",
            "Easy Dev Android","Android Java","Android Awesome","Android Fundamental"};
    String [] desk = {"Book Fundamental","Book To be Expert","Hero To Zero ","Easy Make App",
            "make it again","Try error","it is easy","Being expert now"};
    String [] Harga = {"Rp. 100.000","Rp. 200.000","Rp. 70.000","Rp. 90.000",
            "Rp. 100.000","Rp. 200.000","Rp. 70.000","Rp. 90.000"};
    int gambar1 []= {R.drawable.b1,R.drawable.c1,R.drawable.book1,
            R.drawable.d1,R.drawable.b2,R.drawable.c2,R.drawable.book2,R.drawable.d2};
    int gambar2 []= {R.drawable.b2,R.drawable.c2,R.drawable.book2,R.drawable.d2,};
    LayoutInflater inflater;

    public RecyclerviewAdapter(Context context) {
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public RecyclerviewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.customlist, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyHolder holder, final int position) {
        holder.judul.setText(judul1[position]);
        holder.deskripsi.setText(desk[position]);
        holder.harga.setText(Harga[position]);
        holder.imgBook.setImageResource(gambar1[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(context, DetailItemActivity.class);
                kirim.putExtra("judul", judul1[position]);
                kirim.putExtra("desk", desk[position]);
                kirim.putExtra("harga", Harga[position]);
                kirim.putExtra("gmb", gambar1[position]);
                context.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return judul1.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       ImageView imgBook ;
        TextView judul, deskripsi, harga;

        public MyHolder(View itemView) {
            super(itemView);

            imgBook = (ImageView) itemView.findViewById(R.id.imgBook);
            judul = (TextView) itemView.findViewById(R.id.judul);
            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            harga = (TextView) itemView.findViewById(R.id.harga);
        }
    }
}
