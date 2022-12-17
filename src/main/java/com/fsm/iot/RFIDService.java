package com.fsm.iot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RFIDService {

	public RFIDEntity addRFIDCard(RFIDCard rfidCard);
	public List<RFIDEntity> getRFIDCardList();
}
