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
    private String pair;
    private String timeframe;
    private double startingBalance;
    private double currentBalance;
    private int riskPerPosition;
    private int totalDrawdown;
    ArrayList<Trade> trades = new ArrayList<Trade>(100); // 100 Trades to get comfortable with a strategy

    Logger(String pair, String timeframe, double startingBalance, int riskPerPosition) {
        this.pair = pair;
        this.timeframe = timeframe;
        this.startingBalance = startingBalance;
        this.riskPerPosition = riskPerPosition;
        currentBalance = startingBalance;
        totalDrawdown = 0;
    }

    public int generateTradeID(){
        return trades.size() + 1;
    }

    public double getStartingBalance(){
        return startingBalance;
    }
    
    public String getPair(){
        return pair;
    }

    public String getTimeframe(){
        return timeframe;
    }

    public void addTrade(Trade trade){
        trades.add(trade);
        calculateCurrentBalance();
        postToDB();
    }

    public Trade getLastTrade(){ // handle NoSuchElementException properly
        if (trades.size() <= 0){
            System.out.println("No Trades Yet!");
            throw new NoSuchElementException();
        }
        return trades.get(trades.size() - 1);
    }

    public void printAllTrades(){
        for (Trade i : trades){
            System.out.println(i);
        }
    }

    public void postToDB(){
       JSONObject mainObj = new JSONObject();

       JSONObject loggerObj = new JSONObject();
       loggerObj.put("pair", pair);
       loggerObj.put("timeframe", timeframe);
       loggerObj.put("startingBalance", startingBalance);
       loggerObj.put("currentBalance", currentBalance);
       loggerObj.put("riskPerPosition", riskPerPosition);
       loggerObj.put("totalDrawdown", totalDrawdown);

       JSONArray tradesArray = new JSONArray();
       JSONObject tradesArrayObj = new JSONObject();

       for (int i = 0; i < trades.size(); i++){
            tradesArrayObj.put("tradeId", trades.get(i).tradeId);
            tradesArrayObj.put("time", trades.get(i).time);
            tradesArrayObj.put("date", trades.get(i).date);
            tradesArrayObj.put("stopLossInPips", trades.get(i).stopLossInPips);
            tradesArrayObj.put("finalPipAmmount", trades.get(i).finalPipAmmount);
            tradesArray.add(tradesArrayObj);
       }

       loggerObj.put("trades", tradesArray);

       mainObj.put("Logger", loggerObj);

       try (FileWriter file = new FileWriter("db.json")){
           file.write(mainObj.toJSONString());
           file.flush();
       } catch (IOException e){
           e.printStackTrace();
       }
    }

    public void getFromDB(){
        // read trades from the json file
    }

    public void calculateCurrentBalance(){
        double positionDollarAmmount = currentBalance * (riskPerPosition / 100);
        double riskToRewardRatio = getLastTrade().stopLossInPips / getLastTrade().finalPipAmmount;
        currentBalance += (positionDollarAmmount * riskToRewardRatio);
    }

    public double getCurrentBalance(){
        calculateCurrentBalance();
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