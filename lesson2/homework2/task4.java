package homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task4 {

    /*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя. */
    
    public static void main(String[] args) throws MyMessageException {
        messege();
    }

    public static String messege() throws MyMessageException{
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: ");
        result = scanner.nextLine();
        
        if (result.trim() == ""){
            
            throw new MyMessageException("Пустую строку вводить нельзя");

        }
        
        scanner.close();
        return result;
        
    }

  
}
