package castelles.com.github.structuresmodule.live

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

open class LiveEvent<T> : MutableLiveData<Event<T>>() {

    fun executeEvent(content: T) {
        postValue(Event(content))
    }

    fun observeAt(owner: LifecycleOwner, handle: (T) -> Unit) {
        observe(owner) { event ->
            event?.handleBy {
                handle.invoke(event.peekContent())
            }
        }
    }
}