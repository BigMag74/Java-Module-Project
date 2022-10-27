import static java.lang.Math.floor;

public class Calculator {
    int peronCount;
    double sum = 0;
    String items = "";

    Calculator(int peronCount){
        this.peronCount = peronCount;
    }

    void addItem(Item item) {
        sum += item.price;
        items += item.name + "\n";
    }
    void showResult(){
        System.out.println("Добавленные товары:");
        System.out.println(items);
        double priceForPerson = sum/peronCount;
        String endOfString = " рублей";
        if((int)floor(priceForPerson) % 100 / 10 != 1) {
            switch ((int) floor(priceForPerson) % 10) {
                case 1:
                    endOfString = " рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    endOfString = " рубля";
                    break;
            }
        }
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", priceForPerson) + endOfString);
    }

}
