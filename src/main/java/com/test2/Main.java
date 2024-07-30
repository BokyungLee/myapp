package com.test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface Database {void open();}
@Component
class MySql implements Database {
    public void open() { System.out.println("MySql Open()");}
}
@Component
class Oracle implements Database {
    public void open() { System.out.println("Oracle Open()");}
}
@Configuration
@ComponentScan(basePackages = "com.test4")
class JavaConfig {}

@Component
class DbManager {
    Database db;
    @Autowired
    public DbManager(@Qualifier("mySql") Database db) {
        this.db = db;
    }
    public void open() {
        db.open();
    }
}
public class Main {
    public static void main(String[] args) {
        // Database db = new DbManager(new MySql());
        // db.open();
        // Database db2 = new DbManager(new Oracle());
        // db2.open();
        ApplicationContext context =
    new AnnotationConfigApplicationContext(JavaConfig.class);
    DbManager dbManager = context.getBean(DbManager.class); 
    dbManager.open();
    }
}