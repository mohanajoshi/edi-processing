package com.ct.parser.filereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Scanner;

import dao.ShipmentStatusMessage;


public class FileReader {

	private static final String UTF_8_ENCODING = "UTF-8";

	public static void main(String[] args) throws Exception {
		FileReader rf = new FileReader();	
		//rf.loadDocument("D://PPD_Project//Preclarus//EDI Integration//1buv00n5an4sv1.fnf");
//		rf.readFile("D://PPD_Project//Preclarus//EDI Integration//1buv00n5an4sv1.fnf", "D://PPD_Project//Preclarus//EDI Integration//smallfile.txt");
		
		Properties rules = loadRules();
		
		Properties appProps = loadAppicationProperties();
		
		readFile(rules, appProps.getProperty("fileLocation") + "/test_input_file.txt");
//		readFile(rules, appProps.getProperty("fileLocation") + "/214OutputB.TXT");
		
	}

	public static Properties loadRules() {
		return loadProperties("/rules.properties");
	}
	
	public static Properties loadAppicationProperties() {
		return loadProperties("/application.properties");
	}
	
	public static Properties loadProperties(String filePath) {
		FileInputStream fileInput = null;
		Properties properties = new Properties();
		
		  InputStream is = null;
	        try {
	         
	            is = FileReader.class.getResourceAsStream(filePath);
	            properties.load(is);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return properties;
	}

	private static void readFile(Properties rules, String inputPath) throws Exception{
		BufferedReader reader = null;
		BufferedWriter writer = null;
		ShipmentStatusMessage msg = new ShipmentStatusMessage();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), UTF_8_ENCODING));
			for (String line; (line = reader.readLine()) != null;) {

				try {
					FileParser.parseLine(rules, line, msg);
				} catch(Exception e) {
					System.out.println("Some error caused while parsing the following line, please check this line:\n" + line);
				}

			}
			System.out.println("Message object: " + msg);
		}
		finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}

	}
}

