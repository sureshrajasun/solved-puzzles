import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class BuyingShowTicket {

    static long waitingTime(int[] tickets, int p) {
        Queue<Pair<Integer, Boolean>> ticketingQueue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            Pair<Integer, Boolean> pair = new Pair(tickets[i], i == p);
            ticketingQueue.add(pair);
        }

        long numOfTimes = 1;
        while (!ticketingQueue.isEmpty()) {
            Pair<Integer, Boolean> firstPerson = ticketingQueue.peek();
            ticketingQueue.remove();
            numOfTimes++;
            if (firstPerson.getKey() == 1 && firstPerson.getValue() == true)
                break;
            else if (firstPerson.getKey() > 1) {
                Pair<Integer, Boolean> tempPair = new Pair(firstPerson.getKey() - 1, firstPerson.getValue());
                ticketingQueue.add(tempPair);
            }
        }
        return numOfTimes - 1;
    }

    public static void main(String[] args) {

        int[] tickets = new int[]{2, 6, 3, 4, 5};

        System.out.println(waitingTime(tickets, 2));

        tickets = new int[]{1, 1, 1, 1};
        System.out.println(waitingTime(tickets, 0));

    }
}


class Pair<K,V> implements Serializable {

    private K key;

    public K getKey() {
        return key;
    }

    private V value;

    public V getValue() {
        return value;
    }


    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return key + "=" + value;
    }


    @Override
    public int hashCode() {

        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
            return true;
        }
        return false;
    }
}