package com.javadist.teams.service;


import com.javadist.teams.infrastructure.dao.TeamDao;
import com.javadist.teams.infrastructure.model.Team;
import com.javadist.teams.service.Errors.MemberIsAlreadyInTheTeam;
import com.javadist.teams.service.Errors.TeamNotExited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "TeamService")
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    public Team create(Integer leaderId, String name) {
        Team team = Team.builder().name(name).leaderId(leaderId).build();
        teamDao.save(team);
        return team;
    }

    public Team addMember(Long teamID, Long memberID) throws TeamNotExited, MemberIsAlreadyInTheTeam {
        Team team = teamDao.findById(teamID).orElse(null);

        if (team == null) {
            throw new TeamNotExited();
        }
        
        team.assignMemberToTeam(memberID);
        teamDao.save(team);
        return team;
    }

}
