package org.shoppingcontroller.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.listobjects.kafka.Topics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder
                .name(Topics.UPDATE_LIST_TOPIC)
                .build();
    }
}
