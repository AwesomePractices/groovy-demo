package com.moqi.ch17

/**
 * 使用元编程定制生成器
 *
 * @author moqi On 10/27/20 14:32
 */
bldr = new A08TodoBuilder()

bldr.build {
    Prepare_Vacation(start: '02/15', end: '02/22') {
        Reserve_Flight(on: '01/01', status: 'done')
        Reserve_Hotel(on: '01/02')
        Reserve_Car(on: '01/02')
    }
    Buy_New_Mac {
        Install_QuickSilver
        Install_TextMate
        Install_Groovy {
            Run_all_tests
        }
    }
}
