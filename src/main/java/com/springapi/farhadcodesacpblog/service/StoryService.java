package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.dtos.StoryDTO;
import com.springapi.farhadcodesacpblog.entity.Story;
import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.exceptions.NotFoundException;
import com.springapi.farhadcodesacpblog.exceptions.UnauthorizedException;
import com.springapi.farhadcodesacpblog.repository.StoryRepository;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.utils.StoryDTOMapper;
import com.springapi.farhadcodesacpblog.utils.authorization.StoryValidation;
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
    private StoryValidation storyValidation;
    @Autowired
    private StoryDTOMapper storyDTOMapper;
    public List<StoryDTO> getAllStory() {

        List<Story> allStudent= storyRepository.findAll();
        Collections.reverse(allStudent);
        return allStudent.stream().map(x->storyDTOMapper.mapDetails(x)).toList();
    }

    public StoryDTO getSingleStory(int id) {

        Optional<Story> checkStory=storyRepository.findById(id);
        if(checkStory.isEmpty())
            throw new NotFoundException(Story.class,"id",String.valueOf(id));
        return storyDTOMapper.mapDetails(checkStory.get());
    }

    public StoryDTO postStory(Story story)  {
        String email = storyValidation.getCurrentAuthorName();
        Optional<Users> currentUser= userRepository.findByEmail(email);
        story.setAuthorId(currentUser.get());
        storyRepository.save(story);
        return storyDTOMapper.mapDetails(story);
    }

    public StoryDTO updateStory(int id, Story story) {

        Optional<Story> newStory=storyRepository.findById(id);

        if(newStory.isEmpty())
            throw new NotFoundException(Story.class,"id",String.valueOf(id));
        if(newStory.isPresent()){

            Story checkStory=newStory.get();
            checkStory.setTitle(story.getTitle());
            checkStory.setDescription(story.getDescription());
            storyRepository.save(checkStory);
            return storyDTOMapper.mapDetails(checkStory);
        }
        throw new UnauthorizedException("Unauthorized user");
    }

    public void deleteStory(int id) {

        Optional<Story> newStory= storyRepository.findById(id);
        if(newStory.isEmpty())
            throw new NotFoundException(Story.class,"id",String.valueOf(id));

        if(storyValidation.verify(newStory)) {
            storyRepository.deleteById(id);
            return;
        }
        throw new UnauthorizedException("Unauthorized user");
    }
}
