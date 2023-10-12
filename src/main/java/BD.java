import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, Ciclo> ciclos= new HashMap<>();

    public static Ciclo getCiclo(Integer id){
        return ciclos.get(id);
    }

    public static void addCiclo(Ciclo ciclo){
        ciclos.put(ciclo.getId(),ciclo);
    }
}
