import java.sql.*;
import java.util.ArrayList;
/**
 * Created by marshall on 10/04/2017.
 */
public class DbController {
    private String dbName;
    private int postcode;
    private ArrayList<DataRow> dataList = new ArrayList<>();
    public ArrayList<DataRow> getDataList() {
        return dataList;
    }
    public int getPostcode() {
        return postcode;
    }
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    public void printOutlet(ResultSet rs) {
        dataList.clear();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int sn = rs.getInt("streetNum");
                String street = rs.getString("street");
                String suburb = rs.getString("suburb");
                int postcode = rs.getInt("postcode");
                float ar = rs.getFloat("averageRating");
                String descr = rs.getString("description");
                String scene = rs.getString("scenery");
                float ap = rs.getFloat("averagePrice");
                DataRow dr = new DataRow(id, name, sn, street, suburb, postcode, ar, descr, scene, ap);
                dataList.add(dr);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createTables() { // Creates tables in Outlets.db: outlets,
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            String sql = "";
            sql = "CREATE TABLE IF NOT EXISTS Outlets " +
                    "(id int PRIMARY KEY NOT NULL, " +
                    "name char, " +
                    "streetNum int, " +
                    "street varchar(300), " +
                    "suburb varchar(300), " +
                    "postcode int, " +
                    "averageRating decimal(3,1), " +
                    "description varchar(300), " +
                    "scenery varchar(100), " +
                    "averagePrice decimal(5,2));";
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS Tags " +
                    "(outletId int NOT NULL, " +
                    "tag varchar(10));";
            stmt.execute(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String strQuote(String s){
        String newS = "";
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            newS += c;
            if(c == 39 && i != 0 && i != (s.length())-1){
                newS += "'";
            }
        }
        return newS;
    }
    public void addToTable(String tableName, String[] splitLine) {
        try {
            String sql = "INSERT INTO " + tableName + " ";
            String colStr = "(";
            String valStr = " (";
            int len = splitLine.length;
            for (int i = 3; i < len; i += 2) {
                colStr += splitLine[i];
                if (i != len - 2) {
                    colStr += ", ";
                }
            }
            colStr += ") ";
            for (int i = 4; i < len; i += 2) {
                splitLine[i] = strQuote(splitLine[i]);
                valStr += splitLine[i];
                if (i != len - 1) {
                    valStr += ", ";
                }
            }
            valStr += ");";
            sql += colStr + "VALUES" + valStr;
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            stmt.execute(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void searchName(String n) {
        dataList.clear();
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Outlets");
            n = n.toLowerCase();
            while (rs.next()) {
                String name = rs.getString("name");
                if (name.toLowerCase().contains(n)) {
                    int id = rs.getInt("id");
                    int sn = rs.getInt("streetNum");
                    String street = rs.getString("street");
                    String suburb = rs.getString("suburb");
                    int postcode = rs.getInt("postcode");
                    float ar = rs.getFloat("averageRating");
                    String descr = rs.getString("description");
                    String scene = rs.getString("scenery");
                    float ap = rs.getFloat("averagePrice");
                    DataRow dr = new DataRow(id, name, sn, street, suburb, postcode, ar, descr, scene, ap);
                    dataList.add(dr);
                }
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void printTable(String tableName, String[] splitLine) {
        int len = splitLine.length;
        int bottomRange;
        int topRange;
        String idName = "";
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            ResultSet rs = null;
            String sql = "";
            if (len == 3) {
                rs = stmt.executeQuery("SELECT * FROM " + tableName + ";"); // Print out everything in the table
                if (tableName.equals("Outlets")) {
                    printOutlet(rs);
                } else {
                    while (rs.next()) {
                        if (tableName.equals("Tags")) {
                            int id = rs.getInt("outletId");
                            String tag = rs.getString("tag");
                            System.out.print(id + " ");
                            System.out.println(tag);
                        }
                    }
                }
                rs.close();
            } else if (splitLine[3].equals("name")) {
                searchName(splitLine[4]);
            } else {
                sql += "SELECT * FROM Outlets WHERE ";
                if (splitLine[3].equals("tag")) {
                    sql += "id IN (SELECT DISTINCT outletId FROM Tags WHERE " + splitLine[3] + "=" + splitLine[4] + ")";
                } else if (splitLine[3].equals("postcode")) {
                    bottomRange = Integer.parseInt(splitLine[4]) - 10;
                    topRange = Integer.parseInt(splitLine[4]) + 10;
                    postcode = Integer.parseInt(splitLine[4]);
                    sql += splitLine[3] + " BETWEEN " + Integer.toString(bottomRange) + " AND " + Integer.toString(topRange);
                } else if (splitLine[3].equals("averageRating")) {
                    sql += splitLine[3] + ">=" + splitLine[4];
                } else if(splitLine[3].equals("averagePrice")){
                    sql += splitLine[3] + "<=" + splitLine[4];
                } else {
                    sql += splitLine[3] + "=" + strQuote(splitLine[4]);
                }
                for (int i = 5; i < len; i++) {
                    if (i % 2 == 1) {
                        sql += " OR ";
                        if (splitLine[i].equals("tag")) {
                            sql += "id IN (SELECT DISTINCT outletId FROM Tags WHERE " + splitLine[i++] + "=" + splitLine[i] + ")";
                        } else if (splitLine[i].equals("postcode")) {
                            sql += splitLine[i++];
                            bottomRange = Integer.parseInt(splitLine[i]) - 10;
                            topRange = Integer.parseInt(splitLine[i]) + 10;
                            postcode = Integer.parseInt(splitLine[i]);
                            sql += " BETWEEN " + Integer.toString(bottomRange) + " AND " + Integer.toString(topRange);
                        } else if (splitLine[i].equals("averageRating")) {
                            sql += splitLine[i++] + ">=" + splitLine[i];
                        } else if(splitLine[i].equals("averagePrice")){
                            sql += splitLine[i++] + "<=" + splitLine[i];
                        } else {
                            sql += splitLine[i++] + "=" + strQuote(splitLine[i]);
                        }
                    }
                }
                sql += ";";
                rs = stmt.executeQuery(sql);
                printOutlet(rs);
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteFromTable(String tableName, String[] splitLine) {
        try {
            int len = splitLine.length;
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            String sql = "DELETE FROM " + tableName + " WHERE ";
            sql += splitLine[3] + "=" + strQuote(splitLine[4]);
            for (int i = 5; i < len; i++) {
                sql += " AND " + splitLine[i++] + "=" + strQuote(splitLine[i]);
            }
            sql += ";";
            stmt.execute(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int highestID(){
        int id = 0;
        try{
            Connection c = DriverManager.getConnection("jdbc:sqlite:Outlets.db");
            Statement stmt = c.createStatement();
            String sql = "SELECT MAX(id) AS LargestID FROM Outlets;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("LargestID");
            }
            stmt.close();
            c.close();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(id);
        return id;
    }
    public void changeRow(String tableName, String[] splitLine) {
        try {
            int len = splitLine.length;
            int i;
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement stmt = c.createStatement();
            String sql = "UPDATE " + tableName + " SET " + splitLine[3] + "=" + strQuote(splitLine[4]);
            for (i = 5; i < len; i++) {
                if (splitLine[i].equals(";")) {
                    break;
                }
                sql += ", " + splitLine[i++] + "=" + strQuote(splitLine[i]);
            }
            i++;
            sql += " WHERE " + splitLine[i++] + "=" + strQuote(splitLine[i]);
            for (i++; i < len; i++) {
                sql += " AND " + splitLine[i++] + "=" + strQuote(splitLine[i]);
            }
            sql += ";";
            stmt.execute(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}