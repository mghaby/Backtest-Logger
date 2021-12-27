package mghaby;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Logger {
    String pair;
    double startingBalance;
    double currentBalance;
    int riskPerPosition;
    int totalDrawdown;
    ArrayList<Trade> trades = new ArrayList<Trade>(100); // 100 Trades to get comfortable with a strategy

    Logger(String pair, double startingBalance, int riskPerPosition) {
        this.pair = pair;
        this.startingBalance = startingBalance;
        this.riskPerPosition = riskPerPosition;
        currentBalance = startingBalance;
        totalDrawdown = 0;
    }

    public int generateTradeID() {
        return trades.size() + 1;
    }

    public void addTrade(Trade trade){
        trades.add(trade);
        calculateCurrentBalance();
       // postToDB();
    }

    public Trade getLastTrade() {
        if (trades.size() <= 0){
            System.out.println("No Trades Yet!");
            throw new NoSuchElementException();
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

    public void calculateCurrentBalance(){
        double positionDollarAmmount = getCurrentBalance() * (riskPerPosition / 100);
        double riskToRewardRatio = getLastTrade().stopLossInPips / getLastTrade().finalPipAmmount;
        currentBalance += (positionDollarAmmount * riskToRewardRatio);
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public void calculateTotalDrawdownPercentage(){
        if(currentBalance > startingBalance) totalDrawdown = 0;
        if(currentBalance < startingBalance){
           double difference = startingBalance - currentBalance;
           double bottomDifference = (startingBalance + currentBalance) / 2;
           double differencePercentage = ((difference / bottomDifference) * 100);
           totalDrawdown = (int) Math.round(differencePercentage);
        }
    }

    public int getTotalDrawdown(){
        calculateTotalDrawdownPercentage();
        return totalDrawdown;
    }



        
}