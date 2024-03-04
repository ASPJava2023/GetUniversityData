package com.restxml;

//http://localhost:8082/swagger-ui/index.html

//http://localhost:8082/v3/api-docs

//Help Link 

//https://www.baeldung.com/spring-rest-openapi-documentation

//Live application -->https://getuniversitydata-production.up.railway.app/swagger-ui/index.html

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.restxml.Exception.AppExceptionHandler;

@RestController
public class UniversityRestcontroler {

	// private static final String API_URL =
	// "http://universities.hipolabs.com/search?country=United+States";

	@GetMapping("/getindiadata/{country}")
	public String getindiadata(@PathVariable String country) throws Exception {
		String c = country;
		if (c == null) {
			throw new Exception();
		} else {
			System.out.println(c);
			String temp_URL = "http://universities.hipolabs.com/search?country=".concat(country);
			String API_URL = temp_URL;
			System.out.println(temp_URL);
// Create a RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
// Make the GET request and convert the response to a list of University objects
			University[] universities = restTemplate.getForObject(API_URL, University[].class);
// Convert the array to a list for easier handling
			List<University> universityList = Arrays.asList(universities);
// Print the fetched data
			System.out.println("==============Fetched University Data:=================");
// universityList.forEach(System.out::println );
			// System.out.println("The Total University :" + universityList.size());

			for (University university : universityList) {
				System.out.println("===============================================");
				System.out.println("University/College Name:: " + university.getName());
				System.out.println("State/Province Name::" + university.getStateprovince());
				System.out.println("Domains ::" + university.getDomains().get(0));
				System.out.println("Website ::" + university.getWeb_pages().get(0));
				System.out.println("country ::" + university.getCountry());
			}

			System.out.println("The Total University :" + universityList.size());

			return " Got Data of ".concat(country);
		}
	}

	@GetMapping("/welcomemsg")
	public String welcomemsg() {
		return "Welcome to App to Get university details by country";
	}

	@GetMapping("/HelloAnkit")
	public String HelloAnkit() {
		return "My Name is Ankit";
	}
	@GetMapping("/welcomemsg/{name}")
	public String welcomemsgbyName(@PathVariable("name") String name) {
		return  name +" ,Welcome to App to Get university details by country";
	}
}
