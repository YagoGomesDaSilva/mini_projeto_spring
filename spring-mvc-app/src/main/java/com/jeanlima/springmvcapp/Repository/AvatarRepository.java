package com.jeanlima.springmvcapp.Repository;


import com.jeanlima.springmvcapp.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Integer> {
}
