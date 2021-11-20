import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {
    SimpleGraph g1 = new SimpleGraph(10);

    @BeforeEach
    void setUp() {
        g1.AddVertex(1);
        g1.AddVertex(2);
        g1.AddVertex(3);
        g1.AddVertex(4);
        g1.AddVertex(5);
        g1.AddVertex(6);
        g1.AddVertex(7);
        g1.AddVertex(8);
        g1.AddVertex(9);
        g1.AddVertex(10);
    }

    @Test
    void addVertex() {
        System.out.println("Vertex size: " + g1.vertexSize());
        System.out.print("[ ");
        for (Vertex i: g1.vertex) {
            if ( i != null ) {
                System.out.print(i.Value + ", ");
            } else {
                System.out.print("null, ");
            }
        }
        System.out.println(" ]");
    }

    @Test
    void removeVertex() {
        printGraph();
        System.out.println("1: Vertex size: " + g1.vertexSize());
        g1.AddEdge(0, 5);
        g1.AddEdge(1, 2);
        g1.AddEdge(3, 3);
        g1.AddEdge(7, 8);
        g1.AddEdge(9, 3);
        g1.AddEdge(10,10);
        g1.AddEdge(10,10);
        printGraph();
        System.out.println("2: Vertex size: " + g1.vertexSize());
        g1.RemoveVertex(3);
        printGraph();
        System.out.println("3: Vertex size: " + g1.vertexSize());
        g1.RemoveVertex(10);
        printGraph();
        System.out.println("4: Vertex size: " + g1.vertexSize());
        g1.RemoveVertex(3);
        printGraph();
        System.out.println("5: Vertex size: " + g1.vertexSize());

    }

    @Test
    void isEdge() {
        assertFalse(g1.IsEdge(0, 5));
        g1.AddEdge(0, 5);
        assertTrue(g1.IsEdge(0, 5));

        assertFalse(g1.IsEdge(1, 2));
        g1.AddEdge(1, 2);
        assertTrue(g1.IsEdge(1, 2));

        assertFalse(g1.IsEdge(3, 3));
        g1.AddEdge(3, 3);
        assertTrue(g1.IsEdge(3, 3));

        assertFalse(g1.IsEdge(7, 8));
        g1.AddEdge(7, 8);
        assertTrue(g1.IsEdge(7, 8));

        assertFalse(g1.IsEdge(7, 8));
        g1.AddEdge(9, 3);
        assertTrue(g1.IsEdge(7, 8));

    }

    @Test
    void addEdge() {
        System.out.println("Vertex size: " + g1.vertexSize());
        g1.AddEdge(0, 5);
        g1.AddEdge(1, 2);
        g1.AddEdge(3, 3);
        g1.AddEdge(7, 8);
        g1.AddEdge(9, 3);
        g1.AddEdge(10,10);



    }

    @Test
    void removeEdge() {
        printGraph();
        g1.AddEdge(0, 5);
        g1.AddEdge(1, 2);
        g1.AddEdge(3, 3);
        g1.AddEdge(7, 8);
        g1.AddEdge(9, 3);
        g1.AddEdge(10,10);
        g1.AddEdge(10,10);
        printGraph();

        System.out.println("Удаление ребер 1-2 и 9-3");
        g1.RemoveEdge(1, 2);
//        g1.RemoveEdge(9, 3);
        g1.RemoveEdge(5, 5);
        g1.RemoveEdge(3, 3);

        printGraph();

    }

    public void printGraph(){
        System.out.print( "     ");
        for ( int j = 0; j != g1.m_adjacency.length; j++ )
        {
            System.out.print( j + "  " );
        }
        System.out.println(" ");
        for ( int i = 0; i != g1.m_adjacency.length; i++ )
        {
            System.out.print( i + ": [ ");
            for ( int j = 0; j != g1.m_adjacency.length; j++ )
            {
                System.out.print( g1.m_adjacency[i][j] + ", " );
            }
            System.out.println("]");
        }
    }
}