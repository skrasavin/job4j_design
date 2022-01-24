package ru.job4j.ood.lsp.part1;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class ControllQualityTest {

    @Test
    public void whenAddToWarehouse()  {
        LocalDateTime ldt = LocalDateTime.now();
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, ldt.getDayOfMonth() - 4);
        Food milk = new Milk("Willey Milk", lastDelivery,
                20, 120, 50);
        List<Storage> storages = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ControllQuality cc = new ControllQuality(storages);
        Storage st = null;
        cc.distribution(milk);
        for (var c : cc.objStorage) {
            if (c.getStorage().size() != 0 && c.getStorage().get(0).equals(milk)) {
                st = c;
            }
        }
        assertThat("Warehouse", is(st.getClass().getSimpleName()));
    }

    @Test
    public void whenAddToShop()  {
        LocalDateTime ldt = LocalDateTime.now();
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, ldt.getDayOfMonth() - 10);
        Food milk = new Milk("Willey Milk", lastDelivery,
                20, 120, 50);
        List<Storage> storages = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ControllQuality cc = new ControllQuality(storages);
        Storage st = null;
        cc.distribution(milk);
        for (var c : cc.objStorage) {
            if (c.getStorage().size() != 0 && c.getStorage().get(0).equals(milk)) {
                st = c;
            }
        }
        assertThat("Shop", is(st.getClass().getSimpleName()));
    }

    @Test
    public void whenAddToTrash()  {
        LocalDateTime ldt = LocalDateTime.now();
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, ldt.getDayOfMonth() - 20);
        Food milk = new Milk("Willey Milk", lastDelivery,
                20, 120, 50);
        List<Storage> storages = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ControllQuality cc = new ControllQuality(storages);
        Storage st = null;
        cc.distribution(milk);
        for (var c : cc.objStorage) {
            if (c.getStorage().size() != 0 && c.getStorage().get(0).equals(milk)) {
                st = c;
            }
        }
        assertThat("Trash", is(st.getClass().getSimpleName()));
    }


    @Test
    public void whenAddToShopWithDiscount()  {
        LocalDateTime ldt = LocalDateTime.now();
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, ldt.getDayOfMonth() - 17);
        Food milk = new Milk("Willey Milk", lastDelivery,
                20, 120, 50);
        List<Storage> storages = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ControllQuality cc = new ControllQuality(storages);
        cc.distribution(milk);
        assertThat(60.0, is(cc.objStorage.get(1).getStorage().get(0).getPrice()));
    }
}