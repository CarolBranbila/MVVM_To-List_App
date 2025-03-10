package com.example.todolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<AppViewModel>()
    val state by viewModel.tasks.collectAsState()
    var isDialogVisible by remember { mutableStateOf(value = false) }

    Scaffold(
        topBar = {
            TopTitle()
        },
        bottomBar = {
            AddTaskButton(
                onClick = { isDialogVisible = true }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            TasksList(
                modifier = Modifier,
                list = state.tasks,
                onCloseTask = { },
                onRemoveClick = {
                    viewModel.removeTask(
                        idTask = it
                    )
                },
                onCheckedChange = {
                    viewModel.isChecked(idTask = it)
                }
            )
            Spacer(Modifier.weight(1f))

            // se botao foi clicado
            if (isDialogVisible) {
                NewTask(
                    onDismissRequest = {
                        isDialogVisible = false
                    },
                    addTask = { viewModel.addTask(it) }
                )
            }

        }
    }
}


@Composable
fun TopTitle(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row() {
            Icon(
                modifier = modifier
                    .paddingFromBaseline(16.dp)
                    .padding(horizontal = 8.dp),
                imageVector = Icons.Default.Create,
                contentDescription = null
            )
            Text(
                text = "To-do List",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                    .padding(horizontal = 0.dp)
            )
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Today",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun AddTaskButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row {
        Spacer(Modifier
            .weight(1f)
        )
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.End

        ) {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),
                onClick = onClick,
                shape = CircleShape,
            ) {
                Icon(Icons.Filled.Add, "Add a new task")
            }
        }
    }


}


@Preview
@Composable
fun TopTitlePreview() {
    TopTitle()
}

@Preview
@Composable
fun AddTaskButtonPreview() {
    AddTaskButton(onClick = {})
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}