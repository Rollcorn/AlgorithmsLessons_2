import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
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

    // Здесь и далее, параметры v -- индекс вершины
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

    // Возвращается список узлов -- путь из VFrom в VTo.
    public ArrayList<Vertex> DepthFirstSearch( int VFrom, int VTo )
    {
        ArrayList<Vertex> ret = new ArrayList<Vertex>();

        if ( VFrom < 0 || VFrom >= vertex.length || VTo < 0 || VTo >= vertex.length ) {
            return ret;
        }

        // Устанавливаю для нвоого поиска все вершины как непосещенные
        for ( int i = 0;i < vertex.length && vertex[i] != null; i++ ) {
            vertex[i].Hit = false;
        }

        Stack<Integer> queue = new Stack<>();
        queue.push( VFrom );                    

        while ( !queue.isEmpty() ) {
            int curVert = queue.peek();
            vertex[curVert].Hit = true;         // Фиксируем текущую вершину как посещенную

            // Искомая вершина является смежной к текущей
            if ( m_adjacency[curVert][VTo] == 1) {
                queue.push(VTo);
                break;
            }

            for ( int i = 0; i < m_adjacency.length; i++ ) {
                // Перебираем список смежных вершин если находим непосещенную, то пушим ее в стек
                if ( m_adjacency[curVert][i] == 1 && vertex[i].Hit == false ){
                    queue.push(i);
                    break;
                }
                if ( i == m_adjacency.length - 1 ){
                    queue.pop();
                }
            }

        }

        if ( !queue.isEmpty() ) {
            int size = queue.size();
            Integer[] arr= new Integer[size];
            queue.copyInto(arr);
            for ( int i = 0; i < arr.length; i++  ) {
                ret.add(i, vertex[arr[i]]);
            }
        }

        return ret;
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