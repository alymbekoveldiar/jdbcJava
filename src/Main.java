import java.sql.*;

public class Main {
    private final String url = "jdbc:postgresql://localhost:5432/air_travel";
    private final String user = "postgres";
    private final String password = "Gthdsqyf[";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected  good");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public String getCustomersCount() {
        String SQL = "select passenger.passenger_name from passenger ;";
        String stmtq = null;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            while (rs.next()){
                stmtq =rs.getString(2);
                System.out.println(stmtq);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return stmtq;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.getCustomersCount();

    }
}

