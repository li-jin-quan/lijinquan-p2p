package cn.lijinquan.action.Admin;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by lijinquan on 2019/4/28.
 */

@Controller
@Namespace("/account")
@Scope("prototype")
public class AdminAction extends ActionSupport {

    @Action("login")
    public void login() {

        try {
            ServletActionContext.getResponse().getWriter().write("{\"status\":\"1\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
