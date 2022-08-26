package xyz.paradoxclient.manager.impl

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import xyz.paradoxclient.feature.Feature
import xyz.paradoxclient.manager.Manager
import java.util.function.Consumer
import java.util.stream.Collectors

class FeatureManager : Manager() {

    val features = ArrayList<Feature>()

    override fun run() {
        val reflections = Reflections("xyz.paradox.feature.impl", SubTypesScanner(false))
        reflections.getSubTypesOf(Feature::class.java).stream().collect(Collectors.toSet()).forEach(Consumer { feature: Class<out Feature> -> features.add(feature.newInstance()) })
    }
}