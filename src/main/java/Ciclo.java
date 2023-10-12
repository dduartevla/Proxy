import java.text.SimpleDateFormat;
import java.util.Date;

public class Ciclo implements ICiclo{

    int id;
    private Date dataPlantio;
    private Date dataColheita;
    private String dadosMonitoramento;
    private String qualidade;
    private int quantidadePlantada;
    private int quantidadePerdida;

    public Ciclo(int id,Date dataPlantio, Date dataColheita, String dadosMonitoramento,
                 String qualidade, int quantidadePlantada, int quantidadePerdida) {
        this.id = id;
        this.dataPlantio = dataPlantio;
        this.dataColheita = dataColheita;
        this.dadosMonitoramento = dadosMonitoramento;
        this.qualidade = qualidade;
        this.quantidadePlantada = quantidadePlantada;
        this.quantidadePerdida = quantidadePerdida;
    }

    public int getId(){
        return this.id;
    }


    @Override
    public String getDadosMonitoramento() {
        return this.dadosMonitoramento;
    }

    @Override
    public String getDadosPlantio() {
        String dados = "";
        SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
        return "Plantio:" + dateFormate.format(this.dataPlantio +
                " -> Colheita:" + dateFormate.format(this.dataColheita));
    }

    @Override
    public String getQualidade() {
        return this.qualidade;
    }

    @Override
    public float getAproveitamento() {
        return (this.quantidadePerdida/this.quantidadePlantada)*100;
    }
}
