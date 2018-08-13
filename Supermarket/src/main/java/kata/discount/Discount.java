package kata.discount;

import kata.price.Price;

public interface Discount {

    Price apply(Price price, int quantity);
}
