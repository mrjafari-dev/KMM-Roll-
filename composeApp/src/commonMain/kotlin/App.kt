import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val coroutineScope = rememberCoroutineScope()
    var side1 = mutableStateOf(1)
    val image = remember { mutableStateOf("dice_1.xml") }
    MaterialTheme {
        val infiniteTransition = rememberInfiniteTransition()
        val shakeState = infiniteTransition.animateFloat(
            initialValue = -10f,
            targetValue = 10f,
            animationSpec = infiniteRepeatable(
                // Tween specifies the duration and easing
                animation = tween(durationMillis = 500, easing = LinearEasing),
                // RepeatMode.Reverse makes the animation play back and forth
                repeatMode = RepeatMode.Reverse
            )
        )
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    when(side1.value){
                        1->{image.value = "dice_1.xml"}
                        2->{image.value = "dice_2.xml"}
                        3->{image.value = "dice_3.xml"}
                        4->{image.value = "dice_4.xml"}
                        5->{image.value = "dice_5.xml"}
                        6->{image.value = "dice_6.xml"}
                    }
                    Image(painterResource(image.value), null,modifier = Modifier
                        .graphicsLayer {
                            // Apply translationX property for shake effect
                            translationX = shakeState.value
                        })
                    Button(onClick = {
                        coroutineScope.launch {
                            Greeting().getRandomNumber(side1)
                        }

                    }) {
                        Text("Roll ^_^")
                    }

                }

        }
    }
}


