package com.xin.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    /**
     * breadth first search
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node,copy);
        queue.offer(node);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode cur = queue.poll();
            for(int i=0;i<cur.neighbors.size();i++)
            {
                if(!map.containsKey(cur.neighbors.get(i)))
                {
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    queue.offer(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }

    /**
     * Depth first search
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null)
            return null;
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        stack.push(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node,copy);
        while(!stack.isEmpty())
        {
            UndirectedGraphNode cur = stack.pop();
            for(int i=0;i<cur.neighbors.size();i++)
            {
                if(!map.containsKey(cur.neighbors.get(i)))
                {
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    stack.push(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }

    /**
     * recursion
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
        if(node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node,copy);
        helper(node,map);
        return copy;
    }
    private void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map)
    {
        for(int i=0;i<node.neighbors.size();i++)
        {
            UndirectedGraphNode cur = node.neighbors.get(i);
            if(!map.containsKey(cur))
            {
                UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
                map.put(cur,copy);
                helper(cur,map);
            }
            map.get(node).neighbors.add(map.get(cur));
        }
    }
}
