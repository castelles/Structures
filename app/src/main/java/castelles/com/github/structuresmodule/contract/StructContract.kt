package castelles.com.github.structuresmodule.contract

interface StructContract<T> {

    fun add(item: T)
    fun remove(item: T)
    fun size(): Int

}