package DS;

public class Queue {
    private int Capacity;
    private int front;
    private int rear;
    private int [] data;
//    private int size;
    static int DEFAULT_SIZE = 6;
    public Queue()
    {
        front = rear = 0;
        Capacity = DEFAULT_SIZE;
        data = new int [Capacity];
    }

    public int getSize()
    {
        return (rear - front + Capacity) % Capacity;
    }

    public boolean isEmpty()
    {
        return (rear == front);
    }

    public boolean isFull()
    {
        return ((rear + 1) % Capacity == front);
    }

    /*出队*/
    public void OutQueue()
    {
        if(isEmpty())
        {
            System.out.println("can't out");
        }
        else
        {
            front = (front + 1) % Capacity;
        }
    }

    /*扩容*/
    public void Enlarge()
    {
        int newCapacity = Capacity * 2 + 1;
        int [] newData = new int [newCapacity];
        for (int i = front, j = 0; i != rear; j++, i = (i + 1) % Capacity)
        {
            newData[j] = data[i];
        }
        front = 0;
        rear = getSize();
        data = newData;
        Capacity = newCapacity;
    }

    /*入队*/
    public void AddQueue (int t)
    {
        if(isFull())
        {
            Enlarge();
        }
        data[rear] = t;
        rear = (rear + 1) % Capacity;
    }


    /*获取队首元素*/
    public int getFront()
    {
        return data[front];
    }


    /*获取队尾元素*/
    public int getRear()
    {
        return data [(rear + Capacity) % Capacity];
    }

    /*遍历 */

    public void traverse()
    {
        int i = front;
        while(i != rear)
        {
            System.out.println(data[i]);
            i = (i+1) % Capacity;
        }
    }

    public static void main(String [] args)
    {
        Queue q = new Queue();
        for (int i = 0; i <8 ; i++)
            q.AddQueue(i);
//        System.out.println(q.getSize());
//        q.traverse();
//        q.OutQueue();
//        q.OutQueue();

        for (int i = 0; i <5 ; i++)
            q.OutQueue();
//        System.out.println(q.getSize());
//        q.traverse();

        for (int i = 0; i < 7 ; i++)
            q.AddQueue(i + 8);

        System.out.println(q.getSize());
        q.traverse();


    }
}
