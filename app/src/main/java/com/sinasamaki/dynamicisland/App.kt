package com.sinasamaki.dynamicisland

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sinasamaki.dynamicisland.island.DynamicIsland
import com.sinasamaki.dynamicisland.island.IslandState

@Composable
fun App() {
    Column {
        var islandState: IslandState by remember { mutableStateOf(IslandState.DefaultState()) }

        DynamicIsland(islandState = islandState)

        RadioButtonRow(
            text = "Default",
            selected = islandState is IslandState.DefaultState
        ) {
            islandState = IslandState.DefaultState()
        }

        RadioButtonRow(
            text = "Call state",
            selected = islandState is IslandState.CallState
        ) {
            islandState = IslandState.CallState()
        }

        RadioButtonRow(
            text = "Call Timer state",
            selected = islandState is IslandState.CallTimerState
        ) {
            islandState = IslandState.CallTimerState()
        }

        RadioButtonRow(
            text = "Face unlock state",
            selected = islandState is IslandState.FaceUnlockState
        ) {
            islandState = IslandState.FaceUnlockState()
        }
    }
}
