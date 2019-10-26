package duke.logic.command.recipecommands;

import duke.logic.command.Command;
import duke.model.list.recipelist.RecipeList;
import duke.storage.RecipeStorage;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.*;
import static duke.common.RecipeMessages.*;

public class EditFeedbackCommand extends Command<RecipeList, Ui, RecipeStorage> {

    public EditFeedbackCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public ArrayList<String> execute(RecipeList recipeList, Ui ui, RecipeStorage recipeStorage) throws ParseException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (userInput.trim().equals(COMMAND_EDIT_FEEDBACK)) {
            arrayList.add(ERROR_MESSAGE_GENERAL + MESSAGE_FOLLOWUP_NUll);
            System.out.println("stuck here 7");
        } else if (userInput.trim().charAt(12) == ' ') {
            String description = userInput.split("\\s", 2)[1].trim();
            if (description.contains("f/")) {
                String recipeTitle, feedback;
                String[] split = description.split("f/", 2);
                recipeTitle = split[0].trim();
                feedback = split[1].trim();
                if (recipeTitle.isEmpty()) {
                    arrayList.add(ERROR_MESSAGE_EDIT_FEEDBACK_INCOMPLETE);
                } else {
                    if (feedback.equals("")) {
                        feedback = "No feedback yet.";
                    }
                    recipeList.editFeedback(recipeTitle, feedback);
                    recipeStorage.saveFile(recipeList);
                    arrayList.add("The feedback of " + "'" + recipeTitle + "'" + " has been edited to: " + feedback);
                }
            } else {
                arrayList.add(ERROR_MESSAGE_FEEDBACK_INCORRECT_FORMAT);
            }
        } else {
            arrayList.add(ERROR_MESSAGE_RANDOM);
        }
        return arrayList;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
