package database;

import domain_classes.Driver;
import domain_classes.Squad;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.time.LocalDate;
import java.time.Period;

public class RestDriver extends Rest {

    public void getAllDrivers() {
        setUrl("http://ergast.com/api/f1/2021/1/results");
        start("Result");
        LocalDate db = null;
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
                age = calculateAge(db.parse(e.getElementsByTagName("DateOfBirth").item(0).getTextContent()), LocalDate.now());
                s = new Squad(e.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println(name + " " + number + " " + age + " " + s.getName());
                new Driver(name, age, number);
                s.insertNewDriver(name, number);
            }

        }


    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        Driver.deleteAllDrivers();
        RestDriver rd = new RestDriver();
        rd.getAllDrivers();
    }
}
