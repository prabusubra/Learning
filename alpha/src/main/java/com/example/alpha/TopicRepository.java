package com.example.alpha;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.alpha.Alltopics;

@Repository
public interface TopicRepository extends ReactiveCassandraRepository<Alltopics, String>{
	
}
