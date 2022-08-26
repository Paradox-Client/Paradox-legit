package xyz.paradoxclient.feature.impl.movement

import rip.hippo.lwjeb.annotation.Handler
import xyz.paradoxclient.event.impl.EventUpdate
import xyz.paradoxclient.feature.Feature
import xyz.paradoxclient.feature.Filter

class Sprint : Feature("Sprint", "Keep sprinting", Filter.MOVEMENT) {

    init {
        toggle()
    }

    @Handler
    fun update(event: EventUpdate) {
        player.isSprinting = true
    }

    override fun onEnable() {
        super.onEnable()
        logger.info("Sprint enabled")
    }

    override fun onDisable() {
        super.onDisable()
        logger.info("Sprint disabled")
    }
}