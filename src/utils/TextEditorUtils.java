package utils;

import models.TextEditor;
import java.util.Stack;

public class TextEditorUtils {
    private Stack<TextEditor> RedoStack;
    private Stack<TextEditor> undoStack;
    private TextEditor currentEditor;

    public TextEditorUtils() {
        this.RedoStack = new Stack<>();
        this.undoStack = new Stack<>();
        this.currentEditor = null;
    }

    public void revertAction(TextEditor texReverted){
        System.out.println("Revirtiendo la acción...");
        if (this.currentEditor != null){
              this.undoStack.push(this.currentEditor);
        }

        this.currentEditor =  texReverted;
        this.RedoStack.clear();
    }


}
