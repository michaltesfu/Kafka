package miu.edu.kafka.producer;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
@Service
@RequiredArgsConstructor  // Use Lombok to generate a constructor for final fields
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;  // Use final to ensure injection

    public void sendMessage(String msg) {
        log.info(String.format("Sending message to alibou Topic: %s", msg));
        kafkaTemplate.send("michal", msg);  // Ensure KafkaTemplate is properly injected and used
    }
}
