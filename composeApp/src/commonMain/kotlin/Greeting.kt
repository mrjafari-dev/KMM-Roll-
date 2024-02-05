import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

class Greeting {

    suspend fun getRandomNumber(side1 : MutableState<Int>) {
        print("OK Click")
        for (index in 1..6) {
            delay(300)
            side1.value = Random.nextInt(1, 6)

            print("for")

        }
    }
}
