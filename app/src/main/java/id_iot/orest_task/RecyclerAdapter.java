package id_iot.orest_task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String names[] = {"Bucket of hot nails", "Chicken", "Oliv`e"};
    String details[] = {"2 ingredients", "3 ingredients", "5 ingredients"};
    int images[] = {R.drawable.logo, R.drawable.logo2, R.drawable.logo3};

    class ViewHolder extends RecyclerView.ViewHolder{

       public ImageView itemImage;
        public TextView itemName;
        public TextView itemDetail;

        public ViewHolder (View view){
            super(view);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i){
        viewHolder.itemName.setText(names[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount(){
        return names.length;
    }

    public String[] getNames(){
        return names;
    }
}
