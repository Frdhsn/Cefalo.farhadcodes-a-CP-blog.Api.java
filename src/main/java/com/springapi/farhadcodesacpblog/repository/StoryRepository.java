package com.springapi.farhadcodesacpblog.repository;

import com.springapi.farhadcodesacpblog.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

}
