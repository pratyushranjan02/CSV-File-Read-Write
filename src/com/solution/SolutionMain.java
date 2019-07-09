package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVWriter;

public class SolutionMain {

	public static void main(String[] args) {
		
		List<MainCSV> collectionCSV = new ArrayList<MainCSV>();
		String delimiter = ",";
		BufferedReader br = null;
		CSVWriter writer = null;
		
		
		try {
			FileWriter fw = new FileWriter("new_data.csv");
			writer = new CSVWriter(fw);
			br = new BufferedReader(new FileReader("sample_email.csv"));
			
			//write the headers to the csv file
			String[] header = {"First Name","Last Name","Phone","Email"};
			writer.writeNext(header);
			
			//to avoid reading the heading
			br.readLine();
			
			String fileLine = br.readLine();
			MainCSV csvObject = null;
			
			while(fileLine != null) {
				String[] splitedLine = fileLine.split(delimiter);
				
				//setting up the values extracted from the csv file
				csvObject = new MainCSV();
				csvObject.setFirstName(splitedLine[0]);
				csvObject.setLastName(splitedLine[1]);
				csvObject.setEmail(splitedLine[10]);
				csvObject.setSubject(splitedLine[11]);
				csvObject.setEmailBody(splitedLine[12]);
				
				collectionCSV.add(csvObject);
				
				//Finding the phone number and email in the email body
				String pattern1 = "^[0-9]{3}-?[0-9]{3}-?[0-9]{4}$" ;
				String pattern2 = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,5}$";
				Pattern pat1 = Pattern.compile(pattern1);
				Pattern pat2 = Pattern.compile(pattern2);
				Matcher matcher1 = pat1.matcher(csvObject.getEmailBody());
				Matcher matcher2 = pat2.matcher(csvObject.getEmailBody());
				if(matcher1.find()) {
					String number = matcher1.group(0);
					String email = matcher2.group(0);
				
					//creating a string array to write it to the csv file
					String[] newLIne = {csvObject.getFirstName(),csvObject.getLastName(),number,email};
				
					//writing the email and the number to the new csv file
					writer.writeNext(newLIne);
				}
				else {
					System.out.println("No Match Found");
				}
				fileLine = br.readLine();
			}
			
			//Display the Email Template(Task 1)
			for(MainCSV str:collectionCSV) {
				System.out.println("Email to : " + str.getEmail() +"\nSubject Line: " + str.getSubject() +"\n"
						+ "Hi " + str.getFirstName() + str.getLastName() + "\n" +str.getEmailBody() +"\nThanks,\nRob Wilson\n");
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			try {
				br.close();
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}

	}

}
