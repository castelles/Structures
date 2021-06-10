package castelles.com.github.structuresmodule.queue

import java.io.IOException

class Queue<T>(
    var item: T,
    var next: Queue<T>? = null,
    private var isFirst: Boolean = true
) {

    fun insert(item: T) {
        var iterator = this
        while (iterator.next != null) {
            iterator = iterator.next!!
        }
        iterator.next = Queue(item, null, false)
    }

    @Throws(IOException::class)
    fun remove() {
        if (isFirst) { stepOnePosition() }
        else throw IOException("You cannot remove an item in the middle of the queue.")
    }

    private fun stepOnePosition() {

        var iterator: Queue<T>? = this
        var iteratorBefore: Queue<T>? = null

        while (iterator!!.next != null) {

            iterator.apply {
                this.item = this.next!!.item
                iteratorBefore = this
            }

            iterator = iterator.next

        }
        iteratorBefore!!.next = null
    }

    @Throws(IOException::class)
    fun size(): Int {
        if (this.isFirst) {
            var size = 0
            forEach {
                size++
            }
            return size
        } else throw IOException("Cannot get size from a middle item.")
    }

    fun forEach(iterator: (Queue<T>) -> Unit) {
        var iteratorItem: Queue<T>? = this
        while (iteratorItem != null) {
            iterator(iteratorItem)
            iteratorItem = iteratorItem.next
        }
    }

}