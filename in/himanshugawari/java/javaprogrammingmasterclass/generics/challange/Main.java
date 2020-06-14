package in.himanshugawari.java.javaprogrammingmasterclass.generics.challange;

public class Main {
  public static void main(String[] args) {

    League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

    Team<FootballPlayer> footballTeam1 = new Team<>("FootballTeam1");
    Team<FootballPlayer> footballTeam2 = new Team<>("FootballTeam2");
    Team<FootballPlayer> footballTeam3 = new Team<>("FootballTeam3");
    Team<FootballPlayer> footballTeam = new Team<>("FootballTeam");

    Team<BaseballPlayer> baseballTeam = new Team<>("BaseballTeam");

    footballLeague.add(footballTeam1);
    footballLeague.add(footballTeam2);
    footballLeague.add(footballTeam3);
    footballLeague.add(footballTeam);

    // footballLeague.add(baseballTeam);

    footballTeam1.matchResult(footballTeam2, 1, 0);
    footballTeam1.matchResult(footballTeam, 3, 8);
    footballTeam.matchResult(footballTeam2, 2, 1);

    footballLeague.showLeagueTable();

  }
}