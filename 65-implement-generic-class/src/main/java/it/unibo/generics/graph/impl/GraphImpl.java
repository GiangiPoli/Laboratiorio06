package it.unibo.generics.graph.impl;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    //Class Fields
    private final Map<N, Set<N>> graph = new HashMap<>();

    //Class Method

    @Override
    public void addNode(N node) {
        if( assertNotNull(node) && !graph.containsKey(node) ) {
            graph.put(node, new HashSet<N>());
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if( assertNotNull(target) && assertNotNull(source) ) {
            
            /*
             * I create the source and target node if they
             * dont already exsist
             */
            graph.putIfAbsent(source, new HashSet<N>());
            graph.putIfAbsent(target, new HashSet<N>());

            graph.get(source).add(target);
        }
        
    }

    @Override
    public Set<N> nodeSet() {
        final Set<N> allGraphNodes = new HashSet<>();

        for (N node : graph.keySet()) {
            allGraphNodes.add(node);
        }

        return allGraphNodes;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        if( assertNotNull(source) && assertNotNull(target) ) {
            List<N> path = new LinkedList<>();

            List<N> temp = new LinkedList<>(this.graph.get(source));
            path.add(source);

            for (N node : temp){
                if(node.equals(target)){
                    path.add(target);
                    return path;
                }
            }

            for (N actualNode : temp){
                if (this.graph.containsKey(actualNode)){
                    List<N> subPath = new LinkedList<>(getPath(actualNode, target));
                    if(!subPath.isEmpty() && subPath.get(subPath.size() - 1).equals(target)){
                        path.addAll(subPath);
                        return path;
                    }            
                }
            }
            return path;
        } else {
            return List.of();
        }
    }

    private boolean assertNotNull(N node) {
        return node != null;
    }

}
