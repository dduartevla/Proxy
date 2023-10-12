import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CicloProxyTest {

    @BeforeEach
    void setUp() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        BD.addCiclo(new Ciclo(20231,
                dateFormat.parse("01/05/2023"),
                dateFormat.parse("20/05/2023"),
                "DADOS MONITORAMENTO CICLO 01",
                "Boa",250,245
        ));

        BD.addCiclo(new Ciclo(20232,
                dateFormat.parse("20/05/2023"),
                dateFormat.parse("10/06/2023"),
                "DADOS MONITORAMENTO CICLO 02",
                "Aceitável",250,215
        ));

        BD.addCiclo(new Ciclo(20233,
                dateFormat.parse("10/06/2023"),
                dateFormat.parse("30/06/2023"),
                "DADOS MONITORAMENTO CICLO 03",
                "Boa",250,247
        ));
    }

    @Test
    void deveReornarDadosPlantio(){
        Funcionario f1 = new Funcionario("Maria", true);
        CicloProxy ciclo = new CicloProxy(20231);
        assertEquals("Plantio:" + "01/05/2023" +
                        " -> Colheita:" + "20/05/2023"
                ,ciclo.getDadosPlantio(f1));
    }

    @Test
    void deveReornarDadosMonitoramento(){
        Funcionario f1 = new Funcionario("Maria", true);
        CicloProxy ciclo = new CicloProxy(20231);
        assertEquals("DADOS MONITORAMENTO CICLO 01",ciclo.getDadosMonitoramento(f1));
    }

    @Test
    void deveReornarQualidade(){
        Funcionario f1 = new Funcionario("Maria", true);
        CicloProxy ciclo = new CicloProxy(20231);
        assertEquals("Boa",ciclo.getQualidade(f1));
    }

    @Test
    void deveReornarAproveitamento(){
        Funcionario f1 = new Funcionario("Maria", true);
        CicloProxy ciclo = new CicloProxy(20231);
        assertEquals(98.0,ciclo.getAproveitamento(f1));
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoAproveitamento(){
        try{
            Funcionario funcionario = new Funcionario("Joao", false);
            CicloProxy ciclo = new CicloProxy(20232);

            ciclo.getAproveitamento(funcionario);
            fail();
        } catch(IllegalArgumentException e){
            assertEquals("Funcionario não autorizado",e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoQualidade(){
        try{
            Funcionario funcionario = new Funcionario("Joao", false);
            CicloProxy ciclo = new CicloProxy(20232);

            ciclo.getQualidade(funcionario);
            fail();
        } catch(IllegalArgumentException e){
            assertEquals("Funcionario não autorizado",e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoMonitoramento(){
        try{
            Funcionario funcionario = new Funcionario("Joao", false);
            CicloProxy ciclo = new CicloProxy(20232);

            ciclo.getDadosMonitoramento(funcionario);
            fail();
        } catch(IllegalArgumentException e){
            assertEquals("Funcionario não autorizado",e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoPlantio(){
        try{
            Funcionario funcionario = new Funcionario("Joao", false);
            CicloProxy ciclo = new CicloProxy(20232);

            ciclo.getDadosPlantio(funcionario);
            fail();
        } catch(IllegalArgumentException e){
            assertEquals("Funcionario não autorizado",e.getMessage());
        }
    }

}