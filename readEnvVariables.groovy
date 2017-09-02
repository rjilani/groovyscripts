def env = System.getenv()

def file = new File(/C:\Users\rjilan01\Documents\envvaraibles.csv/).withWriter {out ->

out.writeLine("key" + "," + "value")
    env.each {

        def list = it.toString().split("=")
        println "${list[0]} ${list[1]}"
        if (list[0] != "GROOVY_OPTS") {
            out.writeLine(list[0] + "," + list[1])
        }
    }
    
}