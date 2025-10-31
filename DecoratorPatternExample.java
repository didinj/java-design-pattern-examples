interface Coffee {
    String getDescription();
    double getCost();
}

class BasicCoffee implements Coffee {
    public String getDescription() { return "Basic Coffee"; }
    public double getCost() { return 2.0; }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription(); }
    public double getCost() { return coffee.getCost(); }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Milk"; }
    public double getCost() { return super.getCost() + 0.5; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Sugar"; }
    public double getCost() { return super.getCost() + 0.2; }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
    }
}