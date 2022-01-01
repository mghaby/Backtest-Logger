package mghaby;
import java.util.*;

public class App {
    public static void main(String[] args ){ // get rid of the instanceof operators in this whole file when you figure out how to handle the `inputMismatchException`1

        // Variables
        boolean newOrOldBool = true;
        int newOrOldDecision = 0;
        int tradeBoolDecision = 0;
        boolean newLogBool = true;
        boolean tradeBool = true;
        boolean tradeCreationBool = true;
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
            }

            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
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

                if ((nLPair instanceof String) && (nLTimeframe instanceof String) && (nLStartingBalance instanceof Double) && (nLRisk instanceof Integer)){
                    logger = new Logger(nLPair, nLTimeframe, nLStartingBalance, nLRisk);
                    newLogBool = false;
                } else {
                    System.out.println("Inccorect Type: Pair, Starting Balance or Risk. Please try again.");
                }

                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }

            // Trade options checks
            while (tradeBool){
                System.out.println("Would you like to log a new trade? (1) OR View current results (2) OR Exit (3)");
                Scanner tradeBoolScanner = new Scanner(System.in);
                tradeBoolDecision = tradeBoolScanner.nextInt();

                if (tradeBoolDecision == 1 || tradeBoolDecision == 2 || tradeBoolDecision == 3){
                    switch (tradeBoolDecision){
                        case 1: // new Trade creation
                        System.out.println("Please input the time of trade, date of trade, stoploss in pips and final pip ammount seperated by new line characters");
                        while (tradeCreationBool){
                            Scanner newTradeScanner = new Scanner(System.in);
                            String timeOfTrade = newTradeScanner.nextLine();
                            String dateOfTrade = newTradeScanner.nextLine();
                            Integer stopLossInPips = newTradeScanner.nextInt();
                            Integer finalPipAmmount = newTradeScanner.nextInt();

                            if ((timeOfTrade instanceof String) && (dateOfTrade instanceof String) && (stopLossInPips instanceof Integer) && (finalPipAmmount instanceof Integer)){
                                logger.addTrade(new Trade(logger.generateTradeID(), timeOfTrade, dateOfTrade, stopLossInPips, finalPipAmmount));
                                tradeCreationBool = false;
                            } else {
                                System.out.println("Inccorect Type: Date, Time, Stoploss or Final Pip Value. Please try again.");
                            }

                            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                        }
                        break;

                        case 2: // Print Logger data
                        if (logger.trades.size() < 1){
                            System.out.println("No Trades To Print");
                        } else {
                            System.out.println("Pair: " + logger.getPair() + " Timeframe: " + logger.getTimeframe());
                            System.out.println("Starting Balance: $" + logger.getStartingBalance());
                            System.out.println("Current Balance: $" + logger.getCurrentBalance());
                            System.out.println("Total Drawdown: " + logger.getTotalDrawdown() + "%");
                            System.out.println("All Trades:");
                            logger.printAllTrades();
                        }
                        break;

                        case 3: // Exit
                        System.out.println("Thanks for using the logger!");
                        System.exit(0);
                    }

                } else {
                    System.out.println("Invalid input. Please try again.");
                }

                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        } else {
            // access old log here



        }


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
         */         // this prints to db.json in main directory

    // App methods here
    }
}


// so far all need to do is populate the App.java logger variable with the set JSON array from the db.json file, 
// we will have a method that it can call on itself that will essentially do everything, then we can copy and paste the code for making new trades that we have from ~50-89
// also need to make a method that writes to the database and is called after everytime a new trade is initialised ( we can add this into the addTrade method in logger.java to make implementation easy)


// make a seperate maven project and implement the json code above and see how to manipulate where the db saves, chuck it into a db folder if possible