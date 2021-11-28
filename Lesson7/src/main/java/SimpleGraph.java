import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
    public int deep;

    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

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
        for ( int i = 0; i < vertex.length; i++ ) {
            if ( vertex[i] == null) {
                vertex[i] = new Vertex(value);
                return;
            }
        }

    }


    public void RemoveVertex(int v)
    {
        if ( v < 0 || v >= vertex.length ) {
            return;
        }
        for ( int i = 0; i < vertex.length; i++ ) {
            if ( m_adjacency[v][i] == 1 ) {
                m_adjacency[i][v] = 0;
                m_adjacency[v][i] = 0;
            }
        }
        vertex[v] = null;

    }

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
    }

    public void RemoveEdge(int v1, int v2)
    {
        if ( !( (v1 < 0) || (v2 < 0) || (v1 >= vertex.length) || (v2 >= vertex.length) ) )
        {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }

    }

    public ArrayList<Vertex> DepthFirstSearch( int VFrom, int VTo )
    {
        ArrayList<Vertex> ret = new ArrayList<Vertex>();

        if ( VFrom < 0 || VFrom >= vertex.length || VTo < 0 || VTo >= vertex.length )
        {
            return ret;
        }

        for ( int i = 0;i < vertex.length && vertex[i] != null; i++ )
        {
            vertex[i].Hit = false;
        }

        Stack<Integer> queue = new Stack<>();
        queue.push( VFrom );                    

        while ( !queue.isEmpty() )
        {
            int curVert = queue.peek();
            vertex[curVert].Hit = true;

            if ( m_adjacency[curVert][VTo] == 1)
            {
                queue.push(VTo);
                break;
            }

            for ( int i = 0; i < m_adjacency.length; i++ )
            {
                if ( m_adjacency[curVert][i] == 1 && !vertex[i].Hit )
                {
                    queue.push(i);
                    break;
                }
                if ( i == m_adjacency.length - 1 ){
                    queue.pop();
                }
            }

        }

        if ( !queue.isEmpty() )
        {
            int size = queue.size();
            Integer[] arr= new Integer[size];
            queue.copyInto(arr);
            for ( int i = 0; i < arr.length; i++  )
            {
                ret.add(i, vertex[arr[i]]);
            }
        }

        return ret;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
        ArrayList<Vertex> ret = new ArrayList<>();

        if ( VFrom < 0 || VFrom >= vertex.length || VTo < 0 || VTo >= vertex.length )
        {
            return ret;
        }

        for ( int i = 0; i < vertex.length && vertex[i] != null; i++ )
        {
            vertex[i].Hit = false;
            vertex[i].deep = vertex.length * vertex.length;
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.push( VFrom );
        vertex[VFrom].deep = 0;
        vertex[VFrom].Hit = true;

        while ( !queue.isEmpty() )
        {
            int curVert = queue.pollFirst();

            if (m_adjacency[curVert][VTo] == 1)
            {
                break;
            }

            for ( int i = 0; i < m_adjacency.length; i++ )
            {

                if ( m_adjacency[curVert][i] == 1 && !vertex[i].Hit )
                {
                    vertex[i].Hit = true;
                    vertex[i].deep = vertex[curVert].deep + 1;
                    queue.addLast(i);
                }
            }

            if ( queue.isEmpty() )
            {
                return ret;
            }
        }

        Deque<Vertex> res = new ArrayDeque<>();
        int curVert = VTo;
        res.addFirst(vertex[VTo]);
        while ( curVert != VFrom)
        {
            if ( m_adjacency[curVert][VFrom] == 1 ) {
                res.addFirst(vertex[VFrom]);
                break;
            }
            int curMinInd = curVert;
            for ( int i = 0; i < m_adjacency.length; i++ )
            {
                if ( m_adjacency[curVert][i] == 1 && vertex[curMinInd].deep > vertex[i].deep )
                {
                    curMinInd = i;
                }
            }
            curVert = curMinInd;
            res.addFirst(vertex[curVert]);
        }
        ret.addAll(res);

        return ret;
    }

    public ArrayList<Vertex> WeakVertices()
    {
        ArrayList<Vertex> ret = new ArrayList<>();

        for ( int i = 0; i < vertex.length && vertex[i] != null; i++ )
        {
            vertex[i].Hit = false;
        }

        for (int i = 0; i < vertex.length; i++)
        {
            if ( vertex[i] == null || vertex[i].Hit )
            {
                continue;
            }

            for (int j = 0; j < vertex.length; j++ )
            {
                if ( vertex[j] == null || m_adjacency[i][j] != 1 )
                {
                    continue;
                }

                for ( int k = j + 1; k < vertex.length; k++ )
                {
                    if ( m_adjacency[i][k] == 1 && m_adjacency[j][k] == 1 )
                    {
                        vertex[i].Hit = true;
                        vertex[j].Hit = true;
                        vertex[k].Hit = true;
                    }
                }
            }
        }

        for ( Vertex x : vertex )
        {
            if ( !x.Hit )
            {
                ret.add(x);
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