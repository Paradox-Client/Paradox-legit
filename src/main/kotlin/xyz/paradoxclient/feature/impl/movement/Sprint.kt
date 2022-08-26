package xyz.paradoxclient.feature.impl.movement

import rip.hippo.lwjeb.annotation.Handler
import xyz.paradoxclient.event.impl.EventUpdate
import xyz.paradoxclient.feature.Feature
import xyz.paradoxclient.feature.Filter

class Sprint : Feature("Sprint", "Keep sprinting", Filter.MOVEMENT) {

    @Handler
    fun update(event: EventUpdate) {
        gameSettings.keyBindSprint.pressed = true
    }

    override fun onDisable() {
        super.onDisable()
        gameSettings.keyBindSprint.pressed = false
        player.isSprinting = false
    }
}