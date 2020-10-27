package com.moqi.ch17

/**
 * 使用 FactoryBuilderSupport
 *
 * @author moqi On 10/27/20 14:44
 */
def bldr = new A11RobotBuilder()

def robot = bldr.robot('iRobot') {
    forward(dist: 20)
    left(rotation: 90)
    forward(speed: 10, duration: 5)
}

robot.go()


class A11RobotBuilder extends FactoryBuilderSupport {
    {
        registerFactory('robot', new A11RobotFactory())

        registerFactory('forward', new A11ForwardMoveFactory())

        registerFactory('left', new A11LeftTurnFactory())
    };
}


class A11Robot {
    String name
    def movements = []

    void go() {
        println "A11Robot $name operationg..."
        movements.each { movement -> println movement }
    }
}

class A11ForwardMove {
    def dist

    String toString() { "move distance... $dist" }
}

class A11LeftTurn {
    def rotation

    String toString() { "turn left... $rotation degrees" }
}


// Except of AbstractFactory.java - part of Groovy
/*
public abstract class AbstractFactory implements Factory
{
  public boolean isLeaf() { return false; }

  public boolean onHandleNodeAttributes(FactoryBuilderSupport builder,
					Object node, Map attributes) { return true; }

  public void onNodeCompleted(FactoryBuilderSupport builder,
			      Object parent, Object child) { }

  public void setParent(FactoryBuilderSupport builder,
			Object parent, Object child) { }

  public void setChild(FactoryBuilderSupport builder,
		       Object parent, Object child) { }
}
*/


class A11RobotFactory extends AbstractFactory {
    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new A11Robot(name: value)
    }

    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.movements << child
    }
}

class A11ForwardMoveFactory extends AbstractFactory {
    boolean isLeaf() { true }

    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new A11ForwardMove()
    }

    boolean onHandleNodeAttributes(FactoryBuilderSupport builder,
                                   Object node, Map attributes) {
        if (attributes.speed && attributes.duration) {
            node.dist = attributes.speed * attributes.duration
            attributes.remove('speed')
            attributes.remove('duration')
        }

        true
    }
}

class A11LeftTurnFactory extends AbstractFactory {
    boolean isLeaf() { true }

    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new A11LeftTurn()
    }
}


def robotBldr = new A11RobotBuilder()
robotBldr.robot('bRobot') {
    forward(dist: 20) {}
}

