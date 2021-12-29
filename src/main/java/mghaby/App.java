package mghaby;

import java.util.*;

public class App {
    public static void main(String[] args ){
        // Variables
        boolean newOrOldBool = true;
        int newOrOldDecision = 0;
        int tradeBoolDecision = 0;
        boolean newLogBool = true;
        boolean tradeBool = true;
        Logger logger = null;

        // Check if new or old logger
        System.out.println("Welcome to the Backtest Logger! \nWould you like to create a new log? (1) OR Access an old log? (2)");
        while (newOrOldBool){
            Scanner newOrOldScanner = new Scanner(System.in);
            newOrOldDecision = newOrOldScanner.nextInt();

            if (newOrOldDecision == 1 || newOrOldDecision == 2) {
                newOrOldBool = false;
            } else {
                System.out.println("Invalid input. Please try again.");
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }

        // New Logger & Trade loop
        if (newOrOldDecision == 1){
            
            // New Logger creation
            System.out.println("Please input the pair, timeframe, starting balance and risk per position seperated by new line characters.");
            while (newLogBool){
                Scanner newLogScanner = new Scanner(System.in);
                String nLPair = newLogScanner.nextLine();
                String nLTimeframe = newLogScanner.nextLine();
                Double nLStartingBalance = newLogScanner.nextDouble();
                Integer nLRisk = newLogScanner.nextInt();

                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                if ((nLPair instanceof String) && (nLTimeframe instanceof String) && (nLStartingBalance instanceof Double) && (nLRisk instanceof Integer)){
                    logger = new Logger(nLPair, nLTimeframe, nLStartingBalance, nLRisk);
                    newLogBool = false;
                } else {
                    System.out.println("Inccorect Type: Pair, Starting Balance or Risk. Please try again.");
                }
            }

            // Trade options checks
            System.out.println("Would you like to log a new trade? (1) OR View current results (2) OR Exit (3)");
            while (tradeBool){
                Scanner tradeBoolScanner = new Scanner(System.in);
                tradeBoolDecision = tradeBoolScanner.nextInt();

                if (tradeBoolDecision == 1 || tradeBoolDecision == 2 || tradeBoolDecision == 3){
                    switch (tradeBoolDecision){
                        case 1: // new Trade creation
                        //logic here
                        break;

                        case 2: // Print Logger data
                        System.out.println("Pair: " + logger.getPair() + " Timeframe: " + logger.getTimeframe());
                        System.out.println("Starting Balance: $" + logger.getStartingBalance());
                        System.out.println("Current Balance: $" + logger.getCurrentBalance());
                        System.out.println("Total Drawdown: " + logger.getTotalDrawdown() + "%");
                        System.out.println("All Trades:");
                        logger.printAllTrades();
                        break;

                        case 3: // Exit
                        System.out.println("Thanks for using the logger!");
                        System.exit(0);

                    }

                    // case statement here
                    // 1 = new Trade();
                        // while loop
                            // print statemtn about the trade reqs
                            // if (instance checks here) { new Trade} else {print wrong whatever and loop back} && in else try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                    // 2 = print logger.printAllTrades, logger.get whatever
                    // 3 = print thanks for using; exit(1);
                } else {
                    System.out.println("Invalid input. Please try again.");
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                }


            }
        
        // Accessing old log here
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