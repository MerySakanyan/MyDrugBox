package com.example.mery.drugbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DrugsListAdapter extends RecyclerView.Adapter<DrugsListAdapter.MyViewHolder> {
  private List<DrugList> list;
    private Context context;

    public DrugsListAdapter(Context context,List<DrugList> list) {
        this.context = context;
        this.list=list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_drugs, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getDrugName());
        holder.price.setText(list.get(position).getPrice());

        if(list.get(position).getPharmacy().equals("Vaga Pharm")){
            holder.imageView.setImageResource(R.drawable.vaga);
        }else  if(list.get(position).getPharmacy().equals("Alfa Pharm")){
            holder.imageView.setImageResource(R.drawable.alfa);
        }
        else  if(list.get(position).getPharmacy().equals("Natali Pharm")){
            holder.imageView.setImageResource(R.mipmap.nataali);
        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Drugs.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("key", list.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name, price;
        private ConstraintLayout layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textdrugname);
            price=itemView.findViewById(R.id.textprice);
            imageView=itemView.findViewById(R.id.circleImageView);
            layout=itemView.findViewById(R.id.layout);

        }

    }
    public void setFilter(ArrayList<DrugList> newlist) {
        list = new ArrayList<>();
        list.addAll(newlist);
        notifyDataSetChanged();
    }
}
