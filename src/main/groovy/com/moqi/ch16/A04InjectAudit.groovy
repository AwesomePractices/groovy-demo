package com.moqi.ch16

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
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
        def checkingAccountClassNode = astNodes[0].classes.find {it.name == 'CheckingAccount'}
        injectAuditMethod(checkingAccountClassNode)
    }

    static void injectAuditMethod(checkingAccountClassNode) {
        def nonAuditMethods = checkingAccountClassNode?.methods?.findAll {it.name != 'audit'}
        nonAuditMethods?.each {injectMethodWithAudit(it)}
    }

    static void injectMethodWithAudit(methodNode) {
        def callToAudit = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('this'),
                        'audit',
                        new ArgumentListExpression(methodNode.parameters)
                )
        )

        methodNode.code.statements.add(0, callToAudit)
    }
}
