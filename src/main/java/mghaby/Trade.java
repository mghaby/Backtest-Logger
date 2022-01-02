package mghaby;

public class Trade {
    
    // Variables
    int tradeId;
    String time;
    String date;
    int stopLossInPips;
    int finalPipAmmount;

    public Trade(int tradeId, String time, String date, int stopLossInPips, int finalPipAmmount) {
        this.tradeId = tradeId;
        this.time = time;
        this.date = date;
        this.stopLossInPips = stopLossInPips;
        this.finalPipAmmount = finalPipAmmount;
    }

    public String toString(){
        return "Trade ID: " + tradeId + " Time: " + time + " Date: " + date + " Stop Loss: " + stopLossInPips + " Final Pip Ammount: " + finalPipAmmount;
    }

}
