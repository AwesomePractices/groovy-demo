package com.moqi.ch13

/**
 * Inject Instance MetaClass
 *
 * @author moqi* On 10/23/20 19:06
 */
class A06Person {
  def play() { println 'playing...' }
}

def emc = new ExpandoMetaClass(A06Person)
emc.sing = { ->
  'oh baby baby...'
}
emc.initialize()

def jack = new A06Person()
def paul = new A06Person()

jack.metaClass = emc

println jack.sing()

try {
  paul.sing()
} catch(ex) {
  println ex
}



jack.metaClass = null
try {
  jack.play()
  jack.sing()
} catch(ex) {
  println ex
}
