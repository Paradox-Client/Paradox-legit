package xyz.paradoxclient

import org.apache.log4j.BasicConfigurator
import org.lwjgl.input.Keyboard
import rip.hippo.lwjeb.annotation.Handler
import rip.hippo.lwjeb.bus.PubSub
import rip.hippo.lwjeb.configuration.BusConfigurations
import rip.hippo.lwjeb.configuration.config.impl.BusPubSubConfiguration
import rip.hippo.lwjeb.message.scan.impl.MethodAndFieldBasedMessageScanner
import xyz.paradoxclient.event.Event
import xyz.paradoxclient.event.impl.EventKey
import xyz.paradoxclient.feature.impl.movement.Sprint
import xyz.paradoxclient.interfaces.ILogger
import xyz.paradoxclient.macro.Macro
import xyz.paradoxclient.macro.impl.ToggleFeature
import xyz.paradoxclient.manager.ManagerManager
import xyz.paradoxclient.manager.impl.FeatureManager
import xyz.paradoxclient.manager.impl.MacroManager

enum class Paradox : ILogger {

    INSTANCE;

    val client = "Paradox"
    val version = "1.0.0"
    val developers = listOf("Exeos", "Kroko", "Solastis")

    private val manager = ManagerManager()

    private val featureManager: FeatureManager = manager.getManager(FeatureManager::class.java)
    val macroManager: MacroManager = manager.getManager(MacroManager::class.java)

    val pubSub = PubSub<Event>(BusConfigurations.Builder().setConfiguration(BusPubSubConfiguration::class.java) {
        val busPubSubConfiguration = BusPubSubConfiguration.getDefault()
        busPubSubConfiguration.setScanner(MethodAndFieldBasedMessageScanner<Any>())
        busPubSubConfiguration
    }.build())

    fun start() {
        BasicConfigurator.configure()
        logger.info("Only Download Paradox from our github page!")
        logger.info("Initializing Paradox...")
        manager.startManagers()

        pubSub.subscribe(this)
        logger.info("Successfully initialized Paradox! ;-)")
        logger.info("$client v$version by ${developers.joinToString()}")
    }

    @Handler
    fun key(event: EventKey) {
        macroManager.macros.stream().filter { macro -> macro.key == event.key }.forEach { it.run() }
    }
}