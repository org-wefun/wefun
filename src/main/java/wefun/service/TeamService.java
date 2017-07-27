package wefun.service;

import java.util.List;

import wefun.model.po.TeamPO;

public interface TeamService {
	
	List<TeamPO> getTeamList();
	
	Integer insertTeam(TeamPO team);
	
	void updateTeam(TeamPO team);
	
	TeamPO getTeam(int id);
	
	void deleteTeam(int id);

}
