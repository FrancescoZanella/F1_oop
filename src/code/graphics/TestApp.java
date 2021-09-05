package graphics;

import domain_classes.*;
import graphics.*;

import java.lang.reflect.Constructor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

public class TestApp {
    public static void main(String[] args) throws SQLException {
       new JoinLeague("zanzi");
       new CreateLeague("zanzi");
    }
}
