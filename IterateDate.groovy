    def start_date = new GregorianCalendar(1941,10,12)  
    def end_date = new GregorianCalendar(1941,12,22)  
    // loop trough the dates  
    (start_date.getTime()..end_date.getTime()).each() { date ->  
    println date.toString()  
    }  