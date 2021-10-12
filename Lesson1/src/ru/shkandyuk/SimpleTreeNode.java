package ru.shkandyuk;

import java.util.*;

public class SimpleTreeNode<T> {
    // значение в узле
    public T NodeValue;
    // родитель или null для корня
    public SimpleTreeNode<T> Parent;
    // список дочерних узлов или null
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent){
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T> {
    // корень, может быть null
        public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        // ваш код добавления нового дочернего узла существующему ParentNode
        ParentNode.Children.add(NewChild);
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        // ваш код удаления существующего узла NodeToDelete
        SimpleTreeNode<T> node = NodeToDelete;
        for (int i = 0; node.Children != null; i++){
            DeleteNode(node.Children.get(i));
            NodeToDelete.Children = null;
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> resList = null;
        SimpleTreeNode<T> node = this.Root;
        for (int i = 0; node.Children != null; i++){
            resList.add(node);
            node = node

        }
        return null;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        return null;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    public int Count() {
        // количество всех узлов в дереве
        return 0;
    }

    public int LeafCount() {
        // количество листьев в дереве
        return 0;
    }


    public List<SimpleTreeNode<T>> GetAllChildren() {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> resList = null;
        SimpleTreeNode<T> node = this.Root;
        for (int i = 0; node.Children != null; i++){
            resList.add(node);
            node = node

        }
        return null;
    }
}

