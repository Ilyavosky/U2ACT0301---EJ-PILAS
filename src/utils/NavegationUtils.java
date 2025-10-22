package utils;

import models.Navegation;

import java.util.Stack;

public class NavegationUtils {
    private Stack<Navegation> Forward ;
    private Stack<Navegation> Backwards;
    private Navegation currentPage;

    public NavegationUtils() {
        this.Forward = new Stack<>();
        this.Backwards = new Stack<>();
        this.currentPage = null;
    }

    //Métodos que usé
    //push(E item): This method adds an element (item) to the top of the stack. It returns the item that was pushed.
    //pop(): This method removes and returns the element at the top of the stack. If the stack is empty, it throws an EmptyStackException.
    //peek(): This method returns the element at the top of the stack without removing it. If the stack is empty, it throws an EmptyStackException.

    public void goToPage(){
        if (this.currentPage != null){
            this.Forward.push(this.currentPage);
        }

        if (this.currentPage == null){
            this.Backwards.push(this.Forward.pop());
        }
    }

    public void returnToPage(){
        if (this.currentPage == null){
            this.Backwards.push(this.Forward.pop());
        }

        if (this.currentPage.equals(this.Backwards.peek())){
            this.Backwards.pop();
        }
    }

    public void goBackAndForward(Navegation navegation){
       if (this.currentPage.equals(this.Backwards.peek())){
           this.Backwards.push(navegation);
       }
    }

}
