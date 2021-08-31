package database;

import domain_classes.Driver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RestResult extends Rest{

    public ArrayList<Driver> getRaceResult() {
        setUrl("http://ergast.com/api/f1/current/last/results");
        start("Result");
        ArrayList<Driver> ad = new ArrayList<>();
        int points;
        Driver d = new Driver();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                String[] parts = e.getAttribute("points").split("\\.");
                points = parseInt(parts[0]);
                d.setName(e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent());
                d.setNumber(parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent()));
                d.setAge(calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now()));
                d.setRace_position(e.getAttribute("positionText"));
                System.out.println(d.getName() + " " + d.getNumber() + " " + points + " " + d.getRace_position());
                d.setF1points(points);
                ad.add(d);
            }

        }
        return ad;
    }

    public ArrayList<Driver> getQualifyingResult() {
        setUrl("http://ergast.com/api/f1/current/last/qualifying");
        start("QualifyingResult");
        ArrayList<Driver> ad = new ArrayList<>();
        Driver d = new Driver();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                d.setName(e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent());
                d.setNumber(parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent()));
                d.setAge(calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now()));
                d.setQualifying_position(e.getAttribute("position"));
                if(e.getAttribute("rank").equals("1"))
                    d.setFantaF1points(5, false);
                System.out.println(d.getName() + " " + d.getNumber() + " " + d.getQualifying_position());
                ad.add(d);
            }

        }
        return ad;
    }
}
