package mghaby;

public class App {
    public static void main( String[] args ){
        Logger logger = new Logger("GBPAUD", 10000, 2);
        logger.addTrade(new Trade(1, "10AM", "21,09", 40, 80));
        System.out.println(logger.getLastTrade());
        //logger.addTrade(new Trade(1, "10AM", "21,09", 40, 80));

    }
}

// essnetialy this should mimic stevens excel spreadsheet but act as an interface for it and the database.

// +--------------------------------------------------------------------------+
// logger class
// communicator class (file io to the DB class)

// +--------------------------------------------------------------------------+
// in the logger class you need to take starting account balance, pair and risk % per position.
// then you need this class to need to have calcualtion methods called upon this class.
// each instance of logger should be pushed to the database itself and should be treated as a single instance

// use jframe and jbuttons to add trades to the logger (let it be ugly until it is done)

// after this you may choose to make a starting interface that will allow the user to access one of the exisitng loggers or make a new one

