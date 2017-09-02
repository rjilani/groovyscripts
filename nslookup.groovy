(1..5).each {
    def path = "cmd /c nslookup 172.25.100.76".execute().text.eachLine 
    {
    
       // println it
    
        if( it =~ /^Name:(.)*ca$/ || it =~ /^Address:/) {
            println it
        }
    
    }
}

