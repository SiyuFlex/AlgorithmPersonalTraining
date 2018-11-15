package v11_Graph_Basic.v05_BFS_and_Shortest_Path;

import java.util.Vector;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    private main.java.v11_Graph_Basic.v05_BFS_and_Shortest_Path.Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord;          // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。


    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public ShortestPath(main.java.v11_Graph_Basic.v05_BFS_and_Shortest_Path.Graph graph, int s){

        // 算法初始化
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        // 无向图最短路径算法, 从s开始广度优先遍历整张图
        Queue<Integer> q = new LinkedList<Integer>(); // 队列 先进先出，用来实现广度优先遍历。

        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while( !q.isEmpty() ){
            int v = q.remove();
            for( int i : G.adj(v) )
                if( !visited[i] ){
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
        }
    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w){

        assert hasPath(w) ;

        Stack<Integer> s = new Stack<Integer>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while( p != -1 ){
            s.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<Integer>();
        while( !s.empty() )
            res.add( s.pop() );

        return res;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w){

        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w){
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
