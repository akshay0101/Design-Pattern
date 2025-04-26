abstract class Burger {
    String type;

    @Override
    public String toString() {
        return type;
    }
}

class CheeseBurger extends Burger {
    public CheeseBurger() {
        type = "Cheese Burger";
        System.out.println("Creating cheese burger");
    }
}

class ChickenBurger extends Burger {
    public ChickenBurger() {
        type = "Chicken Burger";
        System.out.println("Creating chicken burger");
    }
}

class VeggieBurger extends Burger {
    public VeggieBurger() {
        type = "Veggie Burger";
        System.out.println("Creating veggie burger");
    }
}

class BurgerFactory { /
    Burger burger;
    
    public BurgerFactory(String type) { 
        if (type.equals("cheese")) {
            burger = new CheeseBurger(); 
        } else if (type.equals("chicken")) {
            burger = new ChickenBurger(); 
        } else if (type.equals("veggie")) {
            burger = new VeggieBurger(); 
        } else {
            System.out.println("Unknown burger type");
        }
    }
    
    public Burger getBurger() {
        return burger;
    }
}

class Restaurant {
    BurgerFactory burgerFactory;
    
    public Burger createBurger(String type) { 
        System.out.println("Creating burger of type: " + type);
        burgerFactory = new BurgerFactory(type); 
        Burger burger = burgerFactory.getBurger();
        System.out.println("Burger created: " + burger);
        return burger;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.createBurger("cheese");
    }
}