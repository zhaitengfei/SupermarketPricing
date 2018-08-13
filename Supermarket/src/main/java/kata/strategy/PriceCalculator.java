package kata.strategy;

import kata.price.Price;

public interface PriceCalculator {

    Price calculate(Price price, int amount);
}
