package com.globalstore.game8192.ui.board

sealed class Layer {
    object CellLayer : Layer()
    object AnimationLayer : Layer()
    object MergeLayer : Layer()
    object PopupLayer : Layer()

    companion object {
        fun Layer.toZIndex() =
            when (this) {
                CellLayer -> 0.0f
                AnimationLayer -> 1.0f
                MergeLayer -> 2.0f
                PopupLayer -> 3.0f
            }
    }
}
