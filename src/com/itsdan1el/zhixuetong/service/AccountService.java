package com.itsdan1el.zhixuetong.service;

import com.itsdan1el.zhixuetong.pojo.User;
import com.itsdan1el.zhixuetong.session.Session;
import com.itsdan1el.zhixuetong.dao.DAO;

public class AccountService {
    public static boolean userLogin(String username, String password) {
        User user = new User(username, password);
        if (DAO.userLogin(user)) {
            Session.user = user;
            return true;
        } else {
            return false;
        }
    }
}
