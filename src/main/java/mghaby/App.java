package mghaby;

import java.util.*;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App {
    
    // Variables
    static boolean newOrOldBool = true;
    static int newOrOldDecision = 0;
    static int tradeBoolDecision = 0;
    static boolean newLogBool = true;
    static boolean tradeBool = true;
    static boolean tradeCreationBool = true;
    static Logger logger = null;

    public static void main(String[] args ){ // get rid of the instanceof operators in this whole file when you figure out how to handle the `inputMismatchException` -- i think its a try/catch block

        // Check if new or old logger
        System.out.println("Welcome to the Backtest Logger! \nWould you like to create a new log? (1) OR Access an old log? (2)");
        while (newOrOldBool){
            Scanner newOrOldScanner = new Scanner(System.in);

            // try here
            newOrOldDecision = newOrOldScanner.nextInt();

            if (newOrOldDecision == 1 || newOrOldDecision == 2) {
                newOrOldBool = false;
            } else {
                System.out.println("Invalid input. Please try again.");
            }

            // end try here, catch estackprint here

            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        // New Logger & Trade loop
        if (newOrOldDecision == 1){
            
            // New Logger creation
            System.out.println("Please input the pair, timeframe, starting balance and risk per position seperated by new line characters.");
            while (newLogBool){
                Scanner newLogScanner = new Scanner(System.in);

                //try here
                String nLPair = newLogScanner.nextLine();
                String nLTimeframe = newLogScanner.nextLine();
                Double nLStartingBalance = newLogScanner.nextDouble();
                Integer nLRisk = newLogScanner.nextInt();

                if ((nLPair instanceof String) && (nLTimeframe instanceof String) && (nLStartingBalance instanceof Double) && (nLRisk instanceof Integer)){ // remove this & put `else` in catch
                    logger = new Logger(nLPair, nLTimeframe, nLStartingBalance, nLRisk);
                    newLogBool = false; // try end here
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
            getFromDB();

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
        }
    }

    public static void getFromDB(){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("db.json"));
            JSONObject jsonObj = (JSONObject) obj;
            String pairHolder = (String) jsonObj.get("pair");
            String timeframeHolder = (String) jsonObj.get("timeframe");
            double startingBalanceHolder = (double) jsonObj.get("startingBalance");
            double currentBalanceHolder = (double) jsonObj.get("currentBalance");
            int riskPerPositionHolder = (int) jsonObj.get("riskPerPosition");
            int totalDrawdownHolder = (int) jsonObj.get("totalDrawdown");

            logger = new Logger(pairHolder, timeframeHolder, startingBalanceHolder, riskPerPositionHolder);
            logger.updateFromDB(currentBalanceHolder, totalDrawdownHolder);

            JSONArray tradeHolder = (JSONArray) jsonObj.get("trades");
            Iterator<Trade> iterator = tradeHolder.iterator();

            while (iterator.hasNext()){
                logger.addTrade(new Trade(
                            iterator.next().tradeId, iterator.next().time, iterator.next().date, 
                            iterator.next().stopLossInPips,iterator.next().finalPipAmmount));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}