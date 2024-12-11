package com.revature.services;

import com.revature.model.Team;
import org.springframework.stereotype.Service;

/*
 * The service layer is where we have our business logic
 * User input validation, data manipulation/reformatting, user authentication, etc.
 *
 */

@Service
public class TeamService {

    // This method will insert new Teams into the DB once they have been validated
    public Team insertTeam(Team team) {

        if(team.getTeamName() == null || team.getTeamName().isBlank()) {
            throw new IllegalArgumentException("Team name can't be null or blank");
        }
        if(team.getTeamLocation() == null || team.getTeamLocation().isBlank()) {
            throw new IllegalArgumentException("Team Location can't be null or blank");
        }

        // Everything is good

        return team;


    }
}
