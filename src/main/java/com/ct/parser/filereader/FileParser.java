package com.ct.parser.filereader;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.ct.parser.strategy.B10ParsingStrategy;
import com.ct.parser.strategy.G62ParsingStrategy;
import com.ct.parser.strategy.GSParsingStrategy;
import com.ct.parser.strategy.ISAParsingStrategy;
import com.ct.parser.strategy.L11ParsingStrategy;
import com.ct.parser.strategy.NParsingStrategy;
import com.ct.parser.strategy.Parser;
import com.ct.parser.strategy.STParsingStrategy;
import com.ct.parser.strategy.StrategyFactory;

import dao.ShipmentStatusMessage;

public class FileParser {
	
	public static void parseLine(Properties rules, String line, ShipmentStatusMessage msg) throws Exception{

		
		String[] tokens = getTokens(line);
		String mainToken = tokens[0];
		
		//factory pattern is used in below line
		Parser parser = new Parser(StrategyFactory.createObject(mainToken));
		if(parser!=null) {
			parser.parse(rules, tokens, msg);
		}
	}
	
	private static String[] getTokens(String line) {
		if(line==null) {
			line = "";
		}
		return line.split("~");
		 
	}
	
	
}
