package xyz.paradoxclient.feature

import xyz.paradoxclient.Paradox
import xyz.paradoxclient.interfaces.ILogger
import xyz.paradoxclient.interfaces.IMinecraft

open class Feature(val name: String, val description: String, val filter: Filter) : IMinecraft, ILogger {

    var enabled = false

    fun toggle() {
        enabled = !enabled
        if (enabled)
            onEnable()
        else
            onDisable()
    }

    open fun onEnable() {
        Paradox.INSTANCE.pubSub.subscribe(this)
    }

    open fun onDisable() {
        Paradox.INSTANCE.pubSub.unsubscribe(this)
    }

    override fun toString(): String {
        return name
    }
}