package main.java.v11_Graph_Basic.v05_BFS_and_Shortest_Path;

// 图的接口
public interface Graph {

    public int V();
    public int E();
    public void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Integer> adj(int v);
}
