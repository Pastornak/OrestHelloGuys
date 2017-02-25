package id_iot.orest_task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Recipe ITEM = new Recipe();

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
        viewHolder.itemName.setText(ITEM.getRecipies().get(i).getRecipeName());
        viewHolder.itemDetail.setText(ITEM.getRecipies().get(i).getRecipeDetail());
        viewHolder.itemImage.setImageResource(ITEM.getRecipies().get(i).getRecipePhoto());
    }

    @Override
    public int getItemCount(){
        return ITEM.getRecipies().size();
    }
}
