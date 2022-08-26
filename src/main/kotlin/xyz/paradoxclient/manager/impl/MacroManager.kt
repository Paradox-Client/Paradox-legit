package xyz.paradoxclient.manager.impl

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import xyz.paradoxclient.macro.Macro
import xyz.paradoxclient.manager.Manager
import java.util.function.Consumer
import java.util.stream.Collectors

class MacroManager : Manager() {

    val macros = ArrayList<Macro>()

    override fun run() {
        val reflections = Reflections("xyz.paradoxclient.macro.impl", SubTypesScanner(false))
        reflections.getSubTypesOf(Macro::class.java).stream().collect(Collectors.toSet()).forEach(Consumer { macro: Class<out Macro> -> macros.add(macro.newInstance()) })
    }
}