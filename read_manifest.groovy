def file = new File(/C:\Users\rjilan01\Desktop\analysis_jars/)


def outFile = new File(/C:\Users\rjilan01\Desktop\analysis_jars\stats.txt/).withWriter {out ->


    file.eachFileRecurse {
    
            

         if (it.toString().contains(".jar")) {
         
              out.writeLine("------------------------ ${it.name} ------------------------")
         
             new java.util.jar.JarFile(it.getCanonicalPath()).manifest.mainAttributes.entrySet().each  
            {  
                      
                      out.writeLine ( "${it.key}: ${it.value}" ) 
                       
                     
                
            } 
            
           out.writeLine("---------------------------------------------------------------------")
            out.writeLine("")
         }

    }


}