import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Brush

@Composable
fun VisibilityToggleWithFloatingButtonDemo() {

    var isVisible by remember { mutableStateOf(false) }


            Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        IconButton(
            onClick = { isVisible = !isVisible },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 16.dp, end = 16.dp)
        ) {
            Icon(
                imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                contentDescription = if (isVisible) "Скрыть контент" else "Показать контент",
                tint = Color.White
            )
        }


        val alpha by animateFloatAsState(targetValue = if (isVisible) 1f else 0f)


        if (isVisible || alpha > 0f) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 40.dp)
                    .alpha(alpha),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Меню",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color(0xFF42A5F5), Color(0xFF1E88E5))
                            )
                        )
                        .padding(16.dp),
                    color = Color.White
                )


                Text(
                    text = "Дополнительная информация.",
                    modifier = Modifier
                        .background(
                            color = Color(0xFF42A5F5)
                        )
                        .padding(16.dp),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewVisibilityToggleWithFloatingButtonDemo() {
    VisibilityToggleWithFloatingButtonDemo()
}
