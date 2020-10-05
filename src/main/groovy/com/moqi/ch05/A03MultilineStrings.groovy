package com.moqi.ch05

/**
 * 多行字符串
 *
 * @author moqi On 10/5/20 10:17
 */
memo = '''Several of you raised concerns about long meetings.
To discuss this, we will be holding a 3 hour meeting starting
at 9AM tomorrow. All getting this memo are required to attend.
If you can't make it, please have a meeting with your manager to explain.
'''

println memo


price = 251.12

message = """We're very pleased to announce
that our stock price hit a high of \$${price} per share
on December 24th. Great news in time for...
"""

println message
println()

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']
content = new StringBuilder()
langs.each { language, author ->
    content.append("""
        <language name = "${language}">
            <autohr>${author}</author>
        </language>
    """)
}

xml = "    <languages>${content.toString()}</languages>"
println(xml)
