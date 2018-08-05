This Project is to get the details from 2 different apache cassandra tables and joins using reactive operators.
---------------------------------------------------------------
GET : localhost:7070/info
---------------------------------------------------------------

POST : localhost:7070/user

Body: [{
  "userid" : "001",
  "topiclist": ["react","webflux","projectreactor"]
},{
  "userid" : "002",
  "topiclist": ["react","webflux","projectreactor"]
}]
----------------------------------------------------------------
POST: localhost:7070/topic

Body: [{
  "topicid": "react",
  "content":"Intro and operators",
  "author":"Josh Long",
  "name":"React"
},{
  "topicid": "webflux",
  "content":"Intro and operators",
  "author":"Josh Long",
  "name":"webflux"
},{
  "topicid": "projectreactor",
  "content":"Intro and operators",
  "author":"Josh Long",
  "name":"projectreactor"
},{
  "topicid": "restmvc",
  "content":"Intro and annotations",
  "author":"Josh Long",
  "name":"restmvc"
}]
----------------------------------------------------------------
