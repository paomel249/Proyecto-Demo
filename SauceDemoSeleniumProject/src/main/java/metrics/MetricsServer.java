package metrics;

import io.prometheus.metrics.exporter.httpserver.HTTPServer;

public class MetricsServer {

    private static HTTPServer server;

    public static void iniciar() {

        try {

            if(server == null){

                server = HTTPServer.builder()
                        .port(9091)
                        .buildAndStart();

                System.out.println("Servidor Prometheus iniciado en puerto 9091");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}