def file = new File(/C:\Users\rjilan01\Documents\ProdProfiling\ports.txt/)

def outFile = new File(/C:\Users\rjilan01\Documents\ProdProfiling\server_status.txt/).withWriter {out ->
file.eachLine {line ->

    def info = line.split(",")
    
    println info[0]
    
     out.writeLine(info[0])
    
    def path = "cmd /c curl --connect-timeout 40 --head ${info[1]}".execute().text
    
    println info[1]
    
    out.writeLine(info[1])
    println path
    out.writeLine(path)

    }

}