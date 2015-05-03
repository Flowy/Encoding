package com.flowyk.encoding;

import java.util.Map;

/**
 * Created by Lukas on 3. 5. 2015.
 */
public interface CodeConstructor<VALUE, CODE extends Code> {
    Map<VALUE, Code> getCodes();
}