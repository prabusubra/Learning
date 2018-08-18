package com.example.alpha;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SynchronousSink;

@SpringBootApplication
@RestController
public class AlphaApplication {
	@Autowired FollowersRepository followersRepository;
	@Autowired TopicRepository topicRepository;
	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
		
	}

	@GetMapping("/info")
	public Flux<FullDetails> getData(){
		return Flux.create(emitter ->{
			followersRepository.findAll()
			.doOnNext(data -> {
				List<String> all = data.getTopiclist();
				List<Alltopics> processedList = new ArrayList<Alltopics>();
				all.forEach(action -> {
					topicRepository.findById(action)
					.doOnSuccess(topic ->{
						processedList.add(topic);
						if (processedList.size() >= all.size()) {
							FullDetails fulldetails = new FullDetails(data.getUserid(),processedList);
							emitter.next(fulldetails);
							emitter.complete();
						}
					})
					.subscribe();
				});
			})
			.doOnComplete(() ->{
				//emitter.complete();
				System.out.println("All the data are processed !!!");
			})
			.subscribe();
		});
	}
	
	@GetMapping("/info/v2")
	public Flux<?> getData1(){
			return followersRepository.findAll()
			.map(data -> {
				List<String> all = data.getTopiclist();
				List<Alltopics> processedList = new ArrayList<Alltopics>();
				FullDetails fulldetails[]=new FullDetails[1];
				all.forEach(action -> {
					topicRepository.findById(action)
					.map(topic ->{
						processedList.add(topic);
							fulldetails[0] = new FullDetails(data.getUserid(),processedList);
							return fulldetails[0];
					})
					.subscribe();
				});
				return fulldetails[0];
				
			})
			.doOnComplete(() ->{
				System.out.println("All the data are processed !!!");
			});
	}
	

	@PostMapping("/topics")
	public Flux<?> loadTopic(@RequestBody Flux<Alltopics> data)
	{
		return Flux.create(emitter ->{
			data
			.map(topic -> {
				topic.setTopicid(null ==topic.getTopicid() || topic.getTopicid().isEmpty()?UUID.randomUUID().toString():topic.getTopicid());
				return topic;
			})
			.doOnNext(topic -> {
				topicRepository.save(topic).doOnSuccess(persistedTopic ->{
					emitter.next(persistedTopic);
					//emitter.complete();
				}).subscribe();
			})
			.doOnComplete(() -> {
				emitter.complete();
				System.out.println(" all the data are processed!!!");
			}).subscribe();
		});
				//topicRepository.saveAll(data);
	}
	
	@PostMapping("/user")
	public Flux<?> loadFollowers(@RequestBody Flux<Followers> data)
	{
		return followersRepository.saveAll(data);
	}
}
