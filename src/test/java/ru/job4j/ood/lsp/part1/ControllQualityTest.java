package ru.job4j.ood.lsp.part1;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ControllQualityTest {

    @Test
    public void whenAddToWarehouse()  {
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, 14);
        Food apple = new Milk("Willey Milk", lastDelivery,
                100, 120, 50);
        ControllQuality cc = new ControllQuality().distribution(apple);
        assertThat("Warehouse", is(cc.objStorage.getClass().getSimpleName()));
    }

    @Test
    public void whenAddToShop()  {
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, 14);
        Food apple = new Fruit("Lemons", lastDelivery,
                20, 220, 50);
        ControllQuality cc = new ControllQuality().distribution(apple);
        assertThat("Shop", is(cc.objStorage.getClass().getSimpleName()));
    }

    @Test
    public void whenAddToTrash()  {
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, 14);
        Food apple = new Fruit("Apple", lastDelivery,
                5, 100, 50);
        ControllQuality cc = new ControllQuality().distribution(apple);
        assertThat("Trash", is(cc.objStorage.getClass().getSimpleName()));
    }


    @Test
    public void whenAddToShopWithDiscount()  {
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, 14);
        Food apple = new Fruit("Apple", lastDelivery,
                6, 100, 50);
        ControllQuality cc = new ControllQuality().distribution(apple);
        assertThat(50.0, is(cc.objStorage.getStorage().get(0).getPrice()));
    }
}