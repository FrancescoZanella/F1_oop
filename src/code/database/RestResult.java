package database;

import domain_classes.Driver;
import domain_classes.Race;
import domain_classes.Squad;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static java.lang.Double.parseDouble;
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
                System.out.println(d.getName() + " " + d.getNumber() + " " + d.getAge() + " " + points);
                ad.add(d);
            }

        }
        return ad;
    }

    public static void main(String[] args){
        RestResult rd = new RestResult();
        rd.getRaceResult();
    }
}
