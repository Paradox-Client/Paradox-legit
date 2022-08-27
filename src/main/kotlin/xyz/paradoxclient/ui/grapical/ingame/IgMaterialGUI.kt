package xyz.paradoxclient.ui.grapical.ingame

import net.minecraft.client.gui.GuiScreen
import xyz.paradoxclient.utils.RenderUtil
import java.awt.Color

class IgMaterialGUI : GuiScreen() {

    /*
    IDEAS
    - Extendable sidebar
    - Add a search bar
    - Add a sort bar
    - Add a filter bar
     */

    var x = 0.0
    var y = 0.0

    // Change to val when you're done with it
    var gWidth = 600.0
    var gHeight = 500.0

    val navMenu = NavigationMenu(this)

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        RenderUtil.drawRect(x, y, gWidth, gHeight, Color(20, 20, 20))
        navMenu.render(mouseX, mouseY)
    }

    override fun mouseClicked(mouseX: Int, mouseY: Int, mouseButton: Int) {
        super.mouseClicked(mouseX, mouseY, mouseButton)
    }

    override fun mouseReleased(mouseX: Int, mouseY: Int, state: Int) {
        super.mouseReleased(mouseX, mouseY, state)
    }

    override fun initGui() {
        x = RenderUtil.getScaledResolution().scaledWidth.toDouble() / 2 - gWidth / 2
        y = RenderUtil.getScaledResolution().scaledHeight.toDouble() / 2 - gHeight / 2
        gWidth = 400.0;
        gHeight = 300.0;
    }

    override fun updateScreen() {}

    override fun onGuiClosed() {}

    override fun doesGuiPauseGame(): Boolean {
        return false
    }
}