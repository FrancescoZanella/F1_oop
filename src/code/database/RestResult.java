package database;

import domain_classes.Driver;
import domain_classes.Race;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RestResult extends Rest {

    public ArrayList<Driver> getRaceResult() {
        setUrl("http://ergast.com/api/f1/current/last/results");
        start("Race");
        if (nl.getLength() == 1) {
            Node n1 = nl.item(0);
            if (n1.getNodeType() == Node.ELEMENT_NODE) {
                Element r = (Element) n1;
                String racename = r.getElementsByTagName("RaceName").item(0).getTextContent();
                String country = r.getElementsByTagName("Country").item(0).getTextContent();
                String date = r.getElementsByTagName("Date").item(0).getTextContent();
                if (!Race.checkIfAlreadyRaced(racename, country, Date.valueOf(date))) {
                    System.out.println(racename + " " + Race.checkIfAlreadyRaced(racename, country, Date.valueOf(date)));
                    start("Result");
                    ArrayList<Driver> ad = new ArrayList<>();
                    Race.setAlreadyRaced(racename, country, Date.valueOf(date));
                    int points;
                    for (int i = 0; i < nl.getLength(); i++) {
                        Node n = nl.item(i);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element e = (Element) n;
                            Driver d = new Driver();
                            String[] parts = e.getAttribute("points").split("\\.");
                            points = parseInt(parts[0]);
                            d.setName(e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent());
                            d.setNumber(parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent()));
                            d.setAge(calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now()));
                            d.setRace_position(e.getAttribute("positionText"));
                            d.setF1points(points);
                            if (e.getAttribute("rank").equals("1"))
                                d.setFantaF1points(5, false);
                            ad.add(d);
                        }

                    }
                    return ad;
                }
            }
        }
        return null;
    }

    public ArrayList<Driver> getQualifyingResult() {
        setUrl("http://ergast.com/api/f1/current/last/qualifying");
        start("QualifyingResult");
        ArrayList<Driver> ad = new ArrayList<>();

        System.out.println("");
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                Driver d = new Driver();
                d.setName(e.getElementsByTagName("GivenName").item(0).getTextContent() + " " + e.getElementsByTagName("FamilyName").item(0).getTextContent());
                d.setNumber(parseInt(e.getElementsByTagName("PermanentNumber").item(0).getTextContent()));
                d.setAge(calculateAge(LocalDate.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now()));
                d.setQualifying_position(e.getAttribute("position"));
                ad.add(d);
            }

        }
        return ad;
    }
}
