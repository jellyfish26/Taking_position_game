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
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlin.system.exitProcess
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class App : Application() {
    private var row = 0
    var temp = 0

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Taking position game"
        primaryStage.scene = Scene(createContent())
        //primaryStage.scene = Scene(turn(), 1000.0, 1000.0)
        primaryStage.show()
    }

    private fun createContent(): Parent {
        val pane = Pane()
        pane.setPrefSize(750.0, 750.0)

        // Set.setting()
        var file = File("/home/jellyfish/IdeaProjects/TakingPositionGame/src/main/kotlin/qr.json")
        Value.json = file.readText(Charsets.UTF_8)
        val mapper = jacksonObjectMapper()
        val json = mapper.readValue<Json>(Value.json)
        Value.vertical = json.length.vertical
        Value.width = json.length.width
        println(json.position.agent1Position)
        println(json.position.agent2Position)
        Value.point = json.point

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

    private fun turn() : Parent {
        var root = VBox(10.0)
        var t = Text("turn: " + Value.turn)
        root.children.add(t)

        return root
    }

    //tile setting
    private inner class Tile(value: String) : StackPane() {
        private val text = Text()

        var border = Rectangle(50.0, 50.0)

        init {
            var number = temp
            border.fill = null
            border.stroke = Color.BLACK

            ++temp

            text.text = value
            text.font = Font.font(25.0)

            alignment = Pos.CENTER
            children.addAll(border, text)

            if(!Debug.input) onMouseClicked = EventHandler { this.handleMouseClick(it, number) }
        }

        //click setting
        fun handleMouseClick(event: MouseEvent, number: Int) {
            println(number)
            println(Value.panel[(number / Value.width)][number % Value.width])
            //turn
            when(Value.turn) {
                1, 2 -> {
                    if(Value.panel[(number / Value.width)][number % Value.width] == 0) {
                        border.fill = Color.AQUA
                        ++Value.turn
                        Value.panel[(number / Value.width)][number % Value.width] = 1
                    } else {
                        Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "You are selecting a panel painted in color.")
                    }
                }
                3, 4 -> {
                    if(Value.panel[(number / Value.width)][number % Value.width] == 0) {
                        border.fill = Color.FIREBRICK
                        ++Value.turn
                        Value.panel[(number / Value.width)][number % Value.width] = 2
                    } else {
                        Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "You are selecting a panel painted in color.")
                    }
                }
            }

            if(Value.turn == 5) Value.turn = 1 // roop
            if(Debug.developer) println(event)
        }
    }
}
