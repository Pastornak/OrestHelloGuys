package id_iot.orest_task;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String recipeName;
    String recipeDetail;
    int recipePhoto;
    private ArrayList<Recipe> recipies = new ArrayList<>();

    public Recipe(){
        recipies.add(new Recipe("Bucket of hot nails", "2 ingredients", R.drawable.logo));
        recipies.add(new Recipe("Chicken", "3 ingredients", R.drawable.logo2));
        recipies.add(new Recipe("Beef", "5 ingredients", R.drawable.logo3));
    }

    private Recipe(String name, String detail, int photo){
        this.recipeName = name;
        this.recipeDetail = detail;
        this.recipePhoto = photo;
    }

    public ArrayList<Recipe> getRecipies(){
        return this.recipies;
    }

    public String getRecipeName(){
        return this.recipeName;
    }

    public String getRecipeDetail(){
        return this.recipeDetail;
    }

    public int getRecipePhoto(){
        return this.recipePhoto;
    }
}
