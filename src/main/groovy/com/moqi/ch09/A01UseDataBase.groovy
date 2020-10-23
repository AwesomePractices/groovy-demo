package com.moqi.ch09

import groovy.sql.Sql
import groovy.xml.MarkupBuilder

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
println()

// select
println("City                Temperature")
sql.eachRow('select * from weather') {
    printf("%-20s%s\n", it.city, it[1])
}
println()

ProcessMeta = { metaData ->
    metaData.columnCount.times { i ->
        printf("%-20s", metaData.getColumnLabel(i + 1))
    }
    println()
}
sql.eachRow('select * from weather', ProcessMeta) {
    printf("%-20s%s\n", it.city, it[1])
}
println()

rows = sql.rows('select * from weather')
println("Weather info available for ${rows.size()} cities")
println()

bldr = new MarkupBuilder()

bldr.weather {
    sql.eachRow('select * from weather') {
        city(name: it.city, temperature: it.temperature)
    }
}
println()

/**
 * groovy 3.0.5 + mysql 8.0.22 报错如下
 *
 * DataSet unable to evaluate expression. AST not available for closure: com.moqi.ch09.A01UseDataBase$_run_closure5. Is the source code on the classpath?
 */
dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll {it.temperature < 32}
println("Cities below freezing:")
try {
    citiesBelowFreezing.each {
        println(it.city)
    }
} catch (GroovyRuntimeException e) {
    println(e.message)
}
println()

println("Number of cites: " + sql.rows('select * from weather').size())
dataSet.add(city: 'Denver', temperature: 19)
println("Number of cites: " + sql.rows('select * from weather').size())
println()

temperature = 50
sql.executeInsert("""
insert into weather values ('Oklahoma City', ${temperature})
""")
println(sql.firstRow("""
select * from weather where city='Oklahoma City'
"""))
println()

final String WEATHER_EXCEL = '/Users/moqi/Code/groovy-demo/src/main/resources/weather.xlsx'

/*
* 这里应该要外部配置 ODBC
*
* Caught: java.sql.SQLException: No suitable driver found for
jdbc:odbc:Driver=
{Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ=/Users/moqi/Code/groovy-demo/src/main/resources/weather.xlsx;READONLY=false

java.sql.SQLException: No suitable driver found for
jdbc:odbc:Driver=
{Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ=/Users/moqi/Code/groovy-demo/src/main/resources/weather.xlsx;READONLY=false

	at com.moqi.ch09.A01UseDataBase.run(A01UseDataBase.groovy:84)

Process finished with exit code 1
* */
def excel_sql = Sql.newInstance("""
jdbc:odbc:Driver=
{Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ=${WEATHER_EXCEL};READONLY=false
""", '', '')

println("City\t\tTemperature")
excel_sql.eachRow('select * from [temperatures$]') {
    println("${it.city}\t\t${it.temperatures}")
}

