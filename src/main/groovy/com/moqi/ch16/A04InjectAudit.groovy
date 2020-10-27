package com.moqi.ch16

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

/**
 * 注入审计检测
 *
 * @author moqi On 10/26/20 17:45
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class A04InjectAudit implements ASTTransformation {
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def checkingAccountClassNode = astNodes[0].classes.find { it.name == 'CheckingAccount' }
        injectAuditMethod(checkingAccountClassNode)
    }

    static void injectAuditMethod(checkingAccountClassNode) {
        def nonAuditMethods = checkingAccountClassNode?.methods?.findAll { it.name != 'audit' }
        nonAuditMethods?.each { injectMethodWithAudit(it) }
    }

    // 第一个版本
    /*static void injectMethodWithAudit(methodNode) {
        def callToAudit = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('this'),
                        'audit',
                        new ArgumentListExpression(methodNode.parameters)
                )
        )

        methodNode.code.statements.add(0, callToAudit)
    }*/

    // 第二个版本
    /*static void injectMethodWithAudit(methodNode) {
        List<Statement> statements = new AstBuilder().buildFromSpec {
            expression {
                methodCall {
                    variable 'this'
                    constant 'audit'
                    argumentList {
                        methodNode.parameters.each { variable it.name }
                    }
                }
            }
        }

        def callToCheck = statements[0]
        methodNode.code.statements.add(0, callToCheck)
    }*/

    static void injectMethodWithAudit(methodNode) {
        // def codeAsString = 'audit(amount)'
        List<Statement> statements = new AstBuilder().buildFromCode { audit(amount) }

        def callToAudit = statements[0].statements[0].expression
        methodNode.code.statements.add(0, new ExpressionStatement(callToAudit))
    }
}
