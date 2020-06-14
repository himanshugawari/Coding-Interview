package in.himanshugawari.java.javaprogrammingmasterclass.generics.generics2;

public class Main {
  public static void main(String[] args) {
    FootballPlayer joe = new FootballPlayer("Joe");
    BaseballPlayer pat = new BaseballPlayer("Pat");
    SoccerPlayer beckham = new SoccerPlayer("Beckham");

    Team<FootballPlayer> footballTeam = new Team<>("FootballTeam");
    footballTeam.addPlayer(joe);

    Team<BaseballPlayer> baseballTeam = new Team<>("BaseballTeam");
    baseballTeam.addPlayer(pat);

    Team<SoccerPlayer> soccerTeam = new Team<>("SoccerTeam");
    soccerTeam.addPlayer(beckham);

    Team<FootballPlayer> footballTeam1 = new Team<>("FootballTeam1");
    Team<FootballPlayer> footballTeam2 = new Team<>("FootballTeam2");

    footballTeam1.matchResult(footballTeam2, 1, 0);
    footballTeam1.matchResult(footballTeam, 3, 8);
    footballTeam.matchResult(footballTeam2, 2, 1);

    String p = "Players in ";
    System.out.println(p + footballTeam.getName() + " is " + footballTeam.numPlayers());
    System.out.println(p + footballTeam1.getName() + " is " + footballTeam1.numPlayers());
    System.out.println(p + footballTeam2.getName() + " is " + footballTeam2.numPlayers());
    System.out.println(p + baseballTeam.getName() + " is " + baseballTeam.numPlayers());
    System.out.println(p + soccerTeam.getName() + " is " + soccerTeam.numPlayers());

    System.out.println("Rankings");
    System.out.println(footballTeam.getName() + " : " + footballTeam.ranking());
    System.out.println(footballTeam1.getName() + " : " + footballTeam1.ranking());
    System.out.println(footballTeam2.getName() + " : " + footballTeam2.ranking());
    System.out.println(baseballTeam.getName() + " : " + baseballTeam.ranking());
    System.out.println(soccerTeam.getName() + " : " + soccerTeam.ranking());

    System.out.println(footballTeam.compareTo(footballTeam1));
    System.out.println(footballTeam.compareTo(footballTeam2));
    System.out.println(footballTeam2.compareTo(footballTeam));
    System.out.println(footballTeam.compareTo(footballTeam));
  }
}