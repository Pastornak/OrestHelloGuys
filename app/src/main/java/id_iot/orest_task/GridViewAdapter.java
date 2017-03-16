package id_iot.orest_task;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    Recipe recipe;
    private final ArrayList<Recipe> recipes;
    ImageView favoriteStar;

    public GridViewAdapter(Context c) {
        mContext = c;
        recipe = new Recipe();
        recipes = recipe.getRecipies();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.grid_view_cell, null);

        ImageView recipePhoto = (ImageView) convertView.findViewById(R.id.grid_image);
        favoriteStar = (ImageView) convertView.findViewById(R.id.grid_favorite);
        TextView recipeName = (TextView) convertView.findViewById(R.id.grid_name);
        TextView recipeDetail = (TextView) convertView.findViewById(R.id.grid_detail);
        recipeName.setText(recipes.get(position).getRecipeName());
        recipeDetail.setText(recipes.get(position).getRecipeDetail());
        favoriteStar.setImageResource(recipes.get(position).getFavorite()? R.drawable.favorite_checked: R.drawable.favorite_unchecked_2);
        recipePhoto.setImageResource(recipes.get(position).getRecipePhoto());
        return convertView;
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    public void filter(String recipeName) {
        recipeName = recipeName.toLowerCase(Locale.getDefault());
        recipes.clear();
        if (recipeName.length() == 0) {
            recipes.addAll(recipe.getRecipies());
        } else {
            for (Recipe recipeIterator : recipe.getRecipies()) {
                if (recipeIterator.getRecipeName().toLowerCase(Locale.getDefault()).contains(recipeName)) {
                    recipes.add(recipeIterator);
                }
            }
        }
        notifyDataSetChanged();
    }
}
