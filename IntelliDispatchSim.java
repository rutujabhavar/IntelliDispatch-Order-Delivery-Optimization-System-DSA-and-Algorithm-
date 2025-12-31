import java.util.*;

// ===== Graph and BFS/Dijkstra =====
class Graph {

    static class Edge {
        int to;
        int cost;
        Edge(int t, int c){ to = t; cost = c; }
    }

    Map<Integer, List<Edge>> adj = new HashMap<>();

    public void addNode(int node){ adj.putIfAbsent(node, new ArrayList<>()); }

    public void addEdge(int from, int to, int cost){
        addNode(from);
        addNode(to);
        adj.get(from).add(new Edge(to, cost));
        adj.get(to).add(new Edge(from, cost)); // undirected
    }

    // BFS connectivity
    public boolean isConnected(int start, int target){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start); visited.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == target) return true;
            for(Edge e: adj.get(node)){
                if(!visited.contains(e.to)){
                    visited.add(e.to);
                    q.add(e.to);
                }
            }
        }
        return false;
    }

    // Dijkstra shortest-path distances
    public Map<Integer,Integer> dijkstra(int source){
        Map<Integer,Integer> dist = new HashMap<>();
        for(Integer n: adj.keySet()) dist.put(n,Integer.MAX_VALUE);
        dist.put(source,0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int d = top[1];
            if(d > dist.get(node)) continue;

            for(Edge e: adj.get(node)){
                int nd = d + e.cost;
                if(nd < dist.get(e.to)){
                    dist.put(e.to, nd);
                    pq.add(new int[]{e.to, nd});
                }
            }
        }
        return dist;
    }

    public Set<Integer> nodes(){ return adj.keySet(); }
}

// ===== Warehouse =====
class Warehouse {
    int id, node, stock;
    Warehouse(int id,int node,int stock){ this.id=id; this.node=node; this.stock=stock; }
}

// ===== Courier =====
class Courier {
    int id, node;
    double speed;
    boolean available=true;
    Courier(int id,int node,double speed){ this.id=id; this.node=node; this.speed=speed; }
}

// ===== Order =====
class Order {
    int node;
    Order(int node){ this.node=node; }
}

// ===== IntelliDispatch System =====
class IntelliDispatch {

    Graph graph;
    List<Warehouse> warehouses;
    List<Courier> couriers;

    IntelliDispatch(Graph g,List<Warehouse> w,List<Courier> c){
        this.graph = g;
        this.warehouses = w;
        this.couriers = c;
    }

    // Optimized assignment (greedy + shortest-path + fastest courier)
    public double optimizedDeliver(Order o){
        Warehouse bestWh = null;
        Courier bestCourier = null;
        int minDist = Integer.MAX_VALUE;

        for(Warehouse wh: warehouses){
            if(wh.stock <= 0) continue;

            Map<Integer,Integer> dist = graph.dijkstra(wh.node);
            int d = dist.getOrDefault(o.node, Integer.MAX_VALUE);

            if(d < minDist){
                // choose fastest available courier
                Courier fastest = null;
                double maxSpeed = 0;
                for(Courier c: couriers){
                    if(c.available && c.speed > maxSpeed){
                        fastest = c;
                        maxSpeed = c.speed;
                    }
                }
                if(fastest != null){
                    minDist = d;
                    bestWh = wh;
                    bestCourier = fastest;
                }
            }
        }

        if(bestWh != null && bestCourier != null){
            bestWh.stock--;
            bestCourier.available = false;
            bestCourier.node = bestWh.node;
            return (double)minDist / bestCourier.speed;
        }
        return 0;
    }

    // Baseline: random warehouse + random courier
    public double baselineDeliver(Order o){
        List<Warehouse> stocked = new ArrayList<>();
        for(Warehouse w: warehouses) if(w.stock>0) stocked.add(w);
        if(stocked.isEmpty()) return 0;

        Warehouse w = stocked.get(new Random().nextInt(stocked.size()));
        Courier c = couriers.get(new Random().nextInt(couriers.size()));

        Map<Integer,Integer> dist = graph.dijkstra(w.node);
        int d = dist.getOrDefault(o.node,Integer.MAX_VALUE);

        w.stock--;
        return (double)d / c.speed;
    }
}

// ===== Simulation =====
public class IntelliDispatchSim {

    static Random rand = new Random();

    // clone warehouses
    static List<Warehouse> cloneWh(List<Warehouse> src){
        List<Warehouse> out = new ArrayList<>();
        for(Warehouse w: src) out.add(new Warehouse(w.id,w.node,w.stock));
        return out;
    }

    // clone couriers
    static List<Courier> cloneC(List<Courier> src){
        List<Courier> out = new ArrayList<>();
        for(Courier c: src) out.add(new Courier(c.id,c.node,c.speed));
        return out;
    }

    public static void main(String[] args){

        Graph g = new Graph();
        g.addEdge(1,2,4);
        g.addEdge(2,3,2);
        g.addEdge(3,4,3);
        g.addEdge(1,5,7);
        g.addEdge(5,4,1);
        g.addEdge(2,5,2);

        List<Warehouse> warehouses = Arrays.asList(
                new Warehouse(101,1,50),
                new Warehouse(102,4,50)
        );

        List<Courier> couriers = Arrays.asList(
                new Courier(201,2,1.5),
                new Courier(202,5,2.0)
        );

        List<Integer> nodes = new ArrayList<>(g.nodes());
        int ORDERS = 200;

        double baselineSum = 0;
        double optimizedSum = 0;

        for(int i=0;i<ORDERS;i++){
            int dest = nodes.get(rand.nextInt(nodes.size()));
            Order o = new Order(dest);

            // fresh copies for fairness
            List<Warehouse> whBase = cloneWh(warehouses);
            List<Courier> csBase = cloneC(couriers);
            List<Warehouse> whOpt  = cloneWh(warehouses);
            List<Courier> csOpt    = cloneC(couriers);

            IntelliDispatch baseSystem = new IntelliDispatch(g,whBase,csBase);
            IntelliDispatch optSystem  = new IntelliDispatch(g,whOpt,csOpt);

            baselineSum  += baseSystem.baselineDeliver(o);
            optimizedSum += optSystem.optimizedDeliver(o);
        }

        double baselineAvg = baselineSum / ORDERS;
        double optimizedAvg = optimizedSum / ORDERS;
        double improvement = (baselineAvg - optimizedAvg) / baselineAvg * 100.0;

        System.out.println("\n===== IntelliDispatch Simulation Report =====");
        System.out.printf("Orders simulated     : %d%n", ORDERS);
        System.out.printf("Avg ETA (Baseline)   : %.3f units%n", baselineAvg);
        System.out.printf("Avg ETA (Optimized)  : %.3f units%n", optimizedAvg);
        System.out.printf("Efficiency Gain      : %.2f %% %n", improvement);
        System.out.println("================================================\n");
    }
}
