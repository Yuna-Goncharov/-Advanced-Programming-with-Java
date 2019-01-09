import java.util.Scanner;


public class ListTester {
    public static void Test() {

        // first list
        List<String> list1 = new List<>();

        // get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 6 strings :");
        for (int i = 1; i < 7; i++) {
            System.out.println("Please enter String No " + i + " :");
            list1.add(sc.next());
        }

        // print given list
        System.out.println("First List:");
        System.out.println(list1);

        // second list
        List<String> list2 = new List<>();

        while (!list1.isEmpty()) {
            try {
                list2.addFirst(list1.remove());
            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }

        // print second list
        System.out.println("Second List:");
        System.out.println(list2);
    }
}
