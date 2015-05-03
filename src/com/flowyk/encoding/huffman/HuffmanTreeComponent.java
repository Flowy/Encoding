package com.flowyk.encoding.huffman;

import com.flowyk.encoding.Code;

import java.util.Map;

/**
 * Created by Lukas on 3. 5. 2015.
 */
abstract class HuffmanTreeComponent<VALUE> implements Comparable<HuffmanTreeComponent<VALUE>> {

    int frequency;

    public HuffmanTreeComponent(int frequency) {
        this.frequency = frequency;
    }

    abstract Map<VALUE, Code> generateCodes();
    abstract Map<VALUE, Code> generateCodes(BasicCode prefix);

    @Override
    public int compareTo(HuffmanTreeComponent<VALUE> o) {
        return Integer.compare(this.frequency, o.frequency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HuffmanTreeComponent)) return false;

        HuffmanTreeComponent that = (HuffmanTreeComponent) o;

        return frequency == that.frequency;

    }

    @Override
    public int hashCode() {
        return frequency;
    }
}
