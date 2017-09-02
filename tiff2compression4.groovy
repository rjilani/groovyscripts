def file = new File(/C:\Users\rjilan01\Documents\projects\Incidents\tif/)

def dir = new File(/C:\Users\rjilan01\Documents\projects\Incidents\tif\comp4/).mkdir()  

 file.eachFileRecurse {

               if (it.isFile() ) 
  
        { 
  
                if (it.name.toString().endsWith(".tif") || it.name.toString().endsWith(".TIF")) {
                    println it.name
                    
                    def test = it.getParent().toString() + "\\" + "comp4" + "\\" + it.name
                   println test
                    
                   
                    
                     def a = "tiffcp -c g4 " + "\"" +  it +  "\"" + " " +  "\"" + test + "\""
                     println a
                     
                     def c = a.execute().text
                }
    
        }

 }