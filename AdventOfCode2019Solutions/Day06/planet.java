import java.util.ArrayList;

public class Planet {
    private String planetName;
    private ArrayList<Planet> orbits;

    public Planet(String _planetName) {
        planetName = _planetName;
        orbits = new ArrayList<>();
    }

    public void addOrbitingPlanet(Planet planet) {
        orbits.add(planet);
    }

    public Integer getOrbitingPlanets() {
        return orbits.size();
    }
}