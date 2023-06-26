package homework1;

public class task1 {

    /*Реализуйте 3 метода, чтобы в каждом из них получить разные исключения */
    public static void main(String[] args) {

        // myDivide(10);
        // myMassive();
        myNullElement();
        
    }
    // деление на 0
    public static float myDivide(int a){
        int b = 0;
        return a/b;
    }

    // выход за размер массива (проверить массив на наличие одинаковых элементов)

    public static void myMassive(){
        int[] mass = new int[] {1,2,3,3,5};
        for (int i = 0; i < mass.length; i++) {
            System.out.println("Итерация " + (i+1));
            if (mass[i] == mass[i+1]){
                System.out.printf("Элемент %d равен элементу %d", mass[i], mass[i+1]);
            } else{
                System.out.printf("Элемент %d не равен элементу %d", mass[i], mass[i+1]);
            }
            System.out.println();
        }
    }
    // нулевой элемент (проверить массив на наличие одинаковых элементов)
    public static void myNullElement(){
        String[] arr = new String[] {"привет", "hello", null, "good morning"};
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].length() == arr[i+1].length()){
                System.out.printf("Элемент %d равен элементу %d", arr[i], arr[i+1]);
            };
        }
    }

    
}
