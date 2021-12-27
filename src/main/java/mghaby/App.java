package mghaby;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App {
    public static void main( String[] args ){
        System.out.println("Welcome to the Backtest Logger! \nWould you like to create a new log (1) OR access an old log? (2)");
        Scanner newOrOld = new Scanner(System.in);
        // if (inputisValid() && input == 1)
            // ask for pair, starting acc balance, and risk per trade
        // 












        //Logger logger = new Logger("GBPAUD", 10000, 2);
        //logger.addTrade(new Trade(1, "10AM", "21,09", 40, 80));
        //System.out.println(logger.getLastTrade());
        //logger.addTrade(new Trade(1, "10AM", "21,09", 40, 80));








        /**
        JSONObject database = new JSONObject();
        database.put("test", "test2");
        JSONArray dblist = new JSONArray();
        dblist.add(database);
        try (FileWriter file = new FileWriter("db.json")){
            file.write(dblist.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
         */         // this prints to db.json in main directory for some reason
    }
}

// essnetialy this should mimic stevens excel spreadsheet but act as an interface for it and the database.

// +--------------------------------------------------------------------------+
// logger class
// communicator class (file io to the DB class)

// +--------------------------------------------------------------------------+
// in the logger class you need to take starting account balance, pair and risk % per position.
// then you need this class to need to have calcualtion methods called upon this class.
// each instance of logger should be pushed to the database itself and should be treated as a single instance

// use jframe and jbuttons to add trades to the logger (let it be ugly until it is done)

// after this you may choose to make a starting interface that will allow the user to access one of the exisitng loggers or make a new one

