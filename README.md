IntelliDispatch: Order Delivery Optimization System
Project Overview

IntelliDispatch is an Order Delivery Optimization System developed in Java that efficiently assigns customer orders to warehouses and couriers using advanced algorithms and data structures. The system models the delivery network as a graph and dynamically selects the best warehouse and courier for each order to minimize delivery time and distance.

The system supports real-time warehouse stock management, courier availability, and dynamic traffic updates, making it suitable for real-world logistics optimization.

Key Features

Graph-Based Network: Delivery points, warehouses, and routes are modeled as a graph.

Shortest Path Calculation: Uses Dijkstra’s Algorithm to find the shortest path from warehouse to customer.

Connectivity Check: Uses BFS to verify if nodes are connected.

Greedy Assignment: Assigns orders to the nearest warehouse and fastest available courier.

Priority Queue: Utilized in Dijkstra for efficient shortest-path computation.

HashMap & Sorting: Efficient data management for adjacency lists, distances, and courier prioritization.

Simulation & Performance Metrics: Simulates 200+ orders and compares baseline vs optimized delivery efficiency.

Dynamic Updates: Supports stock updates, courier assignment, and potential traffic adjustments.

Tech Stack & Algorithms

Programming Language: Java

Algorithms Used:

Graph Modeling

BFS (Breadth-First Search)

Dijkstra’s Algorithm

Greedy Algorithms

Priority Queue

Sorting

HashMap

Concepts:

Time Complexity Analysis

Efficient resource allocation

Simulation Results

The system demonstrates a ~30% improvement in delivery efficiency compared to a baseline random-assignment approach.
Example output:

===== IntelliDispatch Simulation Report =====
Orders simulated     : 200
Avg ETA (Baseline)   : 7.321 units
Avg ETA (Optimized)  : 5.029 units
Efficiency Gain      : 31.28 %
================================================

Setup & Run Instructions
1. Clone or Download the Project

Save IntelliDispatchSim.java to your local system.

2. Open Terminal or PowerShell

Navigate to the project directory:

cd "C:\path\to\project"

3. Compile the Java Program
javac IntelliDispatchSim.java

4. Run the Simulation
java IntelliDispatchSim


You will see a simulation report with baseline vs optimized delivery efficiency.

How It Works

Graph Representation: Nodes represent locations; edges represent routes with weights (distance/cost).

Order Assignment:

Optimized Approach:

Chooses the warehouse closest to the destination.

Chooses the fastest available courier.

Uses Dijkstra’s Algorithm for shortest path calculation.

Baseline Approach: Random warehouse and courier assignment.

Efficiency Calculation: Computes average delivery time for baseline and optimized assignment to measure improvement.

Future Enhancements

Real-time traffic integration for dynamic edge costs.

Visualization of delivery routes.

REST API for real-world application.

Multi-threaded courier simulation for concurrent deliveries.

Integration with a database for warehouse inventory and courier status.

Project Impact

This project demonstrates how advanced data structures and algorithms (Graphs, BFS, Dijkstra, PriorityQueue, Greedy Methods, HashMaps, Sorting) can be applied to real-world logistics optimization, achieving measurable improvements in delivery efficiency.

Author

Rutuja Bhavar

Email: rutujabhavar95@gmail.com

GitHub: https://github.com/rutujabhavar

LinkedIn: https://linkedin.com/in/rutujabhavar06
