
//class definition

class Person {
	constructor(name, city, area, age){
		this.name = name;
		this.city = city;
		this.area = area;
		this.age = age;
    }
	getDetails(){
		return this.checkAge()? this.name+", ("+this.age+"), from "+this.city+", "+this.area:this.name+", from "+this.city+", "+this.area;
	}
	checkAge (){
		return this.age && this.age > 16?true:false;
	}
}

var person1 = new Person("Steve","Bangalore","BTM 2nd stage",32);
var person2 = new Person("Mark","Bangalore","Electronic city",14);
console.log(person1);
console.log(person1.getDetails());
console.log(person2);
console.log(person2.getDetails());


//Prototype based

function Person(name, city, area, age) {
	this.name = name;
	this.city = city;
	this._area = area;
	this._age = age;
}
Person.prototype.getDetails = function(){
		return this._checkAge() ? this.name+", ("+this._age+"), from "+this.city+", "+this._area:this.name+", from "+this.city+", "+this._area;
	}
Person.prototype._checkAge = function(){
		return this._age && this._age > 16?true:false;
	}
var person1 = new Person("Steve","Bangalore","BTM 2nd stage",32);
var person2 = new Person("Mark","Bangalore","Electronic city",14);
console.log(person1);
console.log(person1.getDetails());
console.log(person2);
console.log(person2.getDetails());

//Factory Function 

function Person(name, city, area, age) {
	let getDetails = function(){
		return checkAge() ? name+", ("+age+"), from "+city+", "+area:name+", from "+city+", "+area;
	}
	let checkAge = function(){
		return age && age > 16?true:false;
	}
	return {
		name:name,
		city:city,
		getDetails:getDetails
	}
}

var person1 = Person("Steve","Bangalore","BTM 2nd stage",32);
var person2 = Person("Mark","Bangalore","Electronic city",14);
console.log(person1);
console.log(person1.getDetails());
console.log(person2);
console.log(person2.getDetails());

//function pattern

function Person(name, city, area, age) {
	this.name = name;
	this.city = city;
	this.getDetails = function(){
		return checkAge() ? name+", ("+age+"), from "+city+", "+area:name+", from "+city+", "+area;
	}
	let checkAge = function(){
		return age && age > 16?true:false;
	}
}

var person1 = new Person("Steve","Bangalore","BTM 2nd stage",32);
var person2 = new Person("Mark","Bangalore","Electronic city",14);
console.log(person1);
console.log(person1.getDetails());
console.log(person2);
console.log(person2.getDetails());
