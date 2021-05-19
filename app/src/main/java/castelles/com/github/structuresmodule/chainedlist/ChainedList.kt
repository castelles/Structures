package castelles.com.github.structuresmodule.chainedlist

import java.lang.NullPointerException

class ChainedList<T>(
    var item: T,
    var next: ChainedList<T>? = null
) {

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

    fun addAt(index: Int, item: T) {

        if (index > size()) throw IndexOutOfBoundsException()
        else {
            val counter = 0
            forEach {
                if (counter == index) {

                }
            }
        }
    }

    fun contains(item: T): Boolean {
        var list: ChainedList<T>? = this
        while (list != null) {
            if (list.item == item) return true
            list = list.next
        }
        return false
    }

    fun remove(item: T): ChainedList<T>? {
        var list: ChainedList<T>? = this
        if (contains(item)) {
            var before = list
            forEach {

                val temp: ChainedList<T> = it
                if (it.item == item) {
                    if (list == temp) {
                        return list?.next
                    }
                    list = temp.next
                    before?.next = list
                } else {
                    if (temp != before) {
                        before = before?.next
                    }
                }

            }
            return this
        } else throw NullPointerException("Item not found.")
    }

    inline fun forEach(action: (ChainedList<T>) -> Unit) {
        var list: ChainedList<T>? = this
        while (list != null) {
            action(list)
            list = list.next
        }
    }

    fun exactlyTo(list: ChainedList<T>): Boolean {
        if (size() != list.size()) return false
        else {
            var itemFromList: ChainedList<T>? = list

            forEach {
                if (itemFromList?.item != it.item) return false
                else itemFromList = itemFromList?.next
            }

            return true
        }
    }

    fun equalsTo(list: ChainedList<T>): Boolean {
        if (list.size() != size()) return false
        forEach {
            if (!list.contains(it.item)) return false
        }
        return true
    }

    fun containsAllItems(list: ChainedList<T>): Boolean {
        list.forEach {
            if (!this.contains(it.item)) return false
        }
        return true
    }

    fun replace(itemToReplace: T, replaceWith: T) {
        forEach {
            if (it.item == itemToReplace) {
                it.item = replaceWith
                return@forEach
            }
        }
    }

    fun replaceAll(itemToReplace: T, replaceWith: T) {
        forEach {
            if (it.item == itemToReplace) {
                it.item = replaceWith
            }
        }
    }

}