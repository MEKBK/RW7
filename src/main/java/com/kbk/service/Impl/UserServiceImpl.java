package com.kbk.service.Impl;

import com.kbk.dao.UserMapper;
import com.kbk.model.User;
import com.kbk.service.UserService;
import com.kbk.util.ImgException;
import com.kbk.util.OSSCOSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OSSCOSUtil osscosUtil;

    @Override
    public int insertSelective(User user){
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectUserName(String username){
        return userMapper.selectUserName(username);
    }

    @Override
    public String upHeadPortrait(MultipartFile file, String username) throws ImgException {
        if (file == null || file.getSize() <= 0) {
            throw new ImgException("头像不能为空");
        }
        String name = osscosUtil.uploadImgOSS(file);
        String imgUrl = osscosUtil.getImgUrl(name);
        User user=new User();
        user.setUsername(username);
        user.setImage(imgUrl);
        //上传的同时把图片url更新到数据库中
        userMapper.upHeadPortrait(user);
        return imgUrl;
    }
}

