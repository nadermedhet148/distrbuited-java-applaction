package com.javadist.teams.service.Errors;

import org.javaDist.Errors.BusinessViolationError;

public class MemberIsAlreadyInTheTeam extends BusinessViolationError {
    public String message = "this member is already in the team";
}
