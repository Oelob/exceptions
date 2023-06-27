package homework2;

import java.io.FileNotFoundException;

public class task3 {

    /* 1. Не понятно, зачем в 8 строке нужен throws Exception, если мы говорили, что такой проброс все равно нужно обрабатывать, 
    а здесь верхняя точка в коде, ольше обрабатывать это исключение негде.
       2. Блок с Throwable нужно перенести в самый низ, чтобы более узкие ошибки обработались ранее 
       3. Блок с NullPointerException лишний, в коде нет строк, где бы он мог сработать. */
        public static void main(String[] args) {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
           
            // } catch (NullPointerException ex) {
            //     System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            }catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            } 
        }
        
         public static void printSum(Integer a, Integer b) throws FileNotFoundException {
            System.out.println(a + b);
        }
         
}
    

