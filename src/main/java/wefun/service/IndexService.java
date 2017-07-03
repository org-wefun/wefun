package wefun.service;

import java.util.List;

import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;

public interface IndexService {
	public List <ResourcePO> getBanner();
	
	public InformationPO getBaseInfo();

}
