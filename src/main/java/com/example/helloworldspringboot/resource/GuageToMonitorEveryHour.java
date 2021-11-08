package com.example.helloworldspringboot.resource;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class GuageToMonitorEveryHour {
    private final Counter counter;
    public GuageToMonitorEveryHour(CollectorRegistry collectorRegistry){
        counter = Counter.build()
                .name("logfiles_request_count")
                .help("logs files polled")
                .register(collectorRegistry);
    }

    //this logic run every hou
    @Scheduled(fixedDelay = 10000, initialDelay = 30000)
    public void Status(){
        logsfileAvailable();
        System.out.println("Checking the files count  status....");
    }
    private void logsfileAvailable(){
        Path path= Paths.get("C:\\Users\\u724198\\Downloads\\plugin\\unprocessed_financial_batch_gateway_files\\Sample-Files\\usage.xml");
                FileStore file = null;
         try {
             file = Files.getFileStore(path);
             //long filebytes = file.getUsableSpace();
             boolean fileExist = file.equals(path);
             counter.inc();
         }
         catch (IOException e ){
             e.printStackTrace();
         }
    }
}
