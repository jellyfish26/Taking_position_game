import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.util.*

data class Json(val length: Length, val position: Position, val point: Array<Array<Int>>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Json

        if (length != other.length) return false
        if (position != other.position) return false
        if (!Arrays.equals(point, other.point)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + Arrays.hashCode(point)
        return result
    }

}

data class Length(val vertical: Int, val width: Int)

data class Position(val agent1Position: Agent1Position, val agent2Position: Agent2Position)

data class Agent1Position(val x: Int, val y: Int)

data class Agent2Position(val x: Int, val y: Int)

