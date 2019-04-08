package com.example.web;


import com.example.model.Group;
import com.example.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class GroupController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);

    @Autowired(required=true)
    private GroupService groupServic;

    @GetMapping(value = "/info")
    public ResponseEntity<?> getAllGroups() {
        List<Group> allPersons = groupServic.getAllPersons();

        return ResponseEntity.ok().body(allPersons);
    }

    @PutMapping(value = "/info/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> updateGroup(@PathVariable long id, @RequestBody Group group) {
        log.info("Request from react", id , group);
        log.info("Request to update group: {}", group);
        System.out.println("Updating Restaurant " + id);

        Group personById = groupServic.getPersonById(id);

        personById.setDone(!group.isDone());

        groupServic.saveOrUpdate(personById);
        return ResponseEntity.ok().body(personById);
    }

    @PostMapping(value = "/info", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Group> create(@RequestBody Group group) throws URISyntaxException {

        try{
            groupServic.saveOrUpdate(group);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(group);
    }

}