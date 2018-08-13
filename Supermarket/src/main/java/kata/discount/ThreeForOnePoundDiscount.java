package kata.discount;

import com.google.common.base.Preconditions;
import kata.price.Price;
import java.math.BigDecimal;
import java.util.Objects;

public class ThreeForOnePoundDiscount implements Discount {

    private static final int DISCOUNT_QUALIFICATION_QUANTITY = 3;
    private static final Price ONE_POUND = new Price(BigDecimal.ONE);

    @Override
    public Price apply(final Price price, final int quantity) {
        Objects.requireNonNull(price, "A price must be provided to apply a discount.");
        Preconditions.checkArgument(quantity >= 1, "Discount can only be applied for 1 or more products. Tried with [%s].", quantity);
        if (quantity < DISCOUNT_QUALIFICATION_QUANTITY) {
            return price.multiplyBy(quantity);
        } else if (quantity == DISCOUNT_QUALIFICATION_QUANTITY) {
            return ONE_POUND;
        }
        return ONE_POUND.addTo(apply(price, quantity - DISCOUNT_QUALIFICATION_QUANTITY));
    }

}
