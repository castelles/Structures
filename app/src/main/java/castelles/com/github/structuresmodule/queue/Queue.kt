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

}