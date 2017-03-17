package id_iot.orest_task;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Recipe ITEM;
    ArrayList<Recipe> recipes;

    public RecyclerAdapter(Recipe recipe){
        ITEM = recipe;
        recipes = ITEM.getRecipies();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

       public ImageView itemImage;
        public TextView itemName;
        public TextView itemDetail;
        private CardView cardView;

        public ViewHolder (View view){
            super(view);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);
            cardView = (CardView) itemView.findViewById(R.id.cv);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i){
        viewHolder.itemName.setText(recipes.get(i).getRecipeName());
        viewHolder.itemDetail.setText(recipes.get(i).getRecipeDetail());
        viewHolder.itemImage.setImageResource(recipes.get(i).getRecipePhoto());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), recipes.get(viewHolder.getAdapterPosition()).getRecipeName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return ITEM.getRecipies().size();
    }


    public void filter(String recipeName) {
        recipeName = recipeName.toLowerCase(Locale.getDefault());
        recipes.clear();
        if (recipeName.length() == 0) {
            recipes.addAll(ITEM.getRecipies());
        } else {
            for (Recipe recipeIterator : ITEM.getRecipies()) {
                if (recipeIterator.getRecipeName().toLowerCase(Locale.getDefault()).contains(recipeName)) {
                    recipes.add(recipeIterator);
                }
            }
        }
        notifyDataSetChanged();
    }
}
