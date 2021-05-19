package castelles.com.github.structuresmodule.live


open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    /**
     * Get content if not handled
     * or return null
     */
    fun handleBy(eventHandler: (T) -> Unit) {
        if (!hasBeenHandled) {
            hasBeenHandled = true
            eventHandler.invoke(content)
        }
    }

    fun peekContent(): T = content

    companion object {
        const val TAG = "OBSERVER_HANDLER"
    }

}