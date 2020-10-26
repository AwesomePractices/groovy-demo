package com.moqi.ch16

import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.ConstructorNode
import org.codehaus.groovy.ast.FieldNode
import org.codehaus.groovy.ast.GroovyClassVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.PropertyNode
import org.codehaus.groovy.control.SourceUnit
import sun.tools.jstat.SyntaxException

/**
 * 代码检查
 *
 * @author moqi On 10/26/20 17:20
 */
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

    }

    @Override
    void visitField(FieldNode node) {

    }

    @Override
    void visitProperty(PropertyNode node) {

    }
}

