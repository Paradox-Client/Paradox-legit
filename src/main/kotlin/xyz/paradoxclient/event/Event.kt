package xyz.paradoxclient.event

import xyz.paradoxclient.Paradox
import xyz.paradoxclient.logger.ILogger

open class Event : ILogger() {

    var cancelled: Boolean = false

    fun post() {
        try {
            Paradox.INSTANCE.pubSub.post(this).dispatch()
        } catch (exception: Exception) {
            logger.error("Error posting event", exception)
        }
    }

    companion object : ILogger() {
        fun post(event: Event) {
            try {
                Paradox.INSTANCE.pubSub.post(event).dispatch()
            } catch (exception: Exception) {
                logger.error("Error posting event", exception)
            }
        }
    }
}