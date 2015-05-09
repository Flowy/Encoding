package com.flowyk.encoding;

import com.flowyk.encoding.huffman.HuffmanCode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        String inputString;
        if (args.length > 0) {
            inputString = args[0];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("P");
            stringBuilder.append("OO");
            stringBuilder.append("NNN");
            stringBuilder.append("MMM");
            stringBuilder.append("LLL");
            stringBuilder.append("KKK");
            stringBuilder.append("JJJ");
            stringBuilder.append("III");
            stringBuilder.append("HHHH");
            stringBuilder.append("GGGG");
            stringBuilder.append("FFFFF");
            stringBuilder.append("EEEEE");
            stringBuilder.append("DDDDD");
            stringBuilder.append("CCCCC");
            stringBuilder.append("BBBBB");
            stringBuilder.append("AAAAA");
            stringBuilder.append(".....");
            stringBuilder.append("))))))))");
            stringBuilder.append("((((((((");
            stringBuilder.append("////////////////////");
            inputString = stringBuilder.toString();
        }
        CodeConstructor<String, Code> codeConstructor = new HuffmanCode<>(Arrays.asList(inputString.split("")));
        System.out.println("Vstupny retazec: " + inputString);
        System.out.println("Vygenerovane kody podla huffmanovho kodovania: " + codeConstructor.getCodes());
    }
}
