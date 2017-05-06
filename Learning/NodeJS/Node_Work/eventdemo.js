var event = require("events").EventEmitter;

var eventEmitter = new event();

eventEmitter.on('test',function(){
	console.log("Hello!!!");

});

//console.log("Event Names : "+eventEmitter.eventNames());

eventEmitter.emit('test');

//bind the event and function.
//eventEmitter.on('welcome',()=>{console.log("Hello, How ae you?");});
//in arrow function this key is no longer referenced.
eventEmitter.addListener('welcome',()=>{
									console.log("Hello, How ae you?");
									console.log("value of this in arrow function : "+JSON.stringify(this));
								
								});

//this keyword in anonymous function
eventEmitter.on('welcome',function(){
	console.log("Hello, How ae you?");
	console.log(" value of this in anonymous function : "+JSON.stringify(this));

});
//eventNames function is added in v6.0.0, below it will throw not a function errror.
//console.log("Events Name : "+eventEmitter.eventNames());

console.log("welcome event count before fire "+event.listenerCount(eventEmitter,'welcome'));
//fire the event.
eventEmitter.emit('welcome');
//console.log("Events Name : "+eventEmitter.eventNames());

console.log("welcome event count after fire "+event.listenerCount(eventEmitter,'welcome'));
