package in.himanshugawari.java.javaprogrammingmasterclass.oop.polymorphism;

/**
 * @author himanshu
 *
 */
public class Polymorphism {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			Movie movie = randomMovie();
			System.out.println("Movie #" + i + " : " + movie.getName() + "\n" + "Plot : " + movie.plot() + "\n");
		}
	}

	public static Movie randomMovie() {
		// return random number between 1 and 5
		int randomNumber = (int) (Math.random() * 5) + 1;
		System.out.println("Random number generated was " + randomNumber);

		switch (randomNumber) {
		case 1:
			return new Jaws();
		case 2:
			return new IndependencyDay();
		case 3:
			return new MazeRunner();
		case 4:
			return new StarWars();
		case 5:
			return new Forgetable();
		}
		return null;
	}
}

class Movie {
	private String name;

	public Movie(String name) {
		this.name = name;
	}

	public String plot() {
		return "no plot here";
	}

	public String getName() {
		return name;
	}
}

class Jaws extends Movie {
	public Jaws() {
		super("Jaws");
	}

	@Override
	public String plot() {
		return "shark eats a lot of people";
	}
}

class IndependencyDay extends Movie {
	public IndependencyDay() {
		super("Independency Day");
	}

	@Override
	public String plot() {
		return "aliens attempt to take over planet earth";
	}
}

class MazeRunner extends Movie {
	public MazeRunner() {
		super("Maze Runner");
	}

	@Override
	public String plot() {
		return "kids try to escape a maze";
	}
}

class StarWars extends Movie {
	public StarWars() {
		super("Star Wars");
	}

	@Override
	public String plot() {
		return "imperial forces try to take over the universe";
	}
}

class Forgetable extends Movie {
	public Forgetable() {
		super("Forgetable");
	}
	// no plot method
}