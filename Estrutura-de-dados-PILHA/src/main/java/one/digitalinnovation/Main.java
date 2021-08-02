package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {

        Stack pilha = new Stack();
        No node = new No(1);
        pilha.push(node);

        No node2 = new No(2);
        pilha.push(node2);

        No node3 = new No(3);
        pilha.push(node3);

        No node4 = new No(4);
        pilha.push(node4);

        No node5 = new No(5);
        pilha.push(node5);

        No node6 = new No(6);
        pilha.push(node6);

        System.out.println(pilha);

        pilha.pop();

        System.out.println(pilha);
    }
}
