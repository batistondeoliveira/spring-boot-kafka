package com.elielbatiston.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.elielbatiston.dto.ShopDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

	private final KafkaTemplate<String, ShopDTO> kafkaTemplate;
	
	private static final String SHOP_TOPIC = "SHOP_TOPIC";
	
	private static final String SHOP_TOPIC_RETRY = "SHOP_TOPIC_RETRY";
		
	@KafkaListener(topics = SHOP_TOPIC, groupId = "group_report")
	public void listenShopTopic(ShopDTO shopDTO) {
		try {
			log.info("Compra recebida no tópico: {}.", shopDTO.getIdentifier());
			
			if (shopDTO.getItems() == null || shopDTO.getItems().isEmpty()) {
				log.error("Compra sem items.");
				throw new Exception();
			}
		} catch (Exception e) {
			log.error("Erro no processamento da mensagem", e);
			kafkaTemplate.send(SHOP_TOPIC_RETRY, shopDTO);
		}
	}
}
