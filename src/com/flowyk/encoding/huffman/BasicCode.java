package com.flowyk.encoding.huffman;

import com.flowyk.encoding.Code;

/**
 * Created by Lukas on 3. 5. 2015.
 */
public class BasicCode implements Code {
    private String code;

    public BasicCode() {
        this.code = "";
    }

    public BasicCode(BasicCode code) {
        this.code = code.code;
    }

    @Override
    public String asString() {
        return code;
    }

    @Override
    public byte[] asByteArray() {
        return code.getBytes();
    }

    @Override
    public String toString() {
        return asString();
    }

    void append(String append) {
        this.code += append;
    }
}
