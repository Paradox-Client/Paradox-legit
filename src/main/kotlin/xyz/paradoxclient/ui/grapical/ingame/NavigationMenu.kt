package xyz.paradoxclient.ui.grapical.ingame

import xyz.paradoxclient.ui.grapical.ingame.item.Item
import xyz.paradoxclient.utils.MouseUtil
import xyz.paradoxclient.utils.RenderUtil
import java.awt.Color

class NavigationMenu(val parentGUI: IgMaterialGUI) {

    var extended = false

    val items = ArrayList<Item>()

    var width = 10.0

    fun render(mouseX: Int, mouseY: Int) {
        extended = MouseUtil.isInside(mouseX, mouseY, parentGUI.x, parentGUI.y, width, parentGUI.gHeight)
        if (extended) {
            width = 70.0
            for (item in items) {
               // RENDER ITEMS item.render()
            }
        } else
            width = 5.0

        RenderUtil.drawRect(parentGUI.x, parentGUI.y, width, parentGUI.gHeight, Color(30, 30, 30))
    }
}