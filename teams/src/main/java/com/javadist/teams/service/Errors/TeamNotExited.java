package com.javadist.teams.service.Errors;

import org.javaDist.Errors.BusinessViolationError;

public class TeamNotExited extends BusinessViolationError {
    public String message = "this team is not exited";
}
