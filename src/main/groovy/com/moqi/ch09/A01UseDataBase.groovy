package com.moqi.ch09

import groovy.sql.Sql

/**
 * 使用数据库
 *
 * @author moqi* On 10/22/20 14:41
 */
String[] mysqlConfig = new File("/Users/moqi/Code/groovy-demo/src/main/resources/mysql_config.txt").text.split(" ")

// 带上最新版 MySQL 依赖，目前版本为 8.0.22
def sql = Sql.newInstance('jdbc:mysql://localhost:3306/weather_info',
        mysqlConfig[0], mysqlConfig[1], 'com.mysql.cj.jdbc.Driver')

println(sql.connection.catalog)
