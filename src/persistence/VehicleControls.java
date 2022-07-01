package persistence;

import java.util.ArrayList;

import business.Vehicle;

public class VehicleControls {

	private ArrayList<Vehicle> vehicles = new ArrayList<>();

	public boolean save(Vehicle v) {
		if (v == null) {
			return false;
		}

		vehicles.add(v);
		return true;
	}

	public ArrayList<Vehicle> retrieveAll() {
		return vehicles;
	}

}
