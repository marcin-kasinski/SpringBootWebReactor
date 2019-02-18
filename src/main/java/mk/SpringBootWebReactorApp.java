package mk;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerSentEvent;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;



/*

<------------------------ docker ------------------------>


/opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --create --zookeeper 127.0.0.1:2181 --replication-factor 1 --partitions 1 --topic logs
/opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --list --zookeeper 127.0.0.1:2181
/opt/kafka_2.11-0.10.1.0/bin/kafka-console-consumer.sh --zookeeper 127.0.0.1:2181 --topic my-topic 
/opt/kafka_2.11-0.10.1.0/bin/kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic my-topic 

<------------------------ docker ------------------------>
{   "parentId" : "ac1ebe5ff1b78e18",   "spanTraceId" : "ac1ebe5ff1b78e18",  "id" : "8 Dec 2017 18:50:21 GMT",  "definition" : "definition"} 
 */


@SpringBootApplication
public class SpringBootWebReactorApp {

	 private static Logger log = LoggerFactory.getLogger(SpringBootWebReactorApp.class);

//	protected Logger logger = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {

		System.out.println("Version 18.02.2019");
		
		System.out.println("Environment variables");
		

		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		
		
		
	SpringApplication.run(SpringBootWebReactorApp.class, args);

	}


}
