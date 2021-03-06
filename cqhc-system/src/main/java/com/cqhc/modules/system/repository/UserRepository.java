package com.cqhc.modules.system.repository;

import com.cqhc.modules.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @author jie
 * @date 2018-11-22
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

    /**
     * 查询用户名
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 查询邮箱
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 修改密码
     * @param username
     * @param pass
     */
    @Modifying
    @Query(value = "update user set password = ?2 , last_password_reset_time = ?3 where username = ?1",nativeQuery = true)
    void updatePass(String username, String pass, Date lastPasswordResetTime);

    /**
     * 修改头像
     * @param username
     * @param url
     */
    @Modifying
    @Query(value = "update user set avatar = ?2 where username = ?1",nativeQuery = true)
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     * @param username
     * @param email
     */
    @Modifying
    @Query(value = "update user set email = ?2 where username = ?1",nativeQuery = true)
    void updateEmail(String username, String email);

    /**
     * 查询用户是否为系统初始化
     * @param id
     * @return
     */
    @Query(value = "select COUNT(*) from user where unit_id = ?1",nativeQuery = true)
    Long getByUnitId(Long id);

    /**
     * 查询用户是否为系统初始化
     *
     * @param id
     * @return
     */
    @Query(value = "select count(*) from user where id = ?1 and source = 0",nativeQuery = true)
    Long findByIdAndSource(Long id);

}
