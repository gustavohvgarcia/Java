package one.digitalinnovation;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String>minhaLista=new ListaDuplamenteEncadeada<>();
        minhaLista.add("primeiro item");
        minhaLista.add("segundo item");
        minhaLista.add("terceiro item");
        minhaLista.add("quarto item");
        minhaLista.add("quinto item");
        minhaLista.add("sexto item");
        minhaLista.add("setimo item");


        System.out.println(minhaLista);

        minhaLista.remove(3);
        System.out.println(minhaLista);
        minhaLista.add(3,"99");
        System.out.println(minhaLista);
    }
}
