package mghaby;


public class Logger { // make this class a singleton
    String pair;
    double startingAccountBalance;
    int riskPerPosition;
    Trade[] trades;

    Logger(String pair, double startingAccountBalance, int riskPerPosition) {
        this.pair = pair;
        this.startingAccountBalance = startingAccountBalance;
        this.riskPerPosition = riskPerPosition;
    }

    public void addTrade(Trade trade) {
        trades[trades.length] = trade;
        postToDB();
    }

    public void getLastTrade() {
        // get the last trade
    }

    public void getAllTrades() {
        for (int i = 0; i < trades.length; i++) {
            System.out.println(trades[i]);
        }
    }

    public void postToDB() {
        // write trades to the json file
    }

    public void getFromDB() {
        // read trades from the json file
    }

    public int generateTradeID() {
        return trades.length + 1;
    }



    
        
}