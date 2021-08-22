package com.example.demo;

public class DeliveryCostCalculator {
	
	public static double getVolume(double height, double width, double length) {
		return height * width * length;
	}
	
	public static double getCost(double weight, double volume) {
		//volume = getVolume(parcel.getHeight(), parcel.getWeight(), parcel.getLength());
		if(weight > 50) {
			return 0; // overweight
		} else if(weight > 10) {
			return volume * 20; // heavy parcel
		}
		
		if(volume < 1500) {
			return volume * 0.03; // small parcel
		} else if(volume < 1500) {
			return volume * 0.04; // medium parcel
		} else {
			return volume * 0.05; // large parcel
		}
	}

}
