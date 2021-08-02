package one.digitalinnovation;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca=null;
        this.tamanho = 0;
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0 ? true : false;
    }

    private No<T> getNo(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("A lista esta vazia!");
        }
        if(index==0){
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;

        for(int i=0;(i<index);i++){
            noAuxiliar=noAuxiliar.getProxNo();
        }
        return noAuxiliar;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void remove(int index){
        if(index>=this.tamanho){
            throw new IndexOutOfBoundsException("O indice eh maior que o tamanho da lista");
        }

        No<T> noAuxiliar = this.cauda;
        if (index == 0){
            this.cauda = this.cauda.getProxNo();
            this.cabeca.setProxNo(this.cauda);
        }else if(index == 1){
            this.cauda.setProxNo(this.cauda.getProxNo().getProxNo());
        }else{
            for(int i=0; i< index-1;i++){
                noAuxiliar = noAuxiliar.getProxNo();
            }
            noAuxiliar.setProxNo(noAuxiliar.getProxNo().getProxNo());
        }
        this.tamanho--;

    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if(this.tamanho == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProxNo(this.cauda);
        }else{
            novoNo.setProxNo(this.cauda);
            this.cabeca.setProxNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanho++;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda;

        for (int i=0; i<this.size();i++){
            strRetorno += "No{" +
                    "conteudo=" + noAuxiliar.getConteudo() +
                    "}--->";
            noAuxiliar=noAuxiliar.getProxNo();
        }

        strRetorno += this.size() != 0 ? "retorna ao inicio" : "{}";

        return strRetorno;
    }
}
