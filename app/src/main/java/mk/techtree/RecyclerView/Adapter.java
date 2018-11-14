package mk.techtree.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mk.techtree.Content.Content_activity;
import mk.techtree.R;
import spencerstudios.com.bungeelib.Bungee;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    List<List_View_Setters> list_view_setters;
    LayoutInflater layoutInflater;

    public Adapter(Context context, List<List_View_Setters> list_view_setters) {
        this.context = context;
        this.list_view_setters = list_view_setters;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.card, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, final int position) {

        final List_View_Setters list_view_setters1 = list_view_setters.get(position);
        holder.projects.setText(list_view_setters1.getName_project());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Content_activity.class);
                intent.putExtra("Title",list_view_setters1.getName_project());
                intent.putExtra("Description",list_view_setters1.getDescription());
                intent.putExtra("Code",list_view_setters1.getCode());
                intent.putExtra("Image",list_view_setters1.getImage());
                view.getContext().startActivity(intent);
                Bungee.slideUp(view.getContext());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_view_setters.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView projects;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            projects = itemView.findViewById(R.id.project);
            cardView = itemView.findViewById(R.id._card);

        }
    }
}
