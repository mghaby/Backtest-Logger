package mghaby;

import java.util.*;

public class App {
    public static void main(String[] args ){
        boolean newOrOldBool = true;
        int newOrOldDecisionOut = 0;
        boolean newLogBool = true;

        System.out.println("Welcome to the Backtest Logger! \nWould you like to create a new log? (1) OR Access an old log? (2)");

        while (newOrOldBool){
            Scanner newOrOld = new Scanner(System.in);
            int newOrOldDecision = newOrOld.nextInt();
            newOrOldDecisionOut = newOrOldDecision;

            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

            if (newOrOldDecision == 1 || newOrOldDecision == 2) {
                newOrOldBool = false;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        if (newOrOldDecisionOut == 1){
            System.out.println("Please input the pair, starting balance and risk per position seperated by new line characters.");

            while (newLogBool){
                Scanner newLog = new Scanner(System.in);
                String nLPair = newLog.nextLine();
                Double nLStartingBalance = newLog.nextDouble();
                Integer nLRisk = newLog.nextInt();

                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                if ((nLPair instanceof String) && (nLStartingBalance instanceof Double) && (nLRisk instanceof Integer)){
                    Logger logger = new Logger(nLPair, nLStartingBalance, nLRisk);
                    newLogBool = false;
                } else {
                    System.out.println("Inccorect Type: Pair, Starting Balance or Risk. Please try again.");
                }
            }



            // make new log here
        } else {
            // access old log here
        }


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

    // methods here










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

