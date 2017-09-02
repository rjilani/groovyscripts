def path = "cmd /c netstat -ao".execute().text


def outFile = new File(/C:\Users\rjilan01\Documents\ports_info.csv/).withWriter {out ->

out.writeLine("Protocol" + "," + "Local Address" + "," + "Foreign Address" + "," + "State" + "," + "ProcessID")

path.eachLine {line, index ->
    
       println line
    
   
       def a = line.split("\\s+")
        if (index > 3) {
        
           if (a.length == 6) {
               out.writeLine( a[1] + "," +  a[2] + "," + a[3] + "," + a[4]+ "," +  a[5])
           }
           
           else 
           {
                out.writeLine( a[1] + "," +  a[2] + "," + a[3] + "," + "  " + "," +  a[4])
           }
           
           // a.each {println it}
        }
    }
    
}