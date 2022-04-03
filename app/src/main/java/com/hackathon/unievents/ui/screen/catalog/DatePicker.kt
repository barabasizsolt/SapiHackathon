package com.hackathon.unievents.ui.screen.catalog

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import java.util.Date

@Composable
fun DatePicker(modifier: Modifier = Modifier){

    val context = LocalContext.current

    val mCalendar = Calendar.getInstance()

    val year = mCalendar.get(Calendar.YEAR)
    val month = mCalendar.get(Calendar.MONTH)
    val day = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, year, month, day
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)) ) {
            Text(text = "Open Date Picker", color = Color.White)
        }
        Spacer(modifier = Modifier.size(size = 100.dp))
        Text(text = "Selected Date: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}