package homework2;

public class task2 {

    /*eсли необходимо, исправьте данный код */

    public static void main(String[] args) {
        /* необходимо объявить массив и заполнить его элементами. 
        Можно добавить исключение IndexOutOfBoundsException на случай выхода за пределы массива.*/ 
        try {
            int d = 0;
            int[] intArray = {7,4,7,5,6,2,4,7,5,6};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }catch (IndexOutOfBoundsException e){
            System.out.println("catchedRes1 = " + e);
         }
         
         
    }
    
   
     
}
