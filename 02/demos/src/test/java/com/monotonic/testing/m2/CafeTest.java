package com.monotonic.testing.m2;

import org.junit.Test;

import static com.monotonic.testing.m2.CoffeeType.Espresso;
import static com.monotonic.testing.m2.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    private static final int REQUIRED_BEANS = Espresso.getRequiredBeans();
    private static final int NO_MILK = 0;
    private static final int NO_BEANS = 0;

    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(REQUIRED_BEANS);
        return cafe;
    }

    @Test
    public void canBrewEspresso() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        assertEquals("Wrong number of beans", NO_MILK, coffee.getMilk());
        assertEquals("Wrong type of coffee", Espresso, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
        Cafe cafe = cafeWithBeans();
        cafe.restockMilk(227);

        // when
        Coffee coffee = cafe.brew(Latte);

        // then
        assertEquals("Wrong type of coffee", Latte, coffee.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockBeans(NO_BEANS);
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequireMilk() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Latte);
    }

}
