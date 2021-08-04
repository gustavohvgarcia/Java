package one.digitalinnovation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Carro> listaCarros = new ArrayList<Carro>();
        listaCarros.add(new Carro("Ford"));
        listaCarros.add(new Carro("Toyota"));
        listaCarros.add(new Carro("Hyunday"));
        listaCarros.add(new Carro("Kia"));

        System.out.println(listaCarros.get(1).hashCode());
        System.out.println(listaCarros.get(2).equals(listaCarros.get(1)));

    }
}
