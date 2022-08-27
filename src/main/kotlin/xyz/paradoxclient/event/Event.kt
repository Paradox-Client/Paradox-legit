package xyz.paradoxclient.event

import xyz.paradoxclient.Paradox
import xyz.paradoxclient.interfaces.ILogger

open class Event : ILogger {

    var cancelled: Boolean = false

    fun post() {
        try {
            Paradox.INSTANCE.pubSub.post(this).dispatch()
        } catch (exception: Exception) {
            logger.error("Error posting event", exception)
        }
    }
}