package org.nix.controllers;

import org.nix.RequestStatus;
import org.nix.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final CheckStatusService checkStatusService;


    @Autowired
    public StatusController(CheckStatusService checkStatusService) {
        this.checkStatusService = checkStatusService;
    }

    @GetMapping("/{id}")
    public RequestStatus show(@PathVariable("id") int id) {
        return checkStatusService.checkStatus(id);
    }

}
