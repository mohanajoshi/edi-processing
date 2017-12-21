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

//	private void readFile(String inputPath, String outputPath) throws IOException{
//		BufferedReader reader = null;
//		BufferedWriter writer = null;
//
//		try {
//			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), UTF_8_ENCODING));
//
//			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), UTF_8_ENCODING));
//
//			for (String line; (line = reader.readLine()) != null;) {
//
//				writer.write(line);
//				writer.newLine();
//
//
//			}
//		}
//		finally {
//			if (reader != null) {
//				reader.close();
//			}
//			if (writer != null) {
//				writer.close();
//			}
//		}
//
//	}
	
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

				FileParser.parseDocument(rules, line, msg);
				

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
	
	/*private void loadDocument(String path) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		int i =0;
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
				i++;
			}
			System.out.println("count = "+ i);

			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
	}*/
}

