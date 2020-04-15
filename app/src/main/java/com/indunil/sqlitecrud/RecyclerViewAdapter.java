package com.indunil.sqlitecrud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.DatabaseViewHolder>{

    ArrayList<ModelClass> objModelClassArrayListl;

    public RecyclerViewAdapter(ArrayList<ModelClass> objModelClassArrayListl) {
        this.objModelClassArrayListl = objModelClassArrayListl;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new DatabaseViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.DatabaseViewHolder holder, int position) {

        ModelClass objModelClass = objModelClassArrayListl.get(position);
        holder.Id.setText(Integer.toString(objModelClass.getID()));
        holder.Name.setText(objModelClass.Name);
        holder.Mobile.setText(objModelClass.Mobile);
        holder.Email.setText(objModelClass.Email);
        holder.Address.setText(objModelClass.Address);

    }

    @Override
    public int getItemCount() {
        return objModelClassArrayListl.size();
    }

    public  static class DatabaseViewHolder extends RecyclerView.ViewHolder{

        TextView Id,Name,Mobile,Email,Address;
        public DatabaseViewHolder(@NonNull View itemView) {
            super(itemView);
            Id=itemView.findViewById(R.id.tID );
            Name=itemView.findViewById(R.id.tName );
            Mobile=itemView.findViewById(R.id.tMobile );
            Email=itemView.findViewById(R.id.tEmail );
            Address=itemView.findViewById(R.id.tAddress );

        }
    }

}
