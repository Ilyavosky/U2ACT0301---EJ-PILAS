package utils;

import models.Navegation;
import java.util.Stack;

public class NavegationUtils {
    private Stack<Navegation> forwardStack;
    private Stack<Navegation> backwardsStack;
    private Navegation currentPage;

    public NavegationUtils() {
        this.forwardStack = new Stack<>();
        this.backwardsStack = new Stack<>();
        this.currentPage = null;
    }

    public void goToNewPage(Navegation newPage) {
        System.out.println("Navegando a la página: " + newPage.getUrl());

        if (this.currentPage != null) {
            this.backwardsStack.push(this.currentPage);
        }

        this.currentPage = newPage;
        this.forwardStack.clear();
    }

    public void goBackwards() {
        if (this.backwardsStack.isEmpty()) {
            System.out.println("No se puede retroceder más.");
            return;
        }

        if (this.currentPage != null) {
            this.forwardStack.push(this.currentPage);
        }

        this.currentPage = this.backwardsStack.pop();
        System.out.println("Retrocediendo a: " + this.currentPage.getUrl());
    }

    public void goForwards() {
        if (this.forwardStack.isEmpty()) {
            System.out.println("No se puede avanzar más.");
            return;
        }

        if (this.currentPage != null) {
            this.backwardsStack.push(this.currentPage);
        }

        this.currentPage = this.forwardStack.pop();
        System.out.println("-> Avanzando a: " + this.currentPage.getUrl());
    }

    public void mostrarEstadoActual() {
        System.out.println("---------------------------------");
        System.out.println("Pila Atrás (Backwards): " + this.backwardsStack.size() + " elementos");
        System.out.println("Página Actual (Current): " + (this.currentPage != null ? this.currentPage.getUrl() : "Ninguna"));
        System.out.println("Pila Adelante (Forward): " + this.forwardStack.size() + " elementos");
        System.out.println("---------------------------------");
    }
}