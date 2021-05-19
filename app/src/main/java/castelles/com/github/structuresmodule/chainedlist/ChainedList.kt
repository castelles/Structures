package castelles.com.github.structuresmodule.chainedlist

class ChainedList<T>(var item: T) {

    var next: ChainedList<T>? = null

    fun size(): Int {
        var size = 0
        if (next != null) {
            size++
            size += next!!.size()
        } else {
            return 1
        }
        return size
    }

    fun add(item: T): ChainedList<T> {
        var list: ChainedList<T>? = this
        var temp = list
        if (list != null) {
            while (list != null) {
                temp = list
                list = list.next
            }
            temp?.next = ChainedList(item)
        }
        return this
    }

}