package ru.shkandyuk;

import java.util.*;

public class SimpleTreeNode<T> {
    // значение в узле
    public T NodeValue;
    // родитель или null для корня
    public SimpleTreeNode<T> Parent;
    // список дочерних узлов или null
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<>();
    }
}

class SimpleTree<T> {
    // корень, может быть null
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    /*************************************************************************************
     * Добавить текущему узлу ParentNode новый узел NewChild в качестве дочернего
     * @param ParentNode
     * @param NewChild
     */
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        // ваш код добавления нового дочернего узла существующему ParentNode
        if( NewChild != null ){
            ParentNode.Children.add(NewChild);
            NewChild.Parent = ParentNode;
        }
    }

    /*************************************************************************************
     * Удалить некорневой узел (удаляется узел вместе со всем поддеревом)
     * @param NodeToDelete
     */
    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {

        if(NodeToDelete != this.Root && NodeToDelete != null){
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }

        SimpleTreeNode<T> currentNode = NodeToDelete;
        for (int i = 0; currentNode != null && !NodeToDelete.Children.isEmpty()
                && i < NodeToDelete.Children.size(); i++) {
            currentNode = NodeToDelete.Children.get(i);
            DeleteNode(currentNode);
            currentNode.Parent = null;
            currentNode.Children.clear();
        }
        if(NodeToDelete != null){
            NodeToDelete.Children.clear();
        }
        if(NodeToDelete == this.Root){
            this.Root = null;
        }

    }

    /**********************************************************************
     * Помещает все дочерние узлы заданного узла в список и возвращает его
     * @return
     */
    public List<SimpleTreeNode<T>> GetAllNodes() {
        return GetNodeChildren(Root);
    }

    /**********************************************************************
     * Последовательно обойти всё дерево и сформировать список всех узлов
     * @return
     */
    public List<SimpleTreeNode<T>> GetAllChildren() {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> resList = new ArrayList<>();
        SimpleTreeNode<T> nodeRoot = this.Root;
        if (nodeRoot != null) {
            resList.addAll(GetNodeChildren(nodeRoot));
        }
        return resList;
    }

    /********************************************************************************
     * Помещает все дочерние узлы поддерева заданного узла в список и возвращает его
     * @param node - заданный узел
     * @return Список всех дочерних элементов заданного узла
     */
    public List<SimpleTreeNode<T>> GetNodeChildren(SimpleTreeNode<T> node) {
        List<SimpleTreeNode<T>> resList = new ArrayList<>();
        SimpleTreeNode<T> currentNode = node;

        // Iterate through the node Children list, call GetNodeChildren for each child and return
        // all children of this node and children of each children nodes
        for (int i = 0; currentNode != null && !currentNode.Children.isEmpty()
                && i < currentNode.Children.size(); i++) {
            currentNode = node.Children.get(i);
            List<SimpleTreeNode<T>> tmpNode = GetNodeChildren(currentNode);
            if (tmpNode != null){
                resList.addAll(tmpNode);
            }
            resList.add(currentNode);
        }

        return resList;
    }

    /**************************************************************************
     * Найти список подходящих узлов по заданному значению
     * @param val
     * @return
     */
    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        return null;
    }

    /*****************************************************************
     * Подсчитать общее количество узлов в дереве, и количество листьев
     * @return res
     */
    public int Count() {
        // количество всех узлов в дереве
        int res = 0;
        if(this.Root != null){
            res = CountNodeChildren(this.Root) + 1;
        }
        return res;
    }

    /********************************************************************
     * Количество листьев в дереве
     * @return
     */
    public int LeafCount() {
        return CountNodeChildren(this.Root);
    }




    /*****************************************************************************
     * Вычисляет количество узлов поддерева переданного узла
     */
    public int CountNodeChildren(SimpleTreeNode<T> node) {
        int nodeAmount = 0;
        SimpleTreeNode<T> currentNode = node;

        for (int i = 0; currentNode != null && !node.Children.isEmpty()
                && i < node.Children.size(); i++) {
            currentNode = node.Children.get(i);
            nodeAmount = nodeAmount + CountNodeChildren(currentNode) + 1;
        }
        return nodeAmount;
    }

    /*****************************************************************************
     * Вычисляет количество листов в дереве
     */
    public int CountNodeLeaf(SimpleTreeNode<T> node) {
        int leafAmount = 0;
        SimpleTreeNode<T> currentNode = node;

        for (int i = 0; node != null && i < currentNode.Children.size(); i++) {
            currentNode = node.Children.get(i);

            leafAmount = CountNodeChildren(currentNode) + 1;
        }
        return leafAmount;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }
}
