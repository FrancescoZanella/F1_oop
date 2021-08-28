package database;

import domain_classes.Abstract_f1_item;
import domain_classes.League;
import domain_classes.Team;
import domain_classes.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class DataTeam extends Data {

    public void insertNewTeam(Team t, String u) {
        try {
            startConnection();
            StringBuffer sb = new StringBuffer();
            StringBuffer sbc = new StringBuffer();
            for (Abstract_f1_item i : t.getTeamDrivers().values()) {
                if (i.getNumber() < 100) {
                    sb.append(",'");
                    sb.append(i.getName());
                    sb.append("','");
                    sb.append(i.getNumber());
                    sb.append("'");
                } else {
                    sbc.append(",'");
                    sbc.append(i.getName());
                    sbc.append("','");
                    sbc.append(i.getNumber());
                    sbc.append("'");
                }
            }
            statement.executeUpdate("INSERT INTO team(teamname, name_user, driver_name1, number_driver1, " +
                    "driver_name2, number_driver2, driver_name3, number_driver3, driver_name4, number_driver4, driver_name5, number_driver5," +
                    "constructor_name, number_constructor, budget, fantaf1points) VALUES('" + t.getTeamName() + "','" + u + sb + sbc + ", 250, 0)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insertNewTeam(String teamname, String u) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO team(teamname, name_user, budget, fantaf1points, number_driver1, number_driver2, number_driver3, number_driver4, number_driver5, number_constructor) VALUES('" + teamname + "','" + u + "', 250, 0, 0, 0, 0, 0, 0, 0)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteTeam(String teamname, String username) {
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM team WHERE(teamname = '" + teamname + "' and name_user = '" + username + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public boolean sameTeam(Team t, User u) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from team");
                while (rs.next()) {
                    if (u.getUsername().equals(rs.getString("username")) && t.getTeamName().equals(rs.getString("teamname")))
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

    public Team getTeam(String new_username, String new_team) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM team WHERE name_user = '" + new_username + "' and teamname = '" + new_team + "'");
            if (rs.next()) {
                DataDriver dd = new DataDriver();
                DataConstructor dc = new DataConstructor();
                HashMap<Integer, Abstract_f1_item> dr = new HashMap<>();
                for (int i = 1; i < 6; i++)
                    dr.put(rs.getInt("number_driver" + i), dd.getDriver(rs.getString("driver_name" + i), rs.getInt("number_driver" + i)));
                dr.put(rs.getInt("number_constructor"), dc.getConstructor(rs.getString("constructor_name"), rs.getInt("number_constructor")));
                return new Team(rs.getString("teamname"), dr, rs.getFloat("budget"), rs.getInt("fantaf1points"));
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public void setFantaPointsTeam(String new_name, int number) {
        try {
            startConnection();
            try {
                DataDriver dd = new DataDriver();
                DataConstructor dc = new DataConstructor();
                if (number < 100) {
                    for (int i = 1; i < Team.getNumDriver(); i++) {
                        rs = statement.executeQuery("UPDATE team SET fantaf1points = fantaf1points + " + dd.getDriver(new_name, number).getFantaF1points() +
                                " where driver_name" + i + " = '" + new_name + "' and number_driver" + i + " = " + number);
                    }
                } else {
                    rs = statement.executeQuery("UPDATE team SET fantaf1points = fantaf1points + " + dc.getConstructor(new_name, number).getFantaF1points() +
                            " where constructor_name = '" + new_name + "' and number_constructor = " + number);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
    }

    public void setBudget(String new_name, int number) {
        try {
            startConnection();
            try {
                DataDriver dd = new DataDriver();
                DataConstructor dc = new DataConstructor();
                if (number < 100) {
                    for (int i = 1; i < Team.getNumDriver(); i++) {
                        rs = statement.executeQuery("UPDATE team SET budget = budget - " + dd.getDriver(new_name, number).getFantavalue() +
                                " where driver_name" + i + " = '" + new_name + "' and number_driver" + i + " = " + number);
                    }
                } else {
                    rs = statement.executeQuery("UPDATE team SET budget = budget - " + dc.getConstructor(new_name, number).getFantavalue() +
                            " where constructor_name = '" + new_name + "' and number_constructor = " + number);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
    }

    public boolean insertNewItem(String new_username, String new_teamname, String name_item, int number_driver) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM team WHERE teamname = '" + new_teamname + "' and name_user = '" + new_username + "'");
            if (rs.next()) {
                if (number_driver < 100) {
                    for (int i = 1; i < Team.getNumDriver(); i++) {
                        if (rs.getString("driver_name" + i) == null && rs.getInt("number_driver" + i) == 0) {
                            statement.executeUpdate("UPDATE team SET driver_name" + i + "= '" + name_item + "', number_driver" + i + "= " + number_driver +
                                    " WHERE teamname = '" + new_teamname + "' and name_user = '" + new_username + "'");
                            return true;
                        }
                    }
                } else {
                    if (rs.getString("constructor_name") == null && rs.getInt("number_constructor") == 0) {
                        statement.executeUpdate("UPDATE team SET constructor_name = '" + name_item + "', number_constructor = " + number_driver +
                                " WHERE teamname = '" + new_teamname + "' and name_user = '" + new_username + "'");
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

    public boolean insertAllItem(String new_username, String new_teamname, HashMap<Integer, Abstract_f1_item> alldrivers) {
        try {
            startConnection();
            int c = 1;
            if (alldrivers.size() == 6) {
                for (Abstract_f1_item i : alldrivers.values()) {
                    if (i.getNumber() < 100) {
                        statement.executeUpdate("UPDATE team SET driver_name" + i + "= '" + i.getName() + "', number_driver" + i + "= " + i.getNumber() +
                                " WHERE teamname = '" + new_teamname + "' and name_user = '" + new_username + "'");
                    } else {
                        statement.executeUpdate("UPDATE team SET constructor_name" + i + "= '" + i.getName() + "', number_constructor" + i + "= " + i.getNumber() +
                                " WHERE teamname = '" + new_teamname + "' and name_user = '" + new_username + "'");
                    }
                }
            } else
                return false;
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public void deleteAllTeams() {
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM team");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
