package duke.model.list.recipelist;

import duke.model.task.recipetasks.Feedback;

import java.util.ArrayList;

import static duke.common.Messages.*;

public class FeedbackList {
    private static String msg = "";
    private ArrayList<Feedback> feedbackList;

    public FeedbackList() {
        this.feedbackList = new ArrayList<>();
    }

    /**
     * Constructor for class FeedbackList.
     *
     * @param feedbackList list containing all the feedback
     */
    public FeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    /**
     * Lists all the feedback.
     *
     * @return arrList containing all the feedback
     */
    public ArrayList<String> listFeedback() {
        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            final int displayedIndex = i + DISPLAYED_INDEX_OFFSET;
            arrList.add(feedbackList.get(i).toString());
        }
        return arrList;
    }


//    public void addFeedback(String feedback) throws ParseException {
//        feedbackList.add(new Feedback(getSize() + 1, feedback));
//        int index = feedbackList.size();
//        if (index == 1) {
//            msg = " feedback in the list.";
//        } else {
//            msg = MESSAGE_ITEMS2;
//        }
//        System.out.println(MESSAGE_ADDED + "       " + feedbackList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg);
//    }

    /**
     * Deletes a feedback according to the index.
     *
     * @param i the index of feedback to be deleted
     */
    public void deleteFeedback(int i) {
        if (feedbackList.size() - 1 <= 1) {
            msg = " feedback in the list.";
        } else {
            msg = MESSAGE_ITEMS2;
        }
        System.out.println(MESSAGE_DELETE + "       " + feedbackList.get(i)
                + "\n" + MESSAGE_ITEMS1 + (feedbackList.size() - 1) + msg);
        feedbackList.remove(feedbackList.get(i));
    }

    public int getSize() {
        return feedbackList.size();
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
