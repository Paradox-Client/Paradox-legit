package xyz.paradoxclient.macro.impl

import xyz.paradoxclient.feature.Feature
import xyz.paradoxclient.macro.Macro

class ToggleFeature(val feature: Feature, fKey: Int) : Macro(fKey) {

    override fun run() {
        feature.toggle()
    }
}