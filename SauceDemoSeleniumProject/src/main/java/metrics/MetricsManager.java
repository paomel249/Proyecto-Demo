package metrics;

import io.prometheus.metrics.core.metrics.Counter;
import io.prometheus.metrics.core.metrics.Gauge;

public class MetricsManager {

    public static final Counter pruebasEjecutadas =
            Counter.builder()
                    .name("selenium_tests_total")
                    .help("Cantidad total de pruebas ejecutadas")
                    .labelNames("scenario","testcase","status")
                    .register();

    public static final Gauge tiempoPrueba =
            Gauge.builder()
                    .name("selenium_test_duration_seconds")
                    .help("Tiempo que tarda una prueba")
                    .labelNames("scenario","testcase")
                    .register();

}