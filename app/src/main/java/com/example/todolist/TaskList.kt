package com.example.todolist

import android.widget.Space
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasksList(
    modifier: Modifier = Modifier,
    list: List<Task>,
    onCloseTask: (Task) -> Unit,
    onRemoveClick: (Int) -> Unit,
    onCheckedChange: (Int) -> Unit,
    ) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            items = list,
            key = { it.idTask }
        ) {
            TaskItem(
                taskName = it.title,
                checked = it.isChecked,
                onCheckedChange = { checked ->
                    onCheckedChange(it.idTask)
                                  },
                onRemoveClick = { onRemoveClick(it.idTask) },
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}