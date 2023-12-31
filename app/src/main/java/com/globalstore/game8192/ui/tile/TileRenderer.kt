package com.globalstore.game8192.ui.tile

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.globalstore.game8192.ui.board.BoardScope
import com.globalstore.game8192.ui.board.Layer
import com.globalstore.game8192.ui.data.TileModel

private const val NEW_DURATION = 100
private const val SWIPE_DURATION = 100
private const val MERGE_DURATION = 200

interface TileRenderer {
    @Composable
    fun BoardScope.RenderNewTile(tileModel: TileModel)

    @Composable
    fun BoardScope.RenderStaticTile(tileModel: TileModel)

    @Composable
    fun BoardScope.RenderSwipedTile(tileModel: TileModel)

    @Composable
    fun BoardScope.RenderMergedTile(tileModel: TileModel)
}

object TileRendererInstance : TileRenderer {

    @Composable
    override fun BoardScope.RenderNewTile(tileModel: TileModel) {
        key(tileModel.id) {
            val scale = remember { Animatable(0f) }
            val alpha = remember { Animatable(0f) }
            Tile(
                fraction = tileFraction,
                value = tileModel.curValue.toString(),
                color = tileModel.curValue.toTextColor(),
                fontSize = tileModel.curValue.toFontSize(),
                backgroundColor = tileModel.curValue.toBackgroundColor(),
                modifier = Modifier
                    .boardCell(
                        row = tileModel.curPosition.row,
                        col = tileModel.curPosition.col,
                        layer = Layer.AnimationLayer
                    )
                    .scale(scale.value)
                    .alpha(alpha.value)
            )
            LaunchedEffect(this) {
                scale.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        delayMillis = SWIPE_DURATION,
                        durationMillis = NEW_DURATION
                    )
                )
            }
            LaunchedEffect(this) {
                alpha.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        delayMillis = SWIPE_DURATION,
                        durationMillis = NEW_DURATION
                    )
                )
            }
        }
    }

    @Composable
    override fun BoardScope.RenderStaticTile(tileModel: TileModel) {
        key(tileModel.id) {
            Tile(
                fraction = tileFraction,
                value = tileModel.curValue.toString(),
                color = tileModel.curValue.toTextColor(),
                fontSize = tileModel.curValue.toFontSize(),
                backgroundColor = tileModel.curValue.toBackgroundColor(),
                modifier = Modifier
                    .boardCell(
                        row = tileModel.curPosition.row,
                        col = tileModel.curPosition.col,
                        layer = Layer.CellLayer
                    )
            )
        }
    }

    @Composable
    override fun BoardScope.RenderSwipedTile(tileModel: TileModel) {
        key(tileModel.id) {
            val row = remember { Animatable(tileModel.prevPosition!!.row) }
            val col = remember { Animatable(tileModel.prevPosition!!.col) }
            Tile(
                fraction = tileFraction,
                value = tileModel.curValue.toString(),
                color = tileModel.curValue.toTextColor(),
                fontSize = tileModel.curValue.toFontSize(),
                backgroundColor = tileModel.curValue.toBackgroundColor(),
                modifier = Modifier
                    .boardCell(
                        row = row.value,
                        col = col.value,
                        layer = Layer.AnimationLayer
                    )
            )
            if (row.value != tileModel.curPosition.row) {
                LaunchedEffect(this) {
                    row.animateTo(
                        targetValue = tileModel.curPosition.row,
                        animationSpec = tween(durationMillis = SWIPE_DURATION)
                    )
                }
            }
            if (col.value != tileModel.curPosition.col) {
                LaunchedEffect(this) {
                    col.animateTo(
                        targetValue = tileModel.curPosition.col,
                        animationSpec = tween(durationMillis = SWIPE_DURATION)
                    )
                }
            }
        }
    }

    @Composable
    override fun BoardScope.RenderMergedTile(tileModel: TileModel) {
        key(tileModel.id) {
            val scale = remember { Animatable(0f) }
            Tile(
                fraction = tileFraction,
                value = tileModel.curValue.toString(),
                color = tileModel.curValue.toTextColor(),
                fontSize = tileModel.curValue.toFontSize(),
                backgroundColor = tileModel.curValue.toBackgroundColor(),
                modifier = Modifier
                    .boardCell(
                        row = tileModel.curPosition.row,
                        col = tileModel.curPosition.col,
                        layer = Layer.MergeLayer
                    )
                    .scale(scale.value),
            )
            LaunchedEffect(this) {
                scale.animateTo(
                    targetValue = 1f,
                    animationSpec = keyframes {
                        delayMillis = SWIPE_DURATION
                        durationMillis = MERGE_DURATION
                        0f atFraction 0f
                        1.2f atFraction 0.5f
                        1f atFraction 1f
                    }
                )
            }
        }
    }

    private fun Int.toBackgroundColor() =
        when {
            this == 2 -> Color(0xFFDCEDC8)
            this == 4 -> Color(0xFFFFCC80)
            this == 8 -> Color(0xff80CBC4)
            this == 16 -> Color(0xffFFD54F)
            this == 32 -> Color(0xffEEEEEE)
            this == 64 -> Color(0xffBA68C8)
            this == 128 -> Color(0xff2E7D32)
            this == 256 -> Color(0xffF9A825)
            this == 512 -> Color(0xffD84315)
            this == 1024 -> Color(0xff424242)
            this == 2048 -> Color(0xff4527A0)
            this == 4096 -> Color(0xff00838F)
            this == 8192 -> Color(0xff212121)
            else -> Color(0xff3c3a32)
        }

    private fun Int.toTextColor() =
        if (this < 64) Color(0xff776e65) else Color(0xfff8f6f2)

    private fun Int.toFontSize() =
        when {
            this == 2 -> 35.sp
            this == 4 -> 35.sp
            this == 8 -> 35.sp
            this == 16 -> 35.sp
            this == 32 -> 35.sp
            this == 64 -> 35.sp
            this == 128 -> 22.sp
            this == 256 -> 22.sp
            this == 512 -> 22.sp
            this == 1024 -> 16.sp
            this == 2048 -> 16.sp
            this == 4096 -> 16.sp
            this == 8192 -> 16.sp
            else -> 13.sp
        }
}
