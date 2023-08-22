package com.t0khyo.cruddemo;

import com.t0khyo.cruddemo.dao.AppDAO;
import com.t0khyo.cruddemo.entity.Instructor;
import com.t0khyo.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			creatInstructor(appDAO);
		};
	}

	private void creatInstructor(AppDAO appDAO) {
		/* ToDo:
				* create instructor
				* create instructor detail
				* associate the objects
				* save the instructor
		 */


		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"Luv 2 code!!");

		tempInstructor.setInstructorDetail(instructorDetail);

		// NOTE: this will ALSO save details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
