package com.springapi.farhadcodesacpblog.controller;

import com.springapi.farhadcodesacpblog.dtos.StoryDTO;
import com.springapi.farhadcodesacpblog.entity.Story;
import com.springapi.farhadcodesacpblog.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;


    @GetMapping("/stories")
    public ResponseEntity<List<StoryDTO>> getAllStory() {
        return ResponseEntity.status(HttpStatus.OK).body(storyService.getAllStory());
    }

    @GetMapping("/stories/{id}")
    public ResponseEntity<?> getSingleStory(@PathVariable int id) {

        StoryDTO newStory =storyService.getSingleStory(id);
        return ResponseEntity.status(HttpStatus.OK).body(newStory);
    }

    /*@PostMapping(value="/" , produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> postStory(@RequestBody Story storys) {

        StoryDto newStory =storyService.postStory(storys);
        //return ResponseEntity.status(HttpStatus.CREATED).body(newStory);
        return new ResponseEntity<>(newStory, HttpStatus.CREATED);
    }*/

    @PutMapping("/stories/{id}")
    public ResponseEntity<?> updateStory(@PathVariable int id, @RequestBody Story story) {
        StoryDTO newStory =storyService.updateStory(id, story);
        return ResponseEntity.status(HttpStatus.OK).body(newStory);
    }
    @DeleteMapping("/stories/{id}")
    public ResponseEntity<?> deleteStory(@PathVariable int id) {
        storyService.deleteStory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
