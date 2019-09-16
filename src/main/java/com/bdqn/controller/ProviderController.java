package com.bdqn.controller;

import com.bdqn.pojo.Provider;
import com.bdqn.service.ProviderService;
import com.bdqn.utils.page.PageResultBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName: ProviderController$
 * Description:
 * Author: anyanglai
 * Date: 2019/9/8
 * Time: 16:50
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    /**
     * description: TODO 提供供应商的数据
     * create time: 2019/9/7 11:28
     * []
     *
     * @return java.lang.Object
     */
    @GetMapping("/providerList")
    public String providerList(@RequestParam(value = "pageNum", required = false) String pageNum,
                           @RequestParam(value = "queryProCode", required = false) String queryProCode,
                           @RequestParam(value = "queryProName", required = false) String queryProName,
                           Model model) {
        if(pageNum == null){
            pageNum = "1";
        }
        PageHelper.startPage(Integer.valueOf(pageNum),5,"creationDate DESC");
        PageResultBean<Provider> providerPageResultBean = new PageResultBean<Provider>(providerService.finderProvidersByCodeAndName(queryProCode,queryProName));

        List<Provider> providerList = providerPageResultBean.getRows();
        model.addAttribute("providerList",providerList);//分页实体信息
        model.addAttribute("page",providerPageResultBean);//分页信息
        model.addAttribute("pageNum",pageNum);//当前页
        return "provider/providerlist";
    }

    /**
     * description: TODO 跳转到供应商添加视图
     * create time: 2019/9/7 12:16
     * []
     *
     * @return java.lang.String
     */
    @GetMapping("/provideraddView")
    public String provideraddView(){
        return "provider/provideradd";
    }
}
