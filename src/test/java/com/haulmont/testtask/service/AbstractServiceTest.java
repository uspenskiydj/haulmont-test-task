package com.haulmont.testtask.service;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db-test.xml"
})
@Sql(scripts = "classpath:db/populateDB_test.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {

}