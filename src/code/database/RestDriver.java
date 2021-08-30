package database;

import domain_classes.Driver;
import domain_classes.Race;
import domain_classes.Squad;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class RestDriver extends Rest {

    public void getAllDrivers() {
        setUrl("http://ergast.com/api/f1/2021/1/results");
        start("Result");
        String name;
        int number;
        int age;
        Squad s;
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                name = e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent();
                number = Integer.parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent());
                age = calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now());
                if(Squad.getConstructor(e.getElementsByTagName("Name").item(0).getTextContent()) == null)
                    s = new Squad(e.getElementsByTagName("Name").item(0).getTextContent());
                else
                    s = Squad.getConstructor(e.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println(name + " " + number + " " + age + " " + s.getName());
                new Driver(name, age, number);
                s.insertNewDriver(name, number);
            }

        }
    }

    public void getAllRaces() {
        setUrl("http://ergast.com/api/f1/current");
        start("Race");
        LocalDate dbr = null, dbq;
        String name;
        String nation;
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                name = e.getElementsByTagName("RaceName").item(0).getTextContent();
                nation = e.getElementsByTagName("Country").item(0).getTextContent();
                dbr = dbr.parse(e.getElementsByTagName("Date").item(0).getTextContent());
                dbq = dbr.withDayOfYear(dbr.getDayOfYear() - 1);
                System.out.println(name + " " + nation + " " + dbr + " " + dbq);
                new Race(name, nation, 0, Date.valueOf(dbr), Date.valueOf(dbq), true);
            }

        }
    }


    public static void main(String[] args){
        Driver.deleteAllDrivers();
        Race.deleteAllRaces();
        RestDriver rd = new RestDriver();
        rd.getAllDrivers();
        rd.getAllRaces();
    }
}
