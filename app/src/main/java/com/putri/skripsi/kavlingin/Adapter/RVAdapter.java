package com.putri.skripsi.kavlingin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.putri.skripsi.kavlingin.Activity.DetailActivity;
import com.putri.skripsi.kavlingin.R;
import com.putri.skripsi.kavlingin.Models.ResultItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    @NonNull
    private Context context;
    private List<ResultItem> results;

    public RVAdapter(@NonNull Context context, List<ResultItem> results) {
        this.context = context;
        this.results = results;
    }

    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listtanah, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final ResultItem result = results.get(i);
        viewHolder.txtjudul.setText(result.getJudul());
        viewHolder.tvharga.setText("Harga Rp." + result.getHarga());
        viewHolder.tvstok.setText("Jumlah " + result.getStok());
        viewHolder.tvstatus.setText(result.getIdTransaksi());
        viewHolder.txtpenjual.setText(result.getNama());
        Glide.with(context)
                .load(result.getGbr())


                .into(viewHolder.imgItemPhoto);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("title", result.getJudul());
                intent.putExtra("id_user", result.getNama());
                intent.putExtra("gambar", result.getGbr());
                intent.putExtra("jumlah", result.getStok());
                intent.putExtra("lat", result.getLat());
                intent.putExtra("lng", result.getLng());
                intent.putExtra("nohp", result.getNohp());
                intent.putExtra("harga", result.getHarga());
                intent.putExtra("idtransaksi", result.getIdTransaksi());
                intent.putExtra("id", result.getId());

                viewHolder.itemView.getContext().startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item_photo)
        ImageView imgItemPhoto;
        @BindView(R.id.txtjudul)
        TextView txtjudul;
        @BindView(R.id.tvharga)
        TextView tvharga;
        @BindView(R.id.tvstok)
        TextView tvstok;
        @BindView(R.id.tvstatus)
        TextView tvstatus;
        @BindView(R.id.txtpenjual)
        TextView txtpenjual;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
