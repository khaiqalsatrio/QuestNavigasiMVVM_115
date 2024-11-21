package com.example.questnavigasimvvm_115.model

import com.example.questnavigasimvvm_115.R

data class JenisKelaminItem(val stringResId: Int)

object JenisKelamin {
    val jenisK = listOf(
        JenisKelaminItem(R.string.laki),
        JenisKelaminItem(R.string.wanita)
    )
}