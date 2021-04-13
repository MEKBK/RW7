package com.kbk.service;


import com.kbk.model.User;
import com.kbk.util.ImgException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @Description
 * @Author 况博凯
 * @Date 2021/03/28 10:14
 * @Version 1.0
 *
 */
@Service
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertSelective(User user);

    /**
     * 查询用户名
     * @param username
     * @return
     */
    User selectUserName(String username);

    /**
     * 上传头像
     * @param
     * @return
     */
    String upHeadPortrait(MultipartFile file, String username) throws IOException, ImgException;
}

