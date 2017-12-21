package com.ct.parser.strategy;

import java.util.Arrays;

public class StrategyFactory {
	public static ParsingStrategy createObject(String strategyName) {
		String[] nArray = {"N1", "N2", "N3", "N4"};
		ParsingStrategy strategy = null;
		if("ISA".equals(strategyName)) {
			strategy = new ISAParsingStrategy();
		}
		else if("GS".equals(strategyName)) {
			strategy = new GSParsingStrategy();
		}
		else if("ST".equals(strategyName)) {
			strategy = new STParsingStrategy();
		}
		else if("B10".equals(strategyName)) {
			strategy = new B10ParsingStrategy();
		} 
		else if("L11".equals(strategyName)) {
			strategy = new L11ParsingStrategy();
		}
		else if("G62".equals(strategyName)) {
			strategy = new G62ParsingStrategy();
		} 
		else if(Arrays.asList(nArray).contains(strategyName)) {
			strategy = new NParsingStrategy();
		} else {
			strategy = new NoStrategy();
		}
		return strategy;
	}
}
