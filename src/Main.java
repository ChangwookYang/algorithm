import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person implements Comparable<Person> {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        return person.height - this.height;
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

        list.sort(Person::compareTo);

        int cnt = 0;
        int maxWeight = list.get(0).weight;
        for (Person target : list) {
            if (maxWeight <= target.weight) {
                maxWeight = target.weight;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}