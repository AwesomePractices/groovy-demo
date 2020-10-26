package com.moqi.ch16

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.ConstructorNode
import org.codehaus.groovy.ast.FieldNode
import org.codehaus.groovy.ast.GroovyClassVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.PropertyNode
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import sun.tools.jstat.SyntaxException

/**
 * 代码检查
 *
 * @author moqi On 10/26/20 17:20
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class A02CodeCheck implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit sourceUnit) {
        sourceUnit.ast.classes.each {classNode ->
            classNode.visitContents(new A02OurClassVisitor(sourceUnit))
        }
    }
}


class A02OurClassVisitor implements GroovyClassVisitor {

    SourceUnit sourceUnit
    A02OurClassVisitor(theSourceUnit) {sourceUnit = theSourceUnit}

    private void reportError(message, lineNumber, columnNumber) {
        sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber))
    }

    @Override
    void visitClass(ClassNode node) {

    }

    @Override
    void visitConstructor(ConstructorNode node) {

    }

    @Override
    void visitMethod(MethodNode node) {
        if(node.name.size() == 1) {
            reportError("Make method name descriptive, avoid single letter names", node.lineNumber, node.columnNumber)

            node.parameters.each {parameter ->
                if (parameter.name.size() == 1) {
                    reportError("Single letter parameters are morally wrong!", parameter.lineNumber, parameter.columnNumber)
                }
            }
        }
    }

    @Override
    void visitField(FieldNode node) {

    }

    @Override
    void visitProperty(PropertyNode node) {

    }
}


