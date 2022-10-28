import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
            answer = scanner.next();
            if(answer.equalsIgnoreCase("Завершить"))
                break;
            item.name = answer;
            System.out.println("Ведите стоимость товара  формате \"рубли.копейки\"");
            try{
                answer = scanner.next();
                if(answer.equalsIgnoreCase("Завершить"))
                    break;
                item.price = Double.parseDouble(answer);
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
