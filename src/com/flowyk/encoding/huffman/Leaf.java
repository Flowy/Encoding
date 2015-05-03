package com.flowyk.encoding.huffman;

import com.flowyk.encoding.Code;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Lukas on 3. 5. 2015.
 */
class Leaf<VALUE> extends HuffmanTreeComponent<VALUE> {
    private VALUE value;

    public Leaf(VALUE value, int frequency) {
        super(frequency);
        if (value == null) {
            throw new NullPointerException("Value can not be null");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "value='" + value +
                "', frequency=" + frequency +
                '}';
    }

    @Override
    Map<VALUE, Code> generateCodes() {
        Map<VALUE, Code> codes = new TreeMap<>();
        BasicCode code = new BasicCode();
        code.append("0");
        codes.put(value, code);
        return codes;
    }

    @Override
    Map<VALUE, Code> generateCodes(BasicCode prefix) {
        Map<VALUE, Code> codes = new TreeMap<>();
        codes.put(value, prefix);
        return codes;
    }
}
