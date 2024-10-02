package miu.edu.kafka.rest;

import lombok.RequiredArgsConstructor;
import miu.edu.kafka.payload.Student;
import miu.edu.kafka.producer.KafkaJsonProducer;
import miu.edu.kafka.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {


    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String>  sendMessage(@RequestBody String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("This is my message");
    }

    @PostMapping("/json")
    public ResponseEntity<String>  sendJsonMessage(@RequestBody Student message){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("This is my message is as json ");
    }
}
