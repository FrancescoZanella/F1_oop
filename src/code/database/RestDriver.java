package database;

import domain_classes.Driver;
import domain_classes.Race;
import domain_classes.Squad;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.sql.Date;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class RestDriver extends Rest{

    public void getAllDrivers() {
        setUrl("http://ergast.com/api/f1/current/driverStandings");
        start("DriverStanding");
        String name;
        int number;
        int age;
        Driver d;
        Squad s;
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                name = e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent();
                number = parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent());
                age = calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now());
                if(Squad.getConstructor(e.getElementsByTagName("Name").item(0).getTextContent()) == null)
                    s = new Squad(e.getElementsByTagName("Name").item(0).getTextContent());
                else
                    s = Squad.getConstructor(e.getElementsByTagName("Name").item(0).getTextContent());
                d = new Driver(name, age, number);
                s.insertNewDriver(name, number);
                String[] parts = e.getAttribute("points").split("\\.");
                d.setF1points(parseInt(parts[0]));
            }
        }
    }

    public void getAllRaces() {
        setUrl("http://ergast.com/api/f1/current");
        start("Race");
        LocalDate dbr, dbq;
        String name;
        String nation;

        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                name = e.getElementsByTagName("RaceName").item(0).getTextContent();
                nation = e.getElementsByTagName("Country").item(0).getTextContent();
                dbr = LocalDate.parse(e.getElementsByTagName("Date").item(0).getTextContent());
                dbq = dbr.withDayOfYear(dbr.getDayOfYear() - 1);
                new Race(name, nation, 0, Date.valueOf(dbr), Date.valueOf(dbq), true);
                if(dbr.isBefore(LocalDate.now())){
                    Race.setAlreadyRaced(name, nation, Date.valueOf(dbr));
                    Race.setAlreadyQualified(name, nation, Date.valueOf(dbr));
                }

            }
        }
    }


   /*public static void main(String[] args){
        Driver.deleteAllDrivers();
        Race.deleteAllRaces();
        Squad.deleteAllConstructors();
        RestDriver rd = new RestDriver();
        rd.getAllDrivers();
        rd.getAllRaces();
    }*/


}
