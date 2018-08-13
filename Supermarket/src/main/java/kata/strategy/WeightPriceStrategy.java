package kata.strategy;

import com.google.common.base.Preconditions;
import kata.discount.Discount;
import kata.price.Price;

public final class WeightPriceStrategy extends AbstractPriceStrategy implements PriceStrategy {

    private final int gramsPerPrice;

    public WeightPriceStrategy(final Price price, final int gramsPerPrice) {
        super(price);
        this.gramsPerPrice = gramsPerPrice;
    }

    public WeightPriceStrategy(final Price price, final int gramsPerPrice, final Discount discount) {
        super(price, discount);
        this.gramsPerPrice = gramsPerPrice;
    }

    @Override
    public Price calculate(final int grams) {
        Preconditions.checkArgument(grams >= 1, "Price can only be calculated for 1 gram or more. Tried with [%s].", grams);
        return calculate(grams, (price, amount) -> price.divideBy(gramsPerPrice).multiplyBy(amount));
    }

}
