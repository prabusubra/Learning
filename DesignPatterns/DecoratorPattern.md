- Attach additional responsibilities to an object dynamically.
- Add functionality to an existing component from outside the class.
- Add responsibility to object not to the class.

Example:-
```
public class DecoratorPattern {
    
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("new Tea().cost() = " + new Tea().cost());
        System.out.println("new Tea().cost() = " + new Coffee().cost());

        System.out.println("coffee + milk + sugar :  " + new ExtraMilk(new ExtraSugar(new Coffee())).cost());

        System.out.println("coffee  + sugar :  " + new ExtraSugar(new Coffee()).cost());

        System.out.println("coffee + milk  :  " + new ExtraMilk(new Coffee()).cost());

        System.out.println("Tea + milk + sugar :  " + new ExtraMilk(new ExtraSugar(new Tea())).cost());


    }
}


interface Drinks {
    public int cost();
}

abstract class DrinksDecorator implements Drinks{

}

class Tea implements Drinks {
    public int cost() {
        return 10;
    }
}

class Coffee implements Drinks {
    public int cost() {
        return 20;
    }
}

class ExtraSugar extends DrinksDecorator {
    Drinks drinks;

    public ExtraSugar(Drinks drinks){
        this.drinks = drinks;
    }

    public int cost(){
        return 2 + drinks.cost();
    }
}

class ExtraMilk extends DrinksDecorator {
    Drinks drinks;

    public ExtraMilk(Drinks drinks){
        this.drinks = drinks;
    }

    public int cost(){
        return 4 + drinks.cost();
    }
}
```
