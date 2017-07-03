package wefun.dao.mysql;

import wefun.model.po.InformationPO;

public interface InformationDAO {
	
	public Integer insert(InformationPO informationPO);
	
	public InformationPO get();

	public void update(InformationPO informationPO);
}
