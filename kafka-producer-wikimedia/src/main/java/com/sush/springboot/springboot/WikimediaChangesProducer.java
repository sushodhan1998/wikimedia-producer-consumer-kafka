package com.sush.springboot.springboot;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    @Value("${spring.kafka.producer.topic}")
    private String topic;

    private static final Logger logger = LoggerFactory.getLogger(WikimediaChangesProducer.class);


    private KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        // to read real time stream data from  wikimedia we use event source
        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate,topic);

        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(eventHandler, new EventSource.Builder(URI.create(url)));
        BackgroundEventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
