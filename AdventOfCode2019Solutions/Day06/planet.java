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

    public String getPlanetName() {
        return planetName;
    }

    public Integer getOrbitingPlanetsAmount() {
        return orbits.size();
    }

    public ArrayList<Planet> getOrbitingPlanets() {
        return orbits;
    }

    public boolean isBeingOrbitted(Planet planet) {
        for (int i = 0; i < orbits.size(); i++) {
            Planet orbitingPlanet = orbits.get(i);
            if (orbitingPlanet.getPlanetName() == planet.getPlanetName()) {
                return true;
            }
        }

        return false;
    }
}