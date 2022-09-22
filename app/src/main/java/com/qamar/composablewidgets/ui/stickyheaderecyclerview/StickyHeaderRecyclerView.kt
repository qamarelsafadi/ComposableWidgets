package com.qamar.composablewidgets.ui.stickyheaderecyclerview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.stickyheaderecyclerview.component.HeaderItem
import com.qamar.composablewidgets.ui.stickyheaderecyclerview.component.ItemList

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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderRecyclerView() {
    val grouped = names.sorted().groupBy { it[0] }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        LazyColumn {
            grouped.forEach { (initial, contactsForInitial) ->
                stickyHeader {
                    HeaderItem(initial)
                }
                items(contactsForInitial) { contact ->
                    ItemList(contact)
                }
            }

        }
    }
}
