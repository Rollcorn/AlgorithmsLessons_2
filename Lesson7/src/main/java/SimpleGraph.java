import java.util.*;

class Vertex
{
    public int Value;
    public Vertex(int val)
    {
        Value = val;
    }
}

class SimpleGraph
{
    Vertex [] vertex;       // список vertex, хранящий вершины
    int [][] m_adjacency;   // матрица смежности
    int max_vertex;         // максимальное количество вершин

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];

        Arrays.fill(vertex, null);

        for ( int i = 0; i != m_adjacency.length; i++ )
        {
            for ( int j = 0; j != m_adjacency.length; j++ )
            {
                m_adjacency[i][j] = 0;
            }
        }
    }

    public void AddVertex(int value)
    {
        // добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        for ( int i = 0; i < vertex.length; i++ ) {
            if ( vertex[i] == null) {
                vertex[i] = new Vertex(value);
                return;
            }
        }

    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
        if ( v < 0 || v >= vertex.length ) {
            return;
        }
        // ваш код удаления вершины со всеми её рёбрами
        for ( int i = 0; i < vertex.length; i++ ) {
            if ( m_adjacency[v][i] == 1 ) {
                m_adjacency[i][v] = 0;
                m_adjacency[v][i] = 0;
            }
        }
        vertex[v] = null;

    }

    // true если есть ребро между вершинами v1 и v2
    public boolean IsEdge(int v1, int v2)
    {
        boolean res;
        if ( (v1 < 0) || (v2 < 0) || (v1 >= vertex.length) || (v2 >= vertex.length) )
        {
            res =  false;
        } else {
            res = (m_adjacency[v1][v2] == 1) && (m_adjacency[v2][v1] == 1);
        }
        return res;
    }

    public void AddEdge(int v1, int v2)
    {
        if ( !( (v1 < 0) || (v2 < 0) || (v1 >= vertex.length) || (v2 >= vertex.length) ) )
        {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
        // добавление ребра между вершинами v1 и v2
    }

    // удаление ребра между вершинами v1 и v2
    public void RemoveEdge(int v1, int v2)
    {
        if ( !( (v1 < 0) || (v2 < 0) || (v1 >= vertex.length) || (v2 >= vertex.length) ) )
        {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }

    }

    public int vertexSize()
    {
        int size = 0;
        for (Vertex i: vertex)
        {
            if (i != null)
            {
                size++;
            }
        }
        return size;
    }
}