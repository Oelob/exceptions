package lesson3.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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
       while(true){ 
        System.out.println("Выберете действие:\n1. Добавить новые данные;\n2. Завершить работу.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice==1){
            String newData = inputData();
                try{
                checkingAndWritingData(newData);
                } catch (MyCountException e){
                    System.out.println(e.getMessage());
                }catch (MyTypeException e){
                    System.out.println(e.getMessage());
                }
        }else{
            sc.close();
            break;
        }
       }
    }

    public static String inputData(){
        String result = "";
        Scanner scan = new Scanner(System.in,"Cp866");
        System.out.println("Введите данные, разделенные пробелом ");
        if (scan.hasNextLine()){
            result = scan.nextLine();
        }
        // sc.close();
        return result;
    }


  public static void checkingAndWritingData(String data) throws MyCountException, MyTypeException{
        
        String[] splitedData = data.split(" ");
        for (int i = 0; i < splitedData.length; i++) {
            System.out.println(splitedData[i]);
        }
        if (splitedData.length!=4){
            throw new MyCountException("Введено неверное количество данных, попробуйте снова");
        }
        stringChecking(splitedData[0], splitedData[1], splitedData[2]);   
        phonenumberChecking(splitedData[3]);
        String path = String.format("C:/Users/1/Desktop/Master/GB/exceptions/lesson3/homework/%s.txt", splitedData[0]);
        try{
            FileWriter file = new FileWriter(path,true);
            String text = String.format("<%s><%s><%s><%s>\n", splitedData[0], splitedData[1],splitedData[2],splitedData[3]);
            file.write(text);
            file.write("\n");
            file.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
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
    

