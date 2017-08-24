package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.PartnerPO;

public interface PartnerDAO {
	
	Integer insert(PartnerPO partner);
	
	void update(PartnerPO partner);
	
	List<PartnerPO> list();
	
	PartnerPO get(int id);
	
	void delete(int id);

}
