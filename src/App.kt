import java.util.ArrayList

import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlin.system.exitProcess

class App : Application() {
    private var row = 0

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Taking position game"
        primaryStage.scene = Scene(createContent())
        primaryStage.show()
    }

    private fun createContent(): Parent {
        val pane = Pane()
        pane.setPrefSize(750.0, 750.0)

        Set.setting()
        val tiles = ArrayList<Tile>()
        for(ver_length in 0 until Value.vertical) {
            for(wid_length in 0 until Value.width) {
                tiles.add(Tile(Value.point[ver_length][wid_length].toString()))
            }
        }

        row = Value.width

        for (size in tiles.indices) {
            val tile = tiles[size]
            tile.translateX = (50 * (size % row)).toDouble()
            tile.translateY = (50 * (size / row)).toDouble()
            pane.children.add(tile)
        }

        return pane
    }

    private inner class Tile(value: String) : StackPane() {
        private val text = Text()

        init {
            val border = Rectangle(50.0, 50.0)
            border.fill = null
            border.stroke = Color.BLACK

            text.text = value
            text.font = Font.font(25.0)

            alignment = Pos.CENTER
            children.addAll(border, text)

            // onMouseClicked = EventHandler<MouseEvent>  { this.handleMouseClick(it) }
            onMouseClicked = EventHandler { this.handleMouseClick(it) }
        }

        fun handleMouseClick(event: MouseEvent) {
            if(Debug.developer) println(event)
        }
    }
}
