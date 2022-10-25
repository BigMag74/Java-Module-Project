import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Здраствуйте, на скольких человек необходимо разделить счет?");
        int peronCount;
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                peronCount = Integer.parseInt(scanner.next());
            }
            catch (NumberFormatException ex) {
                System.out.println("Ошибка \nПожалуйста введите корректное значение");
                continue;
            }
            if (peronCount == 1)
                System.out.println("Вы здесь один, счёт делить не с кем \nПожалуйста введите корректное значение");
            else if (peronCount > 1)
                break;
            else
                System.out.println("Ошибка \nПожалуйста введите корректное значение");
        }
        Calculator calculator = new Calculator(peronCount);
        String answer;
        while (true) {
            Item item = new Item();

            System.out.println("Ведите название товара");
            item.name = scanner.next();
            System.out.println("Ведите стоимость товара  формате \"рубли.копейки\"");
            try{
                item.price = Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException ex){
                System.out.println("Ошибка при добавлении товара, попробуйте снова");
                continue;
            }
            if(item.price < 0) {
                System.out.println("Ошибка при добавлении товара, попробуйте снова");
                continue;
            }

            calculator.addItem(item);
            System.out.println("Товар успешно добавлен");
            System.out.println("Хотите ли добавить еще один товар?");
            answer = scanner.next();
            if(answer.equalsIgnoreCase("Завершить"))
                break;
        }
        calculator.showResult();
    }
}
