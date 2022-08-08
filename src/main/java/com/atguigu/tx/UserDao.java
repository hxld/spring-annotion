package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hxld
 * @create 2022-08-08 10:46
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into t_user(name,age) values(?,?)";
        String name = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,name,18);
    }
}
