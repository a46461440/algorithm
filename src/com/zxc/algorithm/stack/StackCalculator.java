package com.zxc.algorithm.stack;

import java.util.Stack;

/**
 * 栈实现的计数器
 *
 * @author ZRM
 * @date 2019-09-09
 */
public class StackCalculator {

    private enum Priority {
        /**
         * 高
         */
        HIGH,

        /**
         * 低
         */
        LOW,
        ;

        public static Priority judge(String operator) {
            if (operator.equals("+") || operator.equals("-")) {
                return LOW;
            } else if (operator.equals("*") || operator.equals("/")) {
                return HIGH;
            } else {
                return LOW;
            }
        }
    }

    private Stack<Integer> numberStack = new Stack();

    private Stack<String> operatorStack = new Stack();

    private Boolean isOperation(String o) {
        if (o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private Integer calc(Integer a, Integer b, String operation) {
        if (operation.equals("*")) {
            return a * b;
        } else if (operation.equals("/")) {
            return a / b;
        } else if (operation.equals("+")) {
            return a + b;
        } else if (operation.equals("-")) {
            return a - b;
        } else {
            return 0;
        }
    }

    public Integer caculator(String express) {
        String[] str = express.split(" ");
        boolean rightNowFlag = false;
        for (int i = 0; i < str.length; i++) {
            String o = str[i];
            if (this.isOperation(o)) {
                this.operatorStack.push(o);
                if (Priority.judge(o).name().equals(Priority.HIGH.name())) {
                    rightNowFlag = true;
                }
            } else {
                this.numberStack.push(Integer.valueOf(o));
                if (rightNowFlag) {
                    Integer a = this.numberStack.pop();
                    Integer b = this.numberStack.pop();
                    String operation = this.operatorStack.pop();
                    this.numberStack.push(this.calc(b, a, operation));
                    rightNowFlag = false;
                }
            }
        }
        while (!this.numberStack.empty()) {
            Integer result = this.calc(this.numberStack.pop(),
                    this.numberStack.pop(), this.operatorStack.pop());
            if (this.numberStack.empty()) {
                this.numberStack.push(result);
                break;
            } else {
                this.numberStack.push(result);
            }
        }
        return this.numberStack.pop();
    }

}
