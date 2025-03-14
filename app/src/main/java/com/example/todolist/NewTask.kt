package com.example.todolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel

@Composable
fun NewTask(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    addTask: (String) -> Unit

) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,

            )
             {
                    Text(
                    text = "New Task",
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
                 var text by remember {
                     mutableStateOf(value = "")
                 }
                 OutlinedTextField(
                     value = text,
                     modifier = Modifier
                         .padding(32.dp),
                     textStyle = TextStyle(MaterialTheme.colorScheme.secondary),
                     onValueChange = {newText ->
                         text = newText
                     }
                     )

                ElevatedButton(
                    onClick = {
                        addTask(text)
                        onDismissRequest()
                    }
                ) {
                    Text("Save")
                }
            }
        }
    }
}



@Preview
@Composable
fun NewTaskPreview(){
    NewTask( onDismissRequest = { }) {

    }
}


