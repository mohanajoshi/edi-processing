package com.ct.parser.strategy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ct.parser.filereader.FileParser;
import com.ct.parser.filereader.FileReader;
import com.ct.parser.strategy.ISAParsingStrategy;

import dao.ISA_InterchangeControlHeader;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class StrategyTestCases {

//	ISA_InterchangeControlHeader ISA_Obj;
	ISAParsingStrategy ISA_ParsingStrategy;
	Properties rules = null;
	List<String> fileLines = null;
	@Before
	public void runBeforeTestMethods() {
		ISA_ParsingStrategy = new ISAParsingStrategy();
		rules = FileReader.loadRules();
		fileLines = new ArrayList<String>();
		
			fileLines.add("ISA~00~          ~00~          ~ZZ~FEDEX          ~ZZ~PPFGLOBC       ~171122~0404~U~00401~000000002~0~P~:");
			fileLines.add("GS~QM~FEDEX~PPFGLOBC~20171122~0404~2~X~004010");
			fileLines.add("ST~214~0389");
			fileLines.add("B10~406528902161~300-92522-92522020~FDE");
			fileLines.add("L11~REQ-000000033683~PO");
			/*N1~SF~Mayo Clinic Bioservices
			N2~Shipping and Storage
			N3~2915 Valley High Dr NW
			N4~Rochester~MN~55901~US
			G62~11~20171121
			N1~ST~PPD GLOBAL CENTRAL LABS
			N2~MELISSA NORTH
			N3~2 TESSENEER DRIVE
			N4~HIGHLAND HEIGHTS~KY~41076~US
			LX~1
			AT7~AG~NS~~~20171122~1030
			LX~2
			AT7~X4~NS~~~20171121~2316
			MS1~MEMPHIS~TN~US
			L11~300-92522-92522020~CR
			L11~BAP RESEARCH SHIPPING~DP
			AT8~G~L~16~1
			SE~21~0389*/
	}
	
	@Test
	public void testISA_ParsingStrategy() throws Exception {
		String ISA_line = fileLines.get(0);
		ShipmentStatusMessage msg = new ShipmentStatusMessage();
		FileParser.parseDocument(rules, ISA_line, msg);
		
		Object obj = msg.getISA_interchangControlHeader();
		System.out.println(obj);
		assertNotNull(obj);
	}
	
	@Test
	public void testGS_ParsingStrategy() throws Exception {
		String GS_line = fileLines.get(1);
		ShipmentStatusMessage msg = new ShipmentStatusMessage();
		FileParser.parseDocument(rules, GS_line, msg);
		
		Object obj = msg.getGS_functionalGroupHeader();
		System.out.println(obj);
		assertNotNull(obj);
	}
	
	@Test
	public void testST_ParsingStrategy() throws Exception {
		String ST_line = fileLines.get(2);
		ShipmentStatusMessage msg = new ShipmentStatusMessage();
		FileParser.parseDocument(rules, ST_line, msg);
		
		List<ST_TransactionSetHeader> list = msg.getListST_transactionSetHeader();
		for(ST_TransactionSetHeader st : list) {
			System.out.println("\n" + st);
		}
		
		assertNotNull(list);
		assertEquals(list.size(), 1);
	}
}

