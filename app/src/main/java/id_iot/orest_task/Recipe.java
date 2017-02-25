package id_iot.orest_task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Володимир on 24.02.2017.
 */

public class Recipe {
    String recipeName;
    int recipeAge;
    int recipePhoto;
    private ArrayList<Recipe> recipies = new ArrayList<>();

    public Recipe(){}

    public Recipe(String name, int age, int photo){
        this.recipeName = name;
        this.recipeAge = age;
        this.recipePhoto = photo;
    }

    private void initializeRecipes(){
        recipies.add(new Recipe("Bucket of hot nails", 1, R.drawable.logo));
        recipies.add(new Recipe("Chicken", 500, R.drawable.logo));
        recipies.add(new Recipe("Beef", 100, R.drawable.logo));
    }

    public ArrayList<Recipe> getRecipies(){
        return this.recipies;
    }
}
