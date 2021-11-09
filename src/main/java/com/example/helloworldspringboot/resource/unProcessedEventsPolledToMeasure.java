package com.example.helloworldspringboot.resource;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
//@Override
public class unProcessedEventsPolledToMeasure {
   private final Counter counter;
    private static final Logger logger = LoggerFactory.getLogger("MainLogger");

    public unProcessedEventsPolledToMeasure(CollectorRegistry collectorRegistry) {
       counter = Counter.build()
                .name("logfiles_request_total")
                .help("logs files polled")
                .register(collectorRegistry);
    }

    //this logic run every hou
    @Scheduled(fixedDelay = 10000, initialDelay = 30000)
    public void Status() {
        logsfilesAvailable();
        System.out.println("Checking the files count  status....");
    }

    public void logsfilesAvailable()
    {
        try {
        logger.info("Before");
       // Path path = Paths.get("C:\\Finastra Working Folder\\01. Prometheus-CustomMetrics\\hellospringmicro\\src\\main\\java\\com\\example\\Sample-Files");
        //FileStore file;
        File file1 = new File("C:\\Finastra Working Folder\\01. Prometheus-CustomMetrics\\hellospringmicro\\src\\main\\java\\com\\example\\Sample-Files");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File file1, String name) {
                return name.endsWith(".xml");
            }
        };
            logger.info("This is to count if files left in  polling folder");
            File[] files = file1.listFiles(filter);
        // Get the names of the files by using the .getName() method
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
            counter.inc();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
