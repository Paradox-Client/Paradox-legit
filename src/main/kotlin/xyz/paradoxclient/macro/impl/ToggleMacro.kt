package xyz.paradoxclient.macro.impl

import xyz.paradoxclient.feature.Feature
import xyz.paradoxclient.macro.Macro

class ToggleMacro(val feature: Feature, mKey: Int) : Macro(mKey) {

    override fun run() {
        feature.toggle()
    }
}