package com.example.alpha;

import java.util.List;

public class FullDetails {
	
	
	private String userid;
	private List<Alltopics> topics;
	
	
	public FullDetails(String userid, List<Alltopics> topics) {
		super();
		this.userid = userid;
		this.topics = topics;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<Alltopics> getTopics() {
		return topics;
	}
	public void setTopics(List<Alltopics> topics) {
		this.topics = topics;
	}
	

}
