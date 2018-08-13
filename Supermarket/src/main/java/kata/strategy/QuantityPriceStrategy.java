package kata.strategy;

import com.google.common.base.Preconditions;
import kata.discount.Discount;
import kata.price.Price;

public final class QuantityPriceStrategy extends AbstractPriceStrategy implements PriceStrategy {

    public QuantityPriceStrategy(final Price price) {
        super(price);
    }

    public QuantityPriceStrategy(final Price price, final Discount discount) {
        super(price, discount);
    }

    @Override
    public Price calculate(final int quantity) {
        Preconditions.checkArgument(quantity >= 1, "Price can only be calculated for 1 or more products. Tried with [%s].", quantity);
        return calculate(quantity, (price, amount) -> price.multiplyBy(amount));
    }

}
