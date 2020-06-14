package in.himanshugawari.java.javaprogrammingmasterclass.generics.generics2;

public class Main {
  public static void main(String[] args) {
    FootballPlayer joe = new FootballPlayer("Joe");
    BaseballPlayer pat = new BaseballPlayer("Pat");
    SoccerPlayer beckham = new SoccerPlayer("Beckham");

    Team himanshu = new Team("Himanshu");
    himanshu.addPlayer(joe);
    himanshu.addPlayer(pat);
    himanshu.addPlayer(beckham);

    System.out.println(himanshu.numPlayers());
  }
}