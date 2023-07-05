package lesson3.homework;

public abstract class MyExceptions extends Exception {
    
    public MyExceptions(String message) {
        super(message);
    }
    

}

class MyTypeException extends MyExceptions{

    public MyTypeException(String message) {
        super(message);
    }
    
}

class MyCountException extends MyExceptions{

    public MyCountException(String message) {
        super(message);
        //TODO Auto-generated constructor stub
    }
    
}
