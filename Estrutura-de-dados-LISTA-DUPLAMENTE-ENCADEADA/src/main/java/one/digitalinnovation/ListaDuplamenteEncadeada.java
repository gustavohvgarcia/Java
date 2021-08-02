package one.digitalinnovation;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista = 0;

    public ListaDuplamenteEncadeada(){
       this.tamanhoLista = 0;
       this.ultimoNo = null;
       this.primeiroNo = null;
    }

    //retorna o tamanho da lista
    public int size(){
        return tamanhoLista;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i=0;(i<index)&&(noAuxiliar!=null);i++){
                noAuxiliar = noAuxiliar.getNoProx();
        }
        return noAuxiliar;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        novoNo.setNoProx(null);
        novoNo.setNoPrev(ultimoNo);

        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo !=null){
            ultimoNo.setNoProx(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;

    }
    //sobrecarga do metodo add
    public void add(int index,T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProx(noAuxiliar);

        if(novoNo.getNoProx()!=null){
            novoNo.setNoPrev(noAuxiliar.getNoPrev());
            novoNo.getNoProx().setNoPrev(novoNo);
        }else{
            novoNo.setNoPrev(ultimoNo);
            ultimoNo=novoNo;
        }

        if(index==0){
            primeiroNo=novoNo;
        }else{
            novoNo.getNoPrev().setNoProx(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int index){

        if(index == 0){
            primeiroNo = primeiroNo.getNoProx();
            if(primeiroNo != null){
                primeiroNo.setNoPrev(null);
            }
        }else{
            NoDuplo<T> noAux = getNo(index);
            noAux.getNoPrev().setNoProx(noAux.getNoProx());
            if(noAux != ultimoNo){
                noAux.getNoProx().setNoPrev(noAux.getNoPrev());
            }else{
                ultimoNo = noAux;
            }
        }
        this.tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAux = primeiroNo;

        for(int i=0;i<size();i++){
            strRetorno += "[No{conteudo="+noAux.getConteudo()+"}]-->";
            noAux=noAux.getNoProx();

        }
        strRetorno+="null";
        return strRetorno;
    }


}
