package net.codejava.world.model;

import java.util.stream.Stream;

public enum Continent {
	Asia("Asia"), Europe("Europe"), NorthAmerica("North America"), Africa("Africa"), Oceania("Oceania"),
	Antarctica("Antarctica"), SouthAmerica("South America");

	private String name;

	private Continent(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static Continent fromString(String name) {
		return Stream.of(Continent.values())
				.filter(c -> c.getName().equals(name))
				.findFirst().orElseThrow(IllegalArgumentException::new);
	}
}
