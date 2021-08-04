package one.digitalinnovation;

import java.util.Objects;

public class Carro {

    String carro;

    public Carro(String carro) {
        this.carro = carro;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro1 = (Carro) o;
        return Objects.equals(carro, carro1.carro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carro);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "carro='" + carro + '\'' +
                '}';
    }
}
