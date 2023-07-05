package lesson3.homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework3 {

    /*Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номертелефона 

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
вернуть код ошибки, 
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><номер_телефона>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом. 

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки. */

    public static void main(String[] args) throws MyTypeException{
       
       String newData = inputData();
       try{
       checkingData(newData);
       } catch (MyCountException e){
        System.out.println(e.getMessage());
        inputData();
       }
        
      
    }

    public static String inputData(){
        String result = "";
        Scanner sc = new Scanner(System.in,"Cp866");
        System.out.println("Введите данные, разделенные пробелом: ");
        if (sc.hasNextLine()){
            result = sc.nextLine();
        }
        // sc.close();
        return result;
    }


    public static void checkingData(String data) throws MyCountException, MyTypeException{
        
        String[] splitedData = data.split(" ");
        for (int i = 0; i < splitedData.length; i++) {
            System.out.println(splitedData[i]);
        }
        if (splitedData.length!=4){
            throw new MyCountException("Введено неверное количество данных, попробуйте снова");
        }
        stringChecking(splitedData[0], splitedData[1], splitedData[2]);   
        phonenumberChecking(splitedData[3]);
    }

    public static void stringChecking(String str1, String str2, String str3) throws MyTypeException{
        if(!str1.matches("[а-яёА-ЯЁ]+")){
            throw new MyTypeException("Фамилия указана неверно. Этот тип данных должен быть String");
        }
        if(!str2.matches("[а-яёА-ЯЁ]+")){
            throw new MyTypeException("Имя указана неверно. Этот тип данных должен быть String");
        }
        if(!str3.matches("[а-яёА-ЯЁ]+")){
            throw new MyTypeException("Отчество указано неверно. Этот тип данных должен быть String");
        }
    }
    
    public static void phonenumberChecking(String str) throws MyTypeException{
       
        try {
            Long phonenumber = Long.parseLong(str);
        } catch (NumberFormatException e){
            throw new MyTypeException("Неверный тип данных для номера телефона");
        }
    }
    
}
    

