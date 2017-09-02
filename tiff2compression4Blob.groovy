def file = new File(/C:\Users\rjilan01\Desktop\misc\compression_processing/)

//def dir = new File(/C:\Users\rjilan01\Desktop\misc\compression_processing\3\comp4/).mkdir()  

 file.eachFileRecurse {
 
                 if (it.isDirectory()) {
                     def dir = "${it}\\comp4 "
                    new File(dir).mkdir()
                 }
                 

               if (it.isFile() ) 
  
        { 
  
                if (it.name.toString().endsWith(".blob")) {
                   // println it.name
                    
                    def test = it.getParent().toString() + "\\" + "comp4" + "\\" + it.name
                   //println test
                    
                   
                    
                     def a = "tiffcp -c g4 " + "\"" +  it +  "\"" + " " +  "\"" + test + "\""
                     //println a
                     
                    // def c = a.execute().text
                }
    
        }

 }