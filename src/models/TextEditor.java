package models;

public class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextEditor{" +
                "text='" + text + '\'' +
                '}';
    }
}
