package com.globalstore.game8192.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.globalstore.game8192.R
import com.globalstore.game8192.resolve

@Composable
fun SubHeader(
    onResetClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Button(
            onClick = onResetClicked
        ) {
            Text(R.string.sub_header_new_game.resolve())
        }
    }
}
