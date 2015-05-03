package com.flowyk.encoding;

import com.flowyk.encoding.huffman.HuffmanCode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringBuilder inputString = new StringBuilder();
        inputString.append("P");
        inputString.append("OO");
        inputString.append("NNN");
        inputString.append("MMM");
        inputString.append("LLL");
        inputString.append("KKK");
        inputString.append("JJJ");
        inputString.append("III");
        inputString.append("HHHH");
        inputString.append("GGGG");
        inputString.append("FFFFF");
        inputString.append("EEEEE");
        inputString.append("DDDDD");
        inputString.append("CCCCC");
        inputString.append("BBBBB");
        inputString.append("AAAAA");
        inputString.append(".....");
        inputString.append("))))))))");
        inputString.append("((((((((");
        inputString.append("////////////////////");
        CodeConstructor<String, Code> codeConstructor = new HuffmanCode<>(Arrays.asList(inputString.toString().split("")));
        System.out.println(codeConstructor.getCodes());
    }
}
