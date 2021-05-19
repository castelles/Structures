package castelles.com.github.structuresmodule.chainedlist

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.lang.NullPointerException

class ChainedListTest {

    /**
     * SUT for System Under Test
     */
    private lateinit var SUT: ChainedList<Int>

    @Before
    fun setUp() {
        SUT = ChainedList(3)
    }

    @Test
    fun chainedList_addItem_secondItemNotNull() {
        val result = SUT.add(4)
        assertNotEquals(result.next?.item, null)
    }

    @Test
    fun chainedList_listSize_twoItemsReturned() {
        val result = SUT.add(4)
        assertEquals(2, result.size())
    }

    @Test
    fun chainedList_listSize_threeItemsReturned() {
        val result = SUT.add(4).add(5)
        assertEquals(3, result.size())
    }

    @Test
    fun chainedList_containItemAtTheBeginning_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        assertEquals(true, result.contains(3))
    }

    @Test
    fun chainedList_containItemAtTheMiddle_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        assertEquals(true, result.contains(5))
    }

    @Test
    fun chainedList_containItemAtTheEnding_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        assertEquals(true, result.contains(5))
    }

    @Test
    fun chainedList_doesNotContainItem_falseReturned() {
        val result = SUT.add(4).add(5).add(9)
        assertEquals(false, result.contains(7))
    }

    @Test
    fun chainedList_removeFirsItem_listWithItemRemoved() {
        val result = SUT.add(4).add(5).add(9)
        val expected = ChainedList(4).add(5).add(9)
        val end = result.remove(3)
        assertEquals(true, end!!.exactlyTo(expected))
    }

    @Test
    fun chainedList_removeItemAtTheMiddle_listWithItemRemoved() {
        val result = SUT.add(4).add(5).add(9)
        val expected = ChainedList(3).add(4).add(9)
        val end = result.remove(5)
        assertEquals(true, end!!.exactlyTo(expected))
    }

    @Test
    fun chainedList_removeEndingItem_listWithItemRemoved() {
        val result = SUT.add(4).add(5).add(9)
        val expected = ChainedList(3).add(4).add(5)
        val end = result.remove(9)
        assertEquals(true, end!!.exactlyTo(expected))
    }

    @Test
    fun chainedList_removeNonExistentItem_throwableReturned() {
        val result = SUT.add(4).add(5).add(9)

        assertThrows(NullPointerException::class.java) {
            result.remove(10)
        }
    }

    @Test
    fun chainedList_sameSizesAndItems_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(9).add(3).add(5)

        assertTrue(result.equalsTo(sameItems))
    }

    @Test
    fun chainedList_differentItemsWithSameSize_falseReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(12).add(3).add(5)

        assertFalse(result.equalsTo(sameItems))
    }

    @Test
    fun chainedList_differentSizesSameItemsInB_trueReturned() {
        val result = SUT.add(4).add(5).add(9).add(12)
        val sameItems = ChainedList(4).add(9).add(3).add(5)

        assertFalse(result.equalsTo(sameItems))
    }

    @Test
    fun chainedList_differentSizesSameItemsInA_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(9).add(3).add(5).add(12)

        assertFalse(result.equalsTo(sameItems))
    }

    @Test
    fun chainedList_containsItemsFromExpectedWithSameSize_trueReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(9).add(3).add(5)

        assertTrue(result.containsAllItems(sameItems))
    }

    @Test
    fun chainedList_containsItemsFromExpectedWithDifferentSizes_trueReturned() {
        val result = SUT.add(4).add(5).add(9).add(12)
        val sameItems = ChainedList(4).add(9).add(3).add(5)

        assertTrue(result.containsAllItems(sameItems))
    }

    @Test
    fun chainedList_doesNotContainsItemsFromExpectedWithSameSizes_falseReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(2).add(3).add(5)

        assertFalse(result.containsAllItems(sameItems))
    }

    @Test
    fun chainedList_doesNotContainsItemsWithDifferentSizes_falseReturned() {
        val result = SUT.add(4).add(5).add(9)
        val sameItems = ChainedList(4).add(9).add(3).add(5).add(12)

        assertFalse(result.containsAllItems(sameItems))
    }

    @Test
    fun chainedList_replaceFirstItemFound_listWithItemReplacedReturned() {
        val result = SUT.add(4).add(5).add(9)
        val replacement = ChainedList(3).add(4).add(7).add(9)

        result.replace(5, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_noReplacement_sameListReturned() {
        val result = SUT.add(4).add(5).add(9)
        val replacement = ChainedList(3).add(4).add(5).add(9)

        result.replace(12, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_replaceFirstItemOfList_listWithReplacementReturned() {
        val result = SUT.add(4).add(5).add(9)
        val replacement = ChainedList(7).add(4).add(5).add(9)

        result.replace(3, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_replaceLastItemOfList_listWithReplacementReturned() {
        val result = SUT.add(4).add(5).add(9)
        val replacement = ChainedList(3).add(4).add(5).add(7)

        result.replace(9, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_replaceAllItemsOfList_listWithReplacementReturned() {
        val result = SUT.add(3).add(5).add(9).add(3)
        val replacement = ChainedList(7).add(7).add(5).add(9).add(7)

        result.replaceAll(3, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_replaceSingleItemOfList_listWithReplacementReturned() {
        val result = SUT.add(3).add(5).add(9).add(3)
        val replacement = ChainedList(3).add(3).add(7).add(9).add(3)

        result.replaceAll(5, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_dontReplace_sameListReturned() {
        val result = SUT.add(3).add(5).add(9).add(3)
        val replacement = ChainedList(3).add(3).add(5).add(9).add(3)

        result.replaceAll(12, 7)

        assertTrue(result.exactlyTo(replacement))
    }

    @Test
    fun chainedList_iterateAddingOne_listWithEachItemAddedOneReturned() {
        val result = SUT.add(12).add(5).add(9).add(3)
        val replacement = ChainedList(4).add(13).add(6).add(10).add(4)

        result.forEach {
            it.item++
        }

        assertTrue(result.exactlyTo(replacement))
    }
}