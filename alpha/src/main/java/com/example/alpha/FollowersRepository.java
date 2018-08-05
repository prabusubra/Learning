package com.example.alpha;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.alpha.Followers;

@Repository
public interface FollowersRepository extends ReactiveCassandraRepository<Followers, String>{
	
}
