package com.moqi.ch16

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import static groovyjarjarasm.asm.Opcodes.ACC_PUBLIC
import static groovyjarjarasm.asm.Opcodes.ACC_STATIC

/**
 * 使用 AST 变换注入方法
 *
 * @author moqi On 10/27/20 10:33
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class A06EAMTransformation implements ASTTransformation {
    @Override
    void visit(ASTNode[] aSTNodes, SourceUnit sourceUnit) {

        aSTNodes.findAll { node -> node instanceof ClassNode }.each { classNode ->
            def useMethodBody = new AstBuilder().buildFromCode {
                def instance = newInstance()

                try {
                    instance.open()
                    instance.with block
                } finally {
                    instance.close()
                }
            }

            def useMethod = new MethodNode(
                    'use', ACC_PUBLIC | ACC_STATIC, ClassHelper.OBJECT_TYPE,
                    [new Parameter(ClassHelper.OBJECT_TYPE, 'block')] as Parameter[],
                    [] as ClassNode[], useMethodBody[0])

            classNode.addMethod(useMethod)
        }

    }
}
