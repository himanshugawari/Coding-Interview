package in.himanshugawari.java.javaprogrammingmasterclass.collection.setsandhashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author himanshu
 *
 */
public class SetsAndHashSet {
	private static Map<String, HeavenlyBody> solarSystem = new HashMap<String, HeavenlyBody>();
	private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();

	public static void main(String[] args) {
		HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		temp = new HeavenlyBody("Venus", 225);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		temp = new HeavenlyBody("Earth", 365);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);

		temp = new HeavenlyBody("Mars", 687);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		tempMoon = new HeavenlyBody("Deimos", 1.3);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Mars

		tempMoon = new HeavenlyBody("Phobos", 0.3);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Mars

		temp = new HeavenlyBody("Jupiter", 4332);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		tempMoon = new HeavenlyBody("Io", 1.8);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Jupiter

		tempMoon = new HeavenlyBody("Europa", 3.5);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Jupiter

		tempMoon = new HeavenlyBody("Ganymede", 7.1);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Jupiter

		tempMoon = new HeavenlyBody("Callisto", 16.7);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon); // temp is still Jupiter

		temp = new HeavenlyBody("Saturn", 10759);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		temp = new HeavenlyBody("Uranus", 30660);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		temp = new HeavenlyBody("Neptune", 165);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		temp = new HeavenlyBody("Pluto", 248);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);

		System.out.println("Planets");
		for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getName());
		}

		HeavenlyBody body = solarSystem.get("Earth");
		System.out.println("Moons of " + body.getName());
		for (HeavenlyBody jupiterMoon : body.getSatellite()) {
			System.out.println("\t" + jupiterMoon.getName());
		}

		body = solarSystem.get("Mars");
		System.out.println("Moons of " + body.getName());
		for (HeavenlyBody jupiterMoon : body.getSatellite()) {
			System.out.println("\t" + jupiterMoon.getName());
		}

		Set<HeavenlyBody> moons = new HashSet<>();
		for (HeavenlyBody planet : planets) {
			moons.addAll(planet.getSatellite());
		}

		System.out.println("All Moons");
		for (HeavenlyBody moon : moons) {
			System.out.println("\t" + moon.getName());
		}
	}
}

final class HeavenlyBody {
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellite;

	public HeavenlyBody(String name, double orbitalPeriod) {
		super();
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellite = new HashSet<>();
	}

	public boolean addMoon(HeavenlyBody moon) {
		return this.satellite.add(moon);
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Set<HeavenlyBody> getSatellite() {
		return new HashSet<>(this.satellite);
	}

}