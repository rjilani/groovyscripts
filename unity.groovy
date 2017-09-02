

def file = new File(/C:\Users\rjilan01\Desktop\tmp\rashid/)

def ant = new AntBuilder()

file.eachFileRecurse {

    if (it.isFile() ) 
 
     {

        if (it.toString().endsWith("jar")) 
        {
    
            def dir = it.getCanonicalPath().replace(".","-")
         
            def jarDir = new File(dir).mkdir()
        
            ant.copy(file:it, todir:dir )
        
            srcJar = "${dir}\\" + it.name
        
            println dir
            println srcJar
        
            ant.unzip(src:srcJar,dest:dir,overwrite:"false" )
    
        }
      }

}

file.eachFileRecurse {
    if (it.isFile() )
    {
        if (it.name == "jboss.xml")  {
            println it.getCanonicalPath()
        }
    }
}