package com.example.restservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SurveyController {

	private static String dataset_path = "/home/uoy/salary_survey-1.csv"; 

	@GetMapping("/get_by_timestamp")
	public ResponseEntity<List<Dto>> get_by_timestamp(@RequestParam(value = "timestamp", defaultValue = "") String timestamp) {	
		String line = "";
		List<Dto> answers = new ArrayList<Dto>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(dataset_path));
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} // this will read and skip the first line
			
			try {
				while((line = br.readLine()) != null) {
				
					String[] lines = line.split(",", -1); //splitting read line

					if(lines[0] == timestamp){
						Dto objt = new Dto();
					objt.setTimestamp(lines[0]);
					objt.setAge_range(lines[1]);
					objt.setIndustry(lines[2]);
					objt.setJob_title(lines[3]);
					objt.setSalary(lines[4]);
					objt.setCurrency(lines[5]);
					objt.setLocation(lines[6]);
					objt.setYoe(lines[7]);
					objt.setTitle_other(lines[8]);
					objt.setCurrency_other(lines[9]);
					answers.add(objt);
					break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(answers);
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/list_data")
	public ResponseEntity<List<Dto>> list_data(@RequestParam(value = "sort", defaultValue = "") String sort) {	
		String line = "";
		List<Dto> answers = new ArrayList<Dto>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(dataset_path));
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} // this will read and skip the first line
			
			try {
				while((line = br.readLine()) != null) {
				
					String[] lines = line.split(",", -1);
					Dto objt = new Dto();
					objt.setTimestamp(lines[0]);
					objt.setAge_range(lines[1]);
					objt.setIndustry(lines[2]);
					objt.setJob_title(lines[3]);
					objt.setSalary(lines[4]);
					objt.setCurrency(lines[5]);
					objt.setLocation(lines[6]);
					objt.setYoe(lines[7]);
					objt.setTitle_other(lines[8]);
					objt.setCurrency_other(lines[9]);
					answers.add(objt);

					switch(sort){
						case "timestamp":
							answers.sort((o1, o2)
						-> o1.getTimestamp().compareTo(
							o2.getTimestamp()));
							break;
						case "age_range":
							answers.sort((o1, o2)
						-> o1.getAge_range().compareTo(
							o2.getAge_range()));
							break;
							case "industry":
							answers.sort((o1, o2)
						-> o1.getIndustry().compareTo(
							o2.getIndustry()));
							break;
							case "job_title":
							answers.sort((o1, o2)
						-> o1.getJob_title().compareTo(
							o2.getJob_title()));
							break;
							case "salary":
							answers.sort((o1, o2)
						-> o1.getSalary().compareTo(
							o2.getSalary()));
							break;
							case "currency":
							answers.sort((o1, o2)
						-> o1.getSalary().compareTo(
							o2.getSalary()));
							break;
							case "location":
							answers.sort((o1, o2)
						-> o1.getLocation().compareTo(
							o2.getLocation()));
							break;
							case "yoe":
							answers.sort((o1, o2)
						-> o1.getYoe().compareTo(
							o2.getYoe()));
							break;
							case "title_other":
							answers.sort((o1, o2)
						-> o1.getTitle_other().compareTo(
							o2.getTitle_other()));
							break;
							case "currency_other":
							answers.sort((o1, o2)
						-> o1.getCurrency_other().compareTo(
							o2.getCurrency_other()));
							break;
					}
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(answers);
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
