package cn.i623.alpha.javafxdemo.db;


import cn.i623.alpha.javafxdemo.db.domain.XsElement;
import cn.i623.alpha.javafxdemo.db.mapper.XsElementMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest

public class MybatisTest {


    public static void insertRow(String mapName, String templateSn, String eleName) {
        XsElementMapper elementMapper = SpringUtil.getBean(XsElementMapper.class);
        XsElement xsElement = new XsElement();
        xsElement.setMapName(mapName);
        xsElement.setTemplateSn(templateSn);
        xsElement.setEleName(eleName);
        xsElement.setElementcode("XX");
        xsElement.setEleType("单项");
        xsElement.setSelected(1);
        xsElement.setIsDel(0);
        xsElement.setEleCategoryCh("字符串");
        xsElement.setCounted(1);
        xsElement.setNeedsJson(0);
        int insert = elementMapper.insert(xsElement);
        System.out.println("完成" + insert);
    }

    @org.junit.Test
    public void contextLoads() throws IOException {
        close();
//		close();
//        extracted();
//        insertExcal();
//        xsElement.setEleSn();
//        String mapName = "";
//        String templateSn = "";
//        String eleName = "";

//        insertRow(mapName, templateSn, eleName);
    }

    private void close() {
        //GoodsServiceImpl为我想要获取的service层中的类
        XsElementMapper taskMapper = SpringUtil.getBean(XsElementMapper.class);
        System.out.println(taskMapper.selectByPrimaryKey(10221, 0));
//		System.out.println(taskMapper.selectByPrimaryKey("010f4dfe-cd4e-4ca4-8492-5e088c4872e1"));
    }
}