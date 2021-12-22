package ru.job4j.ood.tdd.cinema;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema =  new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session3D session = new Session3D("First");
        cinema.add(session);
        List<Session> sessions = cinema.find(session1 -> "First".equals(session.name));
        assertThat(session, is(sessions.get(0)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void buyTicketOnSamePlace() throws Exception {
        Account account = new AccountCinema();
        Cinema cinema =  new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket sameTicket = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void buyTicketOnWrongDate() throws Exception {
        Account account = new AccountCinema();
        Cinema cinema =  new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }
}