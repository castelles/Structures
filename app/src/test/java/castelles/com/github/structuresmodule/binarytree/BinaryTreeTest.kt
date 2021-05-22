package castelles.com.github.structuresmodule.binarytree

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BinaryTreeTest {

    private lateinit var SUT: BinaryTree

    @Before
    fun setUp() {
        SUT =  BinaryTree(25.4)
    }

    @Test
    fun binaryTree_addHigherValue_rightNodeNotNull() {
        SUT.add(30.0)
        assertNotNull(SUT.rightNode)
        assertEquals(30.0, SUT.rightNode!!.value, 0.1)
    }

    @Test
    fun binaryTree_addLowerValue_leftNodeNotNull() {
        SUT.add(12.0)
        assertNotNull(SUT.leftNode)
        assertEquals(12.0, SUT.leftNode!!.value, 0.1)
    }

    @Test
    fun binaryTree_findLeftNode_leftNodeReturned() {
        SUT.add(12.0)
        SUT.add(30.0)
        SUT.add(35.0)
        assertEquals(35.0, SUT.find(35.0)!!.value, 0.1)
    }
}