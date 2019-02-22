package com.monotonic.testing.m2;

import org.junit.Test;

import static com.monotonic.testing.m2.CoffeeType.Espresso;
import static com.monotonic.testing.m2.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        return cafe;
    }

    @Test
    public void canBrewEspresso() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        assertEquals("Wrong number of beans", 7, coffee.getBeans());
        assertEquals("Wrong amount of milk", 0, coffee.getMilk());
        assertEquals("Wrong type of coffee", Espresso, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(0, cafe.getBeansInStock());
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
        cafe.restockMilk(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockBeans(0);
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequireMilk() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Latte);
    }

}
