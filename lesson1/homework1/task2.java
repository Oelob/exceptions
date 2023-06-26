package homework1;


import java.util.Arrays;

public class task2 {
    /*Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
    каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя. */
    public static void main(String[] args) {

        int[] newArray = newArr(new int[]{5,4,8,9}, new int[]{4,1,5,3,9,7});
        System.out.println(Arrays.toString(newArray));
        
    }

    public static int[] newArr(int[] arr1, int[]arr2){
        int length_min;
        int length_max;
        if (arr1.length > arr2.length){
            length_min = arr2.length;
            length_max = arr1.length;
        }else{
            length_min = arr1.length;
            length_max = arr2.length;
        }
        int[] result = new int[length_min];
        try{
            
            for (int i = 0; i < length_max; i++) {
                result[i] = arr1[i] - arr2[i];  
            }
    
        } catch(IndexOutOfBoundsException e){
            System.out.println("Длины массивов не равны");
        }
        return result;
    }

}
