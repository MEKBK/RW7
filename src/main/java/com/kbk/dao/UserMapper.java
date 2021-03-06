package com.kbk.dao;

import com.kbk.model.User;
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
public interface UserMapper {

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
     * @param user
     * @return
     */
    boolean upHeadPortrait(User user);

}