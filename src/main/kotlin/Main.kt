//CRUD

object UserTable {

    var userId = mutableListOf(0,1)
    var userName = mutableListOf("Eder", "Sara")
    var userSurname = mutableListOf("Oliveira", "Rocha")

}

fun main(args: Array<String>) {


    when (args[0]) {

        "-r" -> {
            read()
        }
        "-d" -> {
            delete(args[1].toInt())
        }

    }

}
/*
fun create() {

}
*/

fun read() {

    for(id in UserTable.userId){
        println("${UserTable.userName[id]} ${UserTable.userSurname[id]}")
    }

}
/*
fun update() {

}
*/
fun delete(deleteUserId: Int) {

    val userDeleted = UserTable.userName[deleteUserId]
    val userIdDeleted = UserTable.userId[deleteUserId]

    UserTable.userId.removeAt(deleteUserId)
    UserTable.userName.removeAt(deleteUserId)
    UserTable.userSurname.removeAt(deleteUserId)

    println("Usuário: $userDeleted com o ID: $userIdDeleted foi deletado com sucesso")

    read()

}
