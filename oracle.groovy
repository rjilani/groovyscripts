import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:oracle:thin:@//mrkgwpdbuxdv01:3081/DLP01D", "TSB_NGTV_APP",
                     "WED_JUN_2014", "oracle.jdbc.driver.OracleDriver")

//def sql = Sql.newInstance("jdbc:oracle:thin:@//mssgwpdbuxut01:3081/DLP01U", "TSB_NGTV_MGS_APP",
//                    "WED_JUN_2014", "oracle.jdbc.driver.OracleDriver")
//                     
sql.eachRow("select * from APP_USER where ROWNUM < 5") {

    println it

}