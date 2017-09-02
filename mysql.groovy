import groovy.sql.Sql


def sql = Sql.newInstance("jdbc:mysql://localhost:3306/test", "root",
                      "test_001", "com.mysql.jdbc.Driver")
                      
sql.eachRow("select * from arcgis_logs") {
    
    println it
}

//sql.execute("insert into arcgis_logs (time, type,target,method_name,map_server,machine,process,thread,user,message) values ('2012-12-04T18:28:55,832','FINE','10000','EMAP_6.MapServer','MapServer.GetDefaultMapName','MRKEMPAPLXPR01','21688','630','agsadmin','Binary request received. Request size is 167 bytes')")