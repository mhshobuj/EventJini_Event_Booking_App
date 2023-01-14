package com.example.eventjinni.view.View.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eventjinni.R;
import com.example.eventjinni.view.View.db.DataBaseHelper;
import com.example.eventjinni.view.View.model.OrderInfoModel;
import com.example.eventjinni.view.View.view.OrderDetails;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<OrderInfoModel> arrayList;
    Context context;

    public MyAdapter(ArrayList<OrderInfoModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_item_card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.order_id_tv.setText(new StringBuilder().append(arrayList.get(position).getId()));
        holder.provider_name_tv.setText(new StringBuilder().append(arrayList.get(position).getProvider_name()));
        holder.customer_name_tv.setText(new StringBuilder().append(arrayList.get(position).getCustomer_name()));
        holder.address_tv.setText(new StringBuilder().append(arrayList.get(position).getAddress()));

        holder.setListener((view, pos) -> {
            Intent intent = new Intent(context, OrderDetails.class);
            intent.putExtra("ID", arrayList.get(pos).getId());
            context.startActivity(intent);

        });

        holder.delete_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Conformation !!!");
                builder.setMessage("Are you sure to delete ?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataBaseHelper dbHelper = new DataBaseHelper(context);
                        int result = dbHelper.deleteUser(arrayList.get(position).getId());
                        if (result > 0){
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            arrayList.remove(arrayList.get(position));
                            notifyDataSetChanged();
                        }
                        else {
                            Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int pos);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView order_id_tv, provider_name_tv, customer_name_tv,address_tv;
        ImageView delete_iv;

        RecyclerViewClickListener listener;

        public void setListener(RecyclerViewClickListener listener) {
            this.listener = listener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            order_id_tv = (TextView) itemView.findViewById(R.id.order_id_tv);
            provider_name_tv = (TextView) itemView.findViewById(R.id.provider_name_tv);
            customer_name_tv = (TextView) itemView.findViewById(R.id.customer_name_tv);
            address_tv = (TextView) itemView.findViewById(R.id.address_tv);

            delete_iv = (ImageView) itemView.findViewById(R.id.delete_iv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
