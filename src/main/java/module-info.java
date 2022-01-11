module cn.i623.alpha.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

//    requires spring.core;
    requires lombok;
    requires spring.web;
    requires org.apache.tomcat.embed.core;

    requires poi;
    requires poi.ooxml;
    requires org.mybatis;
    requires junit;
    requires spring.test;
    requires spring.boot.test;
    requires spring.context;
    requires spring.beans;
    requires org.mybatis.spring;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.net.http;
    requires org.apache.commons.codec;

    exports cn.i623.alpha.javafxdemo.contorl;
    opens cn.i623.alpha.javafxdemo.contorl to javafx.fxml;


    exports cn.i623.alpha.javafxdemo;
    opens cn.i623.alpha.javafxdemo to javafx.fxml;

    exports cn.i623.alpha.javafxdemo.db.domain;
    opens cn.i623.alpha.javafxdemo.db;
    exports cn.i623.alpha.javafxdemo.myinterface;
    opens cn.i623.alpha.javafxdemo.myinterface to javafx.fxml;

}