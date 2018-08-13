package kata.strategy;

import kata.price.Price;

public interface PriceStrategy {

    Price calculate(int amountPurchased);

}
