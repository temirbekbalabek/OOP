import javafx.util.Pair;

import java.util.Queue;

public class Executor extends Employee {
    public static Queue<Pair<Teacher, String>> order;
    public static Queue<Pair<Teacher, String>> accepted;
    public static Queue<Pair<Teacher, String>> done;


    public static String viewNextOrder() {
        Pair<Teacher, String> s = order.peek();
        String message = s.getKey() + " " + s.getValue();
        return message;
    }

    public static void rejectOrder() {
        if (order.size() != 0)
            order.remove(order.peek());
    }

    public static void acceptOrder() {
        accepted.add(order.peek());
    }

    public static void doneOrder(Pair<Teacher, String> order2) {
        accepted.remove(order2);
        done.add(order2);
    }


}
