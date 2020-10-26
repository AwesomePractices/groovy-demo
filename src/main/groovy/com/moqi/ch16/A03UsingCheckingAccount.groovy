package com.moqi.ch16

/**
 * 使用 AST 变换拦截方法调用
 *
 * @author moqi On 10/26/20 17:40
 */
class A03CheckingAccount {
    def audit(amount) {
        if (amount > 10000) println("auditing...")
    }

    def deposit(amount) {
        println("depositing ${amount}...")
    }

    def withdraw(amount) {
        println("withdrawing ${amount}...")
    }
}

def account = new A03CheckingAccount()
account.deposit(1000)
account.deposit(12000)
account.withdraw(11000)
