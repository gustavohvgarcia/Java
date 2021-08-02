package one.digitalinnovation.model;

import java.util.Objects;

public class Obj extends ObjArvore<Obj>{

    Integer valor;

    public Obj(Integer valor){
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null|| getClass()!=o.getClass()) return false;
        Obj obj = (Obj) o;
        return valor.equals(obj.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public int compareTo(Obj outro) {
        int i = 0;

        if(this.valor > outro.valor){
            i = 1;
        }else if(this.valor < outro.valor){
            i = -1;
        }else{
            i = 0;
        }
        return i;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
