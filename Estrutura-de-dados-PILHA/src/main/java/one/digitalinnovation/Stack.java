package one.digitalinnovation;

public class Stack {

    private No refNoStackInput;

    public Stack() {
        this.refNoStackInput = null;
    }

    //Método responsavel por checar se a stack esta vazia ou nao
    public boolean isEmtpy (){
        //operador ternario
        return refNoStackInput == null ? true : false;

    }
    //retorna o topo da pilha
    public No top(){
        return refNoStackInput;
    }

    //insere um elemento na pilha
    public void push(No novoNo){
        //guarda a referencia de entrada
        No auxiliar = refNoStackInput;
        refNoStackInput = novoNo;
        refNoStackInput.setRefNo(auxiliar);

    }
    //metodo que exclui o ultimo elemento colocado na pilha
    public No pop(){
        if (this.isEmtpy()==false){
            No noPoped = refNoStackInput;
            refNoStackInput = refNoStackInput.getRefNo();
            return noPoped;
        }
        return null;
    }

    @Override
    public String toString(){
        String stringRetorno = "-------------------------\n";
        stringRetorno += "      Pilha";
        stringRetorno = "-------------------------\n";

        No noAuxiliar = refNoStackInput;

        while(true){
            if(noAuxiliar!=null){
                stringRetorno+= "[No{dado=" +noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }

        }
        stringRetorno += "-------------------------\n";
        return stringRetorno;
    }

}
