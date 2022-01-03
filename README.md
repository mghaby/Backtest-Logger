# BacktestLogger

This application is used to log FOREX backtesting results up to 100 trades stored in a database.

## Description

The application takes in multiple fields such as the pair, starting balance, timeframe and risk per position when descering the basis of a logger, as well as taking in relevant data for trades when required. You will also have the ability to access a automatically saving local databse `db.json`. This program is in the CLI.

## Getting Started

### Dependencies

* Java JDK 17
* Maven
* json-simple 1.1.1 (In `pom.xml` already)

### Installing

* `git clone https://github.com/mghaby/backtestlogger.git`

### Executing program

```
cd backtestlogger/
cd src/main/java/mghaby
mvn compile
cd target/classes/
java App.class
```

## Authors

1. Mark Ghaby
  * [Github](https://github.com/mghaby)
  * [LinkedIn](https://www.linkedin.com/in/mghaby/)

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the GNU General Public License - see the LICENSE file for details

## Acknowledgments

* [README-Template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)