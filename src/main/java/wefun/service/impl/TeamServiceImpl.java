package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.mysql.InformationDAO;
import wefun.dao.mysql.TeamDAO;
import wefun.model.po.InformationPO;
import wefun.model.po.TeamPO;
import wefun.service.TeamService;
@Service
public class TeamServiceImpl extends BaseServiceImpl implements TeamService{
	@Autowired
    private TeamDAO teamDAO;
	@Autowired
	private InformationDAO informationDAO;
	@Override
	public List<TeamPO> getTeamList() {
		return teamDAO.list();
	}

	@Override
	public Integer insertTeam(TeamPO team) {
		if(null == team ){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
	    InformationPO info = informationDAO.get();
	    if(null != info){
	    	team.setQrCodeQQ(info.getQrCodeQQ());
	    	team.setQrCodeWechat(info.getQrCodeWechat());
	    }
		return teamDAO.insert(team);
	}

	@Override
	public void updateTeam(TeamPO team) {
		if(null == team ){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		final int id = team.getId();
		if(id <= 0){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		TeamPO teamDB = teamDAO.get(id);
		if(teamDB == null){
			throw new BusinessRuntimeException(CodeAndMsg.CANNOT_FIND_IN_DATABASE);
		}
	    InformationPO info = informationDAO.get();
	    if(null != info){
	    	teamDB.setQrCodeQQ(info.getQrCodeQQ());
	    	teamDB.setQrCodeWechat(info.getQrCodeWechat());
	    }
		teamDB.setDegree(team.getDegree());
		teamDB.setLabel(team.getLabel());
		teamDB.setName(team.getName());
		teamDB.setPhoto(team.getPhoto());
		teamDB.setQrCodeQQ(team.getQrCodeQQ());
		teamDB.setQrCodeWechat(team.getQrCodeWechat());
		teamDB.setOrder(team.getOrder());
		teamDB.setDesc(team.getDesc());
		teamDB.setDescDetail(team.getDescDetail());
		teamDAO.update(teamDB);
	}

	@Override
	public TeamPO getTeam(int id) {
		return teamDAO.get(id);
	}

	@Override
	public void deleteTeam(int id) {
		teamDAO.delete(id);
	}

}
