package cn.lijinquan.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by lijinquan on 2019/4/29.
 */
@Entity
@Table(name = "t_admin")
public class AdminModel {

    @Id
    @GeneratedValue //这个是主键生成策略，当前类似与hibernate中的native
    private Integer id;

    @Column(name = "t_username",length = 20)
    private String username;

    private String password;
}
