public class CicloProxy implements ICiclo{

    private Ciclo ciclo;

    private int id;

    public CicloProxy(int id){
        this.id = id;
    }

    @Override
    public String getDadosMonitoramento(Funcionario funcionario) {

        if (!funcionario.temAutorizacao()){
            throw new IllegalArgumentException("Funcionario não autorizado");
        }

        if (this.ciclo == null){
            this.ciclo = new Ciclo(this.id);
        }
        return this.ciclo.getDadosMonitoramento(funcionario);
    }

    @Override
    public String getDadosPlantio(Funcionario funcionario) {

        if (!funcionario.temAutorizacao()){
            throw new IllegalArgumentException("Funcionario não autorizado");
        }

        if (this.ciclo == null){
            this.ciclo = new Ciclo(this.id);
        }
        return this.ciclo.getDadosPlantio(funcionario);
    }

    @Override
    public String getQualidade(Funcionario funcionario) {

        if (!funcionario.temAutorizacao()){
            throw new IllegalArgumentException("Funcionario não autorizado");
        }

        if (this.ciclo == null){
            this.ciclo = new Ciclo(this.id);
        }
        return this.ciclo.getQualidade(funcionario);
    }

    @Override
    public float getAproveitamento(Funcionario funcionario) {
        if (!funcionario.temAutorizacao()){
            throw new IllegalArgumentException("Funcionario não autorizado");
        }

        if (this.ciclo == null){
            this.ciclo = new Ciclo(this.id);
        }
        return this.ciclo.getAproveitamento(funcionario);
    }
}
