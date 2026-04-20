package tp2.Ej7;
import tp2.ejercicio1.BinaryTree;
import java.util.Scanner;

public class Tp2Ej7Main {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = crearArbol();
        System.out.println("Árbol construido correctamente.");
        System.out.println(arbol);
        ParcialArboles lib = new ParcialArboles();
        lib.setArbol(arbol);
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int valor = sc.nextInt();

        boolean resultado = lib.isLeftTree(valor);

        System.out.println("Resultado: " + resultado);
        sc.close();
    }

    public static BinaryTree<Integer> crearArbol() {

        // Raíz
        BinaryTree<Integer> raiz = new BinaryTree<>(2);

        // Nivel 1
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n_5 = new BinaryTree<>(-5);

        raiz.addLeftChild(n7);
        raiz.addRightChild(n_5);

        // Subárbol izquierdo
        BinaryTree<Integer> n23 = new BinaryTree<>(23);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);

        n7.addLeftChild(n23);
        n7.addRightChild(n6);

        BinaryTree<Integer> n_3 = new BinaryTree<>(-3);
        n23.addLeftChild(n_3);

        BinaryTree<Integer> n55 = new BinaryTree<>(55);
        BinaryTree<Integer> n11 = new BinaryTree<>(11);

        n6.addLeftChild(n55);
        n6.addRightChild(n11);

        // Subárbol derecho
        BinaryTree<Integer> n19 = new BinaryTree<>(19);
        n_5.addLeftChild(n19);

        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        n19.addRightChild(n4);

        BinaryTree<Integer> n18 = new BinaryTree<>(18);
        n4.addLeftChild(n18);

        return raiz;
    }
}