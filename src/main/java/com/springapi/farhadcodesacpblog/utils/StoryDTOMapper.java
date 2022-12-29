package com.springapi.farhadcodesacpblog.utils;

import com.springapi.farhadcodesacpblog.dtos.StoryDTO;
import com.springapi.farhadcodesacpblog.entity.Story;
import org.springframework.stereotype.Component;

@Component
public class StoryDTOMapper {
    public StoryDTO mapDetails(Story story){
        StoryDTO storyDto=new StoryDTO();
        storyDto.setId(story.getId());
        storyDto.setTitle(story.getTitle());
        storyDto.setDescription(story.getDescription());
//        storyDto.setAuthor(story.getAuthorId().getEmail());

        storyDto.setCreationTime(story.getCreationTime());
        return storyDto;
    }
}
