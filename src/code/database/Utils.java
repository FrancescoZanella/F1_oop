package database;

import domain_classes.Team;

import java.awt.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static Path p = FileSystems.getDefault().getPath(".").toAbsolutePath().getParent();
    public static final String JDBC_Driver_SQLite = "org.sqlite.JDBC";
    public static final String JDBC_URL_SQLite = "jdbc:sqlite:" + p.toString() + "\\dati.db";
    public final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final static int width=screenSize.width;
    public final static int height=screenSize.height;
}
