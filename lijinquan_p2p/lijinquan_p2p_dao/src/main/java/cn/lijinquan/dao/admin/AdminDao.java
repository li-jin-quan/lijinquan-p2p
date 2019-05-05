package cn.lijinquan.dao.admin;

import cn.lijinquan.domain.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by lijinquan on 2019/4/29.
 */
public interface AdminDao extends JpaRepository<AdminModel, Integer> {


    @Query("SELECT a from AdminModel a where a.username=?1 and a.password=?2")
    public AdminModel login(String username, String password);

}
