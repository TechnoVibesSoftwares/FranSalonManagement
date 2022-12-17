package com.fsm.iot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RFIDServiceImpl implements RFIDService{
	
	@Autowired
	private RFIDRepository rfidRepository;

	@Override
	public RFIDEntity addRFIDCard(RFIDCard rfidCard) {
		RFIDEntity entity= new RFIDEntity();
		entity.setRfid(rfidCard.getRf_id());
		entity.setIsActive(true);
		entity.setIsDeleted(false);
		return rfidRepository.saveAndFlush(entity);
	}

	@Override
	public List<RFIDEntity> getRFIDCardList() {
		return rfidRepository.findAll();
	}

}
