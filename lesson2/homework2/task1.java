package homework2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class task1 {

    /*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
    вместо этого, необходимо повторно запросить у пользователя ввод данных. */


    public static void main(String[] args) {

        number();
        
    }
    
    public static float number(){
        float result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");

        try{
            result = scanner.nextFloat();
        }catch(InputMismatchException e){
            System.out.println("Введите корректные данные");
            number();
        }
        scanner.close();
        return result;
    }
}
