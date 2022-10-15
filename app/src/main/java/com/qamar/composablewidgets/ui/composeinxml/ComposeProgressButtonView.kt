package com.qamar.composablewidgets.ui.composeinxml

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.progressbutton.components.ProgressButtonComponents

class ComposeProgressButtonView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        addView(
            ComposeView(context).apply {
                setContent {
                    var loading by remember {
                        mutableStateOf(false)
                    }
                    ProgressButtonComponents(
                        onClick = { loading = !loading },
                        modifier = Modifier.padding(16.dp).height(46.dp),
                        loading = loading,
                        color = R.color.purple_200,
                        progressColor = R.color.white
                    ) {
                        Text(
                            color = colorResource(id = R.color.white),
                            text = "Refresh"
                        )
                    }
                }
            }
        )
    }
}