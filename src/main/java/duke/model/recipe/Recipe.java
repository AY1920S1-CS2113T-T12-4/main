package duke.model.recipe;

import duke.list.recipelist.RecipeIngredientList;
import duke.task.recipetasks.Feedback;
import duke.task.recipetasks.PrepStep;
import duke.task.recipetasks.Rating;
import duke.task.recipetasks.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String recipeTitle;
    private RecipeIngredient recipeIngredient;
//    private PrepStepList prepStep;
    private Rating rating;
    private Feedback feedback;

    public Recipe(String recipeTitle, RecipeIngredient recipeIngredient, Rating rating, Feedback feedback) {
        this.recipeTitle = recipeTitle;
        this.recipeIngredient = recipeIngredient;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String toSaveString() {
        return "recipe" + " | " + recipeTitle + " | " + recipeIngredient + " | " + rating + " | " + feedback;
    }

    public String toString() {
        return "[Recipe Title: " + recipeTitle + "] " + "[Recipe Ingredient: " + recipeIngredient + "] "
                + "[Rating: " + rating + "] " + "[Feedback: " + feedback + "] ";    }

//    public String getRecipeTitle() {
//        return recipeTitle;
//    }
//
//    public RecipeIngredientList getRecipeTngredientList() {
//        return recipeIngredientList;
//    }
//
//    public Rating getRating() {
//        return rating;
//    }
//
//    public Feedback getFeedback() {
//        return feedback;
//    }

//    public void addIngredient(RecipeIngredient recipeIngredient) {
//        recipeIngredient.add(recipeIngredient);
//    }

//    public void addPrepStep(PrepStep prepstep) { prepStep.add(prepstep); }

//    public void addRating(Rating rating) { this.rating = rating; }
//
//    public void addFeedback(Feedback feedback) { this.feedback = feedback; }
}
