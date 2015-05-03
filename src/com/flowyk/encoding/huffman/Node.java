package com.flowyk.encoding.huffman;

import com.flowyk.encoding.Code;

import java.util.Map;

/**
 * Created by Lukas on 3. 5. 2015.
 */
class Node<VALUE> extends HuffmanTreeComponent<VALUE> {
    HuffmanTreeComponent<VALUE> a;
    HuffmanTreeComponent<VALUE> b;

    public Node(HuffmanTreeComponent<VALUE> a, HuffmanTreeComponent<VALUE> b) {
        super(a.frequency + b.frequency);
        if (a.frequency > b.frequency) {
            this.a = a;
            this.b = b;
        } else {
            this.a = b;
            this.b = a;
        }
    }

    @Override
    Map<VALUE, Code> generateCodes() {
        return generateCodes(new BasicCode());
    }

    @Override
    Map<VALUE, Code> generateCodes(BasicCode prefix) {
        BasicCode aPrefix = new BasicCode(prefix);
        aPrefix.append("0");
        BasicCode bPrefix = new BasicCode(prefix);
        bPrefix.append("1");
        Map<VALUE, Code> aCodes = a.generateCodes(aPrefix);
        Map<VALUE, Code> bCodes = b.generateCodes(bPrefix);
        aCodes.putAll(bCodes);
        return aCodes;
    }
}