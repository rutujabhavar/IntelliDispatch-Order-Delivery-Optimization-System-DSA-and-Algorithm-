# IntelliDispatch: Order Delivery Optimization System

★ Project Overview:

• IntelliDispatch is a Java-based Order Delivery Optimization System.

• Efficiently assigns customer orders to warehouses and couriers using advanced algorithms and data structures.

• Models the delivery network as a graph to dynamically select the best warehouse and courier for each order.

• Optimizes delivery time and distance while supporting real-time updates.




★ Key Features:

• Graph-Based Network: Models delivery points, warehouses, and routes as a graph.

• Shortest Path Calculation: Uses Dijkstra’s Algorithm to find the shortest path from warehouse to customer.

• Connectivity Check: Uses BFS to verify if nodes are connected.

• Greedy Assignment: Assigns orders to the nearest warehouse and fastest available courier.

• Priority Queue: Optimizes shortest-path computations in Dijkstra’s Algorithm.

• HashMap & Sorting: Efficiently manages adjacency lists, distances, and courier prioritization.

• Simulation & Performance Metrics: Simulates 200+ orders and compares baseline vs optimized delivery efficiency.

• Dynamic Updates: Supports stock updates, courier assignment, and potential traffic adjustments.



★ Tech Stack & Algorithms:

• Programming Language: Java

• Algorithms Used:

  • Graph Modeling
  
  • BFS (Breadth-First Search)
  
  • Dijkstra’s Algorithm
  
  • Greedy Algorithms
  
  • Priority Queue
  
  • Sorting
  
  • HashMap

  

★ Concepts Applied:

• Time Complexity Analysis

• Efficient Resource Allocation

• Simulation and Performance Measurement

• Simulation Results:

• Demonstrates a ~30% improvement in delivery efficiency compared to baseline random-assignment approach.



★ Example Output:

===== IntelliDispatch Simulation Report =====

Orders simulated       : 200

Avg ETA (Baseline)     : 7.321 units

Avg ETA (Optimized)    : 5.029 units

Efficiency Gain        : 31.28%



★ Setup & Run Instructions:

• Save IntelliDispatchSim.java to your local system.

• Open Terminal/PowerShell and navigate to project directory:

• cd "C:\path\to\project"




★ Compile the Java program:

• javac IntelliDispatchSim.java

• Run the simulation:

• java IntelliDispatchSim

• Observe the simulation report showing baseline vs optimized delivery efficiency.



★ How It Works:

• Graph Representation: Nodes = locations, Edges = routes with weights (distance/cost).

• Order Assignment:

• Optimized Approach:

• Selects closest warehouse.

• Chooses fastest available courier.

• Uses Dijkstra’s Algorithm for shortest path.

• Baseline Approach: Random warehouse and courier assignment.

• Efficiency Calculation: Measures average delivery time for baseline and optimized assignments.



★ Future Enhancements:

• Real-time traffic integration for dynamic edge costs.

• Visualization of delivery routes.

• REST API for real-world application.

• Multi-threaded courier simulation for concurrent deliveries.

• Integration with a database for warehouse inventory and courier status.



★ Project Impact:

• Demonstrates how advanced data structures and algorithms (Graphs, BFS, Dijkstra, PriorityQueue, Greedy Methods, HashMaps, Sorting) can optimize real-world logistics.


• Achieves measurable improvements in delivery efficiency.



★ Author:

• Rutuja Bhavar

• Email: rutujabhavar95@gmail.com

• GitHub: github.com/rutujabhavar

• LinkedIn: linkedin.com/in/rutujabhavar06
