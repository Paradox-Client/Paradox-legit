package xyz.paradoxclient.interfaces

import org.apache.log4j.Logger
import xyz.paradoxclient.Paradox

interface ILogger {

    val logger: Logger
        get() =  Logger.getLogger(Paradox::class.java.name)
}