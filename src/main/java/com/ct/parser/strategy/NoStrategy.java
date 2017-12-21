package com.ct.parser.strategy;

import java.util.Properties;

import dao.ShipmentStatusMessage;

public class NoStrategy implements ParsingStrategy {

	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens,
			ShipmentStatusMessage msg) throws Exception {
		System.out.println(tokens[0] + " : No Parsing Strategy is applied for this Segment");
		return null;
	}

}
