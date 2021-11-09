/*package com.example.helloworldspringboot.resource;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
//@Override
public class GuageToMonitorEveryHour {
    private final Gauge gauge;

    public GuageToMonitorEveryHour(CollectorRegistry collectorRegistry) {
        gauge = Gauge.build()
                .name("logfiles_request_total")
                .help("logs files polled")
                .register(collectorRegistry);
    }

    //this logic run every hou
    @Scheduled(fixedDelay = 10000, initialDelay = 30000)
    public void Status() {
        logsfileAvailable();
        System.out.println("Checking the files count  status....");
    }

    public void logsfileAvailable()
    {
        Path path = Paths.get("C:\\Finastra Working Folder\\01. Prometheus-CustomMetrics\\hellospringmicro\\src\\main\\java\\com\\example\\Sample-Files");
        FileStore file;

            try {
                file = Files.getFileStore(path);
                //System.out.println(file);
                String filesStore = file.toString();
                gauge.inc();
            } catch (IOException e) {
                e.printStackTrace();

                    }
    }
}
*/