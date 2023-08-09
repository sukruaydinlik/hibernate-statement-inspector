package com.saydinlik.hibernatestatementinspector.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;

@Slf4j
public class Inspector implements StatementInspector {
    @Override
    public String inspect(String s) {
        log.info("Executing query {}", s);
        return s;
    }
}
