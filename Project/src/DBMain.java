import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
/**
 * Created by marshall on 8/04/2017.
 */
public class DBMain {
    ArrayList<DataRow> dl;
    public ArrayList<DataRow> getDl() {
        return dl;
    }
    public void sortPostcode(ArrayList<DataRow> l, int postcode)
    {
        for(int i = 0; i < l.size()-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < l.size(); j++)
            {
                if(Math.abs(l.get(j).getPostcode() - postcode) < Math.abs(l.get(min).getPostcode() - postcode))
                {
                    min = j;
                }
            }
            if(min != i)
            {
                Collections.swap(l, i, min);
            }
        }
    }
    public void sortBookings(ArrayList<DataRow> l, String sortCat)
    {
        for(int i = 0; i < l.size()-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < l.size(); j++)
            {
                switch(sortCat){
                    case "averagePrice": if(l.get(j).getAp() < l.get(min).getAp())
                    {
                        min = j;
                    } break;
                    case "averageRating": if(l.get(j).getAr() < l.get(min).getAr())
                    {
                        min = j;
                    } break;
                }
            }
            if(min != i)
            {
                Collections.swap(l, i, min);
            }
        }
    }
    public void dbControl(String search) {
        DbController dbc = new DbController();
        String[] splitLine = search.split(",");
        for(int i = 0; i < splitLine.length; i++){
            if(splitLine[i].equals("tag")){
                splitLine[i+1] = splitLine[i+1].toLowerCase();
            }
        }
        if (splitLine[0].equals("Make")) {
            File file = new File("Outlets.db");
            if (file.exists()) {
            } else {
                try {
                    Class.forName("org.sqlite.JDBC");
                    Connection c = DriverManager.getConnection("jdbc:sqlite:" + splitLine[1] + ".db");
                    c.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            dbc.setDbName("Outlets");
            dbc.createTables();
        } else if (splitLine[0].equals("Add")) { // Input Format: Add dbName tableName column1 value1 [column2] [value2]...
            dbc.setDbName(splitLine[1]);
            dbc.addToTable(splitLine[2], splitLine);
        } else if (splitLine[0].equals("Delete")) { // Input Format: Delete dbName tableName column1 value1 [column2] [value2]...
            dbc.setDbName(splitLine[1]);
            dbc.deleteFromTable(splitLine[2], splitLine);
        } else if (splitLine[0].equals("Change")) { // Input Format: Change dbName tableName column1 value1 [column2] [value2]... ; condition/s
            dbc.setDbName(splitLine[1]);
            dbc.changeRow(splitLine[2], splitLine);
        } else if (splitLine[0].equals("Print")) { // Input Format: Print dbName tableName column1 value1 [column2] [value2]...
            dbc.setDbName(splitLine[1]);
            dbc.printTable(splitLine[2], splitLine);
            dl = dbc.getDataList();
        }
    }
}