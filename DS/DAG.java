package DS;

public class DAG {
    private Ljtable [] vertex;
    class Ljtable {
        char data;
        Node head;
        int inDegree;

        public  Ljtable(char c,int n)
        {
            data = c;
            head = new Node(n);
            inDegree = 0;
        }
    }

    class Node {
        int number;
        Node next;
        public Node(int a)
        {
            number = a;
            next = null;

        }
    }


    public DAG(char [] ch)
    {
        vertex = new Ljtable[ch.length];
        for (int i = 0; i < ch.length; i++)
        {
            vertex[i] = new Ljtable(ch[i], i);

        }

    }

    public void PrintLjtable()
    {
        for (Ljtable l:vertex)
        {
            Node p = l.head;
            while (p!=null) {
                System.out.print(p.number+1 + " ");
                p = p.next;
            }
            System.out.println();

        }
    }

    public int addArc(int a, int b)
    {
        a = a - 1;
        b = b - 1;
        if(a < 0 || a >vertex.length - 1 || b < 0 || a > vertex.length - 1 )
            return -1;
        else if(a == b)
            return 0;
        else
        {
            Node p = vertex[a].head;
            while(p.next!=null)
            {
                p = p.next;
                if(p.number == b)
                    return 0;

            }
            Node s = new Node(b);
            p.next = s;

            vertex[b].inDegree++;
            return 1;
        }
    }

    public void Topo()
    {
        int [] m = new int [vertex.length];
        for (int i = 0; i < vertex.length; i++)
        {
            m[i] = vertex[i].inDegree;
        }

        int k = 0;
        while(k < vertex.length)
        for (Ljtable l:vertex)
        {
            if(l.inDegree == 0) {
                System.out.print(l.data);
                k++;
                Node h = l.head;
                while(h!=null) {
                    vertex[h.number].inDegree--;
                    h = h.next;
                }
            }

        }

        for (int i = 0; i < vertex.length; i++)
        {
             vertex[i].inDegree  =  m[i];
        }




    }


    public static void main(String []args)
    {
        char [] ch = {'A','B','C','D','E','F','G'};
        DAG dag = new DAG(ch);
        dag.addArc(2,1);
        dag.addArc(1,7);
        dag.addArc(2,4);
        dag.addArc(4,5);
        dag.addArc(4,6);
        dag.addArc(3,6);
        dag.addArc(3,7);
        dag.PrintLjtable();
        dag.Topo();
    }

}
