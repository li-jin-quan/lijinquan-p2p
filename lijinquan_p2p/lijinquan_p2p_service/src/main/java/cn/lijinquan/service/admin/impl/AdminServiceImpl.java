package cn.lijinquan.service.admin.impl;

import cn.lijinquan.dao.admin.AdminDao;
import cn.lijinquan.domain.AdminModel;
import cn.lijinquan.service.admin.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lijinquan on 2019/4/30.
 */
@Service
public class AdminServiceImpl implements IAdminService{

    @Resource
    private AdminDao adminDao;

    @Override
    public AdminModel login(String username, String password) {
        return adminDao.login(username,password);
    }
}
