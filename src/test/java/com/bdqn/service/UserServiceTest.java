/*
package com.bdqn.service;

import com.bdqn.pojo.Address;
import com.bdqn.pojo.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/spring/applicationContext.xml")
public class UserServiceTest {

    private ApplicationContext context;
    private Logger logger = Logger.getLogger(UserServiceTest.class);


    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserCount() {
        UserService userService= (UserService)context.getBean("userService");
        UserService userService1= (UserService)context.getBean("userService");
         */
/*int result = userService.findUserCount();
         logger.info(result);*//*

         //默认单例模式
        logger.info(userService);
        logger.info(userService1);
    }

    @Test
    public void finderUsers() {
        UserService userService= (UserService)context.getBean("userService");
        List<User> userList = userService.finderUsers();
        for (User user :
                userList) {
            logger.info(user.getId() + "——" + user.getUserName() + "——" + user.getAddress());
        }
    }

    @Test
    public void findUserById() {
        UserService userService= (UserService)context.getBean("userService");
        Integer id = 1;
        List<User> userList = userService.findUserById(id);
        for (User user :
                userList) {
            logger.info(user.getId() + "——" + user.getUserName() + "——" + user.getAddress());
        }
    }

    @Test
    public void findUserByUserName() {
        UserService userService= (UserService)context.getBean("userService");
        String userName = "孙";
        List<User> userList = userService.findUserByUserName(userName);
        for (User user :
                userList) {
            logger.info(user.getId() + "——" + user.getUserName() + "——" + user.getAddress());
        }
    }

    @Test
    public void findUserByUser() {
        UserService userService= (UserService)context.getBean("userService");
        User user = new User();
        user.setUserCode("de");
        user.setUserName("孙");
        List<User> userList = userService.findUserByUser(user);
        for (User user1 :
                userList) {
            logger.info(user1.getId() + "——" + user1.getUserName() + "——" + user1.getAddress());
        }
    }

    @Test
    public void findUserByRoleName() {
        UserService userService= (UserService)context.getBean("userService");
        List<User> userList = userService.findUserByRoleName("普通员工");
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getUserRoleName() + "——" + user1.getGender() + "——" + user1.getPhone());
        }
    }

    @Test
    public void findUserByUserRole() {
        UserService userService= (UserService)context.getBean("userService");
        List<User> userList = userService.findUserByUserRole(2);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getGender() + "——" + user1.getPhone()+"——" +
                    user1.getRole().getRoleName() + "——" +
                    user1.getRole().getRoleCode() + "——" +
                    user1.getRole().getId());
        }
    }

    @Test
    public void findUserByUserRoleAndUserNamePaged() {
        UserService userService= (UserService)context.getBean("userService");
        String userName = null;
        Integer userRole = 3;
        Integer current = 2;
        Integer pageSize = 3;
        List<User> userList = userService.findUserByUserRoleAndUserNamePaged(
                userRole,
                userName,
                (current-1)*pageSize,
                pageSize);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getGender() + "——" + user1.getPhone()+"——" +
                    user1.getRole().getRoleName() + "——" +
                    user1.getRole().getRoleCode() + "——" +
                    user1.getRole().getId() );
        }
    }

    @Test
    public void findUserByUserRoleArray() {
        UserService userService= (UserService)context.getBean("userService");
        Integer[] userRoles = {2,3};
        List<User> userList = userService.findUserByUserRoleArray(userRoles);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getGender() + "——" + user1.getPhone()+"——" +
                    user1.getRole().getRoleName() + "——" +
                    user1.getRole().getRoleCode() + "——" +
                    user1.getRole().getId());
        }
    }

    @Test
    public void findUserByUserRoleList() {
        UserService userService= (UserService)context.getBean("userService");
        List<Integer> userRolesList = new ArrayList<Integer>();
        userRolesList.add(1);
        List<User> userList = userService.findUserByUserRoleList(userRolesList);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getGender() + "——" + user1.getPhone()+"——" +
                    user1.getRole().getRoleName() + "——" +
                    user1.getRole().getRoleCode() + "——" +
                    user1.getRole().getId() );
        }
    }

    @Test
    public void findUserByUserRoleMap() {
        UserService userService= (UserService)context.getBean("userService");
        List<Integer> userRolesList = new ArrayList<Integer>();
        userRolesList.add(1);
        userRolesList.add(2);
        Map<String,Object> userRolesMap = new HashMap<String, Object>();
        userRolesMap.put("key",userRolesList);
        List<User> userList = userService.findUserByUserRoleMap(userRolesMap);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode()
                    + "——" + user1.getGender() + "——" + user1.getPhone()+"——" +
                    user1.getRole().getRoleName() + "——" +
                    user1.getRole().getRoleCode() + "——" +
                    user1.getRole().getId() );
        }
    }

    @Test
    public void findUserAddressByUserId() {
        UserService userService= (UserService)context.getBean("userService");
        List<User> userList = userService.findUserAddressByUserId(1);
        for (User user1 :
                userList) {
            logger.info(user1.getUserName() + "——" + user1.getUserCode());
            for (Address add:
                    user1.getAddressList()) {
                logger.info(add.getId() + "——" + add.getAddressDesc());
            }
        }
    }

    @Test
    public void addUser() {
        UserService userService= (UserService)context.getBean("userService");
        int count = 0;
        try {
            User user = new User();
            user.setUserCode("test001");
            user.setUserName("测试用户001");
            user.setUserPassword("1234567");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("地址测试");
            user.setGender(1);
            user.setPhone("13688783697");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            count = userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.info("添加方法的返回值:" + count);
    }

    @Test
    public void modifyUser() {
        UserService userService= (UserService)context.getBean("userService");
        int count = 0;
        try {
            User user = new User();
            user.setId(29);
            user.setUserCode("test002");
            user.setUserName("测试用户002");
            user.setUserPassword("8888888");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1989-12-12");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("地址测试2");
            user.setGender(1);
            user.setPhone("13311111111");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            count = userService.modifyUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.info("修改方法的返回值:" + count);
    }

    @Test
    public void delUser() {
        UserService userService= (UserService)context.getBean("userService");
        int count = 0;
        try {
            count = userService.delUserById(38);
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.info(count);
    }
}*/
