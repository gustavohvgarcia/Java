package one.digitalinnovation;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;


    public ListaEncadeada(){
        this.referenciaEntrada = null;
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    public int size(){
        int tamanholista=0;
        No<T> referenciaAux = referenciaEntrada;

        while(true){
            if(referenciaAux !=null){
                tamanholista++;
                if(referenciaAux.getProxNo()!=null){
                    referenciaAux = referenciaAux.getProxNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return tamanholista;
    }//fim metodo size

    public void add(T object){
        No<T> novoNo = new No<>(object);
        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for(int i =0; i<this.size()-1;i++){
            noAuxiliar = noAuxiliar.getProxNo();
        }
        noAuxiliar.setProxNo(novoNo);

    }//fim metodo add

    private No<T> getNo(int index){

        if(index < 0){
            throw new IndexOutOfBoundsException("No existe conteudo no indice "+index+" desta lista!\n");
        }

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for(int i =0; i<=index;i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProxNo();
        }
        return noRetorno;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public T remove(int index){
        No<T> noPivot = this.getNo(index);

        if(index == 0){
            referenciaEntrada = noPivot.getProxNo();//pega o no da posicao zero e adianta a referencia de entrada para o proximo elemento;
            return noPivot.getConteudo();
        }

        No<T> noAnterior = getNo(index-1);
        noAnterior.setProxNo(noPivot.getProxNo());

        return noPivot.getConteudo();
        /*o garbage collector da free automaticamente no no perdido*/
    }

    @Override
    public String toString() {

        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for(int i=0;i<this.size();i++){
            strRetorno += "No{conteudo=" + noAuxiliar.getConteudo() +
                    "}----->";
            noAuxiliar = noAuxiliar.getProxNo();
        }
        strRetorno+="null";
        return strRetorno;
    }


}
