package com.flowyk.encoding.huffman;

import com.flowyk.encoding.Code;
import com.flowyk.encoding.CodeConstructor;

import java.util.*;

/**
 * Created by Lukas on 3. 5. 2015.
 */
public class HuffmanCode<VALUE extends Comparable<VALUE>>
        implements CodeConstructor<VALUE, Code> {

    private Map<VALUE, Code> generatedCodes;

    public HuffmanCode(Collection<VALUE> input) {
        Queue<HuffmanTreeComponent<VALUE>> leafs = parseInput(input);
        reduce(leafs);
        HuffmanTreeComponent<VALUE> root = leafs.remove();
        generatedCodes = root.generateCodes();
    }

    @Override
    public Map<VALUE, Code> getCodes() {
        return generatedCodes;
    }

    private Queue<HuffmanTreeComponent<VALUE>> parseInput(Collection<VALUE> input) {
        Map<VALUE, Integer> parsingInput = new TreeMap<>();
        for (VALUE value: input) {
            Integer frequency = parsingInput.get(value);
            if (frequency == null) {
                parsingInput.put(value, 1);
            } else {
                parsingInput.put(value, frequency + 1);
            }
        }
        PriorityQueue<HuffmanTreeComponent<VALUE>> leafs = new PriorityQueue<>(parsingInput.size());
        for (Map.Entry<VALUE, Integer> mapEntry: parsingInput.entrySet()) {
            Leaf<VALUE> newLeaf = new Leaf<>(mapEntry.getKey(), mapEntry.getValue());
            leafs.add(newLeaf);
        }
        return leafs;
    }

    private void reduce(Queue<HuffmanTreeComponent<VALUE>> sortedInput) {
        while (sortedInput.size() > 1) {
            HuffmanTreeComponent<VALUE> b = sortedInput.remove();
            HuffmanTreeComponent<VALUE> a = sortedInput.remove();
            sortedInput.add(new Node<>(a, b));
        }
    }
}
