package com.valtech.mobity.vfc;

import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.model.EfficiencyTargetStatus;
import com.valtech.mobity.vfc.model.Users;
import com.valtech.mobity.vfc.model.VehicleDetails;
import com.valtech.mobity.vfc.repository.EfficiencyTargetRepository;
import com.valtech.mobity.vfc.repository.UsersRepository;
import com.valtech.mobity.vfc.repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleFuelConsumptionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VehicleFuelConsumptionApplication.class, args);
	}

	@Autowired
	private VehicleDetailsRepository vehicleDetailsRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private EfficiencyTargetRepository efficiencyTargetRepository;

	@Override
	public void run(String... args) {

		// Saving VehicleDetails
		VehicleDetails vehicle1 = vehicleDetailsRepository.save(new VehicleDetails(1L, "Toyota", "Camry"));
		VehicleDetails vehicle2 = vehicleDetailsRepository.save(new VehicleDetails(2L, "Honda", "Civic"));
		VehicleDetails vehicle3 = vehicleDetailsRepository.save(new VehicleDetails(3L, "Ford", "Mustang"));

		// Saving Users with associated VehicleDetails
		usersRepository.save(new Users(1L, "Alice", vehicle1));
		usersRepository.save(new Users(2L, "Bob", vehicle2));
		usersRepository.save(new Users(3L, "Charlie", vehicle3));
		usersRepository.save(new Users(4L, "David", vehicle1));
		usersRepository.save(new Users(5L, "Eve", vehicle2));
		usersRepository.save(new Users(6L, "Frank", vehicle3));

		// Saving EfficiencyTarget records
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 15.0, EfficiencyTargetStatus.ACTIVE, 1L, 1L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 20.0, EfficiencyTargetStatus.INACTIVE, 2L, 2L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 10.5, EfficiencyTargetStatus.ACTIVE, 3L, 3L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 25.0, EfficiencyTargetStatus.ACTIVE, 4L, 1L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 30.0, EfficiencyTargetStatus.INACTIVE, 5L, 2L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 10.5, EfficiencyTargetStatus.ACTIVE, 6L, 3L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 25.0, EfficiencyTargetStatus.ACTIVE, 2L, 2L));
		efficiencyTargetRepository.save(new EfficiencyTarget(null, 30.0, EfficiencyTargetStatus.ACTIVE, 5L, 2L));


		System.out.println("Database initialized!");


	}

}
