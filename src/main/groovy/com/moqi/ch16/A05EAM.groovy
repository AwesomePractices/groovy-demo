package com.moqi.ch16

import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * 使用 AST 变换注入方法
 *
 * @author moqi On 10/27/20 10:31
 */
@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.TYPE])
@GroovyASTTransformationClass("com.moqi.ch16.A06EAMTransformation")

public @interface A05EAM {
}
