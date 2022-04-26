package dev.manuramos.oversteer.data

interface Dto<T> {
    val data: T
}

val <T> List<Dto<T>>.data: List<T> get() = this.map { it.data }
