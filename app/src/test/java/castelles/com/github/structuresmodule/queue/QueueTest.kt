package castelles.com.github.structuresmodule.queue

import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

class QueueTest {

    private lateinit var SUT: Queue<Int>

    @Before
    fun setUp() {
        SUT = Queue(3)
    }

    @Test
    fun insertItem_queueWithTwoItems() {
        SUT.insert(4)
        assertEquals(4, SUT.next!!.item)
    }


    @Test
    fun removeItem_firstItemRemovedSuccessfullyAndNextIsNull() {

        SUT.apply {
            insert(4)
            remove()
        }

        assertEquals(4, SUT.item)
        assertNull(SUT.next)
    }

    @Test
    fun removeItem_firstItemRemovedSuccessfullyAndNextNotNull() {

        SUT.apply {
            insert(4)
            insert(5)
            insert(6)
            remove()
        }

        assertEquals(4, SUT.item)
        assertNotNull(SUT.next)
    }

    @Test
    fun removeMiddleItem_throwError() {

        SUT.apply {
            insert(4)
            insert(5)
            insert(6)
        }

        assertThrows(IOException::class.java) {
            SUT.next?.next?.remove()
        }
    }

    @Test
    fun getSize_queueWithOneElement() {
        Assert.assertEquals(1, SUT.size())
    }

    @Test
    fun getSize_queueWithTwoElements() {
        SUT.apply {
            insert(4)
        }
        Assert.assertEquals(2, SUT.size())
    }

    @Test
    fun getSize_queueWithMultipleElements() {
        SUT.apply {
            insert(4)
            insert(5)
            insert(6)
        }
        Assert.assertEquals(4, SUT.size())
    }

    @Test
    fun getSizeFromMiddleElement_IOExceptionThrows() {
        SUT.apply {
            insert(4)
            insert(5)
            insert(6)
        }

        assertThrows(IOException::class.java) {
            SUT.next?.next?.size()
        }
    }
}