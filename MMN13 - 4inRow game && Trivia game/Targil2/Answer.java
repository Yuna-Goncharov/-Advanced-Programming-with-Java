/**
 * Represent the answer option for the question
 */
public class Answer {
    private final boolean isCorrect;
    private final String text;

    Answer(final String text, final boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    /**
     * Returns true if answer correct else returns false
     *
     * @return - true if correct, else returns false
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Return the text of the answer
     *
     * @return - text of the answer
     */
    public String getText() {
        return text;
    }
}
