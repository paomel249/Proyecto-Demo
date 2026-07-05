package metrics;

public class MetricsRecorder {

    public static void registrarResultado(
            String escenario,
            String caso,
            String estado,
            double tiempo
    ){

        MetricsManager.pruebasEjecutadas
                .labelValues( escenario, caso, estado)
                .inc();


        MetricsManager.tiempoPrueba
                .labelValues( escenario, caso)
                .set(tiempo);

    }
}