package mghaby;

import java.util.*;

public class App {
    public static void main(String[] args ){
        boolean newOrOldBool = true;
        int newOrOldDecision = 0;
        boolean newLogBool = true;
        boolean tradeBool = true;
        Logger logger;

        System.out.println("Welcome to the Backtest Logger! \nWould you like to create a new log? (1) OR Access an old log? (2)");

        while (newOrOldBool){
            Scanner newOrOldScanner = new Scanner(System.in);
            newOrOldDecision = newOrOldScanner.nextInt();

            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

            if (newOrOldDecision == 1 || newOrOldDecision == 2) {
                newOrOldBool = false;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        if (newOrOldDecision == 1){
            System.out.println("Please input the pair, starting balance and risk per position seperated by new line characters.");

            while (newLogBool){
                Scanner newLogScanner = new Scanner(System.in);
                String nLPair = newLogScanner.nextLine();
                Double nLStartingBalance = newLogScanner.nextDouble();
                Integer nLRisk = newLogScanner.nextInt();

                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                if ((nLPair instanceof String) && (nLStartingBalance instanceof Double) && (nLRisk instanceof Integer)){
                    logger = new Logger(nLPair, nLStartingBalance, nLRisk);
                    newLogBool = false;
                } else {
                    System.out.println("Inccorect Type: Pair, Starting Balance or Risk. Please try again.");
                }
            }

            System.out.println("Would you like to log a new trade? (1) OR View current results (2) OR Exit (3)");
            while (tradeBool){
                //Scanner newTradeBoolScanner = new Scanner(System.in);


                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }



            }

            // make a loop here to check "do you want to add a new trade or quit" if add new trade make another loop asking for inputs etc and use the add logger method thing / if quit look to exit(1) or view drawdown n that



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

    // methods here if needed

}

// use jframe and jbuttons to add trades to the logger (let it be ugly until it is done)