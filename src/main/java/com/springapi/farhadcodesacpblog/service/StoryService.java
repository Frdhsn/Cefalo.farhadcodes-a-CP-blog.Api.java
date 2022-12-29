package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.dtos.StoryDTO;
import com.springapi.farhadcodesacpblog.entity.Story;
import com.springapi.farhadcodesacpblog.repository.StoryRepository;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.utils.StoryDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StoryService {
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoryDTOMapper storyDTOMapper;

    public List<StoryDTO> getAllStory() {

        List<Story> allStudent=storyRepository.findAll();
        Collections.reverse(allStudent);
        return allStudent.stream().map(x->storyDTOMapper.mapDetails(x)).toList();
    }

    public StoryDTO getSingleStory(int id) {

        Optional<Story> checkStory=storyRepository.findById(id);
        return storyDTOMapper.mapDetails(checkStory.get());

    }

    /*public StoryDTO postStory(Story story)  {

        Optional<User> currentUser= userRepository.findByEmail(userEmail);
        story.setAuthorId(currentUser.get());
        storyRepository.save(story);
        return storyDTOMapper.mapDetails(story);
    }*/

    public StoryDTO updateStory(int id, Story story) {

        Optional<Story> newStory=storyRepository.findById(id);
        if(newStory.isPresent()){

            Story checkStory=newStory.get();
            checkStory.setTitle(story.getTitle());
            checkStory.setDescription(story.getDescription());
            storyRepository.save(checkStory);
            return storyDTOMapper.mapDetails(checkStory);
        }
        return null;
    }

    public void deleteStory(int id) {

        Optional<Story> newStory=storyRepository.findById(id);
        if(newStory.isPresent()) {

            storyRepository.deleteById(id);
            return;
        }
    }
}
