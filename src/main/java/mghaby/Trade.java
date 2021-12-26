package mghaby;

public class Trade {
    int tradeId;
    String time;
    String date;
    int stopLossInPips;
    int takeProfitInPips;

    public Trade(int tradeId, String time, String date, int stopLossInPips, int takeProfitInPips) {
        this.tradeId = tradeId;
        this.time = time;
        this.date = date;
        this.stopLossInPips = stopLossInPips;
        this.takeProfitInPips = takeProfitInPips;
    }

    public String toString(){
        return "Trade ID: " + tradeId + " Time: " + time + " Date: " + date + " Stop Loss: " + stopLossInPips + " Take Profit: " + takeProfitInPips;
    }

}
