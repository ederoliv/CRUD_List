//CRUD

object UserTable {

    var userId = mutableListOf(0,1)
    var userName = mutableListOf("Eder", "Sara")
    var userSurname = mutableListOf("Oliveira", "Rocha")

}

fun main(args: Array<String>) {


    when (args[0]) {

        "-c" -> {

            create(args[1], args[2])

        }

        "-r" -> {

            read()

        }
        "-u" -> {

            update(args[1].toInt(),args[2],args[3])

        }

        "-d" -> {

            delete(args[1].toInt())

        }

    }

}

fun create(receiveUserName: String, receiveUserSurname: String) {

    val newUserId = UserTable.userId.size

    UserTable.userId.add(newUserId)
    UserTable.userName.add(newUserId, receiveUserName)
    UserTable.userSurname.add(newUserId, receiveUserSurname)

    println("Usuário: ${UserTable.userName[newUserId]} ${UserTable.userSurname[newUserId]}  com o ID: $newUserId foi criado com sucesso!")

    read()

}


fun read() {

    for(id in UserTable.userId){
        println("${UserTable.userName[id]} ${UserTable.userSurname[id]}")
    }

}

fun update(updateUserId: Int, newUserName: String, newUserSurname: String) {

    read()

    val oldUSerName = UserTable.userName[updateUserId]
    val oldUserSurname = UserTable.userSurname[updateUserId]

    UserTable.userName[updateUserId] = newUserName
    UserTable.userSurname[updateUserId] = newUserSurname

    println("Alterado!")

    read()

}

fun delete(deleteUserId: Int) {

    val userDeleted = UserTable.userName[deleteUserId]
    val userIdDeleted = UserTable.userId[deleteUserId]

    UserTable.userId.removeAt(deleteUserId)
    UserTable.userName.removeAt(deleteUserId)
    UserTable.userSurname.removeAt(deleteUserId)

    println("Usuário: $userDeleted com o ID: $userIdDeleted foi deletado com sucesso")

    read()

}
