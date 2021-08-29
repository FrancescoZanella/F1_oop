package database;

import domain_classes.*;

import java.lang.reflect.Constructor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

public class TestApp {
    public static void main(String[] args) throws SQLException {
        DataDriver dd = new DataDriver();
        DataConstructor dc = new DataConstructor();
        DataLeague dl = new DataLeague();
        DataUser du = new DataUser();
        DataTeam dt = new DataTeam();
        DataRace dr = new DataRace();

        Squad sf, me, am;
        Driver lh, sv, cl, cs, ls, vb;
        Team t = new Team("nonva");
        Team t2 = new Team("vediamo");

        dr.deleteAllRaces();
        du.deleteAllUsers();
        dt.deleteAllTeams();
        dd.deleteAllDrivers();
        dc.deleteAllConstructors();
        dl.deleteAllLeagues();

        du.InsertNewUser(new User("iacopo", "valli", "japy99@gmail.com", "iappi99", "password"));
        du.InsertNewUser(new User("francesco", "zanella", "francizanella00@gmail.com", "zanzi", "password2"));
        du.InsertNewUser(new User("mario", "rossi", "lamaildimario@yahoo.it", "mari", "password3"));
        dr.InsertNewRace(new Race("Monza", "Italy", 4.02, new Date(-900000), new Date(-1000000)));
        dr.InsertNewRace(new Race("Spa", "Belgium", 5.08, new Date(10000), new Date(9000)));
        dd.InsertNewDriver(lh = new Driver("Lewis Hamilton", 36, 44));
        dd.InsertNewDriver(sv = new Driver("Sebastian Vettel", 37, 5));
        dd.InsertNewDriver(cl = new Driver("Charles Leclerc", 23, 16));
        dd.InsertNewDriver(cs = new Driver("Carlos Sainz", 25, 55));
        dd.InsertNewDriver(ls = new Driver("Lance Stroll", 24, 31));
        dd.InsertNewDriver(vb = new Driver("Valtteri Bottas", 30, 77));
        dc.InsertNewConstructor(me = new Squad("Mercedes AMG Petronas", dd.getDriver("Lewis Hamilton", 44), dd.getDriver("Valtteri Bottas", 77)));
        dc.InsertNewConstructor(sf = new Squad("Scuderia Ferrari", dd.getDriver("Charles Leclerc", 16), dd.getDriver("Carlos Sainz", 55)));
        dc.InsertNewConstructor(am = new Squad("Aston Martin", dd.getDriver("Sebastian Vettel", 5), dd.getDriver("Lance Stroll", 31)));
        dl.insertNewLeague(new League("cipollini", "polloarrosto", false, 2));
        dl.insertNewLeague(new League("fagiolini", "pecorino", true, 2));
        dt.insertNewTeam(t.getTeamName(), "mari");
        dt.insertNewTeam("vediamo", "iappi99");

        t.addItem(cl);
        t.addItem(sv);
        t.addItem(lh);
        t.addItem(cs);
        t.addItem(vb);
        t.addItem(sf);

        dt.insertAllItem("mari", t.getTeamName(), t.teamDrivers);
        dt.insertAllItem("iappi99", t2.getTeamName(), t.teamDrivers);
        cl.setFantavalue(13.4);
        cl.setFantaF1points(32);
        vb.setFantaF1points(34);
        lh.setFantaF1points(15);
        vb.setF1points(23);
        lh.setF1points(10);
        dt.deleteDriverFromTeam(cl.getName(), cl.getNumber(), t2.getTeamName(), "iappi99");
    }
}
