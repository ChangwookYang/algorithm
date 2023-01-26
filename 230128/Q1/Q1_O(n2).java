import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            list.add(new Person(height, weight));
        }

        int cnt = 0;
        for (Person target : list) {
            boolean isEnough = true;
            for (Person other : list) {
                if (target.height < other.height && target.weight < other.weight) {
                    isEnough = false;
                    break;
                }
            }
            if (isEnough) cnt++;
        }

        System.out.println(cnt);
    }
}