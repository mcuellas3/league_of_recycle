package com.example.league_of_recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RankingListAdapter extends RecyclerView.Adapter<RankingListAdapter.ViewHolder> {
    private List<ListRanking> mData;
    private LayoutInflater mInflater;
    private Context context;

    public RankingListAdapter(List<ListRanking> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {return mData.size();}

    @Override
    public RankingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.elementosranking, null);
        return new RankingListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RankingListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListRanking> items) { mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre, puntos;

        ViewHolder(View itemview){
            super(itemview);
            iconImage = itemView.findViewById(R.id.fotoPremio);
            nombre = itemView.findViewById(R.id.tv_nombrePremio);
            puntos = itemView.findViewById(R.id.tv_puntosPremio);
        }

        void bindData(final ListRanking item) {
            // iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombre());
            puntos.setText(item.getPuntos());
        }
    }
}
