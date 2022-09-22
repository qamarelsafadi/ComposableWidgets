package com.qamar.composablewidgets.ui.recyclerview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.qamar.composablewidgets.ui.recyclerview.component.ListComponent
import com.qamar.composablewidgets.R

@Composable
fun RecyclerView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        val names = listOf(
            "Carmen",
            "Alaa",
            "Baraa",
            "mohanned",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Carmen",
            "Alaa",
            "Baraa",
            "mohanned",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Sara",
            "Carmen",
            "Alaa",
            "Baraa",
            "mohanned",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Sara",
            "Carmen",
            "Alaa",
            "Baraa",
            "mohanned",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara",
            "Sara",
            "Carmen",
            "Alaa",
            "Baraa",
            "mohanned",
            "Hamdan",
            "Qamar",
            "Samar",
            "Sara"
        )
        ListComponent(names)
    }
}