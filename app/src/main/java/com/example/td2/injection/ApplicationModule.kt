package com.example.td2.injection

import com.example.td2.MainViewModel
import org.koin.dsl.module

val presentationModule = module {

    factory{ MainViewModel()}

    }