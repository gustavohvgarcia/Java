package one.digitalinnovation;

public class No<T> {

    private T conteudo;
    private No<T> refNo;
    private No<T> proxNo;

    public No(T conteudo) {
        this.refNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getRefNo() {
        return refNo;
    }

    public void setRefNo(No<T> refNo) {
        this.refNo = refNo;
    }

    public No<T> getProxNo() {
        return proxNo;
    }

    public void setProxNo(No<T> proxNo) {
        this.proxNo = proxNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}
