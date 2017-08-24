package wefun.service;

import java.util.List;

import wefun.model.po.PartnerPO;

public interface PartnerService {
	
	Integer add(PartnerPO partner);
	
	void update(PartnerPO partner);
	
	List<PartnerPO> getPartnerList();
	
	PartnerPO get(int id);
	
	void delete(int id);
}
