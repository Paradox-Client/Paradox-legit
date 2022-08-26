package xyz.paradoxclient.manager

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import java.util.function.Consumer
import java.util.stream.Collectors

class ManagerManager {

    private val managers = ArrayList<Manager>()

    init {
        val reflections = Reflections("xyz.paradoxclient.manager.impl", SubTypesScanner(false))
        reflections.getSubTypesOf(Manager::class.java).stream().collect(Collectors.toSet()).forEach(Consumer { manager: Class<out Manager> -> managers.add(manager.newInstance()); println("ROFL") })
    }

    fun startManagers() {
        managers.forEach { Thread(it).start() }
    }

    fun <T : Manager?> getManager(managerClass: Class<T>): T {
        return managers.stream().filter { it.javaClass == managerClass }.findFirst().orElse(null) as T
    }
}