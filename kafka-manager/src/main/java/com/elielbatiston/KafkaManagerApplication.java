package com.elielbatiston;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
 
public class KafkaManagerApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Properties properties = new Properties();
		
		properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		AdminClient adminClient = AdminClient.create(properties);
		
		KafkaAdmin.create("topico-1", 2, (short) 1, adminClient);
		KafkaAdmin.create("topico-2", 2, (short) 1, adminClient);
		
		KafkaAdmin.list(adminClient);
		
		KafkaAdmin.describe("topico-1", adminClient);
		
		KafkaAdmin.delete("topico-1", adminClient);
		KafkaAdmin.delete("topico-2", adminClient);
		
		KafkaAdmin.listCG(adminClient);
		
		KafkaAdmin.deleteCG("group", adminClient);
		
		KafkaAdmin.describeCluster(adminClient);
	}

}
