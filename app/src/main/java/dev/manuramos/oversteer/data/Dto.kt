package dev.manuramos.oversteer.data

interface Dto<T> {
    fun toDomain(): T
}

fun <T> List<Dto<T>>.toDomain(): List<T> = this.map { it.toDomain() }
