package com.bdqn.controller;

import com.bdqn.response.CommonReturnType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: testController$
 * Description:测试控制器(本质是Servlet分发的前端控制器)
 * Author: anyanglai
 * Date: 2019/8/30
 * Time: 12:09
 */
//@Component
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/test.html")
    public ModelAndView test(){
        logger.info("hello,test!");
        return new ModelAndView("test");
    }


    /*
     * @Description: 基本数据类型
     * @Author: anyanglai
     * @Date: 2019/9/6 17:18
     * @Param: [age]
     * @return: java.lang.Object
     * http://localhost:8080/ssm/test/baseType?userAge=34
     **/
    @PostMapping("/baseType")
    @ResponseBody
    public Object baseType(@RequestParam("userAge")int age){
        logger.info(age);
        return CommonReturnType.create("age:"+age);
    }

    /*
     * @Description: 包装类
     * @Author: anyanglai
     * @Date: 2019/9/6 17:18
     * @Param: [age]
     * @return: java.lang.Object
     * http://localhost:8080/ssm/test/baseType2?age=34
     **/
    @PostMapping("/baseType2")
    @ResponseBody
    public Object baseType(@RequestParam("age")Integer age){
        logger.info(age);
        return CommonReturnType.create("age:"+age);
    }
}
