package mghaby;
import java.util.ArrayList;

public class Logger {
    String pair;
    double startingAccountBalance;
    int riskPerPosition;
    ArrayList<Trade> trades = new ArrayList<Trade>(100);

    Logger(String pair, double startingAccountBalance, int riskPerPosition) {
        this.pair = pair;
        this.startingAccountBalance = startingAccountBalance;
        this.riskPerPosition = riskPerPosition;
    }

    public int generateTradeID() {
        return trades.size() + 1;
    }

    public void addTrade(Trade trade){
        trades.add(trade);
       // postToDB();
    }

    public Trade getLastTrade() {
        if (trades.size() == 0){
            return trades.get(0);
        }
        return trades.get(trades.size() - 1);
    }

    public void printAllTrades() {
        for (Trade i : trades){
            System.out.println(i);
        }
    }

    public void postToDB() {
       // post trades to json file
    }

    public void getFromDB() {
        // read trades from the json file
    }

        
}