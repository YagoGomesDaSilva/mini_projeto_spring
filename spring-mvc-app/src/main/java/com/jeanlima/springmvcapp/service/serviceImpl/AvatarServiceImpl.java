package com.jeanlima.springmvcapp.Service.serviceImpl;

import com.jeanlima.springmvcapp.Model.Avatar;
import com.jeanlima.springmvcapp.Repository.AvatarRepository;
import com.jeanlima.springmvcapp.Service.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AvatarServiceImpl implements AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public void salvarAvatar(Avatar avatar) {
        avatarRepository.save(avatar);
    }

    @Override
    public void deletarAvatar(Avatar avatar) {
    avatarRepository.delete(avatar);
    }

    @Override
    public Avatar getAvatarById(Integer id) {
        return avatarRepository.findById(id).orElseThrow(()->null);
    }

    @Override
    public List<Avatar> getListaAvatar() {
        return avatarRepository.findAll();
    }
}
