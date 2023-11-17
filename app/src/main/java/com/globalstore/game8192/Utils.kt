package com.globalstore.game8192

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Int.resolve() = LocalContext.current.getString(this)

fun <T> List<T>.toArrayList(): ArrayList<T> = ArrayList(this)
