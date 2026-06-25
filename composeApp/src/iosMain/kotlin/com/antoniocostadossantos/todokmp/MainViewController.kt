package com.antoniocostadossantos.todokmp

import androidx.compose.ui.window.ComposeUIViewController
import com.antoniocostadossantos.todokmp.features.home.ui.screens.App

fun MainViewController() = ComposeUIViewController { App() }