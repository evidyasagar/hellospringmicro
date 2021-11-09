package com.example.helloworldspringboot.resource;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

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
       Path folderPath = Paths.get("C:\\Finastra Working Folder\\01. Prometheus-CustomMetrics\\hellospringmicro\\src\\main\\java\\com\\example\\Sample-Files");
        //FileStore file;
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath);
            List<String> fileNames = new ArrayList<>();
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            counter.inc();
            }
        } catch (IOException e) {
            System.err.println("Error reading files");
            e.printStackTrace();

        }
    }
}
