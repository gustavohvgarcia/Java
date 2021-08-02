package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> minhaLista = new ListaCircular<>();
        minhaLista.add("c0");
        minhaLista.add("c1");
        minhaLista.add("c2");
        minhaLista.add("c3");
        minhaLista.add("c4");
        minhaLista.remove(2);
        System.out.println(minhaLista.get(0));
    }
}
