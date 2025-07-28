package com.example.jetpackcomposepractice.createpdf


import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import java.io.IOException

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun TextToPdfScreen() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    val createPdfLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/pdf")
    ) { uri ->
        uri?.let {
            saveTextToPdfViaUri(context, it, text)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    // When user taps outside any focusable component, clear focus to hide keyboard
                    focusManager.clearFocus()
                })
            }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter text") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    createPdfLauncher.launch("MyFile.pdf")
                    focusManager.clearFocus() // Optional: hide keyboard on button click
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Done (Save as PDF)")
            }
        }
    }
}



fun saveTextToPdfViaUri(context: Context, uri: Uri, text: String) {
    val pdfDocument = PdfDocument()
    val paint = Paint().apply {
        textSize = 14f
    }

    val pageWidth = 595
    val pageHeight = 842
    val lineHeight = 20f
    val marginTop = 30f
    val marginLeft = 10f
    val maxLinesPerPage = ((pageHeight - marginTop) / lineHeight).toInt()

    val lines = text.split("\n")

    var lineIndex = 0
    var pageNumber = 1

    while (lineIndex < lines.size) {
        val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        var y = marginTop

        for (i in 0 until maxLinesPerPage) {
            if (lineIndex >= lines.size) break
            canvas.drawText(lines[lineIndex], marginLeft, y, paint)
            y += lineHeight
            lineIndex++
        }

        pdfDocument.finishPage(page)
        pageNumber++
    }

    try {
        context.contentResolver.openOutputStream(uri)?.use { outputStream ->
            pdfDocument.writeTo(outputStream)
            Toast.makeText(context, "PDF saved successfully", Toast.LENGTH_SHORT).show()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        Toast.makeText(context, "Failed to save PDF", Toast.LENGTH_SHORT).show()
    } finally {
        pdfDocument.close()
    }
}


