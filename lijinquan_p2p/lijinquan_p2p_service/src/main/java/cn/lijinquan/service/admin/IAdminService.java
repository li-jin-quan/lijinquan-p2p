package cn.lijinquan.service.admin;

import cn.lijinquan.domain.AdminModel;

/**
 * Created by lijinquan on 2019/4/29.
 */
public interface IAdminService {

    public AdminModel login(String username,String password);
}
