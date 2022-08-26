package xyz.paradoxclient.macro

abstract class Macro(val key: Int) : Runnable {

    abstract override fun run()
}