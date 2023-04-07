import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<String> = flow {
    for (i in 1..3) {
        delay(100)
        emit("[${Thread.currentThread().name}] result: $i")
    }
}

fun main() = runBlocking<Unit> {
    launch {
        for (k in 1..20) {
            println("[${Thread.currentThread().name}] I'm not blocked $k")
            delay(20)
        }
    }

    simple().collect { value -> println(value) }
}
