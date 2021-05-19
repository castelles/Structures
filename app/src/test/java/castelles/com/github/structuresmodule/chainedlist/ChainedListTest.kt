package castelles.com.github.structuresmodule.chainedlist

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class ChainedListTest {

    lateinit var SUT: ChainedList<Int>

    @Before
    fun setUp() {
        SUT = ChainedList<Int>(3)
    }

    @Test
    fun chainedList_addItem_secondItemNotNull() {
        val result = SUT.add(4)
        assertNotEquals(result.next?.item, null)
    }

    @Test
    fun chainedList_listSize_twoItemsReturned() {
        val result = SUT.add(4).add(5)
        assertEquals(3, result.size())
    }
}