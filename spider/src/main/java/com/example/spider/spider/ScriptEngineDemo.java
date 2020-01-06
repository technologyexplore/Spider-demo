package com.example.spider.spider;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author windows 10
 */
public class ScriptEngineDemo {

    static ScriptEngineManager manager = new ScriptEngineManager();
    static ScriptEngine engine = manager.getEngineByName("JavaScript");

    public static void main(String[] args) {
        // window document
        // JavaScript脚本
        String script = "function add(op1,op2){return op1+op2};";
        try {
            engine.eval(script);
            Invocable invoke = (Invocable) engine;
            // 模拟js执行
            Object c = invoke.invokeFunction("add", 111, 222);
            // 打印结果
            System.out.println("JavaScript 运算结果：c=" + c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
