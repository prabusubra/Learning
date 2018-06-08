package ds.app.listener.SimpleListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.connect.json.JsonDeserializer;

import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;

public class StandaloneListener {
	
	public KafkaReceiver  getConfigureListener() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.12.12.24:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "exmp-group");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		ReceiverOptions receiverOptions = ReceiverOptions.create(props).subscription(Arrays.asList("ExampleChange"));
		
		return  KafkaReceiver.create(receiverOptions);
	}
	
	public static void main(String[] args) {
		StandaloneListener listener = new StandaloneListener();
		KafkaReceiver kafkaReceiver = listener.getConfigureListener();
		 Flux<ReceiverRecord<String, String>> kafkaFlux  = kafkaReceiver.receive();
		 kafkaFlux.subscribe((data)->{
			 ConsumerRecord crecord = (ConsumerRecord)data;
			 if (crecord.value() != null) {
				 System.out.println(crecord);
			 }
		 });
	}

}
