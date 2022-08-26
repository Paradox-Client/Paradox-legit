package xyz.paradoxclient.feature

open class Feature(val name: String, val description: String) {

    var enabled = false

    fun toggle() {
        enabled = !enabled
        if (enabled)
            onEnable()
        else
            onDisable()
    }

    open fun onEnable() {}

    open fun onDisable() {}

    override fun toString(): String {
        return name
    }
}