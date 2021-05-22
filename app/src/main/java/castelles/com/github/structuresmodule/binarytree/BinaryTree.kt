package castelles.com.github.structuresmodule.binarytree

class BinaryTree(
    var value: Double,
    private var counter: Int = 1,
    var leftNode: BinaryTree? = null,
    var rightNode: BinaryTree? = null,
) {

    fun add(node: Double) {

        if (node > value) {
            if (rightNode != null) {
                rightNode!!.add(node)
            } else {
                rightNode = BinaryTree(node)
            }
        } else if (node < value) {
            if (leftNode != null) {
                leftNode!!.add(node)
            } else {
                leftNode = BinaryTree(node)
            }
        } else {
            counter++
        }
    }

    fun find(node: Double): BinaryTree? {
        var tree: BinaryTree? = null
        if (node > value) {
            if (rightNode != null) {
                return rightNode!!.find(node)
            } else {
                return null
            }
        } else if (node < value) {
            if (leftNode != null) {
                return leftNode!!.find(node)
            } else {
                return null
            }
        }
        return this
    }

    fun getAmount() = counter

    fun remove(node: Double) {
    
    }

}