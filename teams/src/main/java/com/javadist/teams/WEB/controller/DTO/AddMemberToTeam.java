package com.javadist.teams.WEB.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberToTeam {

    private Long teamId;
    private Long memberId;

}
