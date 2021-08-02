package one.digitalinnovation;

public class Fila<T> {

    private No<T> refInputFila;

    public Fila() {
        this.refInputFila = null;
    }

    public boolean isEmpty(){
        /*checa se a referencia de entrada da fila esta apontando
        para  null; se sim retorna true, caso contrario retorna false*/
        return refInputFila == null ? true : false;
    }

    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setRefNo(refInputFila);
        refInputFila = novoNo;
    }

    public Object dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refInputFila;
            No auxiliar = refInputFila;
            while(true){
                if(primeiroNo.getRefNo() !=null){
                    auxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    auxiliar.setRefNo(null);
                    break;
                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }


    public T first(){
        if(!this.isEmpty()){
            No primeiroNo = refInputFila;

            while(true){
                if(primeiroNo.getRefNo() !=null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refInputFila;

        if(refInputFila!=null) {
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";

                if(noAuxiliar.getRefNo()!=null){
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringRetorno+="null";
                    break;
                }
            }
        }else{
            stringRetorno = "null";
        }

        return stringRetorno;
    }
}
