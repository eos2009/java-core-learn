package com.chenfei.io;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author chenfei
 * @description
 * @since 2019/5/9
 */
public enum Calculator {
    Instance;
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}