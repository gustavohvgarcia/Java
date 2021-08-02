package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhaLista = new ListaEncadeada<>();

        minhaLista.add("Um");
        minhaLista.add("Dois");
        minhaLista.add("Tres");
        minhaLista.add("Quatro");

        System.out.println(minhaLista.get(1));
        minhaLista.remove(1);
        System.out.println(minhaLista);
    }


}
