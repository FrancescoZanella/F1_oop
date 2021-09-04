package database;

import domain_classes.*;
import graphics.*;

import java.lang.reflect.Constructor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

public class TestApp {
    public static void main(String[] args) throws SQLException {
        new LoginPage();
        //new CreateLeague("francesco001");
        /*
        User u1, u2;
        Squad sf, me, am;
        Driver lh, sv, cl, cs, ls, vb;
        League l1, l2;


        Driver.deleteAllDrivers();
        Squad.deleteAllConstructors();
        Team.deleteAllTeams();
        League.deleteAllLeagues();
        Race.deleteAllRaces();
        User.deleteAllUsers();


        u1 = new User("iacopo", "valli", "japy99@gmail.com", "iappi99", "password");
        u2 = new User("francesco", "zanella", "francizanella00@gmail.com", "zanzi", "password2");
        new User("mario", "rossi", "lamaildimario@yahoo.it", "mari", "password3");
        new Race("Monza", "Italy", 4.02, new Date(-900000), new Date(-1000000), true);
        new Race("Spa", "Belgium", 5.08, new Date(10000), new Date(9000), true);
        Team t = new Team("nonva", u1.getUsername());
        Team t2 = new Team("vediamo", u2.getUsername());
        lh = new Driver("Lewis Hamilton", 36, 44);
        sv = new Driver("Sebastian Vettel", 37, 5);
        cl = new Driver("Charles Leclerc", 23, 16);
        cs = new Driver("Carlos Sainz", 25, 55);
        ls = new Driver("Lance Stroll", 24, 31);
        vb = new Driver("Valtteri Bottas", 30, 77);
        me = new Squad("Mercedes AMG Petronas", lh.getDriver(), vb.getDriver());
        sf = new Squad("Scuderia Ferrari", Driver.getDriver("Charles Leclerc", 16), Driver.getDriver("Carlos Sainz", 55));
        am = new Squad("Aston Martin", Driver.getDriver("Sebastian Vettel", 5), Driver.getDriver("Lance Stroll", 31));
        l1 = new League("cipollini", "polloarrosto", false, 2);
        l2 = new League("fagiolini", "pecorino", true, 2);
        new Team(t.getTeamName(), "mari");
        new Team("vediamo", u1.getUsername());
        new Team("vediam0", u1.getUsername());

        t.addItem(cl);
        t.addItem(sv);
        t.addItem(lh);
        t.addItem(cs);
        t.addItem(vb);
        t.addItem(sf);

        t.insertAllItem(t.teamDrivers);
        t2.insertAllItem(t.teamDrivers);
        l1.addNewTeam(u1, t);
        l2.addNewTeam(u1, t);
        System.out.println(League.leaguesPerUser("iappi99"));
        cl.setFantavalue(13.4);
        cl.setFantaF1points(32);
        vb.setFantaF1points(34);
        lh.setFantaF1points(15);
        vb.setF1points(23);
        lh.setF1points(10);
        t.removeItem(lh);*/
    }
}
