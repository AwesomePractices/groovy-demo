package com.moqi.ch17

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.FlowLayout

/**
 * 构建 Swing
 *
 * @author moqi On 10/27/20 14:28
 */
bldr = new SwingBuilder()

frame = bldr.frame(
        title: 'Swing',
        size: [50, 100],
        layout: new FlowLayout(),
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
) {
    lbl = label(text: 'test')
    btn = button(text: 'Click me', actionPerformed: {
        btn.text = 'Clicked'
        lbl.text = "Groovy!"
    })
}

// show 方法过期了
// frame.show()
frame.setVisible(true)
