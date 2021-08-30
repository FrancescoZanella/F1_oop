package database;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;


public abstract class Rest implements Runnable{
        static String url;
        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document document;
        NodeList nl;


        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public void start(String type) {
                dbf = DocumentBuilderFactory.newInstance();
                db = null;
                try {
                        db = dbf.newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                }
                document = null;
                try {
                        document = db.parse(url);
                } catch (SAXException | IOException e) {
                        e.printStackTrace();
                }

                document.getDocumentElement().normalize();
                nl = document.getElementsByTagName(type);
        }

        @Override
        public void run() {

        }

        public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
                if ((birthDate != null) && (currentDate != null)) {
                        return Period.between(birthDate, currentDate).getYears();
                } else {
                        return 0;
                }
        }

}
