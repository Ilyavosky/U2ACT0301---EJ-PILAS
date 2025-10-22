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
        this.currentEditor = new TextEditor("");
    }

    public void revertAction(TextEditor newAction){
        System.out.println("Nueva acción: '" + newAction.getText() + "'");

        if (this.currentEditor != null){
            this.undoStack.push(this.currentEditor);
        }

        this.currentEditor =  newAction;

        this.RedoStack.clear();
    }


    public void undoAction() {
        if (this.undoStack.isEmpty()) {
            System.out.println("No hay acciones que deshacer.");
            return;
        }

        this.RedoStack.push(this.currentEditor);

        this.currentEditor = this.undoStack.pop();
        System.out.println("DESHACER. El texto ahora es: '" + this.currentEditor.getText() + "'");
    }


    public void redoAction() {
        if (this.RedoStack.isEmpty()) {
            System.out.println("No hay acciones que rehacer.");
            return;
        }

        this.undoStack.push(this.currentEditor);

        this.currentEditor = this.RedoStack.pop();
        System.out.println("REHACER. El texto ahora es: '" + this.currentEditor.getText() + "'");
    }


    public void ShowStatus() {
        System.out.println("---------------------------------");
        System.out.println("Pila Deshacer (undoStack): " + this.undoStack.size() + " estados");
        System.out.println("Texto Actual: '" + (this.currentEditor != null ? this.currentEditor.getText() : "") + "'");
        System.out.println("Pila Rehacer (RedoStack): " + this.RedoStack.size() + " estados");
        System.out.println("---------------------------------");
    }
}