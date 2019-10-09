package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.MESSAGE_TASKED;

/**
 * Handles the list command and inherits all the fields and methods of Command parent class.
 */
public class ListCommand extends CommandTest {

    /**
     * Constructor for class ListCommand.
     * @param userInputCommand String containing input command from user
     */
    public ListCommand(String userInputCommand) {
        this.userInputCommand = userInputCommand;
    }

    /**
     * Processes the list command to display all tasks in task list.
     * @param taskList contains the task list
     * @param ui deals with interactions with the user
     * @param storage deals with loading tasks from the file and saving tasks in the file
     */
    @Override
    public ArrayList<String> feedback(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(MESSAGE_TASKED);
        arrayList.addAll(taskList.listTask());
        return arrayList;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
