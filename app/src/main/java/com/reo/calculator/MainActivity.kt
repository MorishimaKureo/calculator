package com.reo.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.reo.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                var text = remember {
                    mutableStateOf("")
                }
                Column(
                    modifier =  Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text.value,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(16.dp)
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(DarkGray),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row() {
                            Button(onClick = {
                                text.value += "1"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "1",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "2"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "2",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "3"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "3",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "+"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "+",
                                    fontSize = 25.sp
                                )
                            }
                        }
                        Row() {
                            Button(onClick = {
                                text.value += "4"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "4",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "5"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "5",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "6"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "6",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "-"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "-",
                                    fontSize = 25.sp
                                )
                            }
                        }
                        Row() {
                            Button(onClick = {
                                text.value += "7"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "7",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "8"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "8",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "9"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "9",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "*"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "*",
                                    fontSize = 25.sp
                                )
                            }
                        }
                        Row() {
                            Button(onClick = {
                                text.value = ""
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "C",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "0"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "0",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "."
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = ".",
                                    fontSize = 25.sp
                                )
                            }
                            Button(onClick = {
                                text.value += "/"
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape) {
                                Text(
                                    text = "/",
                                    fontSize = 25.sp
                                )
                            }
                        }
                        Column() {
                            Button(onClick = {
                                text.value = calculate(text.value)
                            }, modifier = Modifier.size(64.dp),
                            shape = CircleShape){
                                Text(
                                    text = "=",
                                    fontSize = 25.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun calculate(input: String): String{
    if(input.isEmpty()){
        return ""
    }
    var result = 0.0
    var currentNumber = ""
    var lastOperator = '+'
    val calculateLastNum = input + "+"

    //angka selanjut nya
    for(char in calculateLastNum){
        if(char.isDigit() || char == '.'){
            currentNumber += char
        } else if (char == '+' || char == '-' || char == '*' || char == '/'){
            when(lastOperator){
                '+' -> result += currentNumber.toDouble()
                '-' -> result -= currentNumber.toDouble()
                '*' -> result *= currentNumber.toDouble()
                '/' -> result /= currentNumber.toDouble()
            }
            currentNumber = ""
            lastOperator = char
        }
    }
    val finalResult = result.toString()
    return if(finalResult.endsWith(".0")){
        finalResult.substring(0, finalResult.length - 2)
    } else {
        finalResult
    }
}