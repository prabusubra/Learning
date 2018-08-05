package com.example.alpha;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Followers{
	
	@PrimaryKey
	private String userid;
	private List<String> topiclist;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<String> getTopiclist() {
		return topiclist;
	}
	public void setTopiclist(List<String> topiclist) {
		this.topiclist = topiclist;
	}
	
}
