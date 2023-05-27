package com.shihan.noteapplication.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shihan.noteapplication.R
import com.shihan.noteapplication.components.NoteButton
import com.shihan.noteapplication.components.NoteInputText
import com.shihan.noteapplication.components.NoteRow
import com.shihan.noteapplication.data.NotesDateSource
import com.shihan.noteapplication.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    
    Column(
        modifier = Modifier
            .padding(0.dp)
    ) {
        TopAppBar(
            
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "notification"
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                    10.dp
                )
            ),
        )
        // content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = "",
                label = "Add title",
                onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        title = it
                    }
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )
            
            NoteInputText(
                text = "",
                label = "Add Description",
                onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        title = it
                    }
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )
            
            NoteButton(text = "Save", onClick = {
                if (title.isNotBlank() && description.isNotBlank()) {
                    /// save notes
                    title = ""
                    description = ""
                }
            })
            
            Divider(modifier = Modifier.padding(10.dp))
            LazyColumn {
                items(notes){noteItem->
                    NoteRow(note = noteItem)
                }
            }
            
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NotesDateSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}