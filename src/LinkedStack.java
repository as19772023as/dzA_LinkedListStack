import java.util.Arrays;

public class LinkedStack {

    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        int lastValue = 0;

        if (tail != null) {
            lastValue = tail.getValue(); // возьмите value из последнего узла
            tail = tail.getPrev(); // назначьте предыдущий к последнему узлу последним узлом
        } else {
            tail = null;
        }
        size--;

//        int lastValue = tail.getValue();  //TODO  или так
//        tail = tail.getPrev();

        return lastValue;
    }

    public int getSize() {
        // ваш код
        // верните размер стека
        return size;
    }

    public boolean isEmpty() {
        // ваш код
        // верните ответ на вопрос, не пустой ли стек
        return tail == null;
    }

    public String toString() {
        // если есть элементы, пройдитесь по связному списку,
        // выводя элементы.
        // вывод должен быть в точности как в комментариях к main
        // при этом этот метод не должен менять стек!

        StringBuilder ss = new StringBuilder();
        Node current = tail;

        if (isEmpty()) {
            return "EMPTY";
        } else {

            while (current != null) {
                ss.append(current.getValue());
                current = current.getPrev();

                if (current != null) {
                    ss.append(" -> ");
                }
            }
        }

        return ss.toString();

    }
}
