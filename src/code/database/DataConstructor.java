package database;

import domain_classes.Driver;
import domain_classes.Squad;
import domain_classes.Team;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataConstructor extends Data {
    public void InsertNewConstructor(Squad s) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO constructor VALUES('" + s.getName() + "'," + s.getNumber() + ",'" + s.getD1().getName() + "','" + s.getD2().getName() + "','" + s.getD1().getNumber() + "','" + s.getD2().getNumber() + "', 0, 0, 0)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void InsertNewConstructor(String name, int number) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO constructor(name, number, f1points, fantaf1points, fantavalue) VALUES('" + name + "'," + number + ", 0, 0, 0)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameConstructor(Squad s) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from constructor");
                while (rs.next()) {
                    if (s.getName().equals(rs.getString("name")) && s.getNumber() == rs.getInt("number"))
                        return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public void deleteConstructor(Squad s) {
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM constructor(name, number) WHERE name = '" + s.getName() + "' and number = " + s.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteAllConstructors() {
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM constructor");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Squad> getAllConstructors(String order) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM constructor ORDER BY " + order);
            ArrayList<Squad> d = new ArrayList<>();
            while(rs.next()){
                d.add(new Squad(rs.getString("name"), rs.getInt("number"), rs.getDouble("fantavalue")));}
            return d;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public Squad getConstructor(String new_name) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM constructor WHERE name = '" + new_name + "'");
            if (rs.next()) {
                DataDriver d = new DataDriver();
                return new Squad(rs.getString("name"), rs.getInt("number"), d.getDriver(rs.getString("driver_name1"), rs.getInt("number_driver1")), d.getDriver(rs.getString("driver_name2"), rs.getInt("number_driver2")), rs.getInt("f1points"), rs.getInt("fantaf1points"), rs.getDouble("fantavalue"));
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public Squad getConstructorbyDriver(String new_name, int number) {
        try {
            startConnection();
            for (int i = 1; i < 3; i++) {
                rs = statement.executeQuery("SELECT * FROM constructor WHERE driver_name" + i  + " = '" + new_name + "' and number_driver" + i + " = " + number);
                if (rs.next()) {
                    DataDriver d = new DataDriver();
                    return new Squad(rs.getString("name"), rs.getInt("number"), d.getDriver(rs.getString("driver_name1"), rs.getInt("number_driver1")), d.getDriver(rs.getString("driver_name2"), rs.getInt("number_driver2")), rs.getInt("f1points"), rs.getInt("fantaf1points"), rs.getFloat("fantavalue"));
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public void setAllValues(String new_name, int new_number, int fantaf1points, int f1points, double fantavalue) {
        try {
            startConnection();
            rs = statement.executeQuery("UPDATE constructor SET fantaf1points = fantaf1points + " + fantaf1points + ", f1points = f1points + " + f1points + ", fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean insertNewDriver(String constructor_name, String name_driver, int number_driver) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM constructor WHERE name = '" + constructor_name + "'");
            if (rs.next()) {
                    DataDriver dd = new DataDriver();
                    for (int i = 1; i < 3; i++) {
                        if (rs.getString("driver_name" + i) == null && rs.getInt("number_driver" + i) == 0) {
                            statement.executeUpdate("UPDATE constructor SET driver_name" + i + "= '" + name_driver + "', number_driver" + i + "= " + number_driver +
                                    " WHERE name = '" + constructor_name + "'");
                            return true;
                        }
                    }
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public void setFantaValue(String new_name, int new_number, double fantavalue) {
        try {
            startConnection();
            statement.executeUpdate("UPDATE constructor SET fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setF1Points(String new_name, int new_number, int f1points) {
        try {
            startConnection();
            statement.executeUpdate("UPDATE constructor SET f1points = f1points + " + f1points +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setFantaF1Points(String new_name, int new_number, int fantaf1points) {
        try {
            startConnection();
            statement.executeUpdate("UPDATE constructor SET fantaf1points = fantaf1points + " + fantaf1points +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        DataTeam dt = new DataTeam();
        dt.setFantaPointsTeam(new_name, new_number);
    }


}
