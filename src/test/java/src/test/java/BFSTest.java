package src.test.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {
    @Test
    void bfs(){
        MyGraph testGraph = new MyGraph(5);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);

        testGraph.addEdge(1, 3);
        testGraph.addEdge(1, 4);

        List<Integer> result  = BFS.bfs(testGraph, 0);
        List<Integer> expected = Arrays.asList(0,1,2,3,4);
        assertIterableEquals(expected, result);
    }
}