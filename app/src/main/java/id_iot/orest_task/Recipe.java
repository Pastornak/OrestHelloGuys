package id_iot.orest_task;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeName;
    private String recipeDetail;
    private int recipePhoto;
    private ArrayList<Recipe> recipies = new ArrayList<>();

    public Recipe(){
        recipies.add(new Recipe("Bucket of hot nails", "2 ingredients", R.drawable.bucket_of_nails));
        recipies.add(new Recipe("Chicken", "3 ingredients", R.drawable.chicken));
        recipies.add(new Recipe("Beef", "5 ingredients", R.drawable.beef));
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
