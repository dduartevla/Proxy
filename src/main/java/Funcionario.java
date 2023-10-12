public class Funcionario {

    private String nome;
    private boolean temAutorizacao;

    public Funcionario(String nome, boolean temAutorizacao){
        this.nome = nome;
        this.temAutorizacao = temAutorizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTemAutorizacao(boolean temAutorizacao) {
        this.temAutorizacao = temAutorizacao;
    }

    public boolean temAutorizacao() {
        return this.temAutorizacao;
    }
}
