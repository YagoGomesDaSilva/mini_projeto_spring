package com.jeanlima.springmvcapp.Service.service;

import com.jeanlima.springmvcapp.Model.Aluno;
import com.jeanlima.springmvcapp.Model.Avatar;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AvatarService {

    public void salvarAvatar(Avatar avatar);
    public void deletarAvatar(Avatar avatar);
    public Avatar getAvatarById(Integer id);
    public List<Avatar> getListaAvatar();
}
