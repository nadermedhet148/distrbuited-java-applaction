package com.javadist.teams.WEB.controller;

import com.javadist.teams.WEB.controller.DTO.AddMemberToTeam;
import com.javadist.teams.WEB.controller.DTO.CreateTeamDTO;
import com.javadist.teams.infrastructure.model.Team;
import com.javadist.teams.service.Errors.MemberIsAlreadyInTheTeam;
import com.javadist.teams.service.Errors.TeamNotExited;
import com.javadist.teams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService teamService;


    @PostMapping
    public Team create(@RequestBody CreateTeamDTO createTeamDTO, @RequestHeader("userId") Integer userId) {
        System.out.println(createTeamDTO.getName());
        return this.teamService.create(userId, createTeamDTO.getName());
    }

    @PutMapping
    public Team addMemberToTeam(@RequestBody AddMemberToTeam createTeamDTO) throws MemberIsAlreadyInTheTeam, TeamNotExited {
        return this.teamService.addMember(createTeamDTO.getTeamId(), createTeamDTO.getMemberId());
    }

}
