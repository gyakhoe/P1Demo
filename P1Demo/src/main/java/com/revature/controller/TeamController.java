package com.revature.controller;

// The Controller layer handles HTTP Requests (sends back HTTP response)

import com.revature.model.Team;
import com.revature.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Combines @Controller and @ResponseBody
@RequestMapping("/teams") // This is base URL for this controller
// TODO add @CorsOrigin annotation to allow HTTP from anywhere
public class TeamController {

    // @Autowired shouldn't do field injection is bad, mocking is hard, break encapsulation
    private final TeamService teamService;

    @Autowired // Constructor injection is better than field injection
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Insert new team (HTTP post request)
    @PostMapping
    public ResponseEntity<Team> insertTeam(@RequestBody Team team) {
        // TODO : send the team to the service which will send it to the DAO
        Team insertedTeam = teamService.insertTeam(team);

        // Helps use build  HTTP Response with OK status with team.
        return ResponseEntity.ok(insertedTeam);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
