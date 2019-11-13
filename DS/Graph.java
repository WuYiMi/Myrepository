
package DS;

import java.util.ArrayList;

public class Graph <T>{
    private int [] [] adj;  //邻接矩阵
    private int Vnum,Enum;
    private ArrayList<T> vertex;

    public Graph (int number)
    {
        Vnum = 0;
        Enum = 0;
        vertex = new ArrayList<>();
        adj = new int [number][number];
        for (int i = 0; i < number; i++)
            for (int j = 0; j < number; j++)
                adj[i][j] = 0;

    }

    public boolean addVertex(T t)
    {
        if (Vnum >= adj.length)
        {System.out.println("超过上限");
        return false;}
        else
        {
            vertex.add(t);
            Vnum++;
            return true;
        }
    }

    public boolean addEdge(int a, int b)
    {
        if (a < 1 || a > adj.length || b < 1 || b > adj.length)
            return false;
        else
        {
            adj[a-1][b-1] = 1;
            adj[b-1][a-1] = 1;
            Enum++;
            return true;
        }
    }


    public void PrintAdj()
    {
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++)
                System.out.print(adj[i][j] + " ");

            System.out.println();
        }

    }

    public int getEnum()
    {
        return Enum;
    }

    public void PrintVertex()
    {
        for (T temp:vertex)
            System.out.print(temp + " ");
        System.out.println();

    }



    public void DFS(int i, boolean [] visited)
    {
        if (visited[i] == false)
        {System.out.print(vertex.get(i)); visited[i] = true;}
        for (int j = 0; j < visited.length; j++)
        {
            if(adj[i][j]  == 1 && visited [j]  == false)
                DFS(j,visited);
        }
    }


    public void DFS()
    {
        boolean [] visited = new boolean [Vnum];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        for (int i = 0; i < visited.length; i++)
            if(!visited[i])
                DFS(i,visited);

    }


    public void BFS()
    {
        boolean [] visited = new boolean [Vnum];
        Queue q = new Queue();
        q.AddQueue(0);


        for (int i = 0; i < visited.length; i++)
            visited[i] = false;


        while  (!q.isEmpty()){

            int m = q.OutQueue();
            if (visited[m] == false) {
                visited[m] = true;
                System.out.print(vertex.get(m));
            }
            for (int j = 0; j < visited.length; j++)
            {
                if(adj[m][j]  == 1 && visited [j]  == false)
                {
                    q.AddQueue(j);
                }
            }

        }


    }



    public static void main(String [] args)
    {
        int number = 7;
        Graph <Character> g= new Graph<>(number);
        for (int j = 0; j < number; j++)
            g.addVertex((char)('A' + j));

//        g.addEdge(1,2);
//        g.addEdge(1,3);
//        g.addEdge(1,4);
//        g.addEdge(1,5);
//        g.addEdge(2,7);
//        g.addEdge(5,6);
//        g.addEdge(5,7);
//        g.addEdge(7,6);

//        g.addEdge(5,8);


        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(1,6);
        g.addEdge(3,4);
        g.addEdge(5,7);
        g.addEdge(7,6);




        g.PrintAdj();
        g.PrintVertex();

        System.out.println(g.getEnum());




        g.DFS();
        System.out.println();
        g.BFS();
    }

}
