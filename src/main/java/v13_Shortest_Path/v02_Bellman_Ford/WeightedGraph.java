package v13_Shortest_Path.v02_Bellman_Ford;


interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}