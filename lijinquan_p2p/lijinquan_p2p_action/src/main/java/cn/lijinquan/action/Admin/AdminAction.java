package cn.lijinquan.action.admin;

import cn.lijinquan.action.common.BaseAction;
import cn.lijinquan.domain.AdminModel;
import cn.lijinquan.service.admin.IAdminService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by lijinquan on 2019/4/28.
 */

@Controller
@Namespace("/account")
@Scope("prototype")
public class AdminAction extends BaseAction {

    @Autowired
    private IAdminService adminService;

    @Action("login")
    public void login() {

        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");

        try {
            AdminModel login = adminService.login(username, password);

            if (login != null) {
                ServletActionContext.getResponse().getWriter().write("{\"status\":\"1\"}");

            } else {
                ServletActionContext.getResponse().getWriter().write("{\"status\":\"0\"}");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
