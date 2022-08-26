package xyz.paradoxclient

import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Logger
import rip.hippo.lwjeb.bus.PubSub
import rip.hippo.lwjeb.configuration.BusConfigurations
import rip.hippo.lwjeb.configuration.config.impl.BusPubSubConfiguration
import rip.hippo.lwjeb.message.scan.impl.MethodAndFieldBasedMessageScanner
import xyz.paradoxclient.event.Event
import xyz.paradoxclient.interfaces.ILogger
import xyz.paradoxclient.manager.ManagerManager

enum class Paradox : ILogger {

    INSTANCE;

    val client = "Paradox"
    val version = "1.0.0"
    val developers = listOf("Exeos")

    val manager = ManagerManager()

    val pubSub = PubSub<Event>(BusConfigurations.Builder().setConfiguration(BusPubSubConfiguration::class.java) {
        val busPubSubConfiguration = BusPubSubConfiguration.getDefault()
        busPubSubConfiguration.setScanner(MethodAndFieldBasedMessageScanner<Any>())
        busPubSubConfiguration
    }.build())

    fun start() {
        BasicConfigurator.configure()
        logger.info("Only Download Paradox from our github page!")
        logger.info("Initializing Paradox...")

        manager.run()

        logger.info("Successfully initialized Paradox! ;-)")
        logger.info("$client v$version by ${developers.joinToString()}")
    }
}