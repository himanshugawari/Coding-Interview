package in.himanshugawari.java.javaprogrammingmasterclass.generics.generics2;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

  private String name;
  private int played = 0;
  private int won = 0;
  private int lost = 0;
  private int tied = 0;

  private ArrayList<T> members = new ArrayList<>();

  Team(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean addPlayer(T player) {
    if (members.contains(player)) {
      System.out.println(player.getName() + " is already on this team");
      return false;
    } else {
      members.add(player);
      System.out.println(player.getName() + " picked for team " + this.name);
      return true;
    }
  }

  public int numPlayers() {
    return this.members.size();
  }

  public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
    String message;
    if (ourScore > theirScore) {
      won++;
      message = " beat ";
    } else if (ourScore == theirScore) {
      tied++;
      message = " drew with ";
    } else {
      lost++;
      message = " lost to  ";
    }
    played++;
    int ts = theirScore;
    if (opponent != null) {
      System.out.println(this.getName() + message + opponent.getName());
      opponent.matchResult(null, ts, ourScore);
    }
  }

  public int ranking() {
    return (won * 2) + tied;
  }

  @Override
  public int compareTo(Team<T> team) {
    if (this.ranking() > team.ranking()) {
      return -1;
    } else if (this.ranking() < team.ranking()) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}