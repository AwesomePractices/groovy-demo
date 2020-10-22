package com.moqi.ch02

/**
 * @author moqi On 9/24/20 22:33
 */
class A06ChainCall {

    static void main(String[] args) {
        Wizard.learn('alohomora', {/*...*/ })
                .learn('expelliarmus', {/*...*/ })
                .learn('lumos', {/*...*/ })
    }

}

/**
 * 静态方法内可以使用 this 来引用 Class 对象
 */
class Wizard {

    /**
     * learn 返回的是 Class 对象，所以可以使用链式调用
     */
    def static learn(trick, action) {
        // ...
        this
    }

}
