package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.mysql.PartnerDAO;
import wefun.model.po.PartnerPO;
import wefun.service.PartnerService;
@Service
public class PartnerServiceImpl implements PartnerService{
	@Autowired
	private PartnerDAO partnerDAO;
	@Override
	public Integer add(PartnerPO partner) {
		if(null == partner){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		return partnerDAO.insert(partner);
	}

	@Override
	public void update(PartnerPO partner) {
		if(null == partner){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		final int id = partner.getId();
		PartnerPO partnerDB = partnerDAO.get(id);
		if(partnerDB == null){
			throw new BusinessRuntimeException(CodeAndMsg.CANNOT_FIND_IN_DATABASE);
		}
		partnerDB.setLabel(partner.getLabel());
		partnerDB.setName(partner.getName());
		partnerDB.setOrder(partner.getOrder());
		partnerDB.setPhoto(partner.getPhoto());
		partnerDAO.update(partnerDB);
	}

	@Override
	public List<PartnerPO> getPartnerList() {
		return partnerDAO.list();
	}

	@Override
	public PartnerPO get(int id) {
		return partnerDAO.get(id);
	}

	@Override
	public void delete(int id) {
		partnerDAO.delete(id);
	}

}
