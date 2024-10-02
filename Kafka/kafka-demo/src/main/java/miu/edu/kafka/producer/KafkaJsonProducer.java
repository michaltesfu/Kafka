package miu.edu.kafka.producer;


import lombok.RequiredArgsConstructor;
import miu.edu.kafka.payload.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;


    public void sendMessage(Student student){
        Message<Student> message= MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC,"michal")
                .build();
        kafkaTemplate.send(message);


    }
}
