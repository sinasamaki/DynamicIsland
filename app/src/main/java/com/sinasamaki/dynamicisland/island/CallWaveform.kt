package com.sinasamaki.dynamicisland.island

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sinasamaki.dynamicisland.ui.theme.Green
import com.sinasamaki.dynamicisland.ui.theme.Orange
import com.sinasamaki.dynamicisland.ui.theme.White
import kotlin.random.Random

@Composable
fun CallWaveform() {
    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Waveform(color = Green)
        Waveform(color = Orange)
        Waveform(color = White, limit = .7f)
    }
}

@Composable
fun Waveform(
    color: Color,
    limit: Float = 1f,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in 0..4) {
            val height = remember { Animatable(0f) }

            LaunchedEffect(Unit) {
                while (true) {
                    height.animateTo(
                        Random.nextFloat() * limit,
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxHeight(height.value)
                    .weight(1f)
            )
            Box(modifier = Modifier.width(2.dp))
        }
    }
}