def file = new File(/C:\Users\rjilan01\Desktop\password.src\ca\teranet\password/)




file.eachFileRecurse {

  if (it.isFile() ) 
  {
      if (it.toString().contains(".java")) {
           
           
           
            def outFile = new File("C:\\Users\\rjilan01\\Documents\\src\\${it.name}" ).withWriter {out ->
           
                it.eachLine {line -> 
                    //println line
                    
                   def a = line.replaceAll("/\\*[\\s\\d]+\\*/", ' ')
                   println a
                    out.writeLine(a) 
                    

                }
          }
          
     
     }
  }
  
 }