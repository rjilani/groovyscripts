import groovy.sql.Sql


def sql = Sql.newInstance("jdbc:sybase:Tds:mrktrvdbuxut02:8643", "rjilani01",
                      "Teranet1", "com.sybase.jdbc3.jdbc.SybDriver")
                      
sql.eachRow("select instrument_type_id,instrument_type_group_id from Instrument_Type") {
    
    println it.instrument_type_id 
}

